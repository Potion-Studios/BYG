package potionstudios.byg.common.world;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.Map;

public class BYGBiomeSpawnsLike {

    public static final Map<ResourceKey<Biome>, ResourceKey<Biome>> BIOME_SPAWNS_LIKE = Util.make(new Object2ObjectOpenHashMap<>(), map -> {

    });
}
