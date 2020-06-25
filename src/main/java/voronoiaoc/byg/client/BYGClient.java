package voronoiaoc.byg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.client.textures.BYGColorManager;
import voronoiaoc.byg.client.textures.renders.BYGBlockRenders;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;
import voronoiaoc.byg.common.entity.boat.BYGBoatRenderer;

@Environment(EnvType.CLIENT)
public class BYGClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BYGBlockRenders.renderCutOuts();
        BYGColorManager.addColors();
        EntityRendererRegistry.INSTANCE.register((EntityType<? extends BYGBoatEntity>)BYG.BYGBOAT, (entityRenderDispatcher, context) -> new BYGBoatRenderer(entityRenderDispatcher));
    }
}
