package potionstudios.byg.common.entity.npc;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.npc.VillagerProfession;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.ai.village.poi.BYGPoiTypes;
import potionstudios.byg.mixin.access.VillagerProfessionAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGVillagerProfessions {

    private static final List<RegistryObject<VillagerProfession>> VILLAGER_PROFESSIONS = new ArrayList<>();

    public static final VillagerProfession FORAGER = createVillagerProfession("forager", VillagerProfessionAccess.byg_invokeCreate("forager", BYGPoiTypes.FORAGER, ImmutableSet.of(), ImmutableSet.of(), null));

    private static <VP extends VillagerProfession> VP createVillagerProfession(String id, VP villagerProfession) {
        VILLAGER_PROFESSIONS.add(new RegistryObject<>(villagerProfession, id));
        return villagerProfession;
    }


    public static Collection<RegistryObject<VillagerProfession>> bootStrap() {
        return VILLAGER_PROFESSIONS;
    }

    static {
        BYG.LOGGER.info("BYG Villager Professions class loaded.");
    }
}
