package voronoiaoc.byg.common.properties.blocks.spreadablesnowyblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEngine;

import java.util.Random;

public class SpreadableOvergrownNetherrackBlock extends Block {
    public SpreadableOvergrownNetherrackBlock(Properties properties) {
        super(properties);
    }

    private static boolean canSurviveHere(BlockState state, LevelReader worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.above();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        {
            int i = LayerLightEngine.getLightBlockInto(worldReader, state, blockPos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(worldReader, blockpos));
            return i < worldReader.getMaxLightLevel();
        }
    }

    private static boolean canSpread(BlockState state, LevelReader worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.above();
        return canSurviveHere(state, worldReader, blockPos) && !worldReader.getFluidState(blockpos).is(FluidTags.LAVA);
    }

    @Override
    public void animateTick(BlockState state, Level worldIn, BlockPos pos, Random rand) {
        if (!canSurvive(state, worldIn, pos)) {
            if (!isAreaLoaded(pos, 3, worldIn))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            worldIn.setBlockAndUpdate(pos, Blocks.NETHERRACK.defaultBlockState());
        } else {
            if (worldIn.getBrightness(pos.above()) >= 9) {
                BlockState blockstate = this.defaultBlockState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (worldIn.getBlockState(blockpos).getBlock() == Blocks.NETHERRACK && canSpread(blockstate, worldIn, blockpos)) {
                    }
                }
            }
        }
    }

    public static boolean isAreaLoaded(BlockPos center, int range, Level world) {
        return world.hasChunksAt(center.offset(-range, -range, -range), center.offset(range, range, range));
    }
}