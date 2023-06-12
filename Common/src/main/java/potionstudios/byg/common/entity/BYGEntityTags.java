package potionstudios.byg.common.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import potionstudios.byg.BYG;

public class BYGEntityTags {

    public static final TagKey<EntityType<?>> NOT_HURT_BY_QUARTZ_CRYSTALS = createTag("not_hurt_by_quartz_crystals");

    private static TagKey<EntityType<?>> createTag(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, BYG.createLocation(path));
    }
}
