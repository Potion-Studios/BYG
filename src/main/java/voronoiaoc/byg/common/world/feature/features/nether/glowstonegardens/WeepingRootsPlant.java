package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.serialization.Codec;
import net.minecraft.block.Material;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class WeepingRootsPlant extends Feature<DefaultFeatureConfig> {
    public WeepingRootsPlant(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public boolean generate(ServerWorldAccess worldIn, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        int randLength = random.nextInt(7) + 3;

        if (!worldIn.isAir(pos)) {
            return false;
        } else if (!worldIn.getBlockState(pos.up()).isIn(BlockTags.INFINIBURN_NETHER) || !(worldIn.getBlockState(pos.up()).getMaterial() == Material.STONE) && !worldIn.getDimension().isUltrawarm()) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos.getX(), pos.getY() - WeepingRootPlantLength, pos.getZ());
//            if (worldIn.getBlockState(mutable).getBlock() == Blocks.AIR)
                worldIn.setBlockState(mutable, BYGBlockList.WEEPING_ROOTS_PLANT.getDefaultState(), 10);
            }
            return true;
        }
    }
}