package potionstudios.byg.mixin.access;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(VillagerType.class)
public interface VillagerTypeAccess {

    @Accessor("BY_BIOME")
    static Map<ResourceKey<Biome>, VillagerType> byg_getBY_BIOME() {
        throw new Error("Mixin did not apply!");
    }
}
