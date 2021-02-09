package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

import java.util.Random;

public class StoneEndPlantBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public StoneEndPlantBlock(Settings builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView reader, BlockPos map, ShapeContext ctx) {
        Vec3d Vector3d = state.getModelOffset(reader, map);
        return SHAPE.offset(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (random.nextInt(25) == 0) {
            int i = 5;
            int j = 4;

            for (BlockPos blockpos : BlockPos.iterate(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (worldIn.getBlockState(blockpos).isOf(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

            for (int k = 0; k < 4; ++k) {
                if (worldIn.isAir(blockpos1) && state.canPlaceAt(worldIn, blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }

            if (worldIn.isAir(blockpos1) && state.canPlaceAt(worldIn, blockpos1)) {
                worldIn.setBlockState(blockpos1, state, 2);
            }
        }

    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.isIn(FabricTags.END_STONES) || super.canPlantOnTop(state, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}

