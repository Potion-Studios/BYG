package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BYGTallFlowerBlock extends TallFlowerBlock {
    private final TagKey<Block> validGround;

    public BYGTallFlowerBlock(Properties properties, TagKey<Block> validGround) {
        super(properties);
        this.validGround = validGround;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        return state.is(validGround);
    }
}
