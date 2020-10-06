package corgiaoc.byg.common.properties.blocks.nether.glowstonegardens;

import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import corgiaoc.byg.core.byglists.BYGBlockList;

public class SoulShroomSporeBlock extends AbstractBodyPlantBlock {
    public static final VoxelShape field_235637_d_ = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected SoulShroomSporeBlock(Properties properties) {
        super(properties, Direction.DOWN, field_235637_d_, false);
    }

    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock) BYGBlockList.SOUL_SHROOM_SPORE_END;
    }
}

