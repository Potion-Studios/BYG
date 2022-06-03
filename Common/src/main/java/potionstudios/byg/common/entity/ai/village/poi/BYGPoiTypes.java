package potionstudios.byg.common.entity.ai.village.poi;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.PoiTypeAccess;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

public class BYGPoiTypes {

    private static final RegistrationProvider<PoiType> PROVIDER = RegistrationProvider.get(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<PoiType> FORAGER = createPoiType("forager", () -> PoiTypeAccess.byg_invokeCreate("forager", PoiTypeAccess.byg_invokeGetBlockStates(BYGBlocks.FORAGERS_TABLE.get()), 1, 1));

    public static RegistryObject<PoiType> createPoiType(String id, Supplier<PoiType> poiType) {
        return PROVIDER.register(id, poiType);
    }

    public static void loadClass() {}
}
