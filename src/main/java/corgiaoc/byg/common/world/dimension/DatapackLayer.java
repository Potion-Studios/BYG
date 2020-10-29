package corgiaoc.byg.common.world.dimension;

import corgiaoc.byg.BYG;
import net.minecraft.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.biome.layer.util.CachingLayerSampler;
import net.minecraft.world.biome.layer.util.LayerFactory;

public class DatapackLayer {

    private final CachingLayerSampler lazyArea;

    public DatapackLayer(LayerFactory<CachingLayerSampler> lazyAreaFactoryIn) {
        this.lazyArea = lazyAreaFactoryIn.make();
    }

    static int stopLoggerSpamNether = 0;
    static int stopLoggerSpamEnd = 0;
    static int stopLoggerSpamVoid = 0;

    public Biome sampleNether(Registry<Biome> registry, int x, int z) {
        int biomeID = this.lazyArea.sample(x, z);
        Biome biome = registry.get(biomeID);
        if (biome == null) {
            if (SharedConstants.isDevelopment) {
                throw Util.throwOrPause(new IllegalStateException("Unknown biome id: " + biomeID));
            } else {
                if (stopLoggerSpamNether <= 50) {
                    BYG.LOGGER.warn("BYG's Nether Layer: Unknown biome id: " + biomeID);
                    stopLoggerSpamNether++;
                }
                return registry.get(BuiltinBiomes.fromRawId(8));
            }
        } else {
            return biome;
        }
    }



    public Biome sampleEnd(Registry<Biome> registry, int x, int z) {
        int biomeID = this.lazyArea.sample(x, z);
        Biome biome = registry.get(biomeID);
        if (biome == null) {
            if (SharedConstants.isDevelopment) {
                throw Util.throwOrPause(new IllegalStateException("Unknown biome id: " + biomeID));
            } else {
                if (stopLoggerSpamEnd <= 50) {
                    BYG.LOGGER.warn("BYG's End Layer: Unknown biome id: " + biomeID);
                    stopLoggerSpamEnd++;
                }
                return registry.get(BuiltinBiomes.fromRawId(43));
            }
        } else {
            return biome;
        }
    }

    public Biome sampleEndVoid(Registry<Biome> registry, int x, int z) {
        int biomeID = this.lazyArea.sample(x, z);
        Biome biome = registry.get(biomeID);
        if (biome == null) {
            if (SharedConstants.isDevelopment) {
                throw Util.throwOrPause(new IllegalStateException("Unknown biome id: " + biomeID));
            } else {
                if (stopLoggerSpamVoid <= 50) {
                    BYG.LOGGER.warn("BYG's End Void Layer: Unknown biome id: " + biomeID);
                    stopLoggerSpamVoid++;
                }
                return registry.get(BuiltinBiomes.fromRawId(40));
            }
        } else {
            return biome;
        }
    }
}
