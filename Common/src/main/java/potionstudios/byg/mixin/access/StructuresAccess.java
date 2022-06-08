package potionstudios.byg.mixin.access;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(Structures.class)
public interface StructuresAccess {
    
    
    @Invoker("structure")
    static Structure.StructureSettings byg_invokeStructure(TagKey<Biome> p_236546_, Map<MobCategory, StructureSpawnOverride> p_236547_, GenerationStep.Decoration p_236548_, TerrainAdjustment p_236549_) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("structure")
    static Structure.StructureSettings byg_invokeStructure(TagKey<Biome> p_236539_, GenerationStep.Decoration p_236540_, TerrainAdjustment p_236541_) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("structure")
    static Structure.StructureSettings byg_invokeStructure(TagKey<Biome> p_236543_, TerrainAdjustment p_236544_) {
        throw new Error("Mixin did not apply!");
    }
}
