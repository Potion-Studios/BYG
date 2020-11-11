package corgiaoc.byg.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import corgiaoc.byg.BYG;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGWorldConfig {
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;

    public static final ForgeConfigSpec.IntValue BIOME_SIZE_NETHER;
    public static final ForgeConfigSpec.IntValue BIOME_SIZE_END;
    public static final ForgeConfigSpec.IntValue MAIN_ISLAND_BIOME_SIZE;
    public static final ForgeConfigSpec.ConfigValue<String> BLACKLIST_END;
    public static final ForgeConfigSpec.ConfigValue<String> VOID_BIOMES;
    public static final ForgeConfigSpec.IntValue VOID_BIOME_SIZE;

    public static final ForgeConfigSpec.ConfigValue<String> BLACKLIST_NETHER;
    public static final ForgeConfigSpec.BooleanValue CONTROL_NETHER;
    public static final ForgeConfigSpec.BooleanValue CONTROL_END;
    public static final ForgeConfigSpec.BooleanValue IS_BLACKLIST_END;
    public static final ForgeConfigSpec.BooleanValue IS_BLACKLIST_NETHER;

    public static final ForgeConfigSpec.BooleanValue ROCKY_STONE_GEN;
    public static final ForgeConfigSpec.IntValue ROCKY_STONE_GEN_Y;
    public static final ForgeConfigSpec.IntValue ROCKY_STONE_GEN_SIZE;
    public static final ForgeConfigSpec.IntValue ROCKY_STONE_GEN_PER_CHUNK;

    public static final ForgeConfigSpec.BooleanValue SCORIA_STONE_GEN;
    public static final ForgeConfigSpec.IntValue SCORIA_STONE_GEN_Y;
    public static final ForgeConfigSpec.IntValue SCORIA_STONE_GEN_SIZE;
    public static final ForgeConfigSpec.IntValue SCORIA_STONE_GEN_PER_CHUNK;

    public static final ForgeConfigSpec.BooleanValue SOAP_STONE_GEN;
    public static final ForgeConfigSpec.IntValue SOAP_STONE_GEN_Y;
    public static final ForgeConfigSpec.IntValue SOAP_STONE_GEN_SIZE;
    public static final ForgeConfigSpec.IntValue SOAP_STONE_GEN_PER_CHUNK;

    public static final ForgeConfigSpec.BooleanValue AMETRINE_GEN;
    public static final ForgeConfigSpec.IntValue AMETRINE_GEN_Y;
    public static final ForgeConfigSpec.IntValue AMETRINE_GEN_SIZE;
    public static final ForgeConfigSpec.IntValue AMETRINE_GEN_PER_CHUNK;

    public static final ForgeConfigSpec.BooleanValue PENDORITE_GEN;
    public static final ForgeConfigSpec.IntValue PENDORITE_GEN_Y;
    public static final ForgeConfigSpec.IntValue PENDORITE_GEN_SIZE;
    public static final ForgeConfigSpec.IntValue PENDORITE_GEN_PER_CHUNK;


    static {
        COMMON_BUILDER.push("Overworld");
        COMMON_BUILDER.push("Ores").comment("Datapacks can and will override all values in the \"Ore\" category so keep that in mind!");

        COMMON_BUILDER.push("Ametrine");
        AMETRINE_GEN = COMMON_BUILDER.comment("\nGenerate Ametrine Ore? Only spawns in Guiana Shield, Stone Forest, and Pointed Stone Forest!").define("GenerateAmetrine", true);
        AMETRINE_GEN_Y = COMMON_BUILDER.comment("\nY level to start generating at.\nDefault: 56").defineInRange("AmetrineY", 56, 1, 256);
        AMETRINE_GEN_SIZE = COMMON_BUILDER.comment("\nSize of the clusters.\nDefault: 4").defineInRange("AmetrineSize", 4, 1, 100);
        AMETRINE_GEN_PER_CHUNK = COMMON_BUILDER.comment("\nNumber of times to spawn per chunk.\nDefault: 10").defineInRange("AmetrinePerChunk", 10, 1, 100);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("Pendorite");
        PENDORITE_GEN = COMMON_BUILDER.comment("\nGenerate Pendorite Ore? Only spawns in Forest Fault.").define("GeneratePendorite", true);
        PENDORITE_GEN_Y = COMMON_BUILDER.comment("\nY level to start generating at.\nDefault: 56").defineInRange("PendoriteY", 56, 1, 256);
        PENDORITE_GEN_SIZE = COMMON_BUILDER.comment("\nSize of the clusters.\nDefault: 4").defineInRange("PendoriteSize", 4, 1, 100);
        PENDORITE_GEN_PER_CHUNK = COMMON_BUILDER.comment("\nNumber of times to spawn per chunk.\nDefault: 10").defineInRange("PendoritePerChunk", 10, 1, 100);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.pop();


        COMMON_BUILDER.push("Stones").comment("Datapacks can and will override all values in the \"Stone\" category so keep that in mind!");;
        
        COMMON_BUILDER.push("Rocky_Stone");
        ROCKY_STONE_GEN = COMMON_BUILDER.comment("\nGenerate Rocky Stone?").define("GenerateRockyStone", true);
        ROCKY_STONE_GEN_Y = COMMON_BUILDER.comment("\nY level to start generating at.\nDefault: 63").defineInRange("RockyStoneY", 63, 1, 256);
        ROCKY_STONE_GEN_SIZE = COMMON_BUILDER.comment("\nSize of the clusters.\nDefault: 20").defineInRange("RockyStoneSize", 20, 1, 100);
        ROCKY_STONE_GEN_PER_CHUNK = COMMON_BUILDER.comment("\nNumber of times to spawn per chunk.\nDefault: 10").defineInRange("RockyStonePerChunk", 10, 1, 100);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("Scoria_Stone");
        SCORIA_STONE_GEN = COMMON_BUILDER.comment("\nGenerate Scoria Stone?").define("GenerateScoriaStone", true);
        SCORIA_STONE_GEN_Y = COMMON_BUILDER.comment("\nY level to start generating at.\nDefault: 63").defineInRange("ScoriaStoneY", 63, 1, 256);
        SCORIA_STONE_GEN_SIZE = COMMON_BUILDER.comment("\nSize of the clusters.\nDefault: 20").defineInRange("ScoriaStoneSize", 20, 1, 100);
        SCORIA_STONE_GEN_PER_CHUNK = COMMON_BUILDER.comment("\nNumber of times to spawn per chunk.\nDefault: 10").defineInRange("ScoriaStonePerChunk", 10, 1, 100);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("Soap_Stone");
        SOAP_STONE_GEN = COMMON_BUILDER.comment("\nGenerate Soap Stone?").define("GenerateSoapStone", true);
        SOAP_STONE_GEN_Y = COMMON_BUILDER.comment("\nY level to start generating at.\nDefault: 63").defineInRange("SoapStoneY", 63, 1, 256);
        SOAP_STONE_GEN_SIZE = COMMON_BUILDER.comment("\nSize of the clusters.\nDefault: 20").defineInRange("SoapStoneSize", 20, 1, 100);
        SOAP_STONE_GEN_PER_CHUNK = COMMON_BUILDER.comment("\nNumber of times to spawn per chunk.\nDefault: 10").defineInRange("SoapStonePerChunk", 10, 1, 100);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.pop();

        COMMON_BUILDER.pop();
        
        COMMON_BUILDER.push("The_End");
        CONTROL_END = COMMON_BUILDER.comment("\nDoes BYG control The End?").define("ControlEnd", true);

        COMMON_BUILDER.push("Void");
        VOID_BIOMES = COMMON_BUILDER.comment("\nAdd biomes by their registry String ID's in a commented list.\nAdding a biome several times gives it more weight in generation.\nNO SPACES AFTER COMMAS!\nDefault: \"byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands\"").define("VoidBiomes", "byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands");
        VOID_BIOME_SIZE = COMMON_BUILDER.comment("\nVoid Biome(where small end islands generate in vanilla) size.\nDefault: 3").defineInRange("VoidBiomeSize", 2, 0, 10);
        COMMON_BUILDER.pop();

        IS_BLACKLIST_END = COMMON_BUILDER.comment("\nIs the list of biomes a blacklist or whitelist?\nWhen this list is a blacklist, the values in the list will not be in world generation.\nWhen this list is a whitelist, Adding a biome several times gives it more weight in generation and it must contain at least 1 value.\nWhen set to true, datapack biomes will work automatically! When set to false, you will need to manually add datapack entries.\nDefault: true").define("isBlacklistEnd", true);
        BLACKLIST_END = COMMON_BUILDER.comment("\nThis works as a whitelist or blacklist depending on the \"isBlacklistEnd\" value.\nNO SPACES AFTER COMMAS!\nDefault: \"byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands,minecraft:the_end,minecraft:end_barrens\"").define("BlacklistEnd", "byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands,minecraft:the_end,minecraft:end_barrens");
        BIOME_SIZE_END = COMMON_BUILDER.comment("\nEnd Biome Size\nDefault: 3").defineInRange("EndBiomeSize", 3, 0, 10);
        MAIN_ISLAND_BIOME_SIZE = COMMON_BUILDER.comment("\nEnd Biome Size.\nDefault: 3").defineInRange("IslandBiomeSize", 3, 0, 10);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("The_Nether");
        CONTROL_NETHER = COMMON_BUILDER.comment("\nDoes BYG control The Nether?").define("ControlNether", true);
        IS_BLACKLIST_NETHER = COMMON_BUILDER.comment("\nIs the list of biomes a blacklist or whitelist?\nWhen this list is a blacklist, the values in the list will not be in world generation.\nWhen this list is a whitelist, Adding a biome several times gives it more weight in generation and it must contain at least 1 value.\nWhen set to true, datapack biomes will work automatically! When set to false, you will need to manually add datapack entries.\nDefault: true").define("isBlacklistNether", true);
        BLACKLIST_NETHER = COMMON_BUILDER.comment("\nThis works as a whitelist or blacklist depending on the \"isBlacklistNether\" value.\nNO SPACES AFTER COMMAS!\nDefault: \"\"").define("BlacklistNether", "");
        BIOME_SIZE_NETHER = COMMON_BUILDER.comment("\nNether Biome Size\nDefault: 3").defineInRange("NetherBiomeSize", 3, 0, 10);
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
