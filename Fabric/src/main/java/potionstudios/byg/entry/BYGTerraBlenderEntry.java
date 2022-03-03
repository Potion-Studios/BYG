package potionstudios.byg.entry;

//TODO: Terrablender
public class BYGTerraBlenderEntry /*implements TerraBlenderApi*/ {
//    @Override
//    public void onTerraBlenderInitialized() {
//        BYG.init(FabricLoader.getInstance().getConfigDir().resolve("byg"), "c");
//
//        BYG.MODLOADER_DATA = new ModLoaderContext() {
//            @Override
//            public Path configPath() {
//                return FabricLoader.getInstance().getConfigDir();
//            }
//
//            @Override
//            public Supplier<SurfaceRules.RuleSource> netherRuleSource() {
//                return BiomeProviderUtils::createNetherRules;
//            }
//        };
//        OverworldBiomeConfig config = OverworldBiomeConfig.getConfig(true);
//        if (config.generateOverworld()) {
//            BiomeProviders.register(new BiomeProvider(BYG.createLocation("surface_data"), 0) {
//                @Override
//                public Optional<SurfaceRules.RuleSource> getOverworldSurfaceRules() {
//                    return Optional.of(BYGSurfaceRules.OVERWORLD_SURFACE_RULES);
//                }
//            });
//            config.values().forEach(biomeProviderData -> {
//                BiomeProviders.register(new BYGBiomeProvider(biomeProviderData.overworldWeight(), biomeProviderData.oceans(), biomeProviderData.middleBiomes(), biomeProviderData.middleBiomesVariant(), biomeProviderData.plateauBiomes(), biomeProviderData.plateauBiomesVariant(), biomeProviderData.extremeHills(), biomeProviderData.swapper()));
//            });
//        } else {
//            BYG.LOGGER.info("BYG overworld biomes disabled.");
//        }
//    }
}
