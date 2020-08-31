package voronoiaoc.byg.common.properties.blocks.embur;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class EmburPlantBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected EmburPlantBlock(BlockBehaviour.Properties builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 yes = state.getOffset(world, pos);
        return SHAPE.move(yes.x, yes.y, yes.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        Block block = floor.getBlock();
        return block == BYGBlockList.SYTHIAN_NYLIUM || block == Blocks.NETHERRACK || block == BYGBlockList.OVERGROWN_NETHERRACK || block == BYGBlockList.EMBUR_NYLIUM || block == BYGBlockList.BLUE_NETHERRACK;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return this.mayPlaceOn(world.getBlockState(pos.below()), world, pos.below());
    }
}

