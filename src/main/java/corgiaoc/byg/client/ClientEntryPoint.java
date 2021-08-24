package corgiaoc.byg.client;

import corgiaoc.byg.BYG;
import net.fabricmc.api.ClientModInitializer;

public class ClientEntryPoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BYG.clientLoad();
    }
}
