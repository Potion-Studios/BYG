package potionstudios.byg.datagen.util;

import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagEntry;
import potionstudios.byg.mixin.dev.TagBuilderAccess;

import java.util.*;

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

}
