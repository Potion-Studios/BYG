package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.potion.Effect;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.Tags;

public class BYGFairySlipperBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final Effect stewEffect;
    private final int stewEffectDuration;

    public BYGFairySlipperBlock(Effect effect, int duration, Properties properties) {
        super(properties);
        this.stewEffect = effect;
        if (effect.isInstant()) {
            this.stewEffectDuration = duration;
        } else {
            this.stewEffectDuration = duration * 20;
        }

    }

    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        Vec3d vec3d = state.getOffset(reader, pos);
        return SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(BlockTags.LOGS) || state.isIn(Tags.Blocks.DIRT);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos posDown = pos.down();
        return this.isValidGround(worldIn.getBlockState(posDown), worldIn, posDown);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

}