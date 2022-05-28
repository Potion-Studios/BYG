package potionstudios.byg.datagen.util;

import net.minecraft.tags.Tag;
import potionstudios.byg.mixin.access.TagBuilderAccess;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatagenUtils {

    public static void sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(Map<?, Tag.Builder> tags) {
        for (Tag.Builder value : tags.values()) {
            List<Tag.BuilderEntry> builderEntries = ((TagBuilderAccess) value).byg_getEntries();

            Set<Tag.BuilderEntry> noDuplicates = new HashSet<>(builderEntries);
            builderEntries.clear();
            builderEntries.addAll(noDuplicates);
            builderEntries.sort(Comparator.comparing(builderEntry -> builderEntry.entry().toString()));
        }
    }

}
