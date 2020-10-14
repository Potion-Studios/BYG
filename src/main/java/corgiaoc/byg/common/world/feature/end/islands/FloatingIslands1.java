package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import org.spongepowered.noise.module.source.Perlin;

import java.util.Random;

public class FloatingIslands1 extends Feature<NoFeatureConfig> {

    Perlin perlin = null;

    public FloatingIslands1(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setSeed(world.getSeed());

        double diameter = 11;

        if (world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4 )
            return false;

        for (double x = -diameter - 2; x <= diameter + 2; x++) {
            for (double y = -diameter - 2; y <= diameter + 11; y++) {
                for (double z = -diameter - 2; z <= diameter + 2; z++) {
                    double noise = perlin.getValue(x, y, z) * 12;
                    double scaledNoise = (noise / 11) * ((y * 3) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                        if (y >= 1) {
                            world.setBlockState(pos.add(x, y - 22, z), Blocks.END_STONE.getDefaultState(), 2);
                            if (y >= 20) {
                                world.setBlockState(pos.add(x, y - 22, z), Blocks.END_STONE.getDefaultState(), 2);
                                if (y >= 22) {
                                    //Top block
                                    world.setBlockState(pos.add(x, y - 22, z), BYGBlocks.NIGHTSHADE_PHYLIUM.getDefaultState(), 2);
                                }
                            }
                        }
                    }
                }
            }
        }


        return false;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = new Perlin();
            perlin.setSeed((int) seed);
            perlin.setFrequency(0.2);
        }
    }
}
