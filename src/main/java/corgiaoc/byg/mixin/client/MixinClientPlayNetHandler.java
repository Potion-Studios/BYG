package corgiaoc.byg.mixin.client;

import corgiaoc.byg.helper.BlockEntityPacketHandler;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ClientPlayNetHandler.class)
public class MixinClientPlayNetHandler {


    @Inject(method = "handleBlockEntityData", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/play/server/SUpdateTileEntityPacket;getType()I"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void byg_ApplyPacketRead(SUpdateTileEntityPacket packet, CallbackInfo ci, BlockPos blockEntityPos, TileEntity blockEntity) {
        if (blockEntity instanceof BlockEntityPacketHandler) {
            ((BlockEntityPacketHandler) blockEntity).handleClientPacketNoTypeCheck(packet);
        }
    }
}
