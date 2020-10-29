package corgiaoc.byg.common.properties.blocks.nether.glowstonegardens;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class HangingVinesPlantBlock extends AbstractPlantBlock {
    public static final VoxelShape field_235637_d_ = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected HangingVinesPlantBlock(AbstractBlock.Settings properties) {
        super(properties, Direction.DOWN, field_235637_d_, false);
    }

    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) BYGBlocks.WEEPING_ROOTS;
    }
}

