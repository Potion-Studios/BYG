//package voronoiaoc.byg.common.world.worldtype.layers;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.layer.traits.ICastleTransformer;
//import voronoiaoc.byg.common.world.worldtype.BYGBiomeGetter;
//import voronoiaoc.byg.common.world.worldtype.ClimateBooleans;
//import voronoiaoc.byg.core.byglists.BYGBiomes;
//
//public enum BYGShoreLayer implements ICastleTransformer {
//    INSTANCE;
//
//    public int apply(INoiseRandom rand, int n, int e, int s, int w, int centre) {
//        Biome biome = Registry.BIOME.getOrThrowByValue(centre);
//        if (centre == BYGBiomeGetter.ALPS) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.SNOWYROCKYBLACKBEACH;
//            }
//        }
//        if (centre == BYGBiomeGetter.DOVERMOUNTAINS) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.WHITEBEACH;
//            }
//        }
//        if (biome != null && biome.getBiome.RainType() == Biome.Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.SNOWYBLACKBEACH;
//            }
//        }
//        if (biome != null && biome.getBiome.RainType() == Biome.Biome.RainType.RAIN && biome != BYGBiomes.DOVERMOUNTAINS && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH && biome != BYGBiomes.GRASSLANDPLATEAU && biome != BYGBiomes.TROPICALISLAND && biome.getCategory() != Biome.Category.SWAMP && biome != BYGBiomes.MARSHLANDS && biome.getCategory() != Biome.Category.MUSHROOM) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.VANILLABEACH;
//            }
//        }
//        if (biome == BYGBiomes.GRASSLANDPLATEAU) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.ROCKYBEACH;
//            }
//        }
//        if (biome == BYGBiomes.TROPICALISLAND) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.RAINBOWBEACH;
//            }
//        }
//        if (biome == Biomes.MUSHROOM_FIELDS) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.MUSHROOMBEACH;
//            }
//        }
//        return centre;
//    }
//}