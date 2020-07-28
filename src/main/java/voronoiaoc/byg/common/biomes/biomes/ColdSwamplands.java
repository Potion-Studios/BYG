package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class ColdSwamplands extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.MARSHLAND_SB, new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), BYGBlockList.MUD_BLOCK.getDefaultState()));
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.SWAMP;
    static final double DEPTH = -0.22F;
    static final double SCALE = 0.1F;
    static final float TEMPERATURE = 0.25F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 9202509;
    static final int WATER_FOG_COLOR = 9202509;
    static final String PARENT = null;

    public ColdSwamplands() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build()));
        //this.add//StructureFeature(DefaultBiomeFeatures.SWAMP_HUT);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addDefaultLakes(this);
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addClay(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addSwampVegetation(this);
        DefaultBiomeFeatures.addSprings(this);
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_NORMAL);
        DefaultBiomeFeatures.addSwampFeatures(this);
        BYGFeatures.addMarshGrass(this);
        BYGFeatures.addWiltedGrass(this);
        BYGFeatures.addWiltedGrass(this);
        BYGFeatures.addReeds(this);
        BYGFeatures.addMudDisks(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);

        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 1, 1, 1));
    }

    @Override
    public int getGrassColorAt(double x, double z) {
        double d0 = FOLIAGE_NOISE.sample(x * 0.0225D, z * 0.0225D, false);
        return d0 < -0.1D ? 7365696 : 7365696;
    }

    @Override
    public int getFoliageColor() {
        return 7365696;
    }

    @Override
    public Biome getRiver() {
        return this;
    }

    @Override
    public Biome getHill() {
        return BYGBiomeList.BOG;
    }

    @Override
    public Biome getEdge() {
        return null;
    }

    @Override
    public Biome getBeach() {
        return this;
    }

    @Override
    public Biome getMutation() {
        return null;
    }
}
