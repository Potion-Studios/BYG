package voronoiaoc.byg.mixin.common.server;

import com.google.common.base.MoreObjects;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.worldtype116.BYGBiomeProvider116;

import java.util.*;

@Mixin(DimensionGeneratorSettings.class)
public class MixinDimensionGenSettings {

    @Final
    @Shadow private static Logger field_236203_c_;

    @Inject(at = @At("HEAD"), method = "func_236219_a_(Ljava/util/Properties;)Lnet/minecraft/world/gen/settings/DimensionGeneratorSettings;", cancellable = true)
    private static void yeet(Properties p_236219_0_, CallbackInfoReturnable<DimensionGeneratorSettings> cir) {
        String s = MoreObjects.firstNonNull((String) p_236219_0_.get("generator-settings"), "");
        p_236219_0_.put("generator-settings", s);
        String s1 = MoreObjects.firstNonNull((String) p_236219_0_.get("level-seed"), "");
        p_236219_0_.put("level-seed", s1);
        String s2 = (String) p_236219_0_.get("generate-structures");
        boolean flag = s2 == null || Boolean.parseBoolean(s2);
        p_236219_0_.put("generate-structures", Objects.toString(flag));
        String s3 = (String) p_236219_0_.get("level-type");
        String s4 = Optional.ofNullable(s3).map((p_236217_0_) -> p_236217_0_.toLowerCase(Locale.ROOT)).orElse("default");
        p_236219_0_.put("level-type", s4);
        long i = (new Random()).nextLong();
        if (!s1.isEmpty()) {
            try {
                long j = Long.parseLong(s1);
                if (j != 0L) {
                    i = j;
                }
            } catch (NumberFormatException numberformatexception) {
                i = s1.hashCode();
            }
        }

        SimpleRegistry<Dimension> simpleregistry = DimensionType.func_236022_a_(i);
        byte b0 = -1;

        switch (s4.hashCode()) {
            case -1100099890:
                if (s4.equals("largebiomes")) {
                    b0 = 3;
                }
                break;
            case 3145593:
                if (s4.equals("flat")) {
                    b0 = 0;
                }
                break;
            case 1045526590:
                if (s4.equals("debug_all_block_states")) {
                    b0 = 1;
                }
                break;
            case 1271599715:
                if (s4.equals("amplified")) {
                    b0 = 2;
                }
                break;
            case 98032:
                if (s4.equals("byg")) {
                    b0 = 4;
                    BYG.LOGGER.info("LOADING BYG WORLD FOR SERVER!");
                }
        }

        switch (b0) {
            case 0:
                JsonObject jsonobject = !s.isEmpty() ? JSONUtils.fromJson(s) : new JsonObject();
                Dynamic<JsonElement> dynamic = new Dynamic<>(JsonOps.INSTANCE, jsonobject);
                cir.setReturnValue(new DimensionGeneratorSettings(i, flag, false, DimensionGeneratorSettings.func_236216_a_(simpleregistry, new FlatChunkGenerator(FlatGenerationSettings.field_236932_a_.parse(dynamic).resultOrPartial(field_236203_c_::error).orElseGet(FlatGenerationSettings::getDefaultFlatGenerator)))));
            case 1:
                cir.setReturnValue(new DimensionGeneratorSettings(i, flag, false, DimensionGeneratorSettings.func_236216_a_(simpleregistry, DebugChunkGenerator.field_236065_d_)));
            case 2:
                cir.setReturnValue(new DimensionGeneratorSettings(i, flag, false, DimensionGeneratorSettings.func_236216_a_(simpleregistry, new NoiseChunkGenerator(new OverworldBiomeProvider(i, false, false), i, DimensionSettings.Preset.field_236123_c_.func_236137_b_()))));
            case 3:
                cir.setReturnValue(new DimensionGeneratorSettings(i, flag, false, DimensionGeneratorSettings.func_236216_a_(simpleregistry, new NoiseChunkGenerator(new OverworldBiomeProvider(i, false, true), i, DimensionSettings.Preset.field_236122_b_.func_236137_b_()))));
            case 4:
                cir.setReturnValue(new DimensionGeneratorSettings(i, flag, false, DimensionGeneratorSettings.func_236216_a_(simpleregistry, new NoiseChunkGenerator(new BYGBiomeProvider116(i), i, DimensionSettings.Preset.field_236122_b_.func_236137_b_()))));

            default:
                cir.setReturnValue(new DimensionGeneratorSettings(i, flag, false, DimensionGeneratorSettings.func_236216_a_(simpleregistry, DimensionGeneratorSettings.func_236211_a_(i))));
        }
    }
}
