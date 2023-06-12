package potionstudios.byg.common.entity.npc;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.ai.village.poi.BYGPoiTypes;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BYGVillagerProfessions {

    private static final RegistrationProvider<VillagerProfession> PROVIDER = RegistrationProvider.get(Registries.VILLAGER_PROFESSION, BYG.MOD_ID);

    public static final RegistryObject<VillagerProfession> FORAGER = createVillagerProfession("forager", () -> register(BYG.MOD_ID + ":forager", BYGPoiTypes.FORAGER.getResourceKey(), null));

    private static <VP extends VillagerProfession> RegistryObject<VP> createVillagerProfession(String id, Supplier<VP> villagerProfession) {
        return PROVIDER.register(id, villagerProfession);
    }

    public static void loadClass() {
    }

    private static VillagerProfession register(String name, ResourceKey<PoiType> heldJobSite, @Nullable SoundEvent sound) {
        return register(name, ($$1x) -> $$1x.is(heldJobSite), ($$1x) -> $$1x.is(heldJobSite), sound);
    }

    private static VillagerProfession register(String name, Predicate<Holder<PoiType>> heldJobSite, Predicate<Holder<PoiType>> $$2, @Nullable SoundEvent $$3) {
        return register(name, heldJobSite, $$2, ImmutableSet.of(), ImmutableSet.of(), $$3);
    }

    private static VillagerProfession register(String name, Predicate<Holder<PoiType>> heldJobSite, Predicate<Holder<PoiType>> $$2, ImmutableSet<Item> $$3, ImmutableSet<Block> $$4, @Nullable SoundEvent $$5) {
        return new VillagerProfession(name, heldJobSite, $$2, $$3, $$4, $$5);
    }
}
