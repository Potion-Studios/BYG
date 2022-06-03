package potionstudios.byg.util;

import it.unimi.dsi.fastutil.bytes.Byte2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public interface DuneCache {

    Long2ObjectOpenHashMap<Byte2DoubleOpenHashMap> getDensityAt();

    Long2ObjectOpenHashMap<Byte2ObjectOpenHashMap<ResourceKey<Biome>>> getBiomeAt();


    static byte getLocalPackedCoord(BlockPos pos) {
        return (byte) ((pos.getX() & 0xF) << 4 | pos.getZ() & 0xF);
    }

    static int getLocalX(byte packedLocalCoord) {
        return packedLocalCoord >>> 8 & 0xF;
    }

    static int getLocalZ(byte packedLocalCoord) {
        return packedLocalCoord & 0xF;
    }
}
