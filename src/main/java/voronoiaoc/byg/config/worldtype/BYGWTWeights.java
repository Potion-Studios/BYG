package voronoiaoc.byg.config.worldtype;

import net.minecraftforge.common.ForgeConfigSpec;

public class BYGWTWeights {
    private final String name;
    private final int weight;

    private ForgeConfigSpec.IntValue configWeight;

    public BYGWTWeights(String name, int weight) {
        this.name = name;
        this.weight = weight;
        WTVanillaExternalWeightManager.BYGBIOMEWEIGHTS.add(this);
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return configWeight.get();
    }

    public boolean shouldSpawn() {
        return configWeight.get() != 0;
    }

    public void apply(ForgeConfigSpec.Builder builder) {
        builder.comment(name + " biome generation").push(name + "_biome");
        configWeight = builder.comment("weight of the biome (set to 0 to disable generation). \ndefault is 10").defineInRange("weight", weight, 0, 256);
        builder.pop();
    }

}
