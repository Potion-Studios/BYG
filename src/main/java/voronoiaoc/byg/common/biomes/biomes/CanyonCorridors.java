package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class CanyonCorridors extends Biome  {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.BADLANDS, SurfaceBuilder.RED_SAND_WHITE_TERRACOTTA_GRAVEL_CONFIG);
    static final RainType PRECIPATATION = RainType.SNOW;
    static final Category CATEGORY = Category.ICY;
    static final double DEPTH = 0.0F;
    static final double SCALE = 0.01F;
    static final float TEMPERATURE = -0.5F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public CanyonCorridors() {
        super(new Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).waterColor(WATER_COLOR).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
//        this.addStructure(Feature.VILLAGE, new VillageConfig("village/snowy/town_centers", 60));
//        this.addStructure(Feature.IGLOO, IFeatureConfig.NO_FEATURE_CONFIG);
//        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.008D, MineshaftStructure.BYGType.NORMAL));
//        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
//        this.addStructure(Feature.PILLAGER_OUTPOST, new PillagerOutpostConfig(0.004D));
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addIcebergs(this);
//        DefaultBiomeFeatures.addCarvers(this);
//        /*BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);
//        BYGTreeFeatures.bygAddCanyons(this);*/
//
//
//
//        //BYGTreeFeatures.addDeciduousTrees(this);
//        //BYGTreeFeatures.addBaobabTrees(this);
//
//        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.STRAY, 160, 10, 10));


    }

    @Override
    public Biome getRiver() {
        return Biomes.RIVER;
    }
}

