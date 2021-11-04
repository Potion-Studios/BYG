package corgiaoc.byg.common.entity.manowar;

import com.google.common.collect.Maps;
import corgiaoc.byg.BYG;
import net.minecraft.Util;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class ManOWarRenderer<T extends ManOWar> extends GeoEntityRenderer<T> {

    public static final Map<ManOWar.Colors, ResourceLocation> TEXTURES = Util.make(Maps.newEnumMap(ManOWar.Colors.class), (map) -> {
        map.put(ManOWar.Colors.MAGENTA, new ResourceLocation(BYG.MOD_ID, "textures/entity/manowar/magenta.png"));
        map.put(ManOWar.Colors.RAINBOW, new ResourceLocation(BYG.MOD_ID, "textures/entity/manowar/rainbow.png"));
        map.put(ManOWar.Colors.PURPLE, new ResourceLocation(BYG.MOD_ID, "textures/entity/manowar/purple.png"));
        map.put(ManOWar.Colors.BLUE, new ResourceLocation(BYG.MOD_ID, "textures/entity/manowar/blue.png"));

    });

    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(BYG.MOD_ID, "man_o_war"), "main");

    public ManOWarRenderer(EntityRendererProvider.Context context) {
        super(context, new ManOWarModel());
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURES.get(entity.getColor());
    }
}
