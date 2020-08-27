package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VinePlacer extends Feature<NoneFeatureConfiguration> {
    public VinePlacer(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos().set(blockPos);
        BlockPos.MutableBlockPos mainMutable = new BlockPos.MutableBlockPos().set(block);
        BlockState currentBlockToReplace = worldIn.getBlockState(mainMutable);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState stoneCheck = worldIn.getBlockState(mainMutable.relative(direction));

            if (currentBlockToReplace != Blocks.AIR.defaultBlockState() && stoneCheck != Blocks.STONE.defaultBlockState()) {
                return false;
            } else if (currentBlockToReplace == Blocks.AIR.defaultBlockState() && stoneCheck == Blocks.STONE.defaultBlockState()) {
                for (int placeY = 0; placeY <= rand.nextInt(66) + 10; placeY++) {
                    worldIn.setBlock(mainMutable.move(Direction.DOWN, placeY), Blocks.VINE.defaultBlockState().setValue(VineBlock.getPropertyForFace(direction.getOpposite()), Boolean.valueOf(true)), 2);
                }
            }
        }
        return true;
    }
}