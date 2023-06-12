package potionstudios.byg.common;

import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.util.MultiTag;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@SuppressWarnings("all")
@ParametersAreNonnullByDefault
public enum BYGTags {
    LOGS("logs", "logs", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),
    LOGS_THAT_BURN("logs_that_burn", "logs_that_burn", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),
    LEAVES("leaves", "leaves", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),

    SLABS("slabs", "slabs", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),
    STAIRS("stairs", "stairs", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),
    SAPLINGS("saplings", "saplings", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),
    CAMPFIRES("campfires", "campfires", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),
    BUTTONS("buttons", "buttons", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),
    SCAFFOLDING("scaffolding", null, "scaffoldings", "scaffoldings", RegistryType.BLOCKS, RegistryType.ITEMS),
    SAND("sand", "sand", "sand", "sand", RegistryType.BLOCKS, RegistryType.ITEMS),
    ICE("ice", "ice", null, null, RegistryType.BLOCKS, RegistryType.ITEMS),

    ORES("ores", null, "ores", "ores", RegistryType.ITEMS, RegistryType.BLOCKS),
    BOOKSHELVES("bookshelves", null, "bookshelves", "bookshelves", RegistryType.ITEMS, RegistryType.BLOCKS),
    STICKS("sticks", null, "rods/wooden", "wooden_rods", RegistryType.ITEMS),
    SHEARS("shears", null, "shears", "shears", RegistryType.ITEMS),

    BOATS("boats", null, "boats", "boats", RegistryType.ENTITY_TYPES);

    @Nonnull
    private final MultiTag byg;
    @Nonnull
    private final MultiTag all;
    @Nullable
    private final MultiTag forge;
    @Nullable
    private final MultiTag fabric;
    @Nullable
    private final MultiTag minecraft;
    public final Collection<RegistryType<?>> acceptedTypes;

    BYGTags(String byg, @Nullable String vanilla, @Nullable String forge, @Nullable String fabric, RegistryType<?>... acceptedTypes) {
        this.byg = MultiTag.create(BYG.createLocation(byg));
        this.all = MultiTag.create(BYG.createLocation("all/" + byg));
        this.forge = forge != null ? MultiTag.create(new ResourceLocation("forge", forge)) : null;
        this.fabric = fabric != null ? MultiTag.create(new ResourceLocation("c", fabric)) : null;
        this.minecraft = vanilla != null ? MultiTag.create(new ResourceLocation(vanilla)) : null;
        this.acceptedTypes = acceptedTypes.length == 0 ? RegistryType.REGISTRY.values() : List.of(acceptedTypes);
    }

    @Nullable
    public <T> TagKey<T> forge(RegistryType<T> registry) {
        return forge == null ? null : forge.get(registry.registry);
    }
    @Nullable
    public <T> TagKey<T> fabric(RegistryType<T> registry) {
        return fabric == null ? null : fabric.get(registry.registry);
    }
    @Nullable
    public <T> TagKey<T> minecraft(RegistryType<T> registry) {
        return minecraft == null ? null : minecraft.get(registry.registry);
    }
    @Nonnull
    public <T> TagKey<T> byg(RegistryType<T> registry) {
        return byg.get(registry.registry);
    }
    @Nonnull
    public <T> TagKey<T> all(RegistryType<T> registry) {
        return all.get(registry.registry);
    }

    @SuppressWarnings("ClassCanBeRecord")
    public static final class RegistryType<T> {
        public static final Map<ResourceKey<?>, RegistryType<?>> REGISTRY = new HashMap<>();

        public static final RegistryType<Block> BLOCKS = new RegistryType<>(Registries.BLOCK);
        public static final RegistryType<Item> ITEMS = new RegistryType<>(Registries.ITEM);
        public static final RegistryType<EntityType<?>> ENTITY_TYPES = new RegistryType<>(Registries.ENTITY_TYPE);

        public final ResourceKey<? extends Registry<T>> registry;

        private RegistryType(ResourceKey<? extends Registry<T>> registry) {
            this.registry = registry;
            REGISTRY.put(registry, this);
        }

        public Optional<HolderSet.Named<T>> getTag(TagKey<?> key) {
            final var registry = (Registry<T>) get(BuiltInRegistries.REGISTRY, this.registry);
            return registry.getTag((TagKey<T>) key);
        }

        private static <T> T get(Registry<T> registry, ResourceKey<?> key) {
            return registry.get((ResourceKey<T>) key);
        }
    }
}
