package voronoiaoc.byg.core.registries;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGEntityList;

public class BYGEntityRegistry {
    public static void registerEntities() {
        Registry.register(Registry.ENTITY_TYPE,new Identifier(BYG.MODID,"boat_entity"), BYGEntityList.BYGBOAT);
    }
}
