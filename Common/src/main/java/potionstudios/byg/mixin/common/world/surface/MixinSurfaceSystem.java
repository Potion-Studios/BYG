package potionstudios.byg.mixin.common.world.surface;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.BlockColumn;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.util.SeedGetter;

@Mixin(SurfaceSystem.class)
public abstract class MixinSurfaceSystem implements SeedGetter {

    @Shadow protected abstract void erodedBadlandsExtension(BlockColumn blockColumn, int i, int j, int k, LevelHeightAccessor levelHeightAccessor);

    private long worldSeed;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void obtainSeed(Registry<NormalNoise.NoiseParameters> registry, BlockState state, int $$2, long worldSeed, WorldgenRandom.Algorithm algorithm, CallbackInfo ci) {
        this.worldSeed = worldSeed;
    }

    @Inject(method = "buildSurface", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Holder;is(Lnet/minecraft/resources/ResourceKey;)Z", shift = At.Shift.BEFORE, ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
    private void addBYGErodedBadlandsExtension(BiomeManager $$0, Registry<Biome> $$1, boolean $$2, WorldGenerationContext $$3, ChunkAccess $$4, NoiseChunk $$5, SurfaceRules.RuleSource $$6, CallbackInfo ci, BlockPos.MutableBlockPos $$7, ChunkPos $$8, int $$9, int $$10, BlockColumn blockColumn, SurfaceRules.Context $$12, SurfaceRules.SurfaceRule $$13, BlockPos.MutableBlockPos $$14, int $$15, int $$16, int $$17, int $$18, int $$19, Holder<Biome> biome) {
        if (biome.is(BYGBiomes.SHATTERED_GLACIER) || biome.is(BYGBiomes.SIERRA_BADLANDS)) {
            this.erodedBadlandsExtension(blockColumn, $$17, $$18, $$19, $$4);
        }
    }

    @Override
    public long getSeedAsLong() {
        return this.worldSeed;
    }
}
