package corgiaoc.byg.common.world.structure.largefeature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class VolcanoStructure extends Structure<NoFeatureConfig> {
    public VolcanoStructure(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {

        private final long seed;

        private static FastNoiseLite fnlPerlin = null;

        public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
            this.seed = seed;
        }

        @Override
        public void generatePieces(DynamicRegistries dynamicRegistry, ChunkGenerator generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
            setSeed(this.seed);

            int x = chunkX * 16;
            int z = chunkZ * 16;
            BlockPos blockpos = new BlockPos(x + 9, 90, z + 9);


            int baseRadius = 25;
            double lavaLeakage = 0.7;
            int volcanoConeSize = 150;
            int volcanoStartHeight = volcanoConeSize - 5;
            double threshold = 0.5;


            this.pieces.add(new VolcanoPiece(blockpos, baseRadius, lavaLeakage, volcanoConeSize, volcanoStartHeight, threshold, fnlPerlin, 0, volcanoConeSize, 0, volcanoConeSize));
            this.pieces.add(new VolcanoPiece(blockpos, baseRadius, lavaLeakage, volcanoConeSize, volcanoStartHeight, threshold, fnlPerlin, volcanoConeSize, 0, 0, volcanoConeSize));
            this.pieces.add(new VolcanoPiece(blockpos, baseRadius, lavaLeakage, volcanoConeSize, volcanoStartHeight, threshold, fnlPerlin, volcanoConeSize, 0, volcanoConeSize, 0));
            this.pieces.add(new VolcanoPiece(blockpos, baseRadius, lavaLeakage, volcanoConeSize, volcanoStartHeight, threshold, fnlPerlin, 0, volcanoConeSize, volcanoConeSize, 0));
            this.calculateBoundingBox();
        }


        public void setSeed(long seed) {
            if (fnlPerlin == null) {
                fnlPerlin = FastNoiseLite.createSpongePerlin((int) seed);
                fnlPerlin.SetFrequency(0.2F);
            }
        }
    }
}
