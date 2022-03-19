package potionstudios.byg.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;

public interface BYGS2CPacket {

    void write(FriendlyByteBuf buf);

    void handle(Level level);
}
