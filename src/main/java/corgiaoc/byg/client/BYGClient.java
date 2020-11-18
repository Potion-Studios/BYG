package corgiaoc.byg.client;

import corgiaoc.byg.client.textures.BlockColorManager;
import corgiaoc.byg.client.textures.renders.BYGCutoutRenders;
import corgiaoc.byg.common.network.CustomEntitySpawnS2CPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

@Environment(EnvType.CLIENT)
public class BYGClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BYGCutoutRenders.renderCutOuts();
        BlockColorManager.onBlockColorsInit();
        BlockColorManager.onItemColorsInit();
        ClientSidePacketRegistry.INSTANCE.register(CustomEntitySpawnS2CPacket.SPAWN_PACKET_ID, CustomEntitySpawnS2CPacket::receiveSpawnPacket);
//        EntityRendererRegistry.INSTANCE.register(BYGEntities.BOAT, (entityRenderDispatcher, context) -> new BYGBoatRenderer(entityRenderDispatcher));
    }
}