package potionstudios.byg.data.advancements;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.BYG;
import potionstudios.byg.common.item.BYGItems;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class BYGAdvancementProvider implements DataProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final Path outputFolder;

    private static final List<BYGAdvancementConsumer<Advancement>> ADVANCEMENTS = ImmutableList.of(new BYGHusbandryAdvancements());

    public BYGAdvancementProvider(Path outputFolder) {
        this.outputFolder = outputFolder;
    }

    @Override
    public void run(HashCache cache) {
        Path path = this.outputFolder;
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (advancement) -> {
            if (!set.add(advancement.getId())) {
                throw new IllegalStateException("Duplicate advancement " + advancement.getId());
            } else {
                Path path2 = createPath(path, advancement);

                try {
                    DataProvider.save(GSON, cache, advancement.deconstruct().serializeToJson(), path2);
                } catch (IOException var6) {
                    BYG.LOGGER.error("Couldn't save advancement {}", path2, var6);
                }

            }
        };
        Advancement root = Advancement.Builder.advancement().display(BYGItems.BYG_LOGO, new TranslatableComponent("byg.advancements.root.title"), new TranslatableComponent("byg.advancements.root.description"), BYG.createLocation("textures/block/lush_dirt.png"), FrameType.TASK, false, false, false).addCriterion("consumed_item", ConsumeItemTrigger.TriggerInstance.usedItem()).save(consumer, "byg:root");

        for (BYGAdvancementConsumer<Advancement> advancement : ADVANCEMENTS) {
            advancement.accept(consumer, root);
        }
    }

    private static Path createPath(Path path, Advancement advancement) {
        String nameSpace = advancement.getId().getNamespace();
        return path.resolve("data/" + nameSpace + "/advancements/" + advancement.getId().getPath() + ".json");
    }

    @Override
    public String getName() {
        return "BYG Advancements";
    }
}
