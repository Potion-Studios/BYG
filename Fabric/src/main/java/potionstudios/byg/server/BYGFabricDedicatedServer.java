package potionstudios.byg.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import potionstudios.byg.BYGFabric;

public class BYGFabricDedicatedServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        BYGFabric.afterRegistriesFreeze();
    }
}