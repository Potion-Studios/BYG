package corgiaoc.byg.config;

import java.nio.file.Path;

public class WorldConfig {
    private final AbstractCommentedConfigHelper configHelper;

    public final int netherBiomeSize;
    public final boolean controlNether;

    public final int endBiomeSize;
    public final int voidBiomeSize;
    public final boolean controlEnd;

    public WorldConfig(Path path) {
        this.configHelper = new AbstractCommentedConfigHelper(path);

        AbstractCommentedConfigHelper netherSubConfig = new AbstractCommentedConfigHelper(null);
        this.netherBiomeSize = netherSubConfig.addNumber("Nether Biome Size\nDefault: 3", "NetherBiomeSize", 3, 1, 10);
        this.controlNether = netherSubConfig.add("Does BYG control The Nether?\n This only applies when making NEW worlds!\nIs not guaranteed to work in specific world types.\n You can find more info here in regards to specific world types: https://github.com/CorgiTaco/BYG/wiki/Enabling-BYG-Nether-&-End-Biomes\nFor existing worlds, follow the steps listed here: https://wiki.griefed.de/SCP/edit-world.", "ControlNether", true);
        this.configHelper.addSubConfig("Nether related settings", "The_Nether", netherSubConfig);

        AbstractCommentedConfigHelper endSubConfig = new AbstractCommentedConfigHelper(null);
        this.endBiomeSize = endSubConfig.addNumber("End Biome Size\nDefault: 3", "EndBiomeSize", 3, 1, 10);
        this.voidBiomeSize = endSubConfig.addNumber("Void Biome Size\nDefault: 2", "VoidBiomeSize", 2, 1, 10);
        this.controlEnd = endSubConfig.add("Does BYG control The End?\n This only applies when making NEW worlds!\nIs not guaranteed to work in specific world types.\n You can find more info here in regards to specific world types: https://github.com/CorgiTaco/BYG/wiki/Enabling-BYG-Nether-&-End-Biomes\nFor existing worlds, follow the steps listed here: https://wiki.griefed.de/SCP/edit-world.", "ControlEnd", true);
        this.configHelper.addSubConfig("End related settings", "The_End", endSubConfig);

        this.configHelper.build();
    }
}
