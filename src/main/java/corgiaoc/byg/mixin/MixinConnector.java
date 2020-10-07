package corgiaoc.byg.mixin;

import corgiaoc.byg.BYG;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class MixinConnector implements IMixinConnector {

    @Override
    public void connect() {
        BYG.LOGGER.debug("BYG: Connecting Mixin...");
        Mixins.addConfiguration("byg.mixins.json");
        BYG.isUsingMixin = true;
        BYG.LOGGER.info("BYG: Mixin Connected!");
    }
}