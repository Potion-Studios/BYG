package voronoiaoc.byg.common.world.structure.village;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.structure.VillageStructure;
import net.minecraft.world.gen.feature.template.TemplateManager;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGFeatureList;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

public class BYGVillageStructure extends VillageStructure {
    public BYGVillageStructure(Function<Dynamic<?>, ? extends VillageConfig> villageConfig) {
        super(villageConfig);
    }

    @Override
    public IStartFactory getStartFactory() {
        return BYGVillageStructure.Start::new;
    }

    @Override
    public String getStructureName() {
        return BYG.MOD_ID + ":village";
    }

    @Override
    public int getSize() {
        return 16;
    }

    public static class Start extends MarginedStructureStart {
        public Start(Structure<?> structure, int chunkPosX, int chunkPosZ, MutableBoundingBox boundingBox, int structureStart, long seed) {
            super(structure, chunkPosX, chunkPosZ, boundingBox, structureStart, seed);
        }

        @ParametersAreNonnullByDefault
        public void init(ChunkGenerator<?> chunkGen, TemplateManager template, int x, int z, Biome biome) {
            VillageConfig villageConfig = chunkGen.getStructureConfig(biome, BYGFeatureList.BYGVILLAGE);
            BlockPos blockPos = new BlockPos(x * 16, 0, z * 16);
            assert villageConfig != null;
            BYGVillagePieces.addPieces(chunkGen, template, blockPos, this.components, this.rand, villageConfig);
            this.recalculateStructureSize();
        }
    }
}
