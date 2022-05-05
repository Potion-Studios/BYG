package potionstudios.byg.client;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.screen.HypogealImperiumScreen;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;
import potionstudios.byg.common.container.BYGMenuTypes;
import potionstudios.byg.common.particles.FallingLeafParticle;
import potionstudios.byg.common.particles.TheriumGlint;
import potionstudios.byg.mixin.access.client.MenuScreensAccess;
import potionstudios.byg.util.LangFileGenerator;

import java.nio.file.Paths;

public class BYGClient {

    public static void load() {
        BYG.LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BiomepediaClientData.getConfig(true);
        if (BYG.GENERATE_DATA) {
            LangFileGenerator.createLangFile(Paths.get("generated/en_us.json"));
        }

//        EntityRendererRegistry.register(BYGEntities.MAN_O_WAR, ManOWarRenderer::new);
        BYG.LOGGER.info("BYG: \"Client Setup\" Event Complete!");
    }

    public static void threadSafeLoad() {
        MenuScreensAccess.byg_register(BYGMenuTypes.HYPOGEAL_CONTAINER.get(), HypogealImperiumScreen::new);
    }

    public static void registerParticles(ParticleStrategy strategy) {
        strategy.register(BYGParticleTypes.THERIUM_GLINT.get(), TheriumGlint.Provider::new);
        strategy.register(BYGParticleTypes.WITCH_HAZEL_LEAF.get(), FallingLeafParticle.Provider::new);
        strategy.register(BYGParticleTypes.CHERRY_BLOSSOM_FALL_WHITE.get(), FallingLeafParticle.Provider::new);
        strategy.register(BYGParticleTypes.CHERRY_BLOSSOM_FALL_PINK.get(), FallingLeafParticle.Provider::new);
    }

    public interface ParticleStrategy {
        <T extends ParticleOptions> void register(ParticleType<T> particle, ParticleEngine.SpriteParticleRegistration<T> provider);
    }
}
