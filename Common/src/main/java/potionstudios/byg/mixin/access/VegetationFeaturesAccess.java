package potionstudios.byg.mixin.access;

import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(VegetationFeatures.class)
public interface VegetationFeaturesAccess {

    @Invoker("grassPatch")
    static RandomPatchConfiguration byg_invokeGrassPatch(BlockStateProvider stateProvider, int tries) {
        throw new Error("Mixin did not apply!");
    }
}
