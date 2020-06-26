package voronoiaoc.byg.core.registries;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGEntityList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGEntityRegistry {

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering blocks...");
        event.getRegistry().registerAll(
                BYGEntityList.BYGBOAT.setRegistryName("boat")
        );
        BYG.LOGGER.info("BYG: Entities Registered!");
    }
}
