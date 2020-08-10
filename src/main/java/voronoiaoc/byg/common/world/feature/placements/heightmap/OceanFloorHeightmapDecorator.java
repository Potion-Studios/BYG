package voronoiaoc.byg.common.world.feature.placements.heightmap;

import com.mojang.serialization.Codec;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.*;
import voronoiaoc.byg.common.biomes.BiomeHelper;

public class OceanFloorHeightmapDecorator<DC extends DecoratorConfig> extends HeightmapDecorator<DC> {
   static final Decorator<NopeDecoratorConfig> HEIGHTMAP_OCEAN_FLOOR = BiomeHelper.newDecorator("heightmap_world_surface", new HeightmapWorldSurfaceDecorator(NopeDecoratorConfig.CODEC));
   public static final ConfiguredDecorator<NopeDecoratorConfig> CONFIGURED_OCEAN_FLOOR_HEIGHTMAP = HEIGHTMAP_OCEAN_FLOOR.configure(DecoratorConfig.DEFAULT);


   public OceanFloorHeightmapDecorator(Codec<DC> codec) {
      super(codec);
   }

   protected Heightmap.Type getHeightmapType(DC config) {
      return Heightmap.Type.OCEAN_FLOOR_WG;
   }
}
