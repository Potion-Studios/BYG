package potionstudios.byg.mixin.common;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.server.level.BYGPlayerTrackedData;

@Mixin(PlayerList.class)
public class MixinPlayerList {

    @Inject(method = "sendLevelInfo", at = @At("RETURN"))
    private void onPlayerSpawn(ServerPlayer player, ServerLevel level, CallbackInfo ci) {
        ((BYGPlayerTrackedData.Access) player).getPlayerTrackedData().playerCreate(player);
    }
}
