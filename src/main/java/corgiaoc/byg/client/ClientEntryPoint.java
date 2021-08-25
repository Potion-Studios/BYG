package corgiaoc.byg.client;

import corgiaoc.byg.BYG;
import corgiaoc.byg.util.NetworkUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

public class ClientEntryPoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(NetworkUtil.SPAWN_PACKET_ID, (client, listener, buf, responseSender) -> {
                    buf.retain();
                    NetworkUtil.receiveSpawnPacket(client, buf);
                });

        BYG.clientLoad();
    }
}
