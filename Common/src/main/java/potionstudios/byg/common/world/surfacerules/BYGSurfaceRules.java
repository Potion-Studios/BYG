package potionstudios.byg.common.world.surfacerules;

import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomes;

import static potionstudios.byg.mixin.access.SurfaceRuleDataAccess.invokeSurfaceNoiseAbove;

public class BYGSurfaceRules {

    public static final SurfaceRules.ConditionSource ABOVE_62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
    public static final SurfaceRules.ConditionSource ABOVE_63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
    public static final SurfaceRules.ConditionSource WATER_CHECK = SurfaceRules.waterBlockCheck(-1, 0);

    public static final SurfaceRules.RuleSource PEAT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.PEAT.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.PEAT.defaultBlockState())));
    public static final SurfaceRules.RuleSource GRASS_DIRT_DIRT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.DIRT.defaultBlockState())));
    public static final SurfaceRules.RuleSource LUSH_GRASS_LUSH_DIRT_LUSH_DIRT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.LUSH_GRASS_BLOCK.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.LUSH_DIRT.defaultBlockState())));
    public static final SurfaceRules.RuleSource SAND_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SAND.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.SAND.defaultBlockState())));
    public static final SurfaceRules.RuleSource SNOW_BLOCK_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))));
    public static final SurfaceRules.RuleSource COARSE_DIRT_DIRT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.COARSE_DIRT.defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.DIRT.defaultBlockState())));
    public static final SurfaceRules.RuleSource PODZOL_DIRT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.PODZOL.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.DIRT.defaultBlockState())));
    public static final SurfaceRules.RuleSource OVERGROWN_STONE_STONE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.OVERGROWN_STONE.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.STONE.defaultBlockState())));
    public static final SurfaceRules.RuleSource OVERGROWN_DACITE_DACITE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.OVERGROWN_DACITE.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.DACITE.defaultBlockState())));
    public static final SurfaceRules.RuleSource OVERGROWN_PODZOL_DACITE_STONE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.PODZOL_DACITE.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.DACITE.defaultBlockState())));

    public static final SurfaceRules.RuleSource NOISE_PEAT = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.BOREALIS_GROVE), SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(1.75D), PEAT_SURFACE));
    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT = SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(1.75D), COARSE_DIRT_DIRT_SURFACE);
    public static final SurfaceRules.RuleSource NOISE_SNOW = SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(1.75D), SNOW_BLOCK_SURFACE);

    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT_BIOME_FILTER = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.EBONY_WOODS, BYGBiomes.WEEPING_WITCH_FOREST), SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(1.75D), COARSE_DIRT_DIRT_SURFACE));


    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT_PODZOL = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CIKA_WOODS, BYGBiomes.REDWOOD_THICKET),
            SurfaceRules.sequence(
                    NOISE_COARSE_DIRT,
                    SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(-0.95D), PODZOL_DIRT_SURFACE)
            )
    );
    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT_PEAT = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CONIFEROUS_FOREST, BYGBiomes.BLACK_FOREST, BYGBiomes.TWILIGHT_MEADOW),
            SurfaceRules.sequence(
                    NOISE_COARSE_DIRT,
                    SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(-0.95D), PEAT_SURFACE)
            )
    );
    public static final SurfaceRules.RuleSource OVERGROWN_STONE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CANADIAN_SHIELD, BYGBiomes.GUIANA_SHIELD, BYGBiomes.FRAGMENT_FOREST), OVERGROWN_STONE_STONE_SURFACE);


    public static final SurfaceRules.RuleSource DACITE_RIDGES_SURFACE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.DACITE_RIDGES),
            SurfaceRules.sequence(
                    NOISE_COARSE_DIRT,
                    SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(-0.95D), OVERGROWN_PODZOL_DACITE_STONE_SURFACE),
                    OVERGROWN_DACITE_DACITE_SURFACE,
                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(10, false, true, CaveSurface.FLOOR), SurfaceRules.state(BYGBlocks.DACITE.defaultBlockState())),
                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(10, false, true, CaveSurface.CEILING), SurfaceRules.state(BYGBlocks.DACITE.defaultBlockState()))
            )
    );

    public static final SurfaceRules.RuleSource SWAMP_SURFACE_RULES = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.BAYOU, BYGBiomes.CYPRESS_SWAMPLANDS),
            SurfaceRules.ifTrue(
                    ABOVE_62,
                    SurfaceRules.ifTrue(SurfaceRules.not(ABOVE_63),
                            SurfaceRules.ifTrue(
                                    SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D),
                                    SurfaceRules.state(Blocks.WATER.defaultBlockState())
                            )
                    )
            ));

    public static final SurfaceRules.RuleSource MOJAVE_DESERT = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.MOJAVE_DESERT),
            BYGRuleSources.weightedRuleSource(SimpleWeightedRandomList.<SurfaceRules.RuleSource>builder()
                    .add(SAND_SURFACE, 3).add(COARSE_DIRT_DIRT_SURFACE, 1)
                    .add(GRASS_DIRT_DIRT_SURFACE, 1)
                    .build()));

    public static final SurfaceRules.RuleSource LUSH = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.COCONINO_MEADOW, BYGBiomes.TEMPERATE_RAINFOREST), LUSH_GRASS_LUSH_DIRT_LUSH_DIRT_SURFACE);

    public static final SurfaceRules.RuleSource BLACK_ICE_BANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.SHATTERED_GLACIER), SurfaceRules.sequence(BYGRuleSources.bands(BYGBlocks.BLACK_ICE.defaultBlockState(), BYGBlocks.PACKED_BLACK_ICE.defaultBlockState())));
    public static final SurfaceRules.RuleSource SIERRA_BADLANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.SIERRA_BADLANDS), SurfaceRules.sequence(NOISE_COARSE_DIRT, SurfaceRules.ifTrue(SurfaceRules.not(invokeSurfaceNoiseAbove(-0.95D)), GRASS_DIRT_DIRT_SURFACE), SurfaceRules.bandlands()));

    public static final SurfaceRules.RuleSource ABOVE_PRELIMINARY_SURFACE = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(SWAMP_SURFACE_RULES, NOISE_PEAT, NOISE_COARSE_DIRT_PODZOL, NOISE_COARSE_DIRT_PEAT, OVERGROWN_STONE, DACITE_RIDGES_SURFACE, NOISE_COARSE_DIRT_BIOME_FILTER, MOJAVE_DESERT, LUSH, BLACK_ICE_BANDS, SIERRA_BADLANDS));
    public static final SurfaceRules.RuleSource BYG_SURFACE_RULES = SurfaceRules.sequence(ABOVE_PRELIMINARY_SURFACE);

}
