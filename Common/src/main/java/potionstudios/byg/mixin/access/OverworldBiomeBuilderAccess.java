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

    @Accessor @Mutable
    void setOCEANS(ResourceKey<Biome>[][] oceans);

    @Accessor @Mutable
    void setMIDDLE_BIOMES(ResourceKey<Biome>[][] middleBiomes);

    @Accessor @Mutable
    void setMIDDLE_BIOMES_VARIANT(ResourceKey<Biome>[][] middleBiomesVariant);

    @Accessor @Mutable
    void setPLATEAU_BIOMES(ResourceKey<Biome>[][] plateauBiomes);

    @Accessor @Mutable
    void setPLATEAU_BIOMES_VARIANT(ResourceKey<Biome>[][] plateauBiomesVariant);

    @Invoker
    void invokeAddBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper);
}
