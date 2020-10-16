//package voronoiaoc.byg.common.world.worldtype.math;
//
//import voronoiaoc.byg.common.world.worldtype.noise.simplex.biome.OctaveOpenSimplexNoise;
//
//import java.util.Random;
//
//public class BiomeGroupManager {
//    static final int CLIMATE_SCALE_LAYER_ADJUSTMENT = 6 + 2;
//    static final int LAND_SEA_SCALE_LAYER_ADJUSTMENT = 4 + 2;
//    static int band_set_size = 6;
//    private final OctaveOpenSimplexNoise temperatureRandom, humidity, landSea;
//    private final double zSpread, zShift;
//
//    public BiomeGroupManager(long seed) {
//        Random rand = new Random(seed);
//        this.temperatureRandom = new OctaveOpenSimplexNoise(rand, 1, temperatureScale());
//        this.humidity = new OctaveOpenSimplexNoise(rand, 2, 442 >> CLIMATE_SCALE_LAYER_ADJUSTMENT);
//        this.landSea = new OctaveOpenSimplexNoise(rand, 2, 400 >> LAND_SEA_SCALE_LAYER_ADJUSTMENT);
//        this.zSpread = 1280 >> CLIMATE_SCALE_LAYER_ADJUSTMENT;
//        // z shift, so you don't always spawnTree in the same climate
//        this.zShift = 1000 - rand.nextInt(2000) >> CLIMATE_SCALE_LAYER_ADJUSTMENT;
//    }
//
//    // if the scale of the noise is zero, it will always return the same result due to multiplication by 0
//    // therefore we catch this case in the temperature random noise, which has a low scale and is integer bit shifted
//    private double temperatureScale() {
//        double output = 224 >> CLIMATE_SCALE_LAYER_ADJUSTMENT;
//        return output == 0 ? 0.2 : output;
//    }
//
//    public BYGBiomeGroup getInlandBiomeGroup(int layerX, int layerZ) {
//        TempSection tempCategory = this.getTempCategory(layerX, layerZ);
//        double humidity = this.getHumidity(layerX, layerZ);
//
//        switch (tempCategory) {
//            case HOT:
//                if (humidity > 0.28) return BYGBiomeGroup.INLAND_TROPICAL_RAINFOREST;
//                else if (humidity > -0.28) return BYGBiomeGroup.INLAND_TROPICAL_STEPPE;
//                else return BYGBiomeGroup.INLAND_TROPICAL_DESERT;
//            case TEMPERATE:
//                return humidity > 0.0 ? BYGBiomeGroup.INLAND_TEMPERATE_HUMID : BYGBiomeGroup.INLAND_TEMPERATE_DRY;
//            case COOL:
//                return humidity > 0.0 ? BYGBiomeGroup.INLAND_COOL_HUMID : BYGBiomeGroup.INLAND_COOL_DRY;
//            case COLD:
//            default:
//                return BYGBiomeGroup.INLAND_COLD;
//        }
//    }
//
//    public BYGBiomeGroup getBiomeGroup(int layerX, int layerZ) {
//        TempSection tempCategory = this.getTempCategory(layerX, layerZ);
//        double humidity = this.getHumidity(layerX, layerZ);
//
//        switch (tempCategory) {
//            case HOT:
//                if (humidity > 0.28) return BYGBiomeGroup.TROPICAL_RAINFOREST;
//                else if (humidity > -0.28) return BYGBiomeGroup.TROPICAL_STEPPE;
//                else return BYGBiomeGroup.TROPICAL_DESERT;
//            case TEMPERATE:
//                return humidity > 0.0 ? BYGBiomeGroup.TEMPERATE_HUMID : BYGBiomeGroup.TEMPERATE_DRY;
//            case COOL:
//                return humidity > 0.0 ? BYGBiomeGroup.COOL_HUMID : BYGBiomeGroup.COOL_DRY;
//            case COLD:
//            default:
//                return BYGBiomeGroup.COLD;
//        }
//    }
//
//    public BYGBiomeGroup getCoastalBiomeGroup(int layerX, int layerZ) {
//        TempSection tempCategory = this.getTempCategory(layerX, layerZ);
//        double humidity = this.getHumidity(layerX, layerZ);
//
//        switch (tempCategory) {
//            case HOT:
//                return humidity > 0.0 ? BYGBiomeGroup.COASTAL_TROPICAL_HUMID : BYGBiomeGroup.COASTAL_TROPICAL_DRY;
//            case TEMPERATE:
//                return humidity > 0.0 ? BYGBiomeGroup.COASTAL_TEMPERATE_LUSH : BYGBiomeGroup.COASTAL_TEMPERATE_DRY;
//            case COOL:
//                return BYGBiomeGroup.COASTAL_COOL;
//            case COLD:
//            default:
//                return BYGBiomeGroup.COASTAL_COLD;
//        }
//    }
//
//    public BYGBiomeGroup getIslandBiomeGroup(int layerX, int layerZ) {
//        switch (this.getTempCategory(layerX, layerZ)) {
//            case HOT:
//                return BYGBiomeGroup.OCEAN_ISLANDS_TROPICAL;
//            case TEMPERATE:
//                return BYGBiomeGroup.OCEAN_ISLANDS_TEMPERATE;
//            case COOL:
//
//            case COLD:
//            default:
//                return BYGBiomeGroup.OCEAN_ISLANDS_SNOWY;
//        }
//    }
//
//    public BYGBiomeGroup getCoastalOceanBiome(int layerX, int layerZ) {
//        switch (this.getTempCategory(layerX, layerZ)) {
//            case HOT:
//                return BYGBiomeGroup.HOT_OCEAN;
//            case TEMPERATE:
//                return BYGBiomeGroup.TEMPERATE_OCEAN;
//            case COOL:
//                return BYGBiomeGroup.COOL_OCEAN;
//            case COLD:
//            default:
//                return BYGBiomeGroup.FROZEN_OCEAN;
//        }
//    }
//
//    public BYGBiomeGroup getDeepOceanBiome(int layerX, int layerZ) {
//        switch (this.getTempCategory(layerX, layerZ)) {
//            case HOT:
//                return BYGBiomeGroup.DEEP_HOT_OCEAN;
//            case TEMPERATE:
//                return BYGBiomeGroup.DEEP_TEMPERATE_OCEAN;
//            case COOL:
//                return BYGBiomeGroup.DEEP_COOL_OCEAN;
//            case COLD:
//            default:
//                return BYGBiomeGroup.DEEP_FROZEN_OCEAN;
//        }
//    }
//
//
//    double getTemperature(int layerX, int layerZ) {
//        layerZ += this.zShift;
//        layerZ += this.temperatureRandom.sample(layerX + 2.2) * 0.4;
//        while (layerZ < -band_set_size + 3) {
//            layerZ += 2 * band_set_size;
//        }
//        while (layerZ > band_set_size - 1) {
//            layerZ -= 2 * band_set_size;
//        }
//        return this.temperatureRandom.sample(layerX) * 0.4 + 1 - Math.abs(layerZ / this.zSpread) * 2;
//    }
//
//    double getHumidity(int layerX, int layerZ) {
//        return this.humidity.sample(layerX, layerZ);
//    }
//
//    public TempSection getTempCategory(int layerX, int layerZ) {
//        double temp = this.getTemperature(layerX, layerZ);
//
//        if (temp > 0.55) return TempSection.HOT;
//        else if (temp > -0.3) return TempSection.TEMPERATE;
//        else if (temp > -1.0) return TempSection.COOL;
//        else return TempSection.COLD;
//    }
//
//    public ContinentSection getSection(int layerX, int layerZ) {
//        double sample = this.landSea.sample(layerX, layerZ);
//        ContinentSection result;
//
//        if (sample > 0.3) result = ContinentSection.INLAND_CONTINENT;
//        else if (sample > -0.1) result = ContinentSection.COASTAL_CONTINENT;
//        else if (sample > -0.35) result = ContinentSection.COASTAL_SEAS;
//        else result = ContinentSection.THE_OCEAN;
//
//        if ((layerX >> 2) == 0 && (layerZ >> 2) == 0 && (result == ContinentSection.COASTAL_SEAS)) {
//            result = ContinentSection.COASTAL_CONTINENT;
//        }
//
//        return result;
//    }
//
//    public enum ContinentSection {
//        INLAND_CONTINENT,
//        COASTAL_CONTINENT,
//        COASTAL_SEAS,
//        THE_OCEAN
//    }
//
//    public enum TempSection {
//        HOT,
//        TEMPERATE,
//        COOL,
//        COLD
//    }
//}
