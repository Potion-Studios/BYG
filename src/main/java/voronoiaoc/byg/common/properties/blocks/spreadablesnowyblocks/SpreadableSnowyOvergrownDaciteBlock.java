package voronoiaoc.byg.common.properties.blocks.spreadablesnowyblocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.SnowyBlock;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SpreadableSnowyOvergrownDaciteBlock extends SnowyBlock {
    public SpreadableSnowyOvergrownDaciteBlock(Settings properties) {
        super(properties);
    }

    private static boolean canSurvive(BlockState state, WorldView worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.up();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        if (blockstate.getBlock() == Blocks.SNOW && blockstate.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else {
            int i = ChunkLightProvider.getRealisticOpacity(worldReader, state, blockPos, blockstate, blockpos, Direction.UP, blockstate.getOpacity(worldReader, blockpos));
            return i < worldReader.getMaxLightLevel();
        }
    }

    private static boolean canSpread(BlockState state, WorldView worldReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.up();
        return canSurvive(state, worldReader, blockPos) && !worldReader.getFluidState(blockpos).isIn(FluidTags.WATER);
    }

    public void randomDisplayTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
        if (!canSurvive(state, worldIn, pos)) {
            if (!SpreadableSythianBlock.isAreaLoaded(pos, 3, worldIn))
                return;
            worldIn.setBlockState(pos, BYGBlockList.DACITE.getDefaultState());
        } else {
            if (worldIn.getBrightness(pos.up()) >= 9) {
                BlockState blockstate = this.getDefaultState();

                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (worldIn.getBlockState(blockpos).getBlock() == BYGBlockList.DACITE && canSpread(blockstate, worldIn, blockpos)) {
                        worldIn.setBlockState(blockpos, blockstate.with(SNOWY, Boolean.valueOf(worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.SNOW)));
                    }
                }
            }
        }
    }
}
