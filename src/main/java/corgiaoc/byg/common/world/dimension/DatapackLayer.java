package corgiaoc.byg.common.world.dimension;

import corgiaoc.byg.BYG;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;

public class DatapackLayer {

    private final LazyArea lazyArea;

    public DatapackLayer(IAreaFactory<LazyArea> lazyAreaFactoryIn) {
        this.lazyArea = lazyAreaFactoryIn.make();
    }

    static int stopLoggerSpamNether = 0;
    static int stopLoggerSpamEnd = 0;
    static int stopLoggerSpamVoid = 0;

    public Biome sampleNether(Registry<Biome> registry, int x, int z) {
        int biomeID = this.lazyArea.getValue(x, z);
        Biome biome = registry.getByValue(biomeID);
        if (biome == null) {
            if (SharedConstants.developmentMode) {
                throw Util.pauseDevMode(new IllegalStateException("Unknown biome id: " + biomeID));
            } else {
                if (stopLoggerSpamNether <= 50) {
                    BYG.LOGGER.warn("BYG's Nether Layer: Unknown biome id: " + biomeID);
                    stopLoggerSpamNether++;
                }
                return registry.getValueForKey(BiomeRegistry.getKeyFromID(8));
            }
        } else {
            return biome;
        }
    }


    public Biome sampleEnd(Registry<Biome> registry, int x, int z) {
        int biomeID = this.lazyArea.getValue(x, z);
        Biome biome = registry.getByValue(biomeID);
        if (biome == null) {
            if (SharedConstants.developmentMode) {
                throw Util.pauseDevMode(new IllegalStateException("Unknown biome id: " + biomeID));
            } else {
                if (stopLoggerSpamEnd <= 50) {
                    BYG.LOGGER.warn("BYG's End Layer: Unknown biome id: " + biomeID);
                    stopLoggerSpamEnd++;
                }
                return registry.getValueForKey(BiomeRegistry.getKeyFromID(43));
            }
        } else {
            return biome;
        }
    }

    public Biome sampleEndVoid(Registry<Biome> registry, int x, int z) {
        int biomeID = this.lazyArea.getValue(x, z);
        Biome biome = registry.getByValue(biomeID);
        if (biome == null) {
            if (SharedConstants.developmentMode) {
                throw Util.pauseDevMode(new IllegalStateException("Unknown biome id: " + biomeID));
            } else {
                if (stopLoggerSpamVoid <= 50) {
                    BYG.LOGGER.warn("BYG's End Void Layer: Unknown biome id: " + biomeID);
                    stopLoggerSpamVoid++;
                }
                return registry.getValueForKey(BiomeRegistry.getKeyFromID(40));
            }
        } else {
            return biome;
        }
    }
}
