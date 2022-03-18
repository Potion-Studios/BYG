package potionstudios.byg.data.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.tags.BlockTags;
import potionstudios.byg.common.item.BYGItems;

import java.util.function.Consumer;

public class BYGHusbandryAdvancements implements BYGAdvancementConsumer<Advancement> {


    @Override
    public void accept(Consumer<Advancement> advancementConsumer, Advancement root) {

        Advancement husbandryRoot = Advancement.Builder.advancement().parent(root).display(BYGItems.GREEN_APPLE, new TranslatableComponent("byg.advancements.husbandry.root.title"),
            new TranslatableComponent("byg.advancements.husbandry.root.description"), null, FrameType.TASK, false, false, false).addCriterion("consumed_item", ConsumeItemTrigger.TriggerInstance.usedItem()).save(advancementConsumer, "byg:husbandry/root");

        Advancement.Builder.advancement().parent(husbandryRoot).display(BYGItems.GREEN_APPLE, new TranslatableComponent("byg.advancements.husbandry.granny_smith.title"),
                new TranslatableComponent("byg.advancements.husbandry.granny_smith.description"), null, FrameType.CHALLENGE, true, true, false)
            .addCriterion("green_apple", InventoryChangeTrigger.TriggerInstance.hasItems(BYGItems.GREEN_APPLE)).save(advancementConsumer, "byg:husbandry/granny_smith");

        Advancement.Builder.advancement().parent(husbandryRoot).display(BYGItems.CATTAIL_SPROUT, new TranslatableComponent("byg.advancements.husbandry.hot_diggity_not_dog.title"),
                new TranslatableComponent("byg.advancements.husbandry.hot_diggity_not_dog.description"), null, FrameType.CHALLENGE, true, true, false)
            .addCriterion("cattail_sprout", ItemUsedOnBlockTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(BlockTags.CAMPFIRES).build()), ItemPredicate.Builder.item().of(BYGItems.CATTAIL_SPROUT))).save(advancementConsumer, "byg:husbandry/hot_diggity_not_dog");

        Advancement.Builder.advancement().parent(husbandryRoot).display(BYGItems.WHITE_PUFFBALL_CAP, new TranslatableComponent("byg.advancements.husbandry.forager.title"),
                new TranslatableComponent("byg.advancements.husbandry.forager.description"), null, FrameType.CHALLENGE, true, true, false)
            .addCriterion("white_puffball_cap", InventoryChangeTrigger.TriggerInstance.hasItems(BYGItems.WHITE_PUFFBALL_CAP)).save(advancementConsumer, "byg:husbandry/forager");

        Advancement.Builder.advancement().parent(husbandryRoot).display(BYGItems.BLUE_BERRY, new TranslatableComponent("byg.advancements.husbandry.berrily_alive.title"),
                new TranslatableComponent("byg.advancements.husbandry.berrily_alive.description"), null, FrameType.CHALLENGE, true, true, false)
            .addCriterion("blue_berry", InventoryChangeTrigger.TriggerInstance.hasItems(BYGItems.BLUE_BERRY)).save(advancementConsumer, "byg:husbandry/berrily_alive");

        Advancement.Builder.advancement().parent(husbandryRoot).display(BYGItems.GREEN_APPLE_PIE, new TranslatableComponent("byg.advancements.husbandry.just_like_grandmas.title"),
                new TranslatableComponent("byg.advancements.husbandry.just_like_grandmas.description"), null, FrameType.CHALLENGE, true, true, false)
            .requirements(RequirementsStrategy.OR)
            .addCriterion("blueberry_pie", InventoryChangeTrigger.TriggerInstance.hasItems(BYGItems.BLUEBERRY_PIE))
            .addCriterion("green_apple_pie", InventoryChangeTrigger.TriggerInstance.hasItems(BYGItems.GREEN_APPLE_PIE))
            .addCriterion("crimson_berry_pie", InventoryChangeTrigger.TriggerInstance.hasItems(BYGItems.CRIMSON_BERRY_PIE))
            .addCriterion("nightshade_berry_pie", InventoryChangeTrigger.TriggerInstance.hasItems(BYGItems.NIGHTSHADE_BERRY_PIE))
            .save(advancementConsumer, "byg:husbandry/just_like_grandmas");

    }
}