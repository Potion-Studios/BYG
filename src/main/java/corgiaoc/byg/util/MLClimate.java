package corgiaoc.byg.util;

import com.mojang.serialization.Codec;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Util;
import net.minecraftforge.common.BiomeManager;

import java.util.HashMap;
import java.util.Map;

public enum MLClimate implements IStringSerializable {
    HOT(BiomeManager.BiomeType.DESERT),
    HOT_LEGACY(BiomeManager.BiomeType.DESERT_LEGACY),
    WARM(BiomeManager.BiomeType.WARM),
    COOL(BiomeManager.BiomeType.COOL),
    COLD(BiomeManager.BiomeType.ICY);

    private final BiomeManager.BiomeType climate;

    public static final Codec<MLClimate> CODEC = IStringSerializable.fromEnum(MLClimate::values, MLClimate::byName);

    private static final Map<String, String> OLD_TO_NEW_NAME = Util.make(new HashMap<>(), (map) -> {
        map.put("DESERT", "HOT");
        map.put("DESERT_LEGACY", "HOT_LEGACY");
        map.put("WARM", "WARM");
        map.put("COOL", "COOL");
        map.put("ICY", "COLD");
    });

    public static MLClimate byName(String name) {
        name = OLD_TO_NEW_NAME.getOrDefault(name.toUpperCase(), name.toUpperCase());
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
