package voronoiaoc.byg.common.world.structure.misc.reddesert;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import voronoiaoc.byg.BYG;

import java.util.function.Function;

public class RedDesertTempleStructure extends ScatteredStructure<NoFeatureConfig> {
    public RedDesertTempleStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
        super(config);
    }

    @Override
    public String getStructureName() {
        return BYG.MOD_ID + ":red_desert_temple";
    }

    public int getSize() {
        return 3;
    }

    public Structure.IStartFactory getStartFactory() {
        return RedDesertTempleStructure.Start::new;
    }

    protected int getSeedModifier() {
        return 34543;
    }

    public static class Start extends StructureStart {
        public Start(Structure<?> structure, int p_i225801_2_, int p_i225801_3_, MutableBoundingBox p_i225801_4_, int p_i225801_5_, long p_i225801_6_) {
            super(structure, p_i225801_2_, p_i225801_3_, p_i225801_4_, p_i225801_5_, p_i225801_6_);
        }

        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            RedDesertTemplePiece redDesertTemplePiece = new RedDesertTemplePiece(this.rand, chunkX * 16, chunkZ * 16);
            this.components.add(redDesertTemplePiece);
            this.recalculateStructureSize();
        }
    }
}