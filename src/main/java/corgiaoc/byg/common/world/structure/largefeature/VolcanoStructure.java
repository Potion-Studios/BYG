package corgiaoc.byg.common.world.structure.largefeature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class VolcanoStructure extends StructureFeature<DefaultFeatureConfig> {
    public VolcanoStructure(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {

        private static FastNoiseLite fnlPerlin = null;
        private final long seed;

        public Start(StructureFeature<DefaultFeatureConfig> structure, int chunkX, int chunkZ, BlockBox boundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
            this.seed = seed;
        }

        @Override
        public void init(DynamicRegistryManager dynamicRegistry, ChunkGenerator generator, StructureManager templateManager, int chunkX, int chunkZ, Biome biome, DefaultFeatureConfig config) {
            setSeed(this.seed);

            int x = chunkX * 16;
            int z = chunkZ * 16;
            BlockPos blockpos = new BlockPos(x + 9, 90, z + 9);


            int baseRadius = 25;
            double lavaLeakage = 0.7;
            int volcanoConeSize = 150;
            int volcanoStartHeight = volcanoConeSize - 5;
            double threshold = 0.5;


            this.children.add(new VolcanoPiece(blockpos, baseRadius, lavaLeakage, volcanoConeSize, volcanoStartHeight, threshold, fnlPerlin, 0, volcanoConeSize, 0, volcanoConeSize));
            this.children.add(new VolcanoPiece(blockpos, baseRadius, lavaLeakage, volcanoConeSize, volcanoStartHeight, threshold, fnlPerlin, volcanoConeSize, 0, 0, volcanoConeSize));
            this.children.add(new VolcanoPiece(blockpos, baseRadius, lavaLeakage, volcanoConeSize, volcanoStartHeight, threshold, fnlPerlin, volcanoConeSize, 0, volcanoConeSize, 0));
            this.children.add(new VolcanoPiece(blockpos, baseRadius, lavaLeakage, volcanoConeSize, volcanoStartHeight, threshold, fnlPerlin, 0, volcanoConeSize, volcanoConeSize, 0));
            this.setBoundingBoxFromChildren();
        }


        public void setSeed(long seed) {
            if (fnlPerlin == null) {
                fnlPerlin = FastNoiseLite.createSpongePerlin((int) seed);
                fnlPerlin.SetFrequency(0.2F);
            }
        }
    }
}
