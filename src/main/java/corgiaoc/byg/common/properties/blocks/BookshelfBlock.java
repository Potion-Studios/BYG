package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class BookshelfBlock extends Block {
    public BookshelfBlock(Properties builder) {
        super(builder);
    }

    @Override
    public float getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos) {
        return 1f;
    }
}
