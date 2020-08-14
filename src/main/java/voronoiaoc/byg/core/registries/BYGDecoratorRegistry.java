package voronoiaoc.byg.core.registries;

import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.placements.AnyWaterOrSolidSurfaceSurface;
import voronoiaoc.byg.common.world.feature.placements.AtOceanFloorWithExtra;
import voronoiaoc.byg.common.world.feature.placements.ObsidianSpikePlacer;
import voronoiaoc.byg.common.world.feature.placements.UnderGroundPlacement;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGDecoratorRegistry {


    @SubscribeEvent
    public static void bygRegisterFeatures(RegistryEvent.Register<Placement<?>> event) {
        BYG.LOGGER.debug("BYG: Registering Features...");
        event.getRegistry().register(AnyWaterOrSolidSurfaceSurface.WATER_OR_SOLID_SURFACE.setRegistryName("any_water_or_solid_surface_decorator"));
        event.getRegistry().register(AtOceanFloorWithExtra.OCEANFLOOR.setRegistryName("ocean_floor_count_extra"));
        event.getRegistry().register(ObsidianSpikePlacer.OBBY_SPIKE.setRegistryName("obsidian_spike_placer"));
        event.getRegistry().register(UnderGroundPlacement.UGPLACER.setRegistryName("underground_count_extra_decorator"));
        BYG.LOGGER.info("BYG: Features Registered!");
    }
}
