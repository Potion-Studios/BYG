package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

import java.util.Random;

public class FillerSurfaceBuilder extends SurfaceBuilder<FillSurfaceBuilderConfig> {
    public FillerSurfaceBuilder(Codec<FillSurfaceBuilderConfig> config) {
        super(config);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, FillSurfaceBuilderConfig config) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        int xPos = x & 15;
        int zPos = z & 15;

        int seaFloorHeight = chunkIn.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, x, z);


        if (startHeight <= seaLevel) {
            mutable.set(xPos, seaFloorHeight, zPos);
            for (int i = 0; i <= 3; i++) {
                if (i == 0)
                    chunkIn.setBlockState(mutable, config.getTopMaterialProvider().getState(random, mutable), false);
                else
                    chunkIn.setBlockState(mutable, config.getUnderMaterialProvider().getState(random, mutable), false);

                mutable.move(Direction.DOWN);
            }
        } else {
            mutable.set(xPos, startHeight, zPos);
            for (int i = 0; i <= 3; i++) {
                if (i == 0)
                    chunkIn.setBlockState(mutable, config.getTopMaterialProvider().getState(random, mutable), false);
                else
                    chunkIn.setBlockState(mutable, config.getUnderMaterialProvider().getState(random, mutable), false);

                mutable.move(Direction.DOWN);
            }

            mutable.set(xPos, startHeight - 3, zPos);


            for (int yPos = startHeight - 3; yPos >= config.getFillDownToY(); --yPos) {
                BlockState currentBlockToReplace = chunkIn.getBlockState(mutable);
                if (config.getReplaceList().contains(currentBlockToReplace.getBlock())) {
                    chunkIn.setBlockState(mutable, config.getFillMaterial().getState(random, mutable), false);
                }
                mutable.move(Direction.DOWN);
            }

            mutable.set(xPos, startHeight + 1, zPos);

            if (config.getFillUpToY() > 0) {
                for (int yPos = startHeight + 1; yPos <= config.getFillUpToY(); ++yPos) {
                    BlockState currentBlockToReplace = chunkIn.getBlockState(mutable);
                    if (config.getReplaceList().contains(currentBlockToReplace.getBlock())) {
                        chunkIn.setBlockState(mutable, config.getFillMaterial().getState(random, mutable), false);
                    }
                    mutable.move(Direction.DOWN);
                }
            }
        }
    }
}