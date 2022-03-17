package potionstudios.byg.data.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.mixin.access.AdventureAdvancementsAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BYGAdventureAdvancements implements BYGAdvancementConsumer<Advancement> {


    @Override
    public void accept(Consumer<Advancement> advancementConsumer, Advancement root) {


        List<ResourceKey<Biome>> biomes = BYGBiomes.BIOMES.stream().map(RegistryObject::id).map(key -> ResourceKey.create(Registry.BIOME_REGISTRY, BYG.createLocation(key))).filter(biomeResourceKey -> biomeResourceKey != BYGBiomes.WINDSWEPT_DUNES).collect(Collectors.toList());
        AdventureAdvancementsAccess.byg_invokeAddBiomes(Advancement.Builder.advancement(), biomes).parent(root)
            .display(BYGItems.BYG_LOGO, new TranslatableComponent("byg.advancements.adventure.explore_biomes.title"),
                new TranslatableComponent("byg.advancements.adventure.explore_biomes.description"), null, FrameType.CHALLENGE, true, true, false)
            .rewards(AdvancementRewards.Builder.experience(1000))
            .save(advancementConsumer, "byg:adventure/oh_the_biomes_youll_go");
    }
}