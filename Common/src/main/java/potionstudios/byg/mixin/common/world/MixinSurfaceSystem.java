package potionstudios.byg.mixin.common.world;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.util.SeedGetter;

@Mixin(SurfaceSystem.class)
public class MixinSurfaceSystem implements SeedGetter {

    private long worldSeed;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void obtainSeed(Registry registry, BlockState state, int $$2, long worldSeed, WorldgenRandom.Algorithm algorithm, CallbackInfo ci) {
        this.worldSeed = worldSeed;
    }

    @Override
    public long getLong() {
        return this.worldSeed;
    }
}
