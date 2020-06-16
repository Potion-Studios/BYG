package voronoiaoc.byg.common.properties.blocks.plants;

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

public class BYGFairySlipperBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final StatusEffect stewEffect;
    private final int stewEffectDuration;

    public BYGFairySlipperBlock(StatusEffect statusEffect, int duration, Settings properties) {
        super(properties);
        this.stewEffect = statusEffect;
        if (statusEffect.isInstant()) {
            this.stewEffectDuration = duration;
        } else {
            this.stewEffectDuration = duration * 20;
        }

    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3D = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3D.x, vec3D.y, vec3D.z);
    }

    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        return state.isIn(BlockTags.LOGS);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public StatusEffect getEffectInStew() {
        return this.stewEffect;
    }

    public int getEffectInStewDuration() {
        return this.stewEffectDuration;
    }
}