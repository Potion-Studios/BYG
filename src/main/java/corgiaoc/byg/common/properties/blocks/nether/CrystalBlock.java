package corgiaoc.byg.common.properties.blocks.nether;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CrystalBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public CrystalBlock(Properties builder) {
        super(builder);

    }

    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d Vector3d = state.getOffset(worldIn, pos);
        return SHAPE.move(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.GHAST && entityIn.getType() != EntityType.HOGLIN && entityIn.getType() != EntityType.ENDERMAN) {
            double d0 = Math.abs(entityIn.getX() - entityIn.xOld);
            double d1 = Math.abs(entityIn.getZ() - entityIn.zOld);
            if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                entityIn.hurt(DamageSource.CACTUS, 3.0F);
            }
        }

    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return canSupportRigidBlock(worldIn, blockpos) || canSupportCenter(worldIn, blockpos, Direction.UP);
    }
}
