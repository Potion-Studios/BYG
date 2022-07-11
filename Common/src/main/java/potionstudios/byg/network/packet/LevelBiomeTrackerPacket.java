package potionstudios.byg.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import potionstudios.byg.common.world.LevelBiomeTracker;

public record LevelBiomeTrackerPacket(LevelBiomeTracker biomeTracker) implements BYGS2CPacket {

    public static LevelBiomeTrackerPacket read(FriendlyByteBuf buf) {
        try {
            return new LevelBiomeTrackerPacket(buf.readWithCodec(LevelBiomeTracker.CODEC));
        } catch (Exception e) {
            throw new IllegalStateException("LevelBiomeTracker packet could not be read. This is really really bad...\n\n" + e.getMessage());
        }
    }


    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeWithCodec(LevelBiomeTracker.CODEC, this.biomeTracker);
        } catch (Exception e) {
            throw new IllegalStateException("LevelBiomeTracker packet could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(Level level) {
        LevelBiomeTracker.client_instance = this    .biomeTracker;
    }
}
