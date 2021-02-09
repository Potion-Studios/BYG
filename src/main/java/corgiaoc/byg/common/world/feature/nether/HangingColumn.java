package corgiaoc.byg.common.world.feature.nether;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.HangingColumnConfig;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class HangingColumn extends Feature<HangingColumnConfig> {
    public HangingColumn(Codec<HangingColumnConfig> config) {
        super(config);
    }

    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator generator, Random rand, BlockPos pos, HangingColumnConfig config) {
        int randLength = rand.nextInt(config.getMaxPossibleLength()) + config.getMinLength();
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

        if (worldIn.getRegistryManager().getOptional(Registry.BIOME_KEY).get().getKey(worldIn.getBiome(pos)).get() != BiomeKeys.THE_VOID) {
            //Code
        }

        if (!worldIn.isAir(pos)) {
            return false;
        } else if (!config.getWhitelist().contains(worldIn.getBlockState(pos.up()).getBlock())) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                if (worldIn.getBlockState(mutable).getMaterial() == Material.AIR)
                    worldIn.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 10);
                mutable.move(Direction.DOWN);
            }
            return true;
        }
    }
}