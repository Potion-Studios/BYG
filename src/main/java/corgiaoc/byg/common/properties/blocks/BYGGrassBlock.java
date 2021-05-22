package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.mixin.access.SpreadableSnowyDirtBlockAccess;
import net.minecraft.block.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BYGGrassBlock extends GrassBlock implements IGrowable {

    @Nullable
    private final BlockClusterFeatureConfig featureConfig;
    private final Block dirtBlock;

    public BYGGrassBlock(Properties properties, @Nullable BlockClusterFeatureConfig featureConfig, Block dirtBlock) {
        super(properties);
        this.featureConfig = featureConfig;
        this.dirtBlock = dirtBlock;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!SpreadableSnowyDirtBlockAccess.invokeCanBeGrass(state, world, pos)) {
            world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
            return;
        }
        if (world.getMaxLocalRawBrightness(pos.above()) >= 9) {
            BlockState blockstate = this.defaultBlockState();

            for (int i = 0; i < 4; ++i) {
                BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if (world.getBlockState(blockpos).is(this.dirtBlock) && SpreadableSnowyDirtBlockAccess.invokeCanPropagate(blockstate, world, blockpos)) {
                    world.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, world.getBlockState(blockpos.above()).is(Blocks.SNOW)));
                }
            }
        }
    }

    @Override
    public void performBonemeal(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (featureConfig != null) {
            place(world, random, pos.above(), this.featureConfig);
        } else {
            List<ConfiguredFeature<?, ?>> flowerFeatures = world.getBiome(pos).getGenerationSettings().getFlowerFeatures();
            ConfiguredFeature<?, ?> flowerFeature = flowerFeatures.get(random.nextInt(flowerFeatures.size()));
            flowerFeature.place(world, world.getChunkSource().getGenerator(), random, pos);
            Features.PATCH_GRASS_NORMAL.place(world, world.getChunkSource().getGenerator(), random, pos);
        }
    }

    public static boolean place(ISeedReader world, Random random, BlockPos pos, BlockClusterFeatureConfig config) {
        int i = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int j = 0; j < config.tries; ++j) {
            mutable.setWithOffset(pos, random.nextInt(config.xspread + 1) - random.nextInt(config.xspread + 1), random.nextInt(config.yspread + 1) - random.nextInt(config.yspread + 1), random.nextInt(config.zspread + 1) - random.nextInt(config.zspread + 1));
            BlockPos blockpos1 = mutable.below();
            BlockState blockstate1 = world.getBlockState(blockpos1);
            BlockState blockstate = config.stateProvider.getState(random, mutable);

            if ((world.isEmptyBlock(mutable) || config.canReplace && world.getBlockState(mutable).getMaterial().isReplaceable()) && blockstate.canSurvive(world, mutable) && (config.whitelist.isEmpty() || config.whitelist.contains(blockstate1.getBlock())) && !config.blacklist.contains(blockstate1) && (!config.needWater || world.getFluidState(blockpos1.west()).is(FluidTags.WATER) || world.getFluidState(blockpos1.east()).is(FluidTags.WATER) || world.getFluidState(blockpos1.north()).is(FluidTags.WATER) || world.getFluidState(blockpos1.south()).is(FluidTags.WATER))) {
                config.blockPlacer.place(world, mutable, blockstate, random);
                ++i;
            }
        }
        return i > 0;
    }
}
