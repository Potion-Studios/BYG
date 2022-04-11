package potionstudios.byg.mixin.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYG;
import potionstudios.byg.server.command.ReloadConfigsCommand;
import potionstudios.byg.server.command.WorldGenExportCommand;

@Mixin(Commands.class)
public class MixinCommands {

    @Shadow @Final private CommandDispatcher<CommandSourceStack> dispatcher;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void attachBYGCommands(Commands.CommandSelection environmentType, CallbackInfo ci) {
        WorldGenExportCommand.worldGenExportCommand(this.dispatcher);
        LiteralArgumentBuilder<CommandSourceStack> bygCommands = Commands.literal(BYG.MOD_ID).requires(commandSource -> commandSource.hasPermission(3));
        bygCommands.then(ReloadConfigsCommand.register());
        dispatcher.register(bygCommands);
    }
}