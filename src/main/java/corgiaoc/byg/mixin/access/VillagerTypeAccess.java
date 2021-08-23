package corgiaoc.byg.mixin.access;

import net.minecraft.entity.villager.VillagerType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(VillagerType.class)
public interface VillagerTypeAccess {

    @Accessor("BY_BIOME")
    static Map<RegistryKey<Biome>, VillagerType> getVillagerByBiome() {
        throw new Error("Mixin did not apply!");
    }
}
