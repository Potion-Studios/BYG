package potionstudios.byg.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import potionstudios.byg.BYG;

import java.util.Locale;

public interface BYGAdditionalData {

    default void writeBYG(CompoundTag tag) {
        tag.put(BYG.MOD_ID.toLowerCase(Locale.ROOT), write());
    }

    default void readBYG(CompoundTag tag) {
        String tagLocation = BYG.MOD_ID.toLowerCase(Locale.ROOT);
        if (tag.contains(tagLocation, Tag.TAG_COMPOUND)) {
            read(tag.getCompound(tagLocation));
        }
    }

    Tag write();

    void read(CompoundTag tag);
}