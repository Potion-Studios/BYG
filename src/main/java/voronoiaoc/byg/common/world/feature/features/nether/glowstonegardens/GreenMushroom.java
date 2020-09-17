package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class GreenMushroom extends Feature<NoFeatureConfig> {
    public GreenMushroom(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.OVERGROWN_NETHERRACK) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlockList.GREEN_MUSHSHROOM.getDefaultState(), 10);
            return true;
        }
    }
}