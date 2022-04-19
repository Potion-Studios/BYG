package potionstudios.byg.common.entity.ai.village.poi;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.PoiTypeAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGPoiTypes {

    public static List<RegistryObject<PoiType>> POI_TYPES = new ArrayList<>();

    public static final PoiType FORAGER = createPoiType("forager", PoiTypeAccess.byg_invokeCreate("forager", PoiTypeAccess.byg_invokeGetBlockStates(BYGBlocks.FORAGERS_TABLE), 1, 1));

    public static PoiType createPoiType(String id, PoiType poiType) {
        POI_TYPES.add(new RegistryObject<>(poiType, id));
        return PoiTypeAccess.byg_invokeRegisterBlockStates(poiType);
    }


    public static Collection<RegistryObject<PoiType>> bootStrap() {
        return POI_TYPES;
    }

    static {
        BYG.LOGGER.info("BYG POI Types class loaded.");
    }
}
