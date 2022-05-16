package potionstudios.byg.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import potionstudios.byg.client.BiomepediaInventoryConfig;

public record BiomepediaActivePacket(boolean active) implements BYGS2CPacket{

    public static BiomepediaActivePacket read(FriendlyByteBuf buf) {
        try {
            return new BiomepediaActivePacket(buf.readBoolean());
        } catch (Exception e) {
            throw new IllegalStateException("BiomepediaActivePacket could not be read. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeBoolean(this.active);
        } catch (Exception e) {
            throw new IllegalStateException("BiomepediaActivePacket could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(Level level) {
        BiomepediaInventoryConfig.server_value = this.active;
    }
}
