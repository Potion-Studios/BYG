package voronoiaoc.byg.common.properties.blocks.embur;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SpreadableEmburBlock extends Block {
    public SpreadableEmburBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    private static boolean canSurvive(BlockState state, WorldView worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.up();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        {
            int i = ChunkLightProvider.getRealisticOpacity(worldReader, state, blockPos, blockstate, blockpos, Direction.UP, blockstate.getOpacity(worldReader, blockpos));
            return i < worldReader.getMaxLightLevel();
        }
    }

    private static boolean func_220256_c(BlockState state, WorldView worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.up();
        return canSurvive(state, worldReader, blockPos) && !worldReader.getFluidState(blockpos).isIn(FluidTags.LAVA);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random rand) {
        if (!canSurvive(state, world, pos)) {
            if (!isAreaLoaded(pos, 3, world))
                return;
            world.setBlockState(pos, BYGBlockList.BLUE_NETHERRACK.getDefaultState());
        } else {
            if (world.getLightLevel(pos.up()) <= 12) {
                BlockState blockstate = this.getDefaultState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (world.getBlockState(blockpos).getBlock() == BYGBlockList.BLUE_NETHERRACK && func_220256_c(blockstate, world, blockpos)) {
                    }
                }
            }

        }
    }

    public static boolean isAreaLoaded(BlockPos center, int range, World world) {
        return world.isRegionLoaded(center.add(-range, -range, -range), center.add(range, range, range));
    }
}
