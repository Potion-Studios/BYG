package potionstudios.byg.world;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomes;
import terrablender.api.BiomeProvider;
import terrablender.worldgen.TBClimate;

import java.util.function.Consumer;

public class BYGBiomeProvider extends BiomeProvider {
    public static final ResourceLocation LOCATION = new ResourceLocation(BYG.MOD_ID, "provider");

    public BYGBiomeProvider(ResourceLocation name) {
        super(name, 10);
    }

    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(Biomes.PLAINS, BYGBiomes.ALLIUM_FIELDS);
        });
    }
}
