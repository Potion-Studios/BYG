package voronoiaoc.byg.config.biomeweight;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigWeight {
    private final String NAME;
    private final int WEIGHT;

    private ForgeConfigSpec.IntValue configWeight;

    public ConfigWeight(String NAME, int WEIGHT) {
        this.NAME = NAME;
        this.WEIGHT = WEIGHT;
        ConfigWeightManager.biomeWeights.add(this);
    }

    public String getName() {
        return NAME;
    }

    public int getWeight() {
        return configWeight.get();
    }

    public void apply(ForgeConfigSpec.Builder builder) {
        builder.push(NAME);
        configWeight = builder.comment("Set to 0 to disable generation. Default Weight is: " + WEIGHT).defineInRange("Weight", WEIGHT, 0, 256);
        builder.pop();
    }
}
