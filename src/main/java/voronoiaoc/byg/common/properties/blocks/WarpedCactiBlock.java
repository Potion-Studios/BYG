package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class WarpedCactiBlock extends CactusBlock  {
    protected WarpedCactiBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isAreaLoaded(pos, 1))
            return; // Forge: prevent growing cactus from loading unloaded chunks with block update
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        } else {
            BlockPos blockpos = pos.up();
            if (worldIn.isAirBlock(blockpos)) {
                int i;
                for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i) {
                }

                if (i < 3) {
                    int j = state.get(AGE);
                    if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, true)) {
                        if (j == 15) {
                            worldIn.setBlockState(blockpos, this.getDefaultState());
                            BlockState blockstate = state.with(AGE, Integer.valueOf(0));
                            worldIn.setBlockState(pos, blockstate, 4);
                            blockstate.neighborChanged(worldIn, blockpos, this, pos, false);
                        } else {
                            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)), 4);
                        }
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                    }
                }
            }
        }
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
            Material material = blockstate.getMaterial();
            if (material.isSolid() || worldIn.getFluidState(pos.offset(direction)).isTagged(FluidTags.LAVA)) {
                return false;
            }
        }
        return worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.NYLIUM_SOUL_SAND || worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.NYLIUM_SOUL_SOIL || worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.WARPED_CACTUS && !worldIn.getBlockState(pos.up()).getMaterial().isLiquid() && worldIn.getDimension().isNether();
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        return this.getDefaultState();
    }
}


