package corgiaoc.byg.helper;

import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;

public interface BlockEntityPacketHandler {

    void handleClientPacketNoTypeCheck(ClientboundBlockEntityDataPacket sUpdateTileEntityPacket);
}
