package potionstudios.byg.common.world.surfacerules;

import corgitaco.corgilib.serialization.jankson.JanksonJsonOps;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import corgitaco.corgilib.shadow.blue.endless.jankson.api.SyntaxError;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.SurfaceRules;
import potionstudios.byg.BYG;
import potionstudios.byg.util.ModPlatform;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public record SurfaceRulesConfig() {

    public static final Supplier<Map<ResourceKey<LevelStem>, Path>> CONFIG_PATHS = () -> {
        Map<ResourceKey<LevelStem>, Path> map = new Object2ObjectOpenHashMap<>();
        Path surface_rules = ModPlatform.INSTANCE.configPath().resolve("surface_rules");
        map.put(LevelStem.OVERWORLD, surface_rules.resolve("overworld_surface_rules.json5"));
        map.put(LevelStem.NETHER, surface_rules.resolve("nether_surface_rules.json5"));
        map.put(LevelStem.END, surface_rules.resolve("end_surface_rules.json5"));
        return map;
    };

    public static final Map<ResourceKey<LevelStem>, SurfaceRules.RuleSource> DEFAULTS = Util.make(new Object2ObjectOpenHashMap<>(), map -> {
        map.put(LevelStem.OVERWORLD, BYGSurfaceRules.OVERWORLD_SURFACE_RULES);
        map.put(LevelStem.NETHER, BYGSurfaceRules.NETHER_SURFACE_RULES);
        map.put(LevelStem.END, BYGSurfaceRules.END_SURFACE_RULES);
    });

    public static Map<ResourceKey<LevelStem>, SurfaceRules.RuleSource> INSTANCE = null;

    public static Map<ResourceKey<LevelStem>, SurfaceRules.RuleSource> getConfig() {
        return getConfig(false, false);
    }

    public static Map<ResourceKey<LevelStem>, SurfaceRules.RuleSource> getConfig(boolean serialize, boolean recreate) {
        if (INSTANCE == null || serialize || recreate) {
            INSTANCE = readConfig(recreate);
        }

        return INSTANCE;
    }

    private static Map<ResourceKey<LevelStem>, SurfaceRules.RuleSource> readConfig(boolean recreate) {
        Object2ObjectOpenHashMap<ResourceKey<LevelStem>, SurfaceRules.RuleSource> result = new Object2ObjectOpenHashMap<>();
        CONFIG_PATHS.get().forEach((stemResourceKey, path) -> {
            if (!path.toFile().exists() || recreate) {
                JanksonUtil.createConfig(path, SurfaceRules.RuleSource.CODEC, JanksonUtil.HEADER_OPEN + "\n\nSurface rules in this file are added after data packs load for this dimension(file name is the dimension).\nA guide for surface rules can be found here: https://github.com/TheForsakenFurby/Surface-Rules-Guide-Minecraft-JE-1.18/blob/main/Guide.md\n*/", new HashMap<>(), JanksonJsonOps.INSTANCE, DEFAULTS.get(stemResourceKey));
            }
            BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

            try {
                result.put(stemResourceKey, JanksonUtil.readConfig(path, SurfaceRules.RuleSource.CODEC, JanksonJsonOps.INSTANCE));
            } catch (IOException | SyntaxError e) {
                throw new RuntimeException(e);
            }
        });
        return result;
    }
}