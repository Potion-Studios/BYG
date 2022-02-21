package potionstudios.byg.common.world.feature.gen.nether.subzero;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Random;

public class SubzeroCrystalFeature extends Feature<NoneFeatureConfiguration> {
    private static final BlockStatePredicate IS_TRAVERTINE = BlockStatePredicate.forBlock(BYGBlocks.TRAVERTINE);

    public SubzeroCrystalFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {

        int type = random.nextInt(2);

        if (type == 1) {
            //rules
            if (!IS_TRAVERTINE.test(world.getBlockState(pos.east(2)))) {
                return false;
            }

            if (!world.getBlockState(pos.east()).canOcclude()) {
                return false;
            }

            if (IS_TRAVERTINE.test(world.getBlockState(pos.below(3)))) {
                return false;
            }

            for (int y1 = 0; y1 <= 3; ++y1) {
                if (IS_TRAVERTINE.test(world.getBlockState(pos.above(y1)))) {
                    return false;
                }
            }

            //place
            for (int y1 = 0; y1 >= -3; --y1) {
                world.setBlock(pos.offset(0, y1, 1), getCrystalType(random), 3);
                world.setBlock(pos.offset(0, y1, 2), getCrystalType(random), 3);


            }
            for (int y1 = 0; y1 >= -2; --y1) {
                world.setBlock(pos.offset(0, y1, 0), getCrystalType(random), 3);
                world.setBlock(pos.offset(-1, y1, -1), getCrystalType(random), 3);
                world.setBlock(pos.offset(-1, y1, -2), getCrystalType(random), 3);
                world.setBlock(pos.offset(0, y1, -2), getCrystalType(random), 3);
                world.setBlock(pos.offset(0, y1, 2), getCrystalType(random), 3);

            }
            for (int y1 = 0; y1 >= -1; --y1) {
                world.setBlock(pos.offset(-1, y1, 0), getCrystalType(random), 3);
                world.setBlock(pos.offset(1, y1, -1), getCrystalType(random), 3);
                world.setBlock(pos.offset(-1, y1, 1), getCrystalType(random), 3);
                world.setBlock(pos.offset(-2, y1, 1), getCrystalType(random), 3);
                world.setBlock(pos.offset(-2, y1, 2), getCrystalType(random), 3);
            }
        }
        //rules
        else {
             if (!IS_TRAVERTINE.test(world.getBlockState(pos.west(2)))) {
                return false;
            }

        if (!world.getBlockState(pos.west()).canOcclude()) {
            return false;
        }

        if (IS_TRAVERTINE.test(world.getBlockState(pos.below(3)))) {
            return false;
        }

        for (int y1 = 0; y1 <= 3; ++y1) {
            if (IS_TRAVERTINE.test(world.getBlockState(pos.above(y1)))) {
                return false;
            }
        }

        //place
        for (int y1 = 0; y1 >= -3; --y1) {
            world.setBlock(pos.offset(0, y1, -1), getCrystalType(random), 3);
            world.setBlock(pos.offset(0, y1, -2), getCrystalType(random), 3);


        }
        for (int y1 = 0; y1 >= -2; --y1) {
            world.setBlock(pos.offset(0, y1, 0), getCrystalType(random), 3);
            world.setBlock(pos.offset(1, y1, 1), getCrystalType(random), 3);
            world.setBlock(pos.offset(0, y1, -2), getCrystalType(random), 3);
            world.setBlock(pos.offset(0, y1, 2), getCrystalType(random), 3);
            world.setBlock(pos.offset(1, y1, 2), getCrystalType(random), 3);
        }
        for (int y1 = 0; y1 >= -1; --y1) {
            world.setBlock(pos.offset(1, y1, 0), getCrystalType(random), 3);
            world.setBlock(pos.offset(-1, y1, 1), getCrystalType(random), 3);
            world.setBlock(pos.offset(1, y1, -1), getCrystalType(random), 3);
            world.setBlock(pos.offset(2, y1, -2), getCrystalType(random), 3);
        }
        for (int y1 = -1; y1 >= -2; --y1) {
            world.setBlock(pos.offset(3, y1, -2), getCrystalType(random), 3);
            world.setBlock(pos.offset(3, y1, -1), getCrystalType(random), 3);
            world.setBlock(pos.offset(2, -2, -1), getCrystalType(random), 3);
        }
    }
        return true;
    }


    public static BlockState getCrystalType(Random rand){
        int i = rand.nextInt(7);
        if (i <= 5){
            return BYGBlocks.SUBZERO_CRYSTAL_BLOCK.defaultBlockState();
        } else{
            return BYGBlocks.BUDDING_SUBZERO_CRYSTAL.defaultBlockState();
        }
    }
}
