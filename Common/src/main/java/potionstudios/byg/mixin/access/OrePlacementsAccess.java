package potionstudios.byg.mixin.access;

import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(OrePlacements.class)
public interface OrePlacementsAccess {

    @Invoker("commonOrePlacement")
    static List<PlacementModifier> byg_invokeCommonOrePlacement(int count, PlacementModifier $$1) {
        throw new Error("Mixin did not apply!");
    }
}