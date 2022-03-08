package potionstudios.byg.mixin.access;

import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(VegetationPlacements.class)
public interface VegetationPlacementsAccess {

    @Invoker("getMushroomPlacement")
    static List<PlacementModifier> byg_invokeGetMushroomPlacement(int $$0, @Nullable PlacementModifier $$1) {
        throw new Error("Mixin did not apply!");
    }
}
