package potionstudios.byg.util;

import com.mojang.serialization.Codec;
import net.minecraft.Util;
import net.minecraft.util.StringRepresentable;

import java.util.HashMap;
import java.util.Map;

public enum MLClimate implements StringRepresentable {
    HOT(),
    WARM(),
    COOL(),
    COLD();

//    private final Object climate;

    public static final Codec<MLClimate> CODEC = StringRepresentable.fromEnum(MLClimate::values, MLClimate::byName);

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


    MLClimate(/*OverworldClimate climate*/) {
//        this.climate = climate;
    }

    public Object getClimate() {
        return new Object();
    }

    @Override
    public String getSerializedName() {
        return this.name();
    }
}
