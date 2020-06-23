package voronoiaoc.byg.common.world.structure.village;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.VillageStructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.world.gen.feature.VillageFeature;

public class BYGVillageStructureFeature extends StructureFeature<StructurePoolFeatureConfig> {
    public BYGVillageStructureFeature(Codec<StructurePoolFeatureConfig> codec) {
        super(codec);
    }

    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return VillageFeature.Start::new;
    }

    public static class Start extends VillageStructureStart<StructurePoolFeatureConfig> {
        public Start(StructureFeature<StructurePoolFeatureConfig> structureFeature, int i, int j, BlockBox blockBox, int k, long l) {
            super(structureFeature, i, j, blockBox, k, l);
        }

        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int i, int j, Biome biome, StructurePoolFeatureConfig structurePoolFeatureConfig) {
            BlockPos blockPos = new BlockPos(i * 16, 0, j * 16);
            BYGVillagePieces.addPieces(chunkGenerator, structureManager, blockPos, this.children, this.random, structurePoolFeatureConfig);
            this.setBoundingBoxFromChildren();
        }
    }
}
