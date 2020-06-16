package voronoiaoc.byg.common.properties.blocks.spreadablesnowyblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

import java.util.Random;

public class SpreadableIvisBlock extends Block {
    public SpreadableIvisBlock(Settings properties) {
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


    public void randomDisplayTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
        if (!canSurvive(state, worldIn, pos)) {
            if (!SpreadableSythianBlock.isAreaLoaded(pos, 3, worldIn))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            worldIn.setBlockState(pos, Blocks.END_STONE.getDefaultState());
        } else {
            if (worldIn.getBrightness(pos.up()) >= 9) {
                BlockState blockstate = this.getDefaultState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE) {
                    }
                }
            }

        }
    }
}
