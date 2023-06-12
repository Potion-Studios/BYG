package potionstudios.byg.mixin.access;

import net.minecraft.advancements.Advancement;
import net.minecraft.data.advancements.packs.VanillaAdventureAdvancements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(VanillaAdventureAdvancements.class)
public interface AdventureAdvancementsAccess {

    @Invoker("addBiomes")
    static Advancement.Builder byg_invokeAddBiomes(Advancement.Builder $$0, List<ResourceKey<Biome>> $$1) {
        throw new Error("Mixin did not apply!");
    }
}