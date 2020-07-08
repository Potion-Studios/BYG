package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class VinePlacer extends Feature<DefaultFeatureConfig> {
    public VinePlacer(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ServerWorldAccess worldIn, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().set(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().set(block);
        BlockState currentBlockToReplace = worldIn.getBlockState(mainMutable);

        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockState stoneCheck = worldIn.getBlockState(mainMutable.offset(direction));

            if (currentBlockToReplace != Blocks.AIR.getDefaultState() && stoneCheck != Blocks.STONE.getDefaultState()) {
                return false;
            } else if (currentBlockToReplace == Blocks.AIR.getDefaultState() && stoneCheck == Blocks.STONE.getDefaultState()) {
                for (int placeY = 0; placeY <= rand.nextInt(66) + 10; placeY++) {
                    worldIn.setBlockState(mainMutable.move(Direction.DOWN, placeY), Blocks.VINE.getDefaultState().with(VineBlock.getFacingProperty(direction.getOpposite()), Boolean.valueOf(true)), 2);
                }
            }
        }
        return true;
    }
}