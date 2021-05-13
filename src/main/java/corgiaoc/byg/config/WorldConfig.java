package corgiaoc.byg.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import corgiaoc.byg.BYG;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.nio.file.Path;
import java.util.Arrays;

public class WorldConfig {
    private final AbstractCommentedConfigHelper configHelper;

    public final int netherBiomeSize;
    public final boolean controlNether;

    public final int endBiomeSize;
    public final int voidBiomeSize;
    public final boolean controlEnd;
    public final String ametrineSpawns;
    public final String theriumSpawns;
    public final String pendoriteSpawns;

    public WorldConfig(Path path) {
        this.configHelper = new AbstractCommentedConfigHelper(path);

        AbstractCommentedConfigHelper netherSubConfig = new AbstractCommentedConfigHelper(this.configHelper.getValue("The_End") != null ? this.configHelper.getValue("The_Nether") : CommentedConfig.inMemory());
        this.netherBiomeSize = netherSubConfig.addNumber("Nether Biome Size\nDefault: 3", "NetherBiomeSize", 3, 1, 10);
        this.controlNether = netherSubConfig.add("Does BYG control The Nether?\nThis only applies when making NEW worlds!\nIs not guaranteed to work in specific world types.\nYou can find more info here in regards to specific world types: https://github.com/CorgiTaco/BYG/wiki/Enabling-BYG-Nether-&-End-Biomes\nFor existing worlds, follow the steps listed here: https://wiki.griefed.de/SCP/edit-world.", "ControlNether", true);
        this.configHelper.addSubConfig("Nether related settings", "The_Nether", netherSubConfig);

        AbstractCommentedConfigHelper endSubConfig = new AbstractCommentedConfigHelper(this.configHelper.getValue("The_End") != null ? this.configHelper.getValue("The_End") : CommentedConfig.inMemory());
        this.endBiomeSize = endSubConfig.addNumber("End Biome Size\nDefault: 3", "EndBiomeSize", 3, 1, 10);
        this.voidBiomeSize = endSubConfig.addNumber("Void Biome Size\nDefault: 2", "VoidBiomeSize", 2, 1, 10);
        this.controlEnd = endSubConfig.add("Does BYG control The End?\nThis only applies when making NEW worlds!\nIs not guaranteed to work in specific world types.\nYou can find more info here in regards to specific world types: https://github.com/CorgiTaco/BYG/wiki/Enabling-BYG-Nether-&-End-Biomes\nFor existing worlds, follow the steps listed here: https://wiki.griefed.de/SCP/edit-world.", "ControlEnd", true);
        this.configHelper.addSubConfig("End related settings", "The_End", endSubConfig);

        AbstractCommentedConfigHelper oreSubConfig = new AbstractCommentedConfigHelper(this.configHelper.getValue("Ores") != null ? this.configHelper.getValue("Ores") : CommentedConfig.inMemory());
        this.ametrineSpawns = oreSubConfig.add("What biome(s) does Ametrine spawn in? Default: \"byg:shattered_viscal_isles\".", "AmetrineSpawns", "byg:shattered_viscal_isles");
        this.theriumSpawns = oreSubConfig.add("What biome(s) does Therium spawn in? Default: \"byg#END\".", "TheriumSpawns", "byg#END");
        this.pendoriteSpawns = oreSubConfig.add("What biome(s) does Pendorite spawn in? Default: \"byg:forest_fault\".", "PendoriteSpawns", "byg:forest_fault");
        this.configHelper.addSubConfig("BYG uses a prefix system for its ore spawns.\n Prefix Guide:\n \"#\" - Biome category representable.\n \"$\" - Biome dictionary representable.\n \",\" - Creates a new condition, separate from the previous.\n \"\" - No prefix serves as a biome ID OR Mod ID representable.\n\n Here are a few examples:\n1. \"byg#END,$OCEAN\" would mean that the ore may spawn in biomes with the name space \"byg\" AND in the \"END\" biome category, OR all biomes in the \"OCEAN\" dictionary.\n2. \"byg:guiana_shield, #MESA\" would mean that the ore may spawn in the \"byg:guiana_shield\" OR all biomes in the \"MESA\" category.\n3. \"byg#ICY$MOUNTAIN\" would mean that the ore may only spawn in biomes from byg in the \"ICY\" category and \"MOUNTAIN\" dictionary type.\n4. \"\" Don't spawn anywhere.", "Ores", oreSubConfig);

        this.configHelper.build();
    }

    public static boolean conditionPasses(String conditionString, RegistryKey<Biome> biomeKey, Biome biome) {
        if (conditionString.isEmpty()) {
            return false;
        }
        String[] conditions = conditionString.trim().split("\\s*,\\s*");
        String biomeNamespace = biomeKey.location().getNamespace();
        String biomeLocation = biomeKey.location().toString();
        for (String condition : conditions) {
            String[] split = condition.split("(?=[\\$#])");
            boolean categoryExists = true;
            for (String result : split) {
                if (result.startsWith("#")) {
                    String categoryString = result.substring(1);
                    categoryExists = Arrays.stream(Biome.Category.values()).anyMatch(bc -> bc.toString().equalsIgnoreCase(categoryString));
                    if (!categoryExists) {
                        BYG.LOGGER.error("\"" + categoryString + "\" is not a valid biome category!");
                    }
                }
            }
            if (!categoryExists) {
                continue;
            }
            boolean fail = false;
            for (String result : split) {
                if (result.startsWith("$")) {
                    if (!BiomeDictionary.hasType(biomeKey, BiomeDictionary.Type.getType(result.substring(1).toUpperCase()))) {
                        fail = true;
                    }
                } else if (result.startsWith("#")) {
                    String categoryString = result.substring(1);
                    if (!biome.getBiomeCategory().getName().equalsIgnoreCase(categoryString)) {
                        fail = true;
                    }
                } else if (!biomeLocation.equalsIgnoreCase(result) && !result.equalsIgnoreCase(biomeNamespace)) {
                    fail = true;
                }
            }
            if (!fail) {
                return true;
            }
        }
        return false;
    }
}
