package potionstudios.byg.server.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.client.KillClient;
import potionstudios.byg.config.ConfigVersionTracker;
import potionstudios.byg.mixin.access.CommandSourceStackAccess;
import potionstudios.byg.util.FileUtils;
import potionstudios.byg.util.ModPlatform;
import potionstudios.byg.util.ServerKillCountDown;

import java.nio.file.Path;

public class UpdateConfigsCommand {
    private static int warnings = 0;

    private static final long COUNTDOWN_LENGTH = 1200; // 60 Seconds in ticks.


    public static final String COMMAND_STRING = "update_configs";
    public static final String UPDATE_STRING = "update";
    public static final String DISMISS_STRING = "dismiss";
    public static final Component UPDATE_COMPONENT = ComponentUtils.wrapInSquareBrackets(new TranslatableComponent("UPDATE").withStyle(ChatFormatting.GREEN).withStyle(style -> {
        return style.withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + BYG.MOD_ID + " " + COMMAND_STRING + " " + UPDATE_STRING)).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("Running this command will update your configs and restart your game! A back of your configs will be created in \".../config/byg/backups\"").withStyle(ChatFormatting.RED)));
    }));
    public static final Component DISMISS_UPDATE_COMPONENT = ComponentUtils.wrapInSquareBrackets(new TranslatableComponent("DISMISS").withStyle(ChatFormatting.YELLOW).withStyle(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + BYG.MOD_ID + " " + COMMAND_STRING + " " + DISMISS_STRING))));
    public static final TranslatableComponent CONTACT_SERVER_OWNER = new TranslatableComponent("Contact the server owner and let them know BYG's configs are outdated!");


    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        String argName = "action";
        return Commands.literal(COMMAND_STRING).then(Commands.argument(argName, StringArgumentType.string()).suggests((ctx, sb) -> SharedSuggestionProvider.suggest(new String[]{UPDATE_STRING, DISMISS_STRING}, sb)).requires(stack -> {
            return stack.hasPermission(4);
        }).executes(cs -> {
            CommandSourceStack stack = cs.getSource();
            MinecraftServer server = stack.getServer();
            CommandSource commandSource = ((CommandSourceStackAccess) cs.getSource()).byg_getSource();

            ConfigVersionTracker configVersionTracker = new ConfigVersionTracker(BYGConstants.CONFIG_VERSION);
            if (ConfigVersionTracker.getConfig().configVersion() == BYGConstants.CONFIG_VERSION) {
                stack.sendSuccess(new TranslatableComponent("Configs are already up to date!"), true);
                return 1;
            }


            boolean isSinglePlayerOwner = (commandSource instanceof Player player) && server.isSingleplayerOwner(player.getGameProfile());
            boolean isServerConsole = commandSource instanceof MinecraftServer;

            if (!(isSinglePlayerOwner || isServerConsole)) {
                stack.sendFailure(CONTACT_SERVER_OWNER);
                BYG.LOGGER.warn("BYG's configs are outdated, run \"/byg update_configs update\" to dismiss this warning");
                return 0;
            }

            String argument = cs.getArgument(argName, String.class);


            if (argument.equalsIgnoreCase(UPDATE_STRING)) {
                switch (warnings) {
                    case 0 -> {
                        stack.sendFailure(new TranslatableComponent("BYG: Warning this command will close your game to ensure all configs are re-read.").withStyle(ChatFormatting.BOLD));
                        warnings++;
                    }
                    case 1 -> {
                        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                            serverPlayer.displayClientMessage(new TranslatableComponent("BYG: Warning the server owner is attempting to update all BYG configs, all connected users should expect the possibility of being disconnected...").withStyle(ChatFormatting.YELLOW), false);
                        }
                        stack.sendFailure(new TranslatableComponent("BYG: Warning this command will close your game to ensure all configs are re-read.").withStyle(ChatFormatting.BOLD));
                        warnings++;
                    }
                    case 2 -> {
                        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                            serverPlayer.displayClientMessage(new TranslatableComponent("BYG: The server owner is updating all BYG configs, all connected users will be disconnected...\n\nBeginning 60 second server kill countdown").withStyle(ChatFormatting.RED), false);
                        }

                        ((ServerKillCountDown) server).setKillCountdown(1200, isSinglePlayerOwner);
                        warnings++;
                    }
                    default -> {
                        warnings = 0;
                    }
                }
            } else if (argument.equalsIgnoreCase(DISMISS_STRING)) {
                ConfigVersionTracker.getConfig(configVersionTracker, true);
            }

            return 1;
        }));
    }

    public static void backupAndKillGameInstance(MinecraftServer server, ConfigVersionTracker configVersionTracker, boolean isSinglePlayerOwner) {
        Path directory = ModPlatform.INSTANCE.configPath();
        ConfigVersionTracker.getConfig(configVersionTracker, true);
        Path backUpPath = FileUtils.backUpDirectory(directory);
        //noinspection ConstantConditions
        FileUtils.deleteDirectory(directory, path -> !path.equals(backUpPath) && !(path.toFile().isDirectory() && path.toFile().listFiles().length > 0));
        BYG.loadAllConfigs(true, true);
        if (server.isSingleplayer() && isSinglePlayerOwner) {
            KillClient.kill();
        } else {
            server.halt(false);
        }
    }
}
