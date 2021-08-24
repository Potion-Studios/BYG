package corgiaoc.byg.common.world.feature.overworld.river;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;

import java.util.Objects;

public class MegaChunkPos {
    private final int x;
    private final int z;

    public MegaChunkPos(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public static MegaChunkPos fromBlockPos(BlockPos pos) {
        return new MegaChunkPos(pos.getX() >> 8, pos.getZ() >> 8);
    }

    public ChunkPos toChunkPos(int localX, int localZ) {
        return new ChunkPos((this.x << 4) | localX, (this.z << 4) | localZ);
    }

    public static byte packLocalPos(int localX, int localZ) {
        return (byte) (localX << 4 | localZ);
    }

    public ChunkPos unpackLocalPos(byte packedPos) {
        return this.toChunkPos(packedPos >> 4 & 0xF, packedPos & 0xF);
    }

    public MegaChunkPos add(int x, int z) {
        return new MegaChunkPos(this.x + x, this.z + z);
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MegaChunkPos that = (MegaChunkPos) o;
        return x == that.x && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, z);
    }
}
