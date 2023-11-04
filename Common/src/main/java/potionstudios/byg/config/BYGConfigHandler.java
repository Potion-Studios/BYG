package potionstudios.byg.config;

import potionstudios.byg.BYGConstants;
import potionstudios.byg.client.BiomepediaInventoryConfig;
import potionstudios.byg.common.block.sapling.GrowingPatterns;
import potionstudios.byg.common.entity.npc.TradesConfig;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.common.world.surfacerules.SurfaceRulesConfig;
import potionstudios.byg.config.json.BiomeDictionaryConfig;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.util.FeatureGrowerFromBlockPattern;
import potionstudios.byg.util.ModPlatform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BYGConfigHandler {

    public static String loadAllConfigs(boolean serialize, boolean recreate) {
        return loadAllConfigs(serialize, recreate, ModPlatform.INSTANCE.isClientEnvironment());
    }

    public static String loadAllConfigs(boolean serialize, boolean recreate, boolean isClientSide) {
        StringBuilder errors = new StringBuilder();
        errors.append(tryCatchErrors(() -> EndBiomesConfig.getConfig(serialize, recreate, null)));
        errors.append(tryCatchErrors(() -> NetherBiomesConfig.getConfig(serialize, recreate, null)));
        errors.append(tryCatchErrors(() -> OverworldBiomeConfig.getConfig(serialize, recreate)));
        if (ModPlatform.INSTANCE.modPlatform() == ModPlatform.Platform.FORGE) {
            errors.append(tryCatchErrors(() -> BiomeDictionaryConfig.getConfig(serialize, recreate)));
        }
        errors.append(tryCatchErrors(() -> SurfaceRulesConfig.getConfig(serialize, recreate)));
        errors.append(tryCatchErrors(() -> {
            GrowingPatterns.getConfig(serialize, recreate);
            FeatureGrowerFromBlockPattern.ENTRIES.forEach(c -> c.get().load());
        }));
        errors.append(tryCatchErrors(() -> TradesConfig.getConfig(serialize, recreate)));
        errors.append(tryCatchErrors(() -> SettingsConfig.getConfig(serialize, recreate)));
        if (isClientSide) {
            errors.append(tryCatchErrors(() -> BiomepediaInventoryConfig.getConfig(serialize, recreate)));
        }
        errors.append(tryCatchErrors(() -> BiomepediaConfig.getConfig(serialize, recreate)));
        errors.append(tryCatchErrors(() -> ConfigVersionTracker.getConfig(new ConfigVersionTracker(BYGConstants.CONFIG_VERSION), recreate)));
        errors.append(tryCatchErrors(BYGConfigHandler::makeREADME));

        if (!errors.isEmpty()) {
            return String.format("Config errors were found:\n\n%s", errors.toString());
        }

        return errors.toString();
    }

    private static String tryCatchErrors(Runnable run) {
        String error = "";

        try {
            run.run();
        } catch (Exception e) {
            error = e.getMessage();
        }
        if (error == null) return "";
        return error + (!error.isEmpty() ? "\n" : "");
    }

    private static void makeREADME() {
        try {
            Path configPath = ModPlatform.INSTANCE.configPath();
            Files.createDirectories(configPath);
            Files.write(configPath.resolve("README.txt"), "For information on how BYG configs work, you can find that here: https://github.com/AOCAWOL/BYG/wiki/Configs".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
