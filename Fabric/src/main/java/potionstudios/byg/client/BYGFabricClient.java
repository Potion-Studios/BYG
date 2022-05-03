package potionstudios.byg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import potionstudios.byg.client.textures.renders.BYGCutoutRenders;
import potionstudios.byg.mixin.access.client.ItemBlockRenderTypeAccess;
import potionstudios.byg.mixin.client.access.AccessEntityRenderers;
import potionstudios.byg.mixin.client.access.ParticleEngineAccess;
import potionstudios.byg.network.NetworkUtil;

public class BYGFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(NetworkUtil.SPAWN_PACKET_ID, (client, listener, buf, responseSender) -> {
            buf.retain();
            NetworkUtil.receiveSpawnPacket(client, buf);
        });

        BYGClient.load();
        BYGClient.threadSafeLoad();
        BYGCutoutRenders.renderCutOuts(blockRenderTypeMap -> ItemBlockRenderTypeAccess.byg_getTYPE_BY_BLOCK().putAll(blockRenderTypeMap));

        BYGEntityRenderers.register(AccessEntityRenderers::byg_register);

        final var particleAccessor = ((ParticleEngineAccess) Minecraft.getInstance().particleEngine);
        BYGClient.registerParticles(particleAccessor::byg_register);
    }
}