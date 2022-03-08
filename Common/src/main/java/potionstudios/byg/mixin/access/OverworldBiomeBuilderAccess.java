package potionstudios.byg.mixin.access;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public interface OverworldBiomeBuilderAccess {

    @Accessor("OCEANS") @Mutable
    void byg_setOCEANS(ResourceKey<Biome>[][] oceans);

    @Accessor("MIDDLE_BIOMES") @Mutable
    void byg_setMIDDLE_BIOMES(ResourceKey<Biome>[][] middleBiomes);

    @Accessor("MIDDLE_BIOMES_VARIANT") @Mutable
    void byg_setMIDDLE_BIOMES_VARIANT(ResourceKey<Biome>[][] middleBiomesVariant);

    @Accessor("PLATEAU_BIOMES") @Mutable
    void byg_setPLATEAU_BIOMES(ResourceKey<Biome>[][] plateauBiomes);

    @Accessor("PLATEAU_BIOMES_VARIANT") @Mutable
    void byg_setPLATEAU_BIOMES_VARIANT(ResourceKey<Biome>[][] plateauBiomesVariant);

    @Accessor("SHATTERED_BIOMES") @Mutable
    void byg_setSHATTERED_BIOMES(ResourceKey<Biome>[][] shatteredBiomes);

    @Invoker("addBiomes")
    void byg_invokeAddBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper);
}
