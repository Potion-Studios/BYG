package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.Feature;

public class BYGFairySlipperBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final StatusEffect stewEffect;
    private final int stewEffectDuration;

    public BYGFairySlipperBlock(StatusEffect effect, int duration, Settings properties) {
        super(properties);
        this.stewEffect = effect;
        if (effect.isInstant()) {
            this.stewEffectDuration = duration;
        } else {
            this.stewEffectDuration = duration * 20;
        }

    }

    public VoxelShape getOutlineShape(BlockState state, BlockView reader, BlockPos pos, ShapeContext context) {
        Vec3d Vector3d = state.getModelOffset(reader, pos);
        return SHAPE.offset(Vector3d.x, Vector3d.y, Vector3d.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.getBlock().isIn(BlockTags.LOGS) || Feature.isSoil(state.getBlock());
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos posDown = pos.down();
        return this.canPlantOnTop(worldIn.getBlockState(posDown), worldIn, posDown);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

}