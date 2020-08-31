package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class YeetSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public YeetSB(Codec<SurfaceBuilderBaseConfiguration> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = (int) (startHeight - 1 - noise); yPos >= -2; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            if (currentBlockToReplace == Blocks.STONE.defaultBlockState() || currentBlockToReplace == Blocks.BEDROCK.defaultBlockState() || currentBlockToReplace == Blocks.GRAVEL.defaultBlockState()) {
                chunkIn.setBlockState(block, Blocks.AIR.defaultBlockState(), false);
            }
        }
        if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_THEEND);
        } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.AIR_CF);
        } else {
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.AIR_CF);
        }

    }
}