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
    public static ForgeConfigSpec.BooleanValue vanillaBiomes;
    public static ForgeConfigSpec.IntValue seaLevel;
    public static ForgeConfigSpec.ConfigValue<String> externalEndBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalNetherBiomes;
    public static ForgeConfigSpec.BooleanValue tallNether;

    public static ForgeConfigSpec.IntValue rockyStoneSize;
    public static ForgeConfigSpec.IntValue rockyStoneChance;
    public static ForgeConfigSpec.IntValue rockyStoneMaxY;

    public static ForgeConfigSpec.IntValue scoriaStoneSize;
    public static ForgeConfigSpec.IntValue scoriaStoneChance;
    public static ForgeConfigSpec.IntValue scoriaStoneMaxY;

    public static ForgeConfigSpec.IntValue soapStoneSize;
    public static ForgeConfigSpec.IntValue soapStoneChance;
    public static ForgeConfigSpec.IntValue soapStoneMaxY;

    public static ForgeConfigSpec.IntValue ametrineOreSize;
    public static ForgeConfigSpec.IntValue ametrineOreChance;
    public static ForgeConfigSpec.IntValue ametrineOreMaxY;

    public static ForgeConfigSpec.IntValue pendoriteOreSize;
    public static ForgeConfigSpec.IntValue pendoriteOreChance;
    public static ForgeConfigSpec.IntValue pendoriteOreMaxY;

    static {
        COMMON_BUILDER.comment("BYG WorldType Settings").push("World_Settings");
        vanillaBiomes = COMMON_BUILDER.comment("Vanilla BiomeSounds. Default is true").define("VanillaBiomes", true);
        biomeSize = COMMON_BUILDER.comment("Biome Size, Default 1.").defineInRange("BiomeSize", 1, 0, 25);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("External BiomeSounds").push("Dimension_Settings");
        externalEndBiomes = COMMON_BUILDER.comment("Add external End biomes by their registry names in a commented list.").define("ExternalEndBiomes", "");
        externalNetherBiomes = COMMON_BUILDER.comment("Add external Nether biomes by their registry names in a commented list.").define("ExternalNetherBiomes", "");
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Nether Settings").push("Nether_Settings");
        tallNether = COMMON_BUILDER.comment("256 Height. Default is false").define("TallNether", false);
        COMMON_BUILDER.pop();


        COMMON_BUILDER.push("Stone_Settings");
        COMMON_BUILDER.push("Rocky_Stone");
        rockyStoneSize = COMMON_BUILDER.defineInRange("RockyStoneSize", 0, 0, 100);
        rockyStoneChance = COMMON_BUILDER.defineInRange("RockyStoneChance", 4, 0, 100);
        rockyStoneMaxY = COMMON_BUILDER.defineInRange("RockyStoneMaxY", 256, 0, 256);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("Scoria_Stone");
        scoriaStoneSize = COMMON_BUILDER.defineInRange("ScoriaStoneSize", 24, 0, 35);
        scoriaStoneChance = COMMON_BUILDER.defineInRange("ScoriaStoneChance", 10, 0, 100);
        scoriaStoneMaxY = COMMON_BUILDER.defineInRange("ScoriaStoneMaxY", 20, 0, 256);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("Soapstone");
        soapStoneSize = COMMON_BUILDER.defineInRange("SoapstoneSize", 24, 0, 35);
        soapStoneChance = COMMON_BUILDER.defineInRange("SoapstoneChance", 10, 0, 100);
        soapStoneMaxY = COMMON_BUILDER.defineInRange("SoapstoneMaxY", 30, 0, 256);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.pop();



        COMMON_BUILDER.push("Ore_Settings");
        COMMON_BUILDER.comment("Pendorite is exclusive to Forest Fault!").push("Pendorite");
        pendoriteOreSize = COMMON_BUILDER.defineInRange("PendoriteSize", 4, 0, 16);
        pendoriteOreChance = COMMON_BUILDER.defineInRange("PendoriteChance", 8, 0, 100);
        pendoriteOreMaxY = COMMON_BUILDER.defineInRange("PendoriteMaxY", 26, 0, 256);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Ametrine is exclusive to Guiana Shield!").push("Ametrine");
        ametrineOreSize = COMMON_BUILDER.defineInRange("AmetrineSize", 4, 0, 16);
        ametrineOreChance = COMMON_BUILDER.defineInRange("AmetrineChance", 10, 0, 100);
        ametrineOreMaxY = COMMON_BUILDER.defineInRange("AmetrineMaxY", 56, 0, 256);
        COMMON_BUILDER.pop();
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
