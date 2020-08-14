package voronoiaoc.byg.common.world.feature.features.nether.emburbog;

import com.mojang.serialization.Codec;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class EmburLily extends Feature<NoFeatureConfig> {
    public EmburLily(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn,  ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || !worldIn.getFluidState(pos.down()).isTagged(FluidTags.LAVA)) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlockList.EMBUR_LILY.getDefaultState(), 10);
            return true;
        }
    }
}