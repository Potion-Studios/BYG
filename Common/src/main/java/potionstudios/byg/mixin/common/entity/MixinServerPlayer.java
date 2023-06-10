package potionstudios.byg.mixin.common.entity;

import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.common.entity.player.extension.BiomepediaExtension;
import potionstudios.byg.server.level.BYGPlayerTrackedData;
import potionstudios.byg.util.BYGAdditionalData;

@Mixin(ServerPlayer.class)
public abstract class MixinServerPlayer implements BYGAdditionalData, BYGPlayerTrackedData.Access {

    @Inject(method = "doTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/critereon/PlayerTrigger;trigger(Lnet/minecraft/server/level/ServerPlayer;)V"))
    private void updateBygServerPlayerTrackedData(CallbackInfo ci) {
        this.getPlayerTrackedData().tickPerSecond((ServerPlayer) (Object) this);
    }

    @Inject(method = "restoreFrom", at = @At("RETURN"))
    private void keepBiomepediaFlags(ServerPlayer player, boolean keepEverything, CallbackInfo ci) {
        ((BiomepediaExtension) this).setGotBiomepedia(((BiomepediaExtension) player).gotBiomepedia());
    }
}