package potionstudios.byg.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.entry.BYGTerraBlenderEntry;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void byg_MinecraftInit(GameConfig gameConfig, CallbackInfo ci) {
        BYGTerraBlenderEntry.readOverworldSurfaceRules();
    }
}