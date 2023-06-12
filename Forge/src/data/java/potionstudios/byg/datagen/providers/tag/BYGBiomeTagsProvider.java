//package potionstudios.byg.datagen.providers.tag;
//
//import net.minecraft.core.HolderLookup;
//import net.minecraft.data.DataGenerator;
//import net.minecraft.data.tags.BiomeTagsProvider;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraftforge.common.data.ExistingFileHelper;
//import org.jetbrains.annotations.Nullable;
//import potionstudios.byg.BYG;
//import potionstudios.byg.common.world.biome.BYGBiomes;
//import potionstudios.byg.datagen.util.DatagenUtils;
//import potionstudios.byg.reg.RegistryObject;
//
//import java.util.concurrent.CompletableFuture;
//
//public class BYGBiomeTagsProvider extends BiomeTagsProvider {
//    public BYGBiomeTagsProvider(DataGenerator gen, CompletableFuture<HolderLookup.Provider> pLookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
//        super(gen.getPackOutput(), pLookupProvider, BYG.MOD_ID, existingFileHelper);
//    }
//
//    @Override
//    protected void addTags(HolderLookup.Provider pProvider) {
//        BYGBiomes.BIOMES_BY_TAG.asMap()
//                .forEach((tag, ros) -> {
//                    this.tag(tag).add(ros.stream().map(RegistryObject::getResourceKey).toArray(ResourceKey[]::new));
////                    BYGBiomeTags.BYG_BIOME_TAGS_TO_TAGS.get().forEach((bygBiomeTag, delegates) -> {
////                        if (BuiltinRegistries.BIOME.getTag(bygBiomeTag).isPresent()) {
////                            for (TagKey<Biome> tagKey : delegates) {
////                                this.tag(tagKey).addTag(bygBiomeTag);
////                            }
////                        }
////                    });
//                });
//        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
//    }
//}
