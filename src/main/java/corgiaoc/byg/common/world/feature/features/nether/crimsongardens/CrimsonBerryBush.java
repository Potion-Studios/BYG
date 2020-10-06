package corgiaoc.byg.common.world.feature.features.nether.crimsongardens;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.byglists.BYGBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import corgiaoc.byg.common.properties.blocks.nether.crimson.CrimsonBerryBushBlock;

import java.util.Random;

public class CrimsonBerryBush extends Feature<NoFeatureConfig> {
    public CrimsonBerryBush(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlocks.CRIMSON_BERRY_BUSH.getDefaultState().with(CrimsonBerryBushBlock.AGE, Integer.valueOf(3)), 10);
            return true;
        }
    }
}