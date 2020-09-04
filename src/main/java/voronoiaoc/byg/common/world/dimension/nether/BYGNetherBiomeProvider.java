package voronoiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.StructureFeature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.newbiome.layer.Layer;

public class BYGNetherBiomeProvider extends BiomeSource {
    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeProvider::new)));


    private final Layer biomeLayer;
    private final long seed;
    public static Registry<Biome> biomeRegistry; // Should always be Dynamic Registry


    public BYGNetherBiomeProvider(Registry<Biome> registry, long seed) {
        super(biomeIdList.stream().map(registry::get).collect(Collectors.toList()));
        this.seed = seed;
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(seed);
        biomeRegistry = registry;
    }

    @Override
    public Biome getNoiseBiome(int biomeX, int biomeY, int biomeZ) {
        //TODO: REIMPLEMENT BIOME LAYERS
        return biomeLayer.get(biomeRegistry, biomeX, biomeZ);
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGNetherBiomeProvider(biomeRegistry, seed);
    }

    public static List<ResourceLocation> biomeIdList = new ArrayList<>();

    public static void addNetherBiomesForProvider() {
        biomeIdList.add(new ResourceLocation("byg:sythian_torrids"));
    }


    @Override
    public List<Biome> possibleBiomes() {
        return biomeIdList.stream().map(biomeRegistry::get).collect(Collectors.toList());
    }

    @Override
    public boolean canGenerateStructure(StructureFeature<?> structureFeature) {
        return this.supportedStructures.computeIfAbsent(structureFeature,
                (structureFeaturex) -> biomeIdList.stream().map(biomeRegistry::get).collect(Collectors.toList()).stream()
                        .anyMatch((biome) -> biome.getGenerationSettings().isValidStart(structureFeaturex)));
    }

    @Override
    public Set<BlockState> getSurfaceBlocks() {
        if (this.surfaceBlocks.isEmpty()) {

            for (Biome biome : biomeIdList.stream().map(biomeRegistry::get).collect(Collectors.toList())) {
                this.surfaceBlocks.add(biome.getGenerationSettings().getSurfaceBuilderConfig().getTopMaterial());
            }
        }

        return this.surfaceBlocks;
    }
}
