package potionstudios.byg.server.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.common.block.sapling.GrowingPatterns;
import potionstudios.byg.network.packet.SaplingPatternsPacket;
import potionstudios.byg.util.FeatureGrowerFromBlockPattern;
import potionstudios.byg.util.ModPlatform;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Consumer;

public class ReloadConfigsCommand {

    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        String commandString = "reload";

        String argName = "config";

        return Commands.literal(commandString).requires(stack -> stack.hasPermission(4)).then(Commands.argument(argName, StringArgumentType.string()).suggests((ctx, sb) -> SharedSuggestionProvider.suggest(Arrays.stream(Config.values()).map(Config::toString), sb)).executes(cs -> {
            try {
                Config config = Config.valueOf(cs.getArgument(argName, String.class).toUpperCase(Locale.ROOT));
                config.accept(cs.getSource());
                cs.getSource().sendSuccess(() -> Component.translatable("byg.command.config.success", config.toString()), true);
                return 1;
            } catch (IllegalArgumentException e) {
                cs.getSource().sendFailure(Component.translatable("byg.command.config.error", argName, Config.values().toString()));
                return 0;
            }
        }));
    }


    private enum Config {
        GROWERS((stack) -> {
            GrowingPatterns.getConfig(true, false);
            FeatureGrowerFromBlockPattern.ENTRIES.forEach(grower -> {
                if (grower.get() instanceof Block block) {
                    grower.get().load(block);
                }
            });
            ModPlatform.INSTANCE.sendToAllClients(stack.getServer().getPlayerList().getPlayers(), new SaplingPatternsPacket(GrowingPatterns.getConfig()));
        });

        private final Consumer<CommandSourceStack> runnable;

        Config(Consumer<CommandSourceStack> runnable) {
            this.runnable = runnable;
        }

        public void accept(CommandSourceStack stack) {
            this.runnable.accept(stack);
        }
    }
}
