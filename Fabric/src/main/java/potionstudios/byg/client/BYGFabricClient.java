package potionstudios.byg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.level.block.state.properties.WoodType;
import potionstudios.byg.BYGFabric;
import potionstudios.byg.client.textures.renders.BYGRenderTypes;
import potionstudios.byg.mixin.access.client.ItemBlockRenderTypeAccess;
import potionstudios.byg.mixin.client.access.AccessEntityRenderers;
import potionstudios.byg.network.NetworkUtil;

import java.util.Map;

public class BYGFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(NetworkUtil.SPAWN_PACKET_ID, (client, listener, buf, responseSender) -> {
            buf.retain();
            NetworkUtil.receiveSpawnPacket(client, buf);
        });

        BYGClient.load();
        BYGClient.threadSafeLoad();
        BYGRenderTypes.renderTypes(blockRenderTypeMap -> ItemBlockRenderTypeAccess.byg_getTYPE_BY_BLOCK().putAll(blockRenderTypeMap));

        BYGEntityRenderers.register(AccessEntityRenderers::byg_register);

        BYGClient.registerParticles(new BYGClient.ParticleStrategy() {
            @Override
            public <T extends ParticleOptions> void register(ParticleType<T> particle, ParticleEngine.SpriteParticleRegistration<T> provider) {
                ParticleFactoryRegistry.getInstance().register(particle, provider::create);
            }
        });
        BYGFabric.afterRegistriesFreeze();
    }
}