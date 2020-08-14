//package voronoiaoc.byg.common.world.worldtype.layers;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.layer.traits.ICastleTransformer;
//import voronoiaoc.byg.common.world.worldtype.BYGBiomeGetter;
//import voronoiaoc.byg.common.world.worldtype.ClimateBooleans;
//import voronoiaoc.byg.core.byglists.BYGBiomeList;
//
//public enum BYGShoreLayer implements ICastleTransformer {
//    INSTANCE;
//
//    public int apply(INoiseRandom rand, int n, int e, int s, int w, int centre) {
//        Biome biome = Registry.field_243657_i.func_243576_dByValue(centre);
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
//        if (biome != null && biome.getRainType() == Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.SNOWYBLACKBEACH;
//            }
//        }
//        if (biome != null && biome.getRainType() == Biome.RainType.RAIN && biome != BYGBiomeList.DOVERMOUNTAINS && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH && biome != BYGBiomeList.GRASSLANDPLATEAU && biome != BYGBiomeList.TROPICALISLAND && biome.getCategory() != Biome.Category.SWAMP && biome != BYGBiomeList.MARSHLANDS && biome.getCategory() != Biome.Category.MUSHROOM) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.VANILLABEACH;
//            }
//        }
//        if (biome == BYGBiomeList.GRASSLANDPLATEAU) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(e) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(w)) {
//                return BYGBiomeGetter.ROCKYBEACH;
//            }
//        }
//        if (biome == BYGBiomeList.TROPICALISLAND) {
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