package potionstudios.byg.world.biome;

public class BYGBiomeProvider /*extends BiomeProvider*/ {
//    private static int count = 0;
//
//    private final OverworldBiomeBuilder overworldBiomeBuilder = new OverworldBiomeBuilder();
//    private final Set<ResourceKey<Biome>> bygKeys = new ObjectOpenHashSet<>();
//    private final Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper;
//
//    public BYGBiomeProvider(int overworldWeight, ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes, ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes, ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] extremeHills, Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
//        super(BYG.createLocation("biome_provider_" + count++), overworldWeight);
//        this.swapper = swapper;
//
//        OverworldBiomeBuilderAccess overworldBiomeBuilderAccess = (OverworldBiomeBuilderAccess) (Object) overworldBiomeBuilder;
//        overworldBiomeBuilderAccess.byg_setOCEANS(oceans);
//        overworldBiomeBuilderAccess.byg_setMIDDLE_BIOMES(middleBiomes);
//        overworldBiomeBuilderAccess.byg_setMIDDLE_BIOMES_VARIANT(middleBiomesVariant);
//        overworldBiomeBuilderAccess.setPLATEAU_BIOMES(plateauBiomes);
//        overworldBiomeBuilderAccess.byg_setPLATEAU_BIOMES_VARIANT(plateauBiomesVariant);
//        overworldBiomeBuilderAccess.setEXTREME_HILLS(extremeHills);
//        dumpArrays((biomeResourceKey -> {
//            if (biomeResourceKey != null && biomeResourceKey != Biomes.THE_VOID) {
//                bygKeys.add(biomeResourceKey);
//                if (swapper.containsValue(biomeResourceKey)) {
//                    throw new IllegalArgumentException("Swapper cannot contain elements found in the temperature arrays.");
//                }
//            }
//        }), oceans, middleBiomes, middleBiomesVariant, plateauBiomes, plateauBiomesVariant, extremeHills);
//    }
//
//    @Override
//    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper) {
//        ((OverworldBiomeBuilderAccess) (Object) this.overworldBiomeBuilder).byg_invokeAddBiomes((parameterPointResourceKeyPair -> {
//            ResourceKey<Biome> biomeKey = parameterPointResourceKeyPair.getSecond();
//            if (this.bygKeys.contains(biomeKey)) {
//                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointResourceKeyPair.getFirst(), getUniquenessParameter()), biomeKey));
//            }
//            if (this.swapper.containsKey(biomeKey)) {
//                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointResourceKeyPair.getFirst(), getUniquenessParameter()), this.swapper.get(biomeKey)));
//            }
//        }));
//    }
//
//    @SafeVarargs
//    private static void dumpArrays(Consumer<ResourceKey<Biome>> biomeConsumer, ResourceKey<Biome>[][]... resourceKeys) {
//        for (ResourceKey<Biome>[][] resourceKey : resourceKeys) {
//            for (ResourceKey<Biome>[] keys : resourceKey) {
//                for (ResourceKey<Biome> key : keys) {
//                    biomeConsumer.accept(key);
//                }
//            }
//        }
//    }
}
