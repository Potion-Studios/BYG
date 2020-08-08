package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.serialization.Codec;
import net.minecraft.block.Material;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class WeepingRoots extends Feature<DefaultFeatureConfig> {
    public WeepingRoots(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        if (!worldIn.isAir(pos)) {
            return false;
        } else if (!worldIn.isAir(pos) || !(worldIn.getBlockState(pos.up()).getMaterial() == Material.STONE) || !worldIn.getBlockState(pos.up()).isIn(BlockTags.INFINIBURN_NETHER) && !worldIn.getDimension().isUltrawarm()) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlockList.WEEPING_ROOTS.getDefaultState(), 10);
            return true;
        }
    }
}