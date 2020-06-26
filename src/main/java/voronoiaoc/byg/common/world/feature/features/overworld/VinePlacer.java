package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class VinePlacer extends Feature<NoFeatureConfig> {
    public VinePlacer(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_230362_a_(ISeedReader worldIn, StructureManager structureManager, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().setPos(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().setPos(block);
        BlockState currentBlockToReplace = worldIn.getBlockState(mainMutable);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState stoneCheck = worldIn.getBlockState(mainMutable.offset(direction));

            if (currentBlockToReplace != Blocks.AIR.getDefaultState() && stoneCheck != Blocks.STONE.getDefaultState()) {
                return false;
            } else if (currentBlockToReplace == Blocks.AIR.getDefaultState() && stoneCheck == Blocks.STONE.getDefaultState()) {
                for (int placeY = 0; placeY <= rand.nextInt(66) + 10; placeY++) {
                    worldIn.setBlockState(mainMutable.move(Direction.DOWN, placeY), Blocks.VINE.getDefaultState().with(VineBlock.getPropertyFor(direction.getOpposite()), Boolean.valueOf(true)), 2);
                }
            }
        }
        return true;
    }
}