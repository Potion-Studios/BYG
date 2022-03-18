package potionstudios.byg.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import potionstudios.byg.BYG;

public interface BYGAdditionalData {

    default void writeBYG(CompoundTag tag) {
        tag.put(BYG.MOD_ID.toLowerCase(), write());
    }

    default void readBYG(CompoundTag tag) {
        String tagLocation = BYG.MOD_ID.toLowerCase();
        if (tag.contains(tagLocation, Tag.TAG_COMPOUND)) {
            read(tag.getCompound(tagLocation));
        }
    }

    Tag write();

    void read(CompoundTag tag);
}