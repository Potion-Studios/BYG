package voronoiaoc.byg.core.registries;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGSBList;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGSurfaceBuilderRegistry {

    @SubscribeEvent
    public static void bygRegisterSurfaceBuilders(final RegistryEvent.Register<SurfaceBuilder<?>> event) {
        BYG.LOGGER.debug("BYG: Registering surface builders...");

        event.getRegistry().registerAll(
                BYGSBList.BOREAL_SB.setRegistryName("boreal_sb"),
                BYGSBList.CONIFEROUS_SB.setRegistryName("coniferous_sb"),
                BYGSBList.DOVER_SB.setRegistryName("dover_sb"),
                BYGSBList.DUNES_SB.setRegistryName("dunes_sb"),
                BYGSBList.RAINBOWBEACH_SB.setRegistryName("rainbowbeach_sb"),
                BYGSBList.REDDUNES_SB.setRegistryName("reddunes_sb"),
                BYGSBList.ROCKYBEACH_SB.setRegistryName("rockybeach_sb"),
                BYGSBList.ROCKYBLACKBEACH_SB.setRegistryName("rockyblackbeach_sb"),
                BYGSBList.QUAGMIRE_SB.setRegistryName("quagmire_sb"),
                BYGSBList.MARSHLAND_SB.setRegistryName("marshland_sb"),
                BYGSBList.GREAT_LAKE_ISLE_SB.setRegistryName("great_lake_isle_sb"),
                BYGSBList.GREAT_LAKES_SB.setRegistryName("great_lake_sb"),
                BYGSBList.SIERRA_VALLEY_SB.setRegistryName("sierra_valley_sb"),
                BYGSBList.ERODED_SIERRA_SB.setRegistryName("eroded_sierra_sb"),
                BYGSBList.GLOWSHROOM_BAYOU_SB.setRegistryName("glowshroom_bayou_sb"),
                BYGSBList.RED_ROCK_SB.setRegistryName("red_rock_sb"),
                BYGSBList.RED_ROCKLOWLAND_SB.setRegistryName("red_rock_lowland_sb"),
                BYGSBList.LUSH_TUNDRA_SB.setRegistryName("lush_tundra_sb"),
                BYGSBList.EBONY_SB.setRegistryName("ebony_woods_sb"),
                BYGSBList.FUNGAL_RAINFOREST_SB.setRegistryName("fungal_rainforest_sb")


        );
        BYG.LOGGER.info("BYG: Surface Builders Registered!");
    }
}
