package voronoiaoc.byg.common.properties.blocks.embur;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEngine;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SpreadableEmburBlock extends Block {
    public SpreadableEmburBlock(BlockBehaviour.Properties properties) {
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

    private static boolean func_220256_c(BlockState state, LevelReader worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.above();
        return canSurviveHere(state, worldReader, blockPos) && !worldReader.getFluidState(blockpos).is(FluidTags.LAVA);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, Random rand) {
        if (!canSurvive(state, world, pos)) {
            if (!isAreaLoaded(pos, 3, world))
                return;
            world.setBlockAndUpdate(pos, BYGBlockList.BLUE_NETHERRACK.defaultBlockState());
        } else {
            if (world.getMaxLocalRawBrightness(pos.above()) <= 12) {
                BlockState blockstate = this.defaultBlockState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (world.getBlockState(blockpos).getBlock() == BYGBlockList.BLUE_NETHERRACK && func_220256_c(blockstate, world, blockpos)) {
                    }
                }
            }

        }
    }

    public static boolean isAreaLoaded(BlockPos center, int range, Level world) {
        return world.hasChunksAt(center.offset(-range, -range, -range), center.offset(range, range, range));
    }
}
