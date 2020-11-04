package corgiaoc.byg.common.world.structure.largefeature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
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
        BYG.LOGGER.info("START FACTORY");
        return Start::new;
    }


    @Override
    public GenerationStage.Decoration getDecorationStage() {
        return GenerationStage.Decoration.RAW_GENERATION;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {

        public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
            BYG.LOGGER.info("CHHHHHHHHHHHHHHHHHHHHHHH");

        }

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistry, ChunkGenerator generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
            BYG.LOGGER.info("AHHHHHHHHHHHHHHHHHHHHHHH");
            int x = chunkX * 16;
            int z = chunkZ * 16;
            BlockPos blockpos = new BlockPos(x + 9, 90, z + 9);
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.components.add(new VolcanoPiece(blockpos));
            this.recalculateStructureSize();
        }
    }
}
