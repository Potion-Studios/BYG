package voronoiaoc.byg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import voronoiaoc.byg.client.textures.BYGColorManager;
import voronoiaoc.byg.client.textures.renders.BYGBlockRenders;

@Environment(EnvType.CLIENT)
public class BYGClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BYGBlockRenders.renderCutOuts();
        BYGColorManager.addColors();
//        EntityRendererRegistry.INSTANCE.register((EntityType<? extends BYGBoatEntity>)BYG.BYGBOAT, (entityRenderDispatcher, context) -> new BYGBoatRenderer(entityRenderDispatcher));
    }
}
