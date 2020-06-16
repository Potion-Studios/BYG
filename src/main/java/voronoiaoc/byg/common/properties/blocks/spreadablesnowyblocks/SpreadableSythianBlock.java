package voronoiaoc.byg.common.properties.blocks.spreadablesnowyblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public class SpreadableSythianBlock extends Block {
    public SpreadableSythianBlock(Settings properties) {
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

    private static boolean canSpread(BlockState state, WorldView worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.up();
        return canSurvive(state, worldReader, blockPos) && !worldReader.getFluidState(blockpos).matches(FluidTags.LAVA);
    }

    @Override
    public void randomDisplayTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
        if (!canSurvive(state, worldIn, pos)) {
            if (!isAreaLoaded(pos, 3, worldIn))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            worldIn.setBlockState(pos, Blocks.NETHERRACK.getDefaultState());
        } else {
            if (worldIn.getBrightness(pos.up()) >= 9) {
                BlockState blockstate = this.getDefaultState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (worldIn.getBlockState(blockpos).getBlock() == Blocks.NETHERRACK && canSpread(blockstate, worldIn, blockpos)) {
                    }
                }
            }
        }
    }

    public static boolean isAreaLoaded(BlockPos center, int range, World world) {
        return world.isRegionLoaded(center.add(-range, -range, -range), center.add(range, range, range));
    }
}