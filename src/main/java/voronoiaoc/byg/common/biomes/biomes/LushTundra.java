package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGSBList;

import javax.annotation.Nullable;

public class LushTundra extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.LUSH_TUNDRA_SB, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
    static final Precipitation PRECIPATATION = Precipitation.SNOW;
    static final Category CATEGORY = Category.ICY;
    static final double DEPTH = 0.15F;
    static final double SCALE = 0.1F;
    static final float TEMPERATURE = 0.35F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public LushTundra() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        //this.addStructure(Feature.VILLAGE.configure(new VillageConfig("village/snowy/town_centers", 6)));
        //this.addStructure(Feature.PILLAGER_OUTPOST.configure(IFeatureConfig.NO_FEATURE_CONFIG));
        //this.addStructure(Feature.MINESHAFT.configure(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        //this.addStructure(Feature.STRONGHOLD.configure(IFeatureConfig.NO_FEATURE_CONFIG));
        DefaultBiomeFeatures.addLandCarvers(this);
        //DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        BYGFeatures.addGrass( this);
        BYGFeatures.addBYGMushrooms( this);
        BYGFeatures.addWinterScilla( this);
        BYGFeatures.addRockyStoneBoulder( this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);

        this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 10, 2, 3));
        this.addSpawn(SpawnGroup.CREATURE, new Biome.SpawnListEntry(EntityType.POLAR_BEAR, 1, 1, 2));
        this.addSpawn(SpawnGroup.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 20, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnListEntry(EntityType.STRAY, 80, 4, 4));
    }

    @Nullable
    @Override
    public Biome getHill(INoiseRandom rand) {
        return (rand.random(5) == 0) ? BYGBiomeList.FROZENLAKE : BYGBiomeList.NORTHERN_FOREST;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getGrassColorAt(double posX, double posZ) {
        return 10044989;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor() {
        return 10044989;
    }

    @Override
    public Biome getRiver() {
        return Biomes.RIVER;
    }
}
