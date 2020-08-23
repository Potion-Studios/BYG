package voronoiaoc.byg.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import voronoiaoc.byg.BYG;

import java.nio.file.Path;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGWorldConfig {
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.IntValue biomeSize;
    public static ForgeConfigSpec.IntValue biomeSizeNETHER;
    public static ForgeConfigSpec.IntValue biomeSizeEND;

    public static ForgeConfigSpec.IntValue seaLevel;
    public static ForgeConfigSpec.ConfigValue<String> externalEndBiomes;
    public static ForgeConfigSpec.ConfigValue<String> netherBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalICYBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalWARMBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalHOTBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalCOOLBiomes;
    public static ForgeConfigSpec.BooleanValue controlNether;
    public static ForgeConfigSpec.BooleanValue controlEnd;

    static {
        COMMON_BUILDER.comment("Dimension Settings").push("Dimension_Settings").push("The_End");
        controlEnd = COMMON_BUILDER.comment("Does BYG control The End?").define("ControlEnd", true);
        externalEndBiomes = COMMON_BUILDER.comment("Add external End biomes by their registry names in a commented list.").define("ExternalEndBiomes", "");
        biomeSizeEND = COMMON_BUILDER.comment("Add external Nether biomes by their registry names in a commented list.").defineInRange("EndBiomeSize", 3, 0, 10);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.push("The_Nether");
        controlNether = COMMON_BUILDER.comment("Does BYG control The Nether?").define("ControlNether", true);
        netherBiomes = COMMON_BUILDER.comment("Add Nether biomes by their registry names(IDs) in a commented list.\n Adding a biome several times gives it more weight in generation.\n Default: \"byg:embur_bog,byg:glowstone_gardens,byg:sythian_torrids,byg:warped_desert,minecraft:basalt_deltas,minecraft:crimson_forest,minecraft:nether_wastes,minecraft:soul_sand_valley,minecraft:warped_forest\".").define("NetherBiomes", "byg:embur_bog,byg:crimson_gardens,byg:embur_bog,byg:wailing_garth,byg:glowstone_gardens,byg:sythian_torrids,byg:warped_desert,minecraft:basalt_deltas,minecraft:crimson_forest,minecraft:nether_wastes,minecraft:soul_sand_valley,minecraft:warped_forest");
        biomeSizeNETHER = COMMON_BUILDER.comment("Add external Nether biomes by their registry names in a commented list.").defineInRange("NetherBiomeSize", 3, 0, 10);
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
