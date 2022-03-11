package potionstudios.byg.util;

import net.minecraft.world.level.levelgen.SurfaceRules;
import potionstudios.byg.BYG;

import java.nio.file.Path;
import java.util.function.Supplier;

public interface ModLoaderContext {

    Path configPath();

    Supplier<SurfaceRules.RuleSource> netherRuleSource();

    boolean isModLoaded(String isLoaded);

    static ModLoaderContext getInstance() {
        ModLoaderContext data = BYG.MODLOADER_DATA;

        if (data == null) {
            throw new RuntimeException("Accessed ModLoaderContext too early!");
        }

        return data;
    }
}
