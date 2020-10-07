package corgiaoc.byg.common.properties.blocks.nether.crimson;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NetherVegetationFeature;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CrimsonBlackstoneBlock extends SpreadableCrimsonBlackstoneBlock implements IGrowable {
    public CrimsonBlackstoneBlock(Properties properties) {
        super(properties);
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockState blockstate = worldIn.getBlockState(pos);
        BlockPos blockpos = pos.up();
        if (blockstate.isIn(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE)) {
            NetherVegetationFeature.func_236325_a_(worldIn, rand, blockpos, Features.Configs.CRIMSON_FOREST_VEGETATION_CONFIG, 3, 1);
        }
    }
}