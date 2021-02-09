package corgiaoc.byg.common.properties.blocks.nether.glowstonegardens;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class SoulShroomSporeBlock extends AbstractPlantBlock {
    public static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected SoulShroomSporeBlock(Settings properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) BYGBlocks.SOUL_SHROOM_SPORE_END;
    }
}

