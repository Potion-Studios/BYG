package potionstudios.byg.entry;

import net.minecraft.world.level.dimension.LevelStem;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGFabric;
import potionstudios.byg.common.world.surfacerules.SurfaceRulesConfig;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.world.biome.BYGTerraBlenderRegion;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class BYGTerraBlenderEntry implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        BYGFabric.initializeBYG("TerraBlender Initializer");

        OverworldBiomeConfig config = OverworldBiomeConfig.getConfig(true);
        if (config.generateOverworld()) {
            SurfaceRulesConfig.getConfig().forEach((stemResourceKey, ruleSource) -> {
                SurfaceRuleManager.RuleCategory ruleCategory = null;
                if (stemResourceKey == LevelStem.OVERWORLD) {
                    ruleCategory = SurfaceRuleManager.RuleCategory.OVERWORLD;
                }
                if (stemResourceKey == LevelStem.NETHER) {
                    ruleCategory = SurfaceRuleManager.RuleCategory.NETHER;
                }
                if (ruleCategory != null) {
                    SurfaceRuleManager.addSurfaceRules(ruleCategory, BYG.MOD_ID, ruleSource);
                }
            });
            config.values().forEach(biomeProviderData -> Regions.register(new BYGTerraBlenderRegion(biomeProviderData.value())));
        } else {
            BYG.LOGGER.info("BYG overworld biomes disabled.");
        }
    }
}