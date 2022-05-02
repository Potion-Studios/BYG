package potionstudios.byg;

import net.minecraft.Util;
import org.apache.commons.compress.utils.Lists;
import potionstudios.byg.registration.BygRegistrationProvider;

import java.util.ServiceLoader;

public interface EnvironmentProvider {

    EnvironmentProvider INSTANCE = Util.make(() -> {
        final var loader = ServiceLoader.load(EnvironmentProvider.class);
        final var providers = Lists.newArrayList(loader.iterator());
        if (providers.isEmpty()) {
            throw new RuntimeException("No EnvironmentProvider was found on the classpath!");
        } else if (providers.size() > 1) {
            throw new RuntimeException("More than one EnvironmentProvider was found on the classpath!");
        }
        return providers.get(0);
    });

    Environment getEnvironment();

    enum Environment {
        FORGE,
        FABRIC;
    }

}
