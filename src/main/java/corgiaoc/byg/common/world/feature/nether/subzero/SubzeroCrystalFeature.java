package corgiaoc.byg.common.world.feature.nether.subzero;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class SubzeroCrystalFeature extends Feature<NoFeatureConfig> {
    private static final BlockStateMatcher IS_TRAVERTINE = BlockStateMatcher.forBlock(BYGBlocks.TRAVERTINE);

    public SubzeroCrystalFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {

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
