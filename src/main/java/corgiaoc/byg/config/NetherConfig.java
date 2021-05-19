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
public class NetherConfig {
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
    public static final ForgeConfigSpec.ConfigValue<String> BLACKLIST_NETHER;
    public static final ForgeConfigSpec.BooleanValue IS_BLACKLIST_NETHER;

    static {
        COMMON_BUILDER.push("The_Nether").comment("This config will be removed soon and replaced with a similar system to that of the nether.");
        IS_BLACKLIST_NETHER = COMMON_BUILDER.comment("\nIs the list of biomes a blacklist or whitelist?\nWhen this list is a blacklist, the values in the list will not be in world generation.\nWhen this list is a whitelist, Adding a biome several times gives it more weight in generation and it must contain at least 1 value.\nWhen set to true, datapack biomes will work automatically! When set to false, you will need to manually add datapack entries.\nDefault: true").define("isBlacklistNether", true);
        BLACKLIST_NETHER = COMMON_BUILDER.comment("\nThis works as a whitelist or blacklist depending on the \"isBlacklistNether\" value.\nNO SPACES AFTER COMMAS!\nDefault: \"\"").define("BlacklistNether", "");
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
