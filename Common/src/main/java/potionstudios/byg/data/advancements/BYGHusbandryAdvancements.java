package potionstudios.byg.data.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.LocationTrigger;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.world.biome.BYGBiomes;

import java.util.function.Consumer;

public class BYGHusbandryAdvancements implements Consumer<Consumer<Advancement>> {


    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement root = Advancement.Builder.advancement().display(BYGItems.GREEN_APPLE, new TranslatableComponent("byg.advancements.husbandry.root.title"), new TranslatableComponent("byg.advancements.husbandry.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/husbandry.png"), FrameType.TASK, false, false, false).addCriterion("consumed_item", ConsumeItemTrigger.TriggerInstance.usedItem()).save(advancementConsumer, "byg:husbandry/root");

        Advancement.Builder.advancement().parent(root)
            .display(BYGItems.GREEN_APPLE, new TranslatableComponent("byg.advancements.items.green_apple.title"),
                new TranslatableComponent("byg.advancements.items.green_apple.description"), null, FrameType.TASK, true, true, false)
            .addCriterion("green_apple", InventoryChangeTrigger.TriggerInstance.hasItems(BYGItems.GREEN_APPLE))
            .addCriterion("skyris_vale", LocationTrigger.TriggerInstance.located(LocationPredicate.inBiome(BYGBiomes.SKYRIS_VALE))).save(advancementConsumer, "byg:husbandry/green_apple");
    }
}