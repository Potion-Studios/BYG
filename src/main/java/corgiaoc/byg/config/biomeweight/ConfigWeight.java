package corgiaoc.byg.config.biomeweight;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigWeight {
    private final String name;
    private final int defaultWeight;

    private ForgeConfigSpec.IntValue configWeight;

    public ConfigWeight(String name, int defaultWeight) {
        this.name = name;
        this.defaultWeight = defaultWeight;
        ConfigWeightManager.CONFIG_WEIGHTS.add(this);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return configWeight.get();
    }

    public void apply(ForgeConfigSpec.Builder builder) {
        builder.push(name);
        configWeight = builder.comment("Set to 0 to disable generation. Default Weight is: " + defaultWeight).defineInRange("Weight", defaultWeight, 0, 256);
        builder.pop();
    }
}
