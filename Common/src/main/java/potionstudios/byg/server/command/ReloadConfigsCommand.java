package potionstudios.byg.server.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.TranslatableComponent;
import potionstudios.byg.common.block.sapling.BYGSapling;
import potionstudios.byg.common.block.sapling.SaplingPatterns;
import potionstudios.byg.util.CommonSetupLoad;

import java.util.Arrays;

public class ReloadConfigsCommand {

    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        String commandString = "reload";

        String argName = "config";

        return Commands.literal(commandString).then(Commands.argument(argName, StringArgumentType.string()).suggests((ctx, sb) -> SharedSuggestionProvider.suggest(Arrays.stream(Config.values()).map(Config::toString), sb)).executes(cs -> {
            try {
                Config config = Config.valueOf(cs.getArgument(argName, String.class).toUpperCase());
                config.run();
                cs.getSource().sendSuccess(new TranslatableComponent("byg.command.config.success", config.toString()), true);
                return 1;
            } catch (IllegalArgumentException e) {
                cs.getSource().sendFailure(new TranslatableComponent("byg.command.config.error", argName, Config.values().toString()));
                return 0;
            }
        }));
    }


    public enum Config {
        SAPLINGS(() -> {
            SaplingPatterns.getConfig(true);
            BYGSapling.SERIALIZERS.forEach(CommonSetupLoad::load);
        });

        private final Runnable runnable;
        Config(Runnable runnable) {
            this.runnable = runnable;
        }

        public void run() {
            this.runnable.run();
        }
    }
}
