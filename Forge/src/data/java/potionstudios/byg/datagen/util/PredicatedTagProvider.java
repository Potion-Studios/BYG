package potionstudios.byg.datagen.util;

import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicatedTagProvider<T> {
    private final RegistrationProvider<T> provider;
    private final List<InstanceInfo<T>> instancePredicates = new ArrayList<>();
    private final List<NamingInfo<T>> namingPredicates = new ArrayList<>();

    public PredicatedTagProvider(RegistrationProvider<T> provider) {
        this.provider = provider;
    }

    public PredicatedTagProvider<T> forInstance(Class<?> clazz, TagKey<T> tag) {
        this.instancePredicates.add(new InstanceInfo<>(clazz::isInstance, tag));
        return this;
    }

    public PredicatedTagProvider<T> checkRegistryName(Predicate<String> namePredicate, TagKey<T> tag) {
        return add(obj -> namePredicate.test(Objects.requireNonNull(obj.location().getPath())), tag);
    }

    public PredicatedTagProvider<T> add(Predicate<? super ResourceKey<T>> predicate, TagKey<T> tag) {
        this.namingPredicates.add(new NamingInfo<>(predicate, tag));
        return this;
    }

    public void run(Function<TagKey<T>, TagsProvider.TagAppender<T>> function) {
        this.provider.getEntries().stream()
                .forEach(obj -> {
                    namingPredicates.forEach(info -> {
                        if (info.predicate.test(obj.getResourceKey()))
                            function.apply(info.tag()).add(obj.getResourceKey());
                    });
                    instancePredicates.forEach(info -> {
                        if (info.predicate.test(obj.get()))
                            function.apply(info.tag()).add(obj.getResourceKey());
                    });
                });
    }

    private record InstanceInfo<T>(Predicate<T> predicate, TagKey<T> tag) {}
    private record NamingInfo<T>(Predicate<? super ResourceKey<T>> predicate, TagKey<T> tag) {}
}
