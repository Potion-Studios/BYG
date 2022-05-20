package potionstudios.byg.data;

import net.minecraft.data.HashCache;
import potionstudios.byg.data.advancements.BYGAdvancementProvider;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BYGDataProviders {

    public static void generateProviders() {
        Path exportPath = Paths.get("generated");
        try {
            HashCache cache = new HashCache(exportPath, "cache");
            BYGAdvancementProvider bygAdvancementProvider = new BYGAdvancementProvider(exportPath);
            bygAdvancementProvider.run(cache);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
