package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Random;

public class FillerSurfaceBuilder extends SurfaceBuilder<FillSurfaceBuilderConfig> {
    public FillerSurfaceBuilder(Codec<FillSurfaceBuilderConfig> config) {
        super(config);
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, FillSurfaceBuilderConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;

        int seaFloorHeight = chunkIn.getTopBlockY(Heightmap.Type.OCEAN_FLOOR_WG, x, z);


        if (startHeight <= seaLevel) {
            mutable.setPos(xPos, seaFloorHeight, zPos);
            for (int i = 0; i <= 3; i++) {
                if (i == 0)
                    chunkIn.setBlockState(mutable, config.getTopMaterial().getBlockState(random, mutable), false);
                else
                    chunkIn.setBlockState(mutable, config.getUnderMaterial().getBlockState(random, mutable), false);

                mutable.move(Direction.DOWN);
            }
        } else {
            mutable.setPos(xPos, startHeight, zPos);
            for (int i = 0; i <= 3; i++) {
                if (i == 0)
                    chunkIn.setBlockState(mutable, config.getTopMaterial().getBlockState(random, mutable), false);
                else
                    chunkIn.setBlockState(mutable, config.getUnderMaterial().getBlockState(random, mutable), false);

                mutable.move(Direction.DOWN);
            }

            mutable.setPos(xPos, startHeight - 3, zPos);


            for (int yPos = startHeight - 3; yPos >= config.getFillDownToY(); --yPos) {
                BlockState currentBlockToReplace = chunkIn.getBlockState(mutable);
                if (config.getReplaceList().contains(currentBlockToReplace.getBlock())) {
                    chunkIn.setBlockState(mutable, config.getFillMaterial().getBlockState(random, mutable), false);
                }
                mutable.move(Direction.DOWN);
            }

            mutable.setPos(xPos, startHeight + 1, zPos);

            if (config.getFillUpToY() > 0) {
                for (int yPos = startHeight + 1; yPos <= config.getFillUpToY(); ++yPos) {
                    BlockState currentBlockToReplace = chunkIn.getBlockState(mutable);
                    if (config.getReplaceList().contains(currentBlockToReplace.getBlock())) {
                        chunkIn.setBlockState(mutable, config.getFillMaterial().getBlockState(random, mutable), false);
                    }
                    mutable.move(Direction.DOWN);
                }
            }
        }
    }
}