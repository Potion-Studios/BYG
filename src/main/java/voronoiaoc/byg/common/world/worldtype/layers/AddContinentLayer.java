package voronoiaoc.byg.common.world.worldtype.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
import voronoiaoc.byg.common.world.worldtype.BYGBiomeLayers;
import voronoiaoc.byg.common.world.worldtype.layers.traits.mergelayerswmanager.InitMerge1;
import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;

@SuppressWarnings("deprecation")
public class AddContinentLayer extends InitMerge1 implements IDimOffset1Transformer {

    public static final int PLAINS = Registry.BIOME.getId(Biomes.PLAINS);
    public static final int OCEAN = Registry.BIOME.getId(Biomes.OCEAN);

    static int continentChance = BYGBiomeLayers.continentChance;

    public AddContinentLayer(BiomeGroupManager manager) {
        super(manager);
    }


    @Override
    public int apply(INoiseRandom context, IArea iArea, int x, int z) {
        if (x == 0 & z == 0) {
           return PLAINS;
        }

        int area1Value = iArea.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z + 1));

        if (context.random(continentChance) == 0) {
            int l = area1Value;
            if (area1Value == OCEAN) {
                l = PLAINS;
            }

            if (l != area1Value) {
                int i1 = 0;
                if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z)), area1Value)) {
                    ++i1;
                }

                if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getOffsetX(x + 2), this.getOffsetZ(z + 1)), area1Value)) {
                    ++i1;
                }

                if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getOffsetX(x + 0), this.getOffsetZ(z + 1)), area1Value)) {
                    ++i1;
                }

                if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z + 2)), area1Value)) {
                    ++i1;
                }

                if (i1 >= 3) {
                    return l;
                }
            }
        }
        return area1Value;
    }
}
