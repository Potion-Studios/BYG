package potionstudios.byg.mixin.common.world.surface;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.BlockColumn;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.*;
import org.spongepowered.asm.mixin.Final;
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

    @Shadow
    protected abstract void erodedBadlandsExtension(BlockColumn blockColumn, int i, int j, int k, LevelHeightAccessor levelHeightAccessor);

    @Shadow
    @Final
    private PositionalRandomFactory noiseRandom;

    @Inject(method = "buildSurface", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Holder;is(Lnet/minecraft/resources/ResourceKey;)Z", shift = At.Shift.BEFORE, ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
    private void addBYGErodedBadlandsExtension(RandomState $$0, BiomeManager $$1, Registry<Biome> $$2, boolean $$3, WorldGenerationContext $$4, ChunkAccess chunkAccess, NoiseChunk $$6, SurfaceRules.RuleSource $$7, CallbackInfo ci, BlockPos.MutableBlockPos $$8, ChunkPos $$9, int $$10, int $$11, BlockColumn blockColumn, SurfaceRules.Context $$13, SurfaceRules.SurfaceRule $$14, BlockPos.MutableBlockPos $$15, int $$16, int $$17, int $$18, int $$19, int $$20, Holder<Biome> biome) {
        if (biome.is(BYGBiomes.SHATTERED_GLACIER) || biome.is(BYGBiomes.SIERRA_BADLANDS)) {
            this.erodedBadlandsExtension(blockColumn, $$18, $$19, $$20, chunkAccess);
        }
    }

    @Override
    public PositionalRandomFactory getRandom() {
        return this.noiseRandom;
    }
}
