package potionstudios.byg.server.command;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import potionstudios.byg.BYG;
import potionstudios.byg.config.BYGConfigHandler;
import potionstudios.byg.util.ModPlatform;

public class ValidateConfigsCommand {

    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        String commandString = "validate";

        return Commands.literal(commandString).requires(stack -> stack.hasPermission(4) && stack.isPlayer()).executes(cs -> {

            BYGConfigHandler.CONFIG_EXCEPTIONS.clear();

            BYGConfigHandler.loadAllConfigs(true, false, ModPlatform.INSTANCE.isClientEnvironment());


            if (!BYGConfigHandler.CONFIG_EXCEPTIONS.isEmpty()) {
                BYG.logConfigErrors();
                BYGConfigHandler.displayChatErrors(cs.getSource().getPlayerOrException());
            } else {
                cs.getSource().sendSuccess(() -> Component.translatable("byg.command.validateconfig.success").withStyle(ChatFormatting.GREEN), true);
                cs.getSource().sendSuccess(() -> Component.translatable("byg.command.validateconfig.notifyrestart").withStyle(ChatFormatting.YELLOW), true);
            }

            return 1;
        });
    }

}
