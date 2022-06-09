package potionstudios.byg.datagen.util;

import net.minecraft.core.Registry;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.common.BYGTags;
import potionstudios.byg.mixin.dev.TagBuilderAccess;

import java.util.*;
import java.util.function.Function;

public class DatagenUtils {

    public static void sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(Map<?, TagBuilder> tags) {
        for (TagBuilder value : tags.values()) {
            List<TagEntry> builderEntries = ((TagBuilderAccess) value).getEntries();

            Set<TagEntry> noDuplicates = new HashSet<>(builderEntries);
            builderEntries.clear();
            builderEntries.addAll(noDuplicates);
            builderEntries.sort(Comparator.comparing(TagEntry::toString));
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> void addBYGTag(Function<TagKey<T>, TagsProvider.TagAppender<T>> function, BYGTags tag, ResourceKey<? extends Registry<T>> registryKey) {
        final var registry = (BYGTags.RegistryType<T>) BYGTags.RegistryType.REGISTRY.get(registryKey);
        if (tag.acceptedTypes.contains(registry)) {
            maybeAddTag(function, false, tag.forge(registry), tag.byg(registry));
            maybeAddTag(function, false, tag.fabric(registry), tag.byg(registry));
            maybeAddTag(function, false, tag.minecraft(registry), tag.byg(registry));
            final var mcTag = tag.minecraft(registry);
            // So, there's an MC tag, which means it's guaranteed to have the BYG tag:
            final var allMainTag = Objects.requireNonNullElseGet(mcTag, () -> tag.byg(registry));
            maybeAddTags(function, tag.all(registry), allMainTag, tag.fabric(registry), tag.forge(registry));
        }
    }

    public static <T> void maybeAddTag(Function<TagKey<T>, TagsProvider.TagAppender<T>> function, boolean optional, @Nullable TagKey<T> primary, @Nullable TagKey<T> toAdd) {
        if (primary != null) {
            final var tag = function.apply(primary);
            if (toAdd != null)
                if (optional)
                    tag.addOptionalTag(toAdd.location());
                else
                    tag.addTag(toAdd);
        }
    }

    @SafeVarargs
    public static <T> void maybeAddTags(Function<TagKey<T>, TagsProvider.TagAppender<T>> function, @Nullable TagKey<T> primary, TagKey<T>... toAdd) {
        if (primary != null) {
            final var tag = function.apply(primary);
            for (final var sub : toAdd) {
                if (sub != null)
                    tag.addOptionalTag(sub.location());
            }
        }
    }

}
