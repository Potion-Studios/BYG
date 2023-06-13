package potionstudios.byg.network.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import potionstudios.byg.server.level.BYGPlayerTrackedData;

public record ConstructBYGPlayerTrackedDataPacket(BYGPlayerTrackedData playerTrackedData) implements BYGS2CPacket {

    public static ConstructBYGPlayerTrackedDataPacket read(FriendlyByteBuf buf) {
        try {
            return new ConstructBYGPlayerTrackedDataPacket(buf.readWithCodec(NbtOps.INSTANCE, BYGPlayerTrackedData.CODEC));
        } catch (Exception e) {
            throw new IllegalStateException("Construct BYG Player Tracked Data packet could not be read. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeWithCodec(NbtOps.INSTANCE, BYGPlayerTrackedData.CODEC, this.playerTrackedData);
        } catch (Exception e) {
            throw new IllegalStateException("Construct BYG Player Tracked Data packet could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(Level level) {
        if (Minecraft.getInstance().player != null) {
            ((BYGPlayerTrackedData.Access) Minecraft.getInstance().player).setPlayerTrackedData(this.playerTrackedData);
        }
    }
}