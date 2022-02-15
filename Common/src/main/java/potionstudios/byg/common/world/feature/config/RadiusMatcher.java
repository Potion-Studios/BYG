package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

import java.util.Arrays;

public enum RadiusMatcher {
    XZ,
    NONE,
    ALL;

    public static final Codec<RadiusMatcher> CODEC = Codec.STRING.comapFlatMap(s -> {
        final RadiusMatcher equipmentSlotType = RadiusMatcher.valueOf(s.toUpperCase());
        if (equipmentSlotType == null) {
            throw new IllegalArgumentException(String.format("\"%s\" is not a valid radius matcher. Valid radius matchers: %s", s, Arrays.toString(Arrays.stream(RadiusMatcher.values()).map(RadiusMatcher::toString).toArray())));
        }
        return DataResult.success(equipmentSlotType);

    }, RadiusMatcher::toString);

}