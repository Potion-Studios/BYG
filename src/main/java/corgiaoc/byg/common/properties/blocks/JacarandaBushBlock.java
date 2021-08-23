package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class JacarandaBushBlock extends BushBlock implements IGrowable {

    public JacarandaBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, BlockState p_180670_4_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        JacarandaBushBlock flowering = (JacarandaBushBlock) (this == BYGBlocks.JACARANDA_BUSH ? BYGBlocks.FLOWERING_JACARANDA_BUSH : BYGBlocks.FLOWERING_JACARANDA_BUSH);
        if (flowering.defaultBlockState().canSurvive(world, pos)) {
            flowering.placeAt(world, pos, 1);
        }
    }

    public void placeAt(IWorld p_196390_1_, BlockPos p_196390_2_, int p_196390_3_) {
        p_196390_1_.setBlock(p_196390_2_, this.defaultBlockState(), p_196390_3_);
    }

}
