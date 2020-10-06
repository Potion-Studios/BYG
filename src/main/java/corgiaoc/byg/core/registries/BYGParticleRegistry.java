package corgiaoc.byg.core.registries;

//@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class BYGParticleRegistry {
//
//    @SubscribeEvent
//    public static void bygRegisterFeatures(RegistryEvent.Register<ParticleType<?>> event) {
//        BYG.LOGGER.debug("BYG: Registering Particles...");
//        event.getRegistry().registerAll(
//                BYGParticleList.NYLIUM_SOUL_SAND_AMBIENCE.setRegistryName("nyliumsoulsandambience")
//        );
//
//        BYG.LOGGER.info("BYG: Particles Registered!");
//    }
//
//    @SubscribeEvent
//    public static void registerParticleTypes(ParticleFactoryRegisterEvent event) {
//        Minecraft.getInstance().particles.registerFactory(BYGParticleList.NYLIUM_SOUL_SAND_AMBIENCE, NyliumParticle.Factory::new);
//    }
//}