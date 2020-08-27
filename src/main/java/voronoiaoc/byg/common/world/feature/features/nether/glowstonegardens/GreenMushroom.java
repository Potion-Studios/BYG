package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GreenMushroom extends Feature<NoneFeatureConfiguration> {
    public GreenMushroom(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {

        if (!worldIn.isEmptyBlock(pos) || worldIn.getBlockState(pos.below()).getBlock() != BYGBlockList.OVERGROWN_NETHERRACK) {
            return false;
        } else {
            worldIn.setBlock(pos, BYGBlockList.GREEN_MUSHSHROOM.defaultBlockState(), 10);
            return true;
        }
    }
}