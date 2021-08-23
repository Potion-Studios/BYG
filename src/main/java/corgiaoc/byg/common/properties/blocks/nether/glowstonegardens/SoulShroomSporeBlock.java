package corgiaoc.byg.common.properties.blocks.nether.glowstonegardens;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

public class SoulShroomSporeBlock extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected SoulShroomSporeBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    protected AbstractTopPlantBlock getHeadBlock() {
        return (AbstractTopPlantBlock) BYGBlocks.SOUL_SHROOM_SPORE_END;
    }
}

