package potionstudios.byg.datagen.providers.tag;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.datagen.util.DatagenUtils;
import potionstudios.byg.reg.RegistryObject;

public class BYGBiomeTagsProvider extends BiomeTagsProvider {
    public BYGBiomeTagsProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        BYGBiomes.BIOMES_BY_TAG.asMap()
                .forEach((tag, ros) -> {
                    this.tag(tag).add(ros.stream().map(RegistryObject::get).toArray(Biome[]::new));
//                    BYGBiomeTags.BYG_BIOME_TAGS_TO_TAGS.get().forEach((bygBiomeTag, delegates) -> {
//                        if (BuiltinRegistries.BIOME.getTag(bygBiomeTag).isPresent()) {
//                            for (TagKey<Biome> tagKey : delegates) {
//                                this.tag(tagKey).addTag(bygBiomeTag);
//                            }
//                        }
//                    });
                });
        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }
}
