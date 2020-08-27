package voronoiaoc.byg.core.registries;

import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGFeatureList;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGFeatureRegistry {

    @SubscribeEvent
    public static void bygRegisterFeatures(RegistryEvent.Register<Feature<?>> event) {
        BYG.LOGGER.debug("BYG: Registering Features...");
        BYGFeatureList.RegisterFeatures.registerBYGFeatures();
        BYG.LOGGER.info("BYG: Features Registered!");
    }
}