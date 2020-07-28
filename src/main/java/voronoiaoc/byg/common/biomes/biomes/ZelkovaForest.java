package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import javax.annotation.Nullable;
import java.util.Random;

public class ZelkovaForest extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState()));
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.TAIGA;
    static final double DEPTH = 0.2F;
    static final double SCALE = 0.1F;
    static final float TEMPERATURE = 0.25F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public ZelkovaForest() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build()));
        //this.add//StructureFeature(DefaultBiomeFeatures.IGLOO);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this);
        //this.add//StructureFeature(DefaultBiomeFeatures.PILLAGER_OUTPOST);
        DefaultBiomeFeatures.addFrozenTopLayer(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addLargeFerns(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        DefaultBiomeFeatures.addTaigaGrass(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        BYGFeatures.addKovanFlower(this);
        BYGFeatures.addAnemones(this);
        BYGFeatures.addCrocus(this);
        BYGFeatures.addBYGMushrooms(this);
        BYGTreeFeatures.addZelkovaTrees(this);

        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.WOLF, 5, 4, 4));
        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
    }

    @Override
    public int getGrassColorAt(double x, double z) {
        double lvt_5_1_ = FOLIAGE_NOISE.sample(x * 0.0225D, z * 0.0225D, false);
        return lvt_5_1_ < -0.1D ? 5416309 : 5416309;
    }

    @Override
    public int getFoliageColor() {
        return 5416309;
    }

    @Nullable
    @Override
    public Biome getRiver() {
        return Biomes.RIVER;
    }

    @Nullable
    @Override
    public Biome getHill() {
        Random random = new Random();
        return randomSubBiome(random);
    }

    @Nullable
    @Override
    public Biome getEdge() {
        return null;
    }

    @Nullable
    @Override
    public Biome getBeach() {
        return null;
    }

    @Nullable
    @Override
    public Biome getMutation() {
        return null;
    }

    public Biome randomSubBiome(Random random) {
        int randomPicker = random.nextInt(4);
        if (randomPicker == 0)
            return BYGBiomeList.ZELKOVAFORESTHILLS;
        else if (randomPicker == 1)
            return BYGBiomeList.ZELKOVA_CLEARING;
        else if (randomPicker == 2)
            return BYGBiomeList.ZELKOVA_CLEARING;
        else
            return BYGBiomeList.FRESHWATERLAKE;

    }
}

