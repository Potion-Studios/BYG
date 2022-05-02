package potionstudios.byg;

import com.google.auto.service.AutoService;

@AutoService(EnvironmentProvider.class)
public class FabricEnvProvider implements EnvironmentProvider {
    @Override
    public Environment getEnvironment() {
        return Environment.FABRIC;
    }
}
