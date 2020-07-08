package voronoiaoc.byg.common.world.feature.features.nether.emburbog;

import com.mojang.serialization.Codec;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class EmburLily extends Feature<DefaultFeatureConfig> {
    public EmburLily(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ServerWorldAccess worldIn, StructureAccessor structureAccessor, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        if (!worldIn.isAir(pos) || !worldIn.getFluidState(pos.down()).isIn(FluidTags.LAVA)) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlockList.EMBUR_LILY.getDefaultState(), 10);
            return true;
        }
    }
}