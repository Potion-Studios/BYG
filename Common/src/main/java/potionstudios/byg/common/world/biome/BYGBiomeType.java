package potionstudios.byg.common.world.biome;

import net.minecraft.core.Registry;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.reg.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public enum BYGBiomeType {
    BEACH(BiomeTags.IS_BEACH),
    ICY("is_icy"),
    SNOWY("is_snowy"),
    SANDY("is_sandy"),
    DEEP_OCEAN(BiomeTags.IS_DEEP_OCEAN),
    OCEAN("is_ocean"),
    SPOOKY("is_spooky"),
    SWAMP("is_swamp"),
    WASTELAND("is_wasteland"),
    DEAD("is_dead"),
    BADLANDS("is_badlands");

    private final TagKey<Biome> tag;
    private final List<RegistryObject<Biome>> biomes = new ArrayList<>();

    BYGBiomeType(TagKey<Biome> tag) {
        this.tag = tag;
    }

    BYGBiomeType(String tag) {
        this(TagKey.create(Registry.BIOME_REGISTRY, BYG.createLocation(tag)));
    }

    public void add(RegistryObject<Biome> biome) {
        this.biomes.add(biome);
    }

    public TagKey<Biome> tag() {
        return tag;
    }

    public Stream<Biome> getBiomes() {
        return biomes.stream().map(RegistryObject::get);
    }
}
