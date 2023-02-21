package potionstudios.byg.datagen.providers.advancements;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.data.ExistingFileHelper;
import potionstudios.byg.common.item.BYGItems;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static potionstudios.byg.BYG.createLocation;

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
                .display(BYGItems.BYG_LOGO.get(), Component.translatable("byg.advancements.root.title"), Component.translatable("byg.advancements.root.description"), createLocation("textures/block/lush_dirt.png"), FrameType.TASK, false, false, false)
                .addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(), EntityPredicate.Composite.ANY)).save(consumer, "byg:root");

        advancements.stream().map(Supplier::get).forEach(cons -> cons.accept(consumer, root));
    }

    @Override
    public String getName() {
        return "BYG Advancements";
    }
}
