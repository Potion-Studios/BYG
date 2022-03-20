package potionstudios.byg.entry;

import net.fabricmc.loader.api.FabricLoader;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGFabric;
import potionstudios.byg.common.world.surfacerules.BYGSurfaceRules;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.world.biome.BYGRegion;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class BYGTerraBlenderEntry implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        BYG.init(FabricLoader.getInstance().getConfigDir().resolve("byg"), "c");

        BYG.MODLOADER_DATA = BYGFabric.getModLoaderData();
        OverworldBiomeConfig config = OverworldBiomeConfig.getConfig(true);
        if (config.generateOverworld()) {
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, BYG.MOD_ID, BYGSurfaceRules.OVERWORLD_SURFACE_RULES);
            config.values().forEach(biomeProviderData -> Regions.register(new BYGRegion(biomeProviderData)));
        } else {
            BYG.LOGGER.info("BYG overworld biomes disabled.");
        }
    }
}
