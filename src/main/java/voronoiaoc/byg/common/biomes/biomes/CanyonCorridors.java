package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class CanyonCorridors extends Biome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.BADLANDS, SurfaceBuilder.BADLANDS_CONFIG);
    static final Precipitation PRECIPATATION = Precipitation.SNOW;
    static final Category CATEGORY = Category.ICY;
    static final double DEPTH = 0.0F;
    static final double SCALE = 0.01F;
    static final float TEMPERATURE = -0.5F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public CanyonCorridors() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
//        //this.addStructureFeature(Feature.VILLAGE, new VillageConfig("village/snowy/town_centers", 60));
//        //this.addStructureFeature(Feature.IGLOO, FeatureConfig.DEFAULT);
//        //this.addStructureFeature(Feature.MINESHAFT, new MineshaftConfig(0.008D, MineshaftStructure.BYGType.NORMAL));
//        //this.addStructureFeature(Feature.STRONGHOLD, FeatureConfig.DEFAULT);
//        //this.addStructureFeature(Feature.PILLAGER_OUTPOST, new PillagerOutpostConfig(0.004D));
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addLandCarvers(this);
//        /*BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);
//       BYGTreeFeatures.bygAddCanyons(this);*/
//
//
//
//        //BYGTreeFeatures.addDeciduousTrees(this);
//        //BYGTreeFeatures.addBaobabTrees(this);
//
//        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(EntityType.STRAY, 160, 10, 10));


    }
}

