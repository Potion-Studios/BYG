package potionstudios.byg.mixin.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomes;

/**
 * GrassBlockMixin to allow us to have Prairie Grass spawn when bonemealing grass in the Prairie Biome.
 * @see GrassBlock
 * @see Mixin
 * @author Joseph T. McQuigg
 */
@Mixin(GrassBlock.class)
public abstract class MixinGrassBlock {

    @Inject(at = @At("HEAD"), method = "performBonemeal", cancellable = true)
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos blockPos, BlockState blockState, CallbackInfo ci) {
        if (level.getBiome(blockPos).is(BYGBiomes.PRAIRIE)) {
            level.setBlock(blockPos.above(), BYGBlocks.PRAIRIE_GRASS.defaultBlockState(), 2);
            ci.cancel();
        }
    }
}
