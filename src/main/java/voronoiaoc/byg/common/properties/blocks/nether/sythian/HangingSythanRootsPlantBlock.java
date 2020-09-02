package voronoiaoc.byg.common.properties.blocks.nether.sythian;

import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class HangingSythanRootsPlantBlock extends AbstractBodyPlantBlock {
    public static final VoxelShape field_235637_d_ = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected HangingSythanRootsPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, field_235637_d_, false);
    }

    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock)BYGBlockList.HANGING_SYTHIAN_ROOTS;
    }
}

