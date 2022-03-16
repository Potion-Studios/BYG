package potionstudios.byg.data.advancements;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.BYG;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

public class BYGAdvancementProvider implements DataProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final Path outputFolder;


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
        new BYGAdvancements().accept(consumer);
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
