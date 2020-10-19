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

    public static ForgeConfigSpec.BooleanValue DATAPACK_HACKS;

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

    static {
        COMMON_BUILDER.push("The_End");
        CONTROL_END = COMMON_BUILDER.comment("\nDoes BYG control The End?").define("ControlEnd", true);
        COMMON_BUILDER.push("Void");
        VOID_BIOMES = COMMON_BUILDER.comment("\nAdd biomes by their registry String ID's in a commented list.\nAdding a biome several times gives it more weight in generation.\nNO SPACES AFTER COMMAS!\nDOES NOT ACCEPT DATAPACK VALUES!\nDefault: \"byg:viscal_isles,minecraft:small_end_islands\"").define("VoidBiomes", "byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands");
        VOID_BIOME_SIZE = COMMON_BUILDER.comment("\nVoid Biome(where small end islands generate in vanilla) size.\nDefault: 3").defineInRange("VoidBiomeSize", 2, 0, 10);
        COMMON_BUILDER.pop();
        IS_BLACKLIST_END = COMMON_BUILDER.comment("\nIs the list of biomes a blacklist or whitelist?\nWhen this list is a blacklist, the values in the list will not be in world generation.\nWhen this list is a whitelist, Adding a biome several times gives it more weight in generation and it must contain at least 1 value.\nWhen set to true, datapack biomes will work automatically!\nDefault: true").define("isBlacklistEnd", true);
        BLACKLIST_END = COMMON_BUILDER.comment("\nThis works as a whitelist or blacklist depending on the \"isBlacklistEnd\" value.\nDOES NOT ACCEPT DATAPACK VALUES!\nDefault: \"\"").define("BlacklistEnd", "byg:viscal_isles,minecraft:small_end_islands,minecraft:the_end,minecraft:end_barrens");
        BIOME_SIZE_END = COMMON_BUILDER.comment("\nEnd Biome Size\nDefault: 3").defineInRange("EndBiomeSize", 3, 0, 10);
        MAIN_ISLAND_BIOME_SIZE = COMMON_BUILDER.comment("\nEnd Biome Size.\nDefault: 3").defineInRange("IslandBiomeSize", 3, 0, 10);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("The_Nether");
        CONTROL_NETHER = COMMON_BUILDER.comment("\nDoes BYG control The Nether?").define("ControlNether", true);
        IS_BLACKLIST_NETHER = COMMON_BUILDER.comment("\nIs the list of biomes a blacklist or whitelist?\nWhen this list is a blacklist, the values in the list will not be in world generation.\nWhen this list is a whitelist, Adding a biome several times gives it more weight in generation and it must contain at least 1 value.\nWhen set to true, datapack biomes will work automatically!\nDefault: true").define("isBlacklistNether", true);
        BLACKLIST_NETHER = COMMON_BUILDER.comment("\nThis works as a whitelist or blacklist depending on the \"isBlacklistNether\" value.\nDOES NOT ACCEPT DATAPACK VALUES!\nDefault: \"\"").define("BlacklistNether", "");
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
