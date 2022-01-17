package potionstudios.byg.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomes;
import terrablender.api.BiomeProvider;
import terrablender.api.ParameterUtils;
import terrablender.worldgen.TBClimate;

import java.util.List;
import java.util.function.Consumer;

public class BYGBiomeProvider extends BiomeProvider {
    public static final ResourceLocation LOCATION = new ResourceLocation(BYG.MOD_ID, "provider");

    public BYGBiomeProvider(ResourceLocation name) {
        super(name, BYG.worldConfig(true).overworldBiomeRegionSize);
    }

    @Override
    public void addOverworldBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper) {
//        ((OverworldBiomeBuilderAccess) (Object) BYGOverworldBiomeBuilder.BYG).invokeAddBiomes((parameterPointResourceKeyPair ->
//                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameterPointResourceKeyPair.getFirst(), getUniquenessParameter()), parameterPointResourceKeyPair.getSecond()))));
//
//        for (Climate.ParameterPoint vanillaParameterPoint : ParameterUtils.getVanillaParameterPoints(Biomes.STONY_PEAKS)) {
//            mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(vanillaParameterPoint, getUniquenessParameter()), BYGBiomes.DACITE_RIDGES));
//        }

        List<Climate.ParameterPoint> vanillaParameterPoints = ParameterUtils.getVanillaParameterPoints(Biomes.PLAINS);
        for (int i = 0; i < vanillaParameterPoints.size(); i++) {
            Climate.ParameterPoint vanillaParameterPoint = vanillaParameterPoints.get(i);
            if (i < vanillaParameterPoints.size() / 2) {
                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(vanillaParameterPoint, getUniquenessParameter()), BYGBiomes.ALLIUM_FIELDS));
            } else {
                mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(vanillaParameterPoint, getUniquenessParameter()), BYGBiomes.AMARANTH_FIELDS));

            }
        }

        for (Climate.ParameterPoint vanillaParameterPoint : ParameterUtils.getVanillaParameterPoints(Biomes.SAVANNA)) {
            mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(vanillaParameterPoint, getUniquenessParameter()), BYGBiomes.ARAUCARIA_SAVANNA));
        }

        for (Climate.ParameterPoint vanillaParameterPoint : ParameterUtils.getVanillaParameterPoints(Biomes.TAIGA)) {
            mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(vanillaParameterPoint, getUniquenessParameter()), BYGBiomes.ASPEN_FOREST));
        }
    }
}
