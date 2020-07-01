package voronoiaoc.byg.client.registries;

import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import voronoiaoc.byg.common.network.CustomEntitySpawnS2CPacket;

import static voronoiaoc.byg.common.network.CustomEntitySpawnS2CPacket.SPAWN_PACKET_ID;

public class BYGClientNetworkRegistry {
    public static void registerPackets() {
        ClientSidePacketRegistry.INSTANCE.register(SPAWN_PACKET_ID, CustomEntitySpawnS2CPacket::receiveSpawnPacket);
    }
}
