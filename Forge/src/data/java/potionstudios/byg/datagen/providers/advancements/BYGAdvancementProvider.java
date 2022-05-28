package potionstudios.byg.datagen.providers.advancements;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.TickTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.common.data.ExistingFileHelper;
import potionstudios.byg.common.item.BYGItems;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static potionstudios.byg.BYG.createLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BYGAdvancementProvider extends AdvancementProvider {

    private final List<Supplier<BYGAdvancementConsumer>> advancements = List.of(
            BYGAdventureAdvancements::new, BYGHusbandryAdvancements::new
    );

    public BYGAdvancementProvider(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, fileHelperIn);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
        final Advancement root = Advancement.Builder.advancement()
                .display(BYGItems.BYG_LOGO.get(), new TranslatableComponent("byg.advancements.root.title"), new TranslatableComponent("byg.advancements.root.description"), createLocation("textures/block/lush_dirt.png"), FrameType.TASK, false, false, false)
                .addCriterion("tick", new TickTrigger.TriggerInstance(EntityPredicate.Composite.ANY)).save(consumer, "byg:root");
        Advancement.Builder.advancement()
                .parent(root).display(BYGItems.BIOMEPEDIA.get(), new TranslatableComponent("byg.advancements.biomepediagift.title"), new TranslatableComponent("byg.advancements.biomepediagift.description"), null, FrameType.TASK, false, false, true)
                .addCriterion("tick", new TickTrigger.TriggerInstance(EntityPredicate.Composite.ANY)).rewards(new AdvancementRewards.Builder().addLootTable(createLocation("advancement/biomepedia_gift"))).save(consumer, "byg:biomepedia_gift");

        advancements.stream().map(Supplier::get).forEach(cons -> cons.accept(consumer, root));
    }

    @Override
    public String getName() {
        return "BYG Advancements";
    }
}
