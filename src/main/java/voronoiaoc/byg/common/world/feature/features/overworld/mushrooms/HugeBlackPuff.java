package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.function.Function;

public class HugeBlackPuff extends Feature<NoFeatureConfig> {
    public HugeBlackPuff(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
        super(config);
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable(pos);
        int randomStemHeight = rand.nextInt(5) + 3;
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock().isIn(Tags.Blocks.DIRT)) {
            return false;
        } else {
            for (int height = 0; height <= 5; height++) {
                worldIn.setBlockState(mutable.move(Direction.UP, height), BYGBlockList.BROWN_MUSHROOM_STEM.getDefaultState(), 2);
            }

//            for (int idx = 0; idx <= 2; idx++) {
//                BlockPos.Mutable mutable2 = new BlockPos.Mutable(mutable);
//                worldIn.setBlockState(mutable2, BYGBlockList.BROWN_MUSHROOM_STEM.getDefaultState(), 2);
//                for (Direction direction : Direction.Plane.HORIZONTAL) {
//                    mutable2.offset(direction, idx);
//                    mutable2.offset(Direction.UP, idx);
//                }
//            }
            return true;
        }
    }
}