package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class JacarandaBushBlock extends BushBlock implements BonemealableBlock {

    public JacarandaBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, BlockState p_180670_4_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, Random rand, BlockPos pos, BlockState state) {
        JacarandaBushBlock flowering = (JacarandaBushBlock) (this == BYGBlocks.JACARANDA_BUSH ? BYGBlocks.FLOWERING_JACARANDA_BUSH : BYGBlocks.FLOWERING_JACARANDA_BUSH);
        if (flowering.defaultBlockState().canSurvive(world, pos)) {
            flowering.placeAt(world, pos, 1);
        }
    }

    public void placeAt(LevelAccessor p_196390_1_, BlockPos p_196390_2_, int p_196390_3_) {
        p_196390_1_.setBlock(p_196390_2_, this.defaultBlockState(), p_196390_3_);
    }

}
