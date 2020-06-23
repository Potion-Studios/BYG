package voronoiaoc.byg.common.biomes.subbiomes.hills;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;

public class AlpineFoothills extends Biome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.GIANT_TREE_TAIGA, new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState()));
    static final Precipitation PRECIPATATION = Precipitation.SNOW;
    static final Category CATEGORY = Category.EXTREME_HILLS;
    static final double DEPTH = 3.5F;
    static final double SCALE = 0.15F;
    static final float TEMPERATURE = -0.25F;
    static final float DOWNFALL = 0.6F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public AlpineFoothills() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        ////this.addStructureFeature(Feature.VILLAGE.configure(new VillageConfig("village/snowy/town_centers", 6)));
        ////this.addStructureFeature(Feature.IGLOO.configure(FeatureConfig.DEFAULT));
        ////this.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        ////this.addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT));
        ////this.addStructureFeature(Feature.PILLAGER_OUTPOST.configure(FeatureConfig.DEFAULT));
        DefaultBiomeFeatures.addFrozenTopLayer(this);
        BYGTreeFeatures.addBluffTrees(this);
        //BYGFeatures.addAlpineBellflower(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        //DefaultBiomeFeatures.addStructureFeatures(this);
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addLargeFerns(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        DefaultBiomeFeatures.addTaigaGrass(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        //BYGFeatures.addForestGrass(this);
        //BYGFeatures.addWinterSucculent(this);
        //BYGFeatures.addWinterSucculent(this);
        //BYGFeatures.addWinterScilla(this);
        //BYGFeatures.addWinterRose(this);
        //BYGFeatures.addBYGMushrooms(this);

        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.RABBIT, 10, 2, 3));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.POLAR_BEAR, 1, 1, 2));
        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 20, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.STRAY, 80, 4, 4));
    }


//    @OnlyIn(Dist.CLIENT)
//    public int getGrassColorAt(double p_225528_1_, double p_225528_3_) {
//        double lvt_5_1_ = INFO_NOISE.sample (p_225528_1_ * 0.0225D, p_225528_3_ * 0.0225D, false);
//        return lvt_5_1_ < -0.1D ? 11909994 : 12499549;
//    }

}

