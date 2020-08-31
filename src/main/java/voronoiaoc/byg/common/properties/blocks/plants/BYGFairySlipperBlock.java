package voronoiaoc.byg.common.properties.blocks.plants;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BYGFairySlipperBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final MobEffect stewEffect;
    private final int stewEffectDuration;

    public BYGFairySlipperBlock(MobEffect statusEffect, int duration, Properties properties) {
        super(properties);
        this.stewEffect = statusEffect;
        if (statusEffect.isInstantenous()) {
            this.stewEffectDuration = duration;
        } else {
            this.stewEffectDuration = duration * 20;
        }

    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 vec3D = state.getOffset(world, pos);
        return SHAPE.move(vec3D.x, vec3D.y, vec3D.z);
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(BlockTags.LOGS);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public MobEffect getEffectInStew() {
        return this.stewEffect;
    }

    public int getEffectInStewDuration() {
        return this.stewEffectDuration;
    }
}