package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class BYGDoublePlantBlock extends DoublePlantBlock {
    private final TagKey<Block> mayPlaceOn;

    public BYGDoublePlantBlock(Properties properties, TagKey<Block> mayPlaceOn) {
        super(properties);
        this.mayPlaceOn = mayPlaceOn;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return state.is(this.mayPlaceOn);
        } else {
            return state.is(this);
        }
    }
}
