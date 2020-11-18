package corgiaoc.byg.common.properties.blocks.nether;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.Feature;

public class CrystalBlock extends Block {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public CrystalBlock(Settings builder) {
        super(builder);

    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        Vec3d Vector3d = state.getModelOffset(worldIn, pos);
        return SHAPE.offset(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.GHAST && entityIn.getType() != EntityType.HOGLIN && entityIn.getType() != EntityType.ENDERMAN) {
            double d0 = Math.abs(entityIn.getX() - entityIn.lastRenderX);
            double d1 = Math.abs(entityIn.getZ() - entityIn.lastRenderZ);
            if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                entityIn.damage(DamageSource.CACTUS, 3.0F);
            }
        }

    }

    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.canPlaceAt(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.isValidGround(worldIn.getBlockState(blockpos));
    }

    protected boolean isValidGround(BlockState state) {
        return state.getMaterial() == Material.STONE || state.isIn(FabricTags.END_STONES) || Feature.isSoil(state) || state.isIn(FabricTags.SAND) || state.isOf(BYGBlocks.QUARTZITE_SAND) || state.isOf(BYGBlocks.RAW_QUARTZ_BLOCK);
    }
}
