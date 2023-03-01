package potionstudios.byg.datagen.providers.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.mixin.access.AdventureAdvancementsAccess;
import potionstudios.byg.reg.RegistryObject;

import java.util.List;
import java.util.function.Consumer;

public class BYGAdventureAdvancements implements BYGAdvancementConsumer {

    @Override
    public void accept(Consumer<Advancement> advancementConsumer, Advancement root) {
        List<ResourceKey<Biome>> biomes = BYGBiomes.PROVIDER.getEntries()
                .stream()
                .map(RegistryObject::getId)
                .map(key -> ResourceKey.create(Registry.BIOME_REGISTRY, key))
                .toList();
        AdventureAdvancementsAccess.byg_invokeAddBiomes(Advancement.Builder.advancement(), biomes).parent(root)
            .display(BYGItems.BYG_LOGO.get(), Component.translatable("byg.advancements.adventure.explore_biomes.title"),
                Component.translatable("byg.advancements.adventure.explore_biomes.description"), null, FrameType.CHALLENGE, true, true, false)
            .rewards(AdvancementRewards.Builder.experience(1000))
            .save(advancementConsumer, "byg:adventure/oh_the_biomes_youll_go");

    }
}