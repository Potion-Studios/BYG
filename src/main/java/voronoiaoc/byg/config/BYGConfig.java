package voronoiaoc.byg.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import voronoiaoc.byg.BYG;

import java.nio.file.Path;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGConfig {
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue mainMenuPanorama;
    public static ForgeConfigSpec.BooleanValue bygWorldType;
    public static ForgeConfigSpec.EnumValue<BiomeFogSettings> biomeFogEffects;

    public enum BiomeFogSettings {DENSEFOGCOLOR, DENSEFOG, FOGCOLOR, OFF}

    static {
        COMMON_BUILDER.comment("Client Settings").push("Client_Settings");
        mainMenuPanorama = COMMON_BUILDER.comment("BYG Main Menu Panorama.").define("Panorama", true);
        biomeFogEffects = COMMON_BUILDER.comment("BYG's Biome Fog Settings.\nApplies to \"Overworld\" ONLY.").defineEnum("BiomeFog", BiomeFogSettings.DENSEFOGCOLOR);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec config, Path path) {
        BYG.LOGGER.info("Loading config: " + path);
        CommentedFileConfig file = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }
}
