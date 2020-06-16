package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

import javax.annotation.Nullable;

public class Canyons extends Biome  {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.CANYONS, SurfaceBuilder.RED_SAND_WHITE_TERRACOTTA_GRAVEL_CONFIG);
    static final RainType PRECIPATATION = RainType.NONE;
    static final Biome.Category CATEGORY = Category.DESERT;
    static final double DEPTH = 5.0F;
    static final double SCALE = 0.05F;
    static final float TEMPERATURE = 1.5F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;


    public Canyons() {
        super(new Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).waterColor(WATER_COLOR).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
        BYGTreeFeatures.addRedRockCanyonVegetation(this);

    }

    @Override
    public Biome getRiver() {
        return this;
    }

    @Nullable
    @Override
    public Biome getHill(INoiseRandom rand) {
        return this;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(double posX, double posZ) {
        return 10855786;

    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor() {
        return 10855786;
    }
}

