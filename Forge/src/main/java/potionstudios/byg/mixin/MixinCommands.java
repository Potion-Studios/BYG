package potionstudios.byg.mixin;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.IModInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYG;
import potionstudios.byg.server.command.GenDataCommand;
import potionstudios.byg.server.command.ReloadConfigsCommand;

import java.util.stream.Collectors;

@Mixin(Commands.class)
public class MixinCommands {

    @Shadow
    @Final
    private CommandDispatcher<CommandSourceStack> dispatcher;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void attachBYGCommands(Commands.CommandSelection environmentType, CallbackInfo ci) {
        GenDataCommand.dataGenCommand(this.dispatcher, ModList.get().getMods().stream().map(IModInfo::getModId).collect(Collectors.toSet()));
        LiteralArgumentBuilder<CommandSourceStack> bygCommands = Commands.literal(BYG.MOD_ID).requires(commandSource -> commandSource.hasPermission(3));
        bygCommands.then(ReloadConfigsCommand.register());
        dispatcher.register(bygCommands);
    }
}