package corgiaoc.byg.helper;

import net.minecraft.network.play.server.SUpdateTileEntityPacket;

public interface BlockEntityPacketHandler {

    void handleClientPacketNoTypeCheck(SUpdateTileEntityPacket sUpdateTileEntityPacket);
}
