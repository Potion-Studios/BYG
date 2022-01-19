package potionstudios.byg.world.biome;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.OverworldBiomeBuilderAccess;
import terrablender.api.BiomeProvider;
import terrablender.api.ParameterUtils;
import terrablender.worldgen.TBClimate;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class BYGBiomeProvider extends BiomeProvider {
    private static int count = 0;

    private final OverworldBiomeBuilder overworldBiomeBuilder = new OverworldBiomeBuilder();
    private final Set<ResourceKey<Biome>> bygKeys = new ObjectOpenHashSet<>();
    private final Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper;

    public BYGBiomeProvider(int overworldWeight, ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes, ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes, ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] extremeHills, Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
        super(new ResourceLocation(BYG.MOD_ID,"biome_provider_" + count++), overworldWeight);
        this.swapper = swapper;

        OverworldBiomeBuilderAccess overworldBiomeBuilderAccess = (OverworldBiomeBuilderAccess) (Object) overworldBiomeBuilder;
        overworldBiomeBuilderAccess.setOCEANS(oceans);
        overworldBiomeBuilderAccess.setMIDDLE_BIOMES(middleBiomes);
        overworldBiomeBuilderAccess.setMIDDLE_BIOMES_VARIANT(middleBiomesVariant);
        overworldBiomeBuilderAccess.setPLATEAU_BIOMES(plateauBiomes);
        overworldBiomeBuilderAccess.setPLATEAU_BIOMES_VARIANT(plateauBiomesVariant);
        overworldBiomeBuilderAccess.setEXTREME_HILLS(extremeHills);
        dumpArrays((biomeResourceKey -> {
            if (biomeResourceKey.location().getNamespace().equals(BYG.MOD_ID)) {
                bygKeys.add(biomeResourceKey);
                if (swapper.containsValue(biomeResourceKey)) {
                    throw new IllegalArgumentException("Swapper cannot contain elements found in the temperature arrays.");
                }
            }
        }), middleBiomes, middleBiomesVariant, plateauBiomes, plateauBiomesVariant, extremeHills);
    }

    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper) {

        ((OverworldBiomeBuilderAccess) (Object) this.overworldBiomeBuilder).invokeAddBiomes((parameterPointResourceKeyPair -> {
            ResourceKey<Biome> biomeKey = parameterPointResourceKeyPair.getSecond();
            if (this.bygKeys.contains(biomeKey)) {
                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointResourceKeyPair.getFirst(), getUniquenessParameter()), biomeKey));
            }
            if (this.swapper.containsKey(biomeKey)) {
                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointResourceKeyPair.getFirst(), getUniquenessParameter()), this.swapper.get(biomeKey)));
            }
        }));
    }

    @SafeVarargs
    private static void dumpArrays(Consumer<ResourceKey<Biome>> biomeConsumer, ResourceKey<Biome>[][]... resourceKeys) {
        for (ResourceKey<Biome>[][] resourceKey : resourceKeys) {
            for (ResourceKey<Biome>[] keys : resourceKey) {
                for (ResourceKey<Biome> key : keys) {
                    biomeConsumer.accept(key);
                }
            }
        }
    }
}
