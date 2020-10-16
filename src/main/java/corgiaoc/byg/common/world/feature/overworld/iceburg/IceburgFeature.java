package corgiaoc.byg.common.world.feature.overworld.iceburg;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.noise.module.source.Perlin;

import java.util.Random;

public class IceburgFeature extends Feature<SimpleBlockProviderConfig> {

    Perlin perlin = null;
    
    public IceburgFeature(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        double baseRadius = 4;
        int iceburgSize = 45;
        int iceburgStartHeight = iceburgSize + 50;
        
        for (double x = -iceburgSize; x <= iceburgSize; x++) {
            for (double y = -iceburgSize; y <= -1; y++) {
                for (double z = -iceburgSize; z <= iceburgSize; z++) {
                    double noise = perlin.getValue(x, y, z) * 12;
                    double scaledNoise = (noise / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                       if(y >= -37) {
                           mutable.setPos(pos).move((int) x, (int) y + iceburgStartHeight, (int) z);

                           world.setBlockState(mutable, Blocks.PACKED_ICE.getDefaultState(), 2);

                       }else{
                           mutable.setPos(pos).move((int) x, (int) y + iceburgStartHeight, (int) z);
                           world.setBlockState(mutable, Blocks.BLUE_ICE.getDefaultState(), 2);
                       }
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = new Perlin();
            perlin.setSeed((int) seed);
            perlin.setFrequency(0.2);
        }
    }
}
