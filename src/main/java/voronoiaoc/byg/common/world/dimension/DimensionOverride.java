package voronoiaoc.byg.common.world.dimension;

import net.minecraft.world.dimension.DimensionType;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.dimension.end.EndDimensionHook;
import voronoiaoc.byg.common.world.dimension.nether.hooks.ClientNetherDimensionHook;
import voronoiaoc.byg.common.world.dimension.nether.hooks.ServerNetherDimensionHook;
import voronoiaoc.byg.config.BYGConfig;

public class DimensionOverride {
    public static void dimensionOverrideClient() {
        BYG.LOGGER.debug("BYG: Replacing Client Dimensions...");
        if (BYGConfig.biomeFogEffects.get() != BYGConfig.BiomeFogSettings.OFF)
            DimensionType.OVERWORLD.factory = ClientOverworldDimensionHook::new;

        DimensionType.THE_NETHER.factory = ClientNetherDimensionHook::new;
        DimensionType.THE_END.factory = EndDimensionHook::new;
        BYG.LOGGER.debug("BYG: Replaced Client Dimensions!");
    }

    public static void dimensionOverrideServerCommon() {
        if (!BYG.isClient) {
            BYG.LOGGER.debug("BYG: Replacing Server/Common Dimensions...");
            DimensionType.THE_NETHER.factory = ServerNetherDimensionHook::new;
            DimensionType.THE_END.factory = EndDimensionHook::new;
            BYG.LOGGER.debug("BYG: Replaced Server/Common Dimensions!");
        }
    }
}
