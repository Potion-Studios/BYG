package potionstudios.byg.datagen.providers.tag;

import it.unimi.dsi.fastutil.Pair;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.datagen.util.DatagenUtils;

import java.util.concurrent.CompletableFuture;

import static potionstudios.byg.BYG.createLocation;

@SuppressWarnings("ALL")
public class BYGBiomeTagsProvider extends BiomeTagsProvider {
    public BYGBiomeTagsProvider(DataGenerator gen, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen.getPackOutput(), pLookupProvider, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        BYGBiomes.BIOMES_BY_TAG.asMap()
                .forEach((tag, ros) -> {
                    if (tag.location().getNamespace().equals(BYG.MOD_ID)) {
                        this.tag(tag).add(ros.stream().toArray(ResourceKey[]::new)).replace(false);
                    } else {
                        this.bygTagWrap(tag, ros.stream().toArray(ResourceKey[]::new));
                    }
                });
        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }

    public Pair<TagKey<Biome>, TagAppender<Biome>> bygTagWrap(TagKey<Biome> targetTag, ResourceKey<Biome>... values) {
        ResourceLocation targetLocation = targetTag.location();
        TagKey<Biome> bygTag = TagKey.create(Registries.BIOME, createLocation(targetLocation.getPath()));
        TagAppender<Biome> tag = tag(bygTag, values).replace(false);
        tag(targetTag).addTag(bygTag).replace(false);

        if (targetLocation.getNamespace().equals("forge")) {
            tag(TagKey.create(Registries.BIOME, new ResourceLocation("c", targetLocation.getPath()))).addTag(bygTag).replace(false);
        } else if (targetLocation.getNamespace().equals("c")) {
            tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", targetLocation.getPath()))).addTag(bygTag).replace(false);
        }

        return Pair.of(bygTag, tag);
    }

    @SafeVarargs
    @SuppressWarnings("ALL")
    private TagAppender<Biome> tag(TagKey<Biome> tag, ResourceKey<Biome>... biomes) {

        return this.tag(tag).add(biomes);
    }
}