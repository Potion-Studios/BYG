package corgiaoc.byg.mixin.client;

import corgiaoc.byg.helper.BlockEntityPacketHandler;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ClientPacketListener.class)
public class MixinClientPlayNetHandler {


    @Inject(method = "handleBlockEntityData", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/protocol/game/ClientboundBlockEntityDataPacket;getType()I"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void byg_ApplyPacketRead(ClientboundBlockEntityDataPacket packet, CallbackInfo ci, BlockPos blockEntityPos, BlockEntity blockEntity) {
        if (blockEntity instanceof BlockEntityPacketHandler) {
            ((BlockEntityPacketHandler) blockEntity).handleClientPacketNoTypeCheck(packet);
        }
    }
}
