package voronoiaoc.byg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import voronoiaoc.byg.client.registries.BYGClientNetworkRegistry;
import voronoiaoc.byg.client.textures.BYGColorManager;
import voronoiaoc.byg.client.textures.renders.BYGBlockRenders;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;
import voronoiaoc.byg.common.entity.boat.BYGBoatRenderer;
import voronoiaoc.byg.core.byglists.BYGEntityList;

@Environment(EnvType.CLIENT)
public class BYGClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BYGBlockRenders.renderCutOuts();
        BYGColorManager.addColors();
        BYGClientNetworkRegistry.registerPackets();
        EntityRendererRegistry.INSTANCE.register(BYGEntityList.BYGBOAT, (entityRenderDispatcher, context) -> new BYGBoatRenderer(entityRenderDispatcher));

    }
}
