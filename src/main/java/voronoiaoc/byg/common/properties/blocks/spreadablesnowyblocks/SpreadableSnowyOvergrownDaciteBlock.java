package voronoiaoc.byg.common.properties.blocks.spreadablesnowyblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEngine;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SpreadableSnowyOvergrownDaciteBlock extends SnowyDirtBlock {
    public SpreadableSnowyOvergrownDaciteBlock(Properties properties) {
        super(properties);
    }

    private static boolean canSurviveHere(BlockState state, LevelReader worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.above();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        if (blockstate.getBlock() == Blocks.SNOW && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else {
            int i = LayerLightEngine.getLightBlockInto(worldReader, state, blockPos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(worldReader, blockpos));
            return i < worldReader.getMaxLightLevel();
        }
    }

    private static boolean canSpread(BlockState state, LevelReader worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.above();
        return canSurviveHere(state, worldReader, blockPos) && !worldReader.getFluidState(blockpos).is(FluidTags.WATER);
    }

    public void animateTick(BlockState state, Level worldIn, BlockPos pos, Random rand) {
        if (!canSurvive(state, worldIn, pos)) {
            if (!SpreadableSythianBlock.isAreaLoaded(pos, 3, worldIn))
                return;
            worldIn.setBlockAndUpdate(pos, BYGBlockList.DACITE.defaultBlockState());
        } else {
            if (worldIn.getBrightness(pos.above()) >= 9) {
                BlockState blockstate = this.defaultBlockState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (worldIn.getBlockState(blockpos).getBlock() == BYGBlockList.DACITE && canSpread(blockstate, worldIn, blockpos)) {
                        worldIn.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, Boolean.valueOf(worldIn.getBlockState(blockpos.above()).getBlock() == Blocks.SNOW)));
                    }
                }
            }
        }
    }
}
