package voronoiaoc.byg.common.properties.blocks.plants;

import net.minecraft.block.*;
import net.minecraft.entity.Shearable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BYGSnowyPlants extends PlantBlock implements Shearable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    protected BYGSnowyPlants(Settings builder) {
        super(builder);

    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3D = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3D.x, vec3D.y, vec3D.z);
    }

    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.SNOW_BLOCK;
    }

    @Override
    public void sheared(SoundCategory shearedSoundCategory) {

    }

    @Override
    public boolean isShearable() {
        return false;
    }
}
