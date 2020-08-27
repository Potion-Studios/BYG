package voronoiaoc.byg.core.registries;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGEntityList;

public class BYGEntityRegistry {
    public static void registerEntities() {
        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(BYG.MODID, "boat_entity"), BYGEntityList.BYGBOAT);
    }
}
