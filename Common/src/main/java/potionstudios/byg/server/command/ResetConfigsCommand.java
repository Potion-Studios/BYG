package potionstudios.byg.server.command;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import potionstudios.byg.config.BYGConfigHandler;
import potionstudios.byg.util.ModPlatform;

public class ResetConfigsCommand {

    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        String commandString = "reset";

        return Commands.literal(commandString).requires(stack -> stack.hasPermission(4) && stack.isPlayer()).executes(cs -> {
            BYGConfigHandler.loadAllConfigs(true, true, ModPlatform.INSTANCE.isClientEnvironment());


            cs.getSource().sendSuccess(() -> Component.translatable("byg.command.resetconfig.notifyrestart").withStyle(ChatFormatting.YELLOW), true);
            return 1;
        });
    }
}