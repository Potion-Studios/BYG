package voronoiaoc.byg.mixin.common.server;

import com.google.common.base.MoreObjects;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.common.world.worldtype116.BYGBiomeProvider116;

import java.util.Properties;
import java.util.Random;

/**
 * Credit: SuperCoder79 - Simplex Terrain
 */


@Mixin(DimensionGeneratorSettings.class)
public class MixinDimensionGenSettings {

    @Inject(at = @At("HEAD"), method = "func_236219_a_(Ljava/util/Properties;)Lnet/minecraft/world/gen/settings/DimensionGeneratorSettings;", cancellable = true)
    private static void yeet(Properties properties, CallbackInfoReturnable<DimensionGeneratorSettings> cir) {
        if (properties.get("level-type") == null) {
            return;
        }

        if (properties.get("level-type").toString().trim().toLowerCase().equals("byg")) {
            String seed = (String) MoreObjects.firstNonNull(properties.get("level-seed"), "");
            long l = new Random().nextLong();
            if (!seed.isEmpty()) {
                try {
                    long m = Long.parseLong(seed);
                    if (m != 0L) {
                        l = m;
                    }
                } catch (NumberFormatException var14) {
                    l = seed.hashCode();
                }
            }

            SimpleRegistry<Dimension> dimensions = DimensionType.func_236022_a_(l);

            String generate_structures = (String)properties.get("generate-structures");
            boolean generateStructures = generate_structures == null || Boolean.parseBoolean(generate_structures);
            cir.setReturnValue(new DimensionGeneratorSettings(l, generateStructures, false, DimensionGeneratorSettings.func_236216_a_(dimensions, new NoiseChunkGenerator(new BYGBiomeProvider116(l), l, DimensionSettings.Preset.field_236122_b_.func_236137_b_()))));
        }
    }
}