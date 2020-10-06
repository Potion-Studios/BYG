package corgiaoc.byg.common.properties.blocks.nether.glowstonegardens;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import corgiaoc.byg.core.byglists.BYGBlocks;

public class HangingVinesPlantBlock extends AbstractBodyPlantBlock {
    public static final VoxelShape field_235637_d_ = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected HangingVinesPlantBlock(AbstractBlock.Properties properties) {
        super(properties, Direction.DOWN, field_235637_d_, false);
    }

    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock) BYGBlocks.WEEPING_ROOTS;
    }
}

