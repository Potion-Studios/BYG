package potionstudios.byg.common.entity.npc;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.npc.VillagerProfession;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.ai.village.poi.BYGPoiTypes;
import potionstudios.byg.mixin.access.VillagerProfessionAccess;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

public class BYGVillagerProfessions {

    private static final RegistrationProvider<VillagerProfession> PROVIDER = RegistrationProvider.get(Registry.VILLAGER_PROFESSION_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<VillagerProfession> FORAGER = createVillagerProfession("forager", () -> VillagerProfessionAccess.byg_invokeCreate("forager", BYGPoiTypes.FORAGER.get(), ImmutableSet.of(), ImmutableSet.of(), null));

    private static <VP extends VillagerProfession> RegistryObject<VP> createVillagerProfession(String id, Supplier<VP> villagerProfession) {
        return PROVIDER.register(id, villagerProfession);
    }

    public static void loadClass() {}
}
