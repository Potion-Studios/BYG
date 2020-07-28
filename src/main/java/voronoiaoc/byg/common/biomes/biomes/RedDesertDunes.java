package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.core.byglists.BYGSBList;

import javax.annotation.Nullable;

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
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build()));
        //StructureFeature.VILLAGE.configure(new StructurePoolFeatureConfig(new Identifier("village/desert/town_centers"), 6));
        //this.add//StructureFeature(DefaultBiomeFeatures.PILLAGER_OUTPOST);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this);
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.HUSK, 160, 10, 10));
    }

    @Nullable
    @Override
    public Biome getRiver() {
        return null;
    }

    @Nullable
    @Override
    public Biome getHill() {
        return null;
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
}
