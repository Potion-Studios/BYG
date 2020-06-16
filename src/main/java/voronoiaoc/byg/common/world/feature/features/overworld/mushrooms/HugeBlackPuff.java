package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class HugeBlackPuff extends Feature<DefaultFeatureConfig> {
    public HugeBlackPuff(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);
        int randomStemHeight = rand.nextInt(5) + 3;
        if (!worldIn.isAir
                (pos) || worldIn.getBlockState(pos.down()).getBlock() == Blocks.DIRT) {
            return false;
        } else {
            for (int height = 0; height <= 5; height++) {
                worldIn.setBlockState(mutable.move(Direction.UP, height), BYGBlockList.BROWN_MUSHROOM_STEM.getDefaultState(), 2);
            }

//            for (int idx = 0; idx <= 2; idx++) {
//                BlockPos.Mutable mutable2 = new BlockPos.Mutable(mutable);
//                worldIn.setBlockState(mutable2, BYGBlockList.BROWN_MUSHROOM_STEM.getDefaultState(), 2);
//                for (Direction direction : Direction.Type.HORIZONTAL) {
//                    mutable2.offset(direction, idx);
//                    mutable2.offset(Direction.UP, idx);
//                }
//            }
            return true;
        }
    }
}