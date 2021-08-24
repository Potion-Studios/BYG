package corgiaoc.byg.common.world.feature.nether;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.HangingColumnConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class HangingColumn extends Feature<HangingColumnConfig> {
    public HangingColumn(Codec<HangingColumnConfig> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, HangingColumnConfig config) {
        int randLength = rand.nextInt(config.getMaxPossibleLength()) + config.getMinLength();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

        if (worldIn.registryAccess().registry(Registry.BIOME_REGISTRY).get().getResourceKey(worldIn.getBiome(pos)).get() != Biomes.THE_VOID) {
            //Code
        }

        if (!worldIn.isEmptyBlock(pos)) {
            return false;
        } else if (!config.getWhitelist().contains(worldIn.getBlockState(pos.above()).getBlock())) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                if (worldIn.getBlockState(mutable).getMaterial() == Material.AIR)
                    worldIn.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 10);
                mutable.move(Direction.DOWN);
            }
            return true;
        }
    }
}