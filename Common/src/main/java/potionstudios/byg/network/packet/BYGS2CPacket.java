package potionstudios.byg.network.packet;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;

public interface BYGS2CPacket {

    void write(FriendlyByteBuf buf);

    void handle(ClientLevel level);
}
