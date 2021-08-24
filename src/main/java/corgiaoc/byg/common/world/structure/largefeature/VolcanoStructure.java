package corgiaoc.byg.common.world.structure.largefeature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;

public class VolcanoStructure extends StructureFeature<NoneFeatureConfiguration> {
    public VolcanoStructure(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<NoneFeatureConfiguration> getStartFactory() {
        return Start::new;
    }

    public static class Start extends StructureStart<NoneFeatureConfiguration> {

        private final long seed;

        private static FastNoiseLite fnlPerlin = null;

        public Start(StructureFeature<NoneFeatureConfiguration> structure, int chunkX, int chunkZ, BoundingBox boundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
            this.seed = seed;
        }

        @Override
        public void generatePieces(RegistryAccess dynamicRegistry, ChunkGenerator generator, StructureManager templateManager, int chunkX, int chunkZ, Biome biome, NoneFeatureConfiguration config) {
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
