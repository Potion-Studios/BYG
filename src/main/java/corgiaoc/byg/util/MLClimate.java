package corgiaoc.byg.util;

import com.mojang.serialization.Codec;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.common.BiomeManager;

public enum MLClimate implements IStringSerializable {
    HOT(BiomeManager.BiomeType.DESERT),
    HOT_LEGACY(BiomeManager.BiomeType.DESERT_LEGACY),
    WARM(BiomeManager.BiomeType.WARM),
    COOL(BiomeManager.BiomeType.COOL),
    COLD(BiomeManager.BiomeType.ICY);

    private final BiomeManager.BiomeType climate;

    public static final Codec<MLClimate> CODEC = IStringSerializable.fromEnum(MLClimate::values, MLClimate::byName);

    public static MLClimate byName(String name) {
        return MLClimate.valueOf(name.toUpperCase());
    }


    MLClimate(BiomeManager.BiomeType climate) {
        this.climate = climate;
    }

    public BiomeManager.BiomeType getClimate() {
        return climate;
    }

    @Override
    public String getSerializedName() {
        return this.name();
    }
}
