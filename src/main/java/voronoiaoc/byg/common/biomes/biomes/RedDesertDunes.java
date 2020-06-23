package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class RedDesertDunes extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.REDDUNES_SB, BYGSBList.BYGSBConfigList.REDSAND_CF);
    static final Precipitation PRECIPATATION = Precipitation.NONE;
    static final Category CATEGORY = Category.DESERT;
    static final double DEPTH = 1.3F;
    static final double SCALE = 0.5F;
    static final float TEMPERATURE = 2.00F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public RedDesertDunes() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        ////this.addStructureFeature(Feature.VILLAGE.configure(new VillageConfig("village/desert/town_centers", 6)));
        ////this.addStructureFeature(Feature.PILLAGER_OUTPOST.configure(FeatureConfig.DEFAULT));
        ////this.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        ////this.addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT));
//        this.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, BYGStructureList.RED_DESERT_PYRAMID.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));
        ////this.addStructureFeature(BYGStructureList.RED_DESERT_PYRAMID.configure(FeatureConfig.DEFAULT));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.HUSK, 160, 10, 10));
    }
}
