package potionstudios.byg.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class MultiTag {
    private final ResourceLocation name;
    private final Map<ResourceKey<? extends Registry<?>>, TagKey<?>> byRegistry = new HashMap<>();

    public static MultiTag create(ResourceLocation name) {
        return new MultiTag(name);
    }

    public MultiTag(ResourceLocation name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    public <T> TagKey<T> get(ResourceKey<? extends Registry<T>> type) {
        return (TagKey<T>) byRegistry.computeIfAbsent(type, k -> TagKey.create(type, name));
    }

    public TagKey<Item> item() {
        return get(Registry.ITEM_REGISTRY);
    }
    public TagKey<Block> block() {
        return get(Registry.BLOCK_REGISTRY);
    }
}
