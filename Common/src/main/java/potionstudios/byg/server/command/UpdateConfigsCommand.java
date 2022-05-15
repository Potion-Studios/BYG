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

    private static final long COUNTDOWN_LENGTH = 1200; // 60 Seconds in ticks(assuming 20 ticks per second)

    public static final String COMMAND_STRING = "update_configs";
    public static final String UPDATE_STRING = "update";
    public static final String DISMISS_STRING = "dismiss";

    public static final Component UPDATE_COMPONENT = ComponentUtils.wrapInSquareBrackets(new TranslatableComponent("byg.command.updateconfig.update")
            .withStyle(ChatFormatting.GREEN)
            .withStyle(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + BYG.MOD_ID + " " + COMMAND_STRING + " " + UPDATE_STRING))
                    .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.command.updateconfig.update.hover")
                            .withStyle(ChatFormatting.RED)))
            )
    );

    public static final Component DISMISS_UPDATE_COMPONENT = ComponentUtils.wrapInSquareBrackets(new TranslatableComponent("byg.command.updateconfig.dismiss")
            .withStyle(ChatFormatting.YELLOW)
            .withStyle(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + BYG.MOD_ID + " " + COMMAND_STRING + " " + DISMISS_STRING)))
    );

    public static final TranslatableComponent CONTACT_SERVER_OWNER = new TranslatableComponent("byg.command.updateconfig.contactserverowner");
    public static final MutableComponent PLAYER_WARNING = new TranslatableComponent("byg.command.updateconfig.warnplayers");
    public static final MutableComponent GAME_CLOSE_WARNING = new TranslatableComponent("byg.command.updateconfig.warngameclose");

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
                stack.sendSuccess(new TranslatableComponent("byg.command.updateconfig.configsuptodate"), true);
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
                        stack.sendFailure(GAME_CLOSE_WARNING.withStyle(ChatFormatting.BOLD));
                        warnings++;
                    }
                    case 1 -> {
                        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                            serverPlayer.displayClientMessage(PLAYER_WARNING.withStyle(ChatFormatting.YELLOW), false);
                        }
                        stack.sendFailure(GAME_CLOSE_WARNING.withStyle(ChatFormatting.BOLD));
                        warnings++;
                    }
                    case 2 -> {
                        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
                            serverPlayer.displayClientMessage(PLAYER_WARNING.withStyle(ChatFormatting.RED), false);
                        }

                        ((ServerKillCountDown) server).setKillCountdown(COUNTDOWN_LENGTH, isSinglePlayerOwner);
                        warnings++;
                    }
                    default -> warnings = 0;
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
