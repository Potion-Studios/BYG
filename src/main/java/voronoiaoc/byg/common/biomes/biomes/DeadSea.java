package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import voronoiaoc.byg.common.biomes.BiomeFog;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class DeadSea extends Biome implements BiomeTools, BiomeFog {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSBList.BYGSBConfigList.BLACKSAND);
    static final Precipitation PRECIPATATION = Precipitation.NONE;
    static final Category CATEGORY = Category.OCEAN;
    static final double DEPTH = -1.05F;
    static final double SCALE = 0.1F;
    static final float TEMPERATURE = 2.0F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 12632256;
    static final int WATER_FOG_COLOR = 12632256;
    static final String PARENT = null;

    public DeadSea() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build()));
        //this.add//StructureFeature(DefaultBiomeFeatures.COLD_OCEAN_RUIN);
        //this.add//StructureFeature(DefaultBiomeFeatures.OCEAN_RUINED_PORTAL);
        DefaultBiomeFeatures.addOceanStructures(this);
        BYGFeatures.addDeadSeaSpires(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addOceanCarvers(this);
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_NORMAL);

        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.DROWNED, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.WITCH, 15, 1, 1));

    }

    @Override
    public float fogDistance(int x, int z, float originalDistanceChunks) {
        return 0.5F;
    }

    @Override
    public Biome getRiver() {
        return this;
    }

    @Override
    public Biome getHill() {
        return null;
    }

    @Override
    public Biome getEdge() {
        return null;
    }

    @Override
    public Biome getBeach() {
        return null;
    }

    @Override
    public Biome getMutation() {
        return null;
    }
}