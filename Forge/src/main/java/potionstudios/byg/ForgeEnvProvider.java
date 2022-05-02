package potionstudios.byg;

import com.google.auto.service.AutoService;

@AutoService(EnvironmentProvider.class)
public class ForgeEnvProvider implements EnvironmentProvider {
    @Override
    public Environment getEnvironment() {
        return Environment.FORGE;
    }
}
