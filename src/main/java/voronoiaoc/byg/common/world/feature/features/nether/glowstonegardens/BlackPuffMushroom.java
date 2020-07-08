package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class BlackPuffMushroom extends Feature<DefaultFeatureConfig> {
    public BlackPuffMushroom(Codec<DefaultFeatureConfig> config) {
        super(config);
    }


    public boolean generate(ServerWorldAccess worldIn, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {

        if (!worldIn.isAir(pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.OVERGROWN_NETHERRACK) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlockList.BLACK_PUFF.getDefaultState(), 10);
            return true;
        }
    }
}