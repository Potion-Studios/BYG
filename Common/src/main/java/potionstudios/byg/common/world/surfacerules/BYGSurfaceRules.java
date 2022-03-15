package potionstudios.byg.common.world.surfacerules;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomes;

import java.util.ArrayList;
import java.util.List;

import static potionstudios.byg.mixin.access.SurfaceRuleDataAccess.byg_invokeSurfaceNoiseAbove;

public class BYGSurfaceRules {
    private static final SurfaceRules.RuleSource BEDROCK = SurfaceRules.state(Blocks.BEDROCK.defaultBlockState());

    public static final SurfaceRules.ConditionSource ABOVE_62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
    public static final SurfaceRules.ConditionSource ABOVE_63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
    public static final SurfaceRules.ConditionSource ABOVE_31 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(31), 0);

    public static final SurfaceRules.ConditionSource WATER_CHECK = SurfaceRules.waterBlockCheck(-1, 0);

    public static final SurfaceRules.RuleSource PEAT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.PEAT.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.PEAT.defaultBlockState())));
    public static final SurfaceRules.RuleSource STONE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.STONE.defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.STONE.defaultBlockState())));
    public static final SurfaceRules.RuleSource GRASS_DIRT_DIRT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.DIRT.defaultBlockState())));
    public static final SurfaceRules.RuleSource WINDSWEPT_SAND_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState())), SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.WINDSWEPT_SAND.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.WINDSWEPT_SAND.defaultBlockState())));
    public static final SurfaceRules.RuleSource LUSH_GRASS_LUSH_DIRT_LUSH_DIRT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.LUSH_GRASS_BLOCK.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.LUSH_DIRT.defaultBlockState())));
    public static final SurfaceRules.RuleSource SAND_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(Blocks.SANDSTONE.defaultBlockState())), SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SAND.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.SAND.defaultBlockState())));
    public static final SurfaceRules.RuleSource SNOW_BLOCK_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))));
    public static final SurfaceRules.RuleSource COARSE_DIRT_DIRT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.COARSE_DIRT.defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.DIRT.defaultBlockState())));
    public static final SurfaceRules.RuleSource PODZOL_DIRT_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.PODZOL.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.DIRT.defaultBlockState())));
    public static final SurfaceRules.RuleSource OVERGROWN_STONE_STONE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.OVERGROWN_STONE.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.STONE.defaultBlockState())));
    public static final SurfaceRules.RuleSource OVERGROWN_DACITE_DACITE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.OVERGROWN_DACITE.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.DACITE.defaultBlockState())));
    public static final SurfaceRules.RuleSource OVERGROWN_PODZOL_DACITE_STONE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.PODZOL_DACITE.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.DACITE.defaultBlockState())));

    public static final SurfaceRules.RuleSource NOISE_PEAT = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.BOREALIS_GROVE), SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(1.75D), PEAT_SURFACE));
    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT = SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(1.75D), COARSE_DIRT_DIRT_SURFACE);
    public static final SurfaceRules.RuleSource NOISE_SNOW = SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(1.75D), SNOW_BLOCK_SURFACE);
    public static final SurfaceRules.RuleSource NOISE_STONE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CARDINAL_TUNDRA), SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(1.75D), STONE_SURFACE));

    public static final SurfaceRules.RuleSource BEDROCK_FLOOR = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK);
    public static final SurfaceRules.RuleSource BEDROCK_ROOF = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK);

    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT_BIOME_FILTER = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.EBONY_WOODS), SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(1.75D), COARSE_DIRT_DIRT_SURFACE));

    public static final SurfaceRules.RuleSource WINDSWEPT_SAND_BIOME_FILTER = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.WINDSWEPT_DUNES), WINDSWEPT_SAND_SURFACE);

    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT_PODZOL = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CIKA_WOODS, BYGBiomes.REDWOOD_THICKET, BYGBiomes.FROSTED_TAIGA),
        SurfaceRules.sequence(
            NOISE_COARSE_DIRT,
            SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(-0.95D), PODZOL_DIRT_SURFACE)
        )
    );
    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT_PEAT = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CONIFEROUS_FOREST, BYGBiomes.FROSTED_CONIFEROUS_FOREST, BYGBiomes.BLACK_FOREST, BYGBiomes.TWILIGHT_MEADOW),
        SurfaceRules.sequence(
            NOISE_COARSE_DIRT,
            SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(-0.95D), PEAT_SURFACE)
        )
    );
    public static final SurfaceRules.RuleSource OVERGROWN_STONE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CANADIAN_SHIELD, BYGBiomes.GUIANA_SHIELD, BYGBiomes.FRAGMENT_FOREST, BYGBiomes.CRAG_GARDENS, BYGBiomes.LUSH_STACKS), OVERGROWN_STONE_STONE_SURFACE);


    public static final SurfaceRules.RuleSource RED_ROCK_SURFACE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.RED_ROCK_VALLEY),
        SurfaceRules.sequence(
            NOISE_COARSE_DIRT,
            SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(-0.95D), SurfaceRules.bandlands()),
            SurfaceRules.state(BYGBlocks.RED_ROCK.defaultBlockState())
        )
    );

    public static final SurfaceRules.RuleSource DACITE_RIDGES_SURFACE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.DACITE_RIDGES),
        SurfaceRules.sequence(
            NOISE_COARSE_DIRT,
            SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(-0.95D), OVERGROWN_PODZOL_DACITE_STONE_SURFACE),
            OVERGROWN_DACITE_DACITE_SURFACE,
            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(10, false, CaveSurface.FLOOR), SurfaceRules.state(BYGBlocks.DACITE.defaultBlockState())),
            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(10, false, CaveSurface.CEILING), SurfaceRules.state(BYGBlocks.DACITE.defaultBlockState()))
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
            .build()
        ));

    public static final SurfaceRules.RuleSource LUSH = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.COCONINO_MEADOW, BYGBiomes.TEMPERATE_RAINFOREST, BYGBiomes.WEEPING_WITCH_FOREST, BYGBiomes.AUTUMNAL_VALLEY), LUSH_GRASS_LUSH_DIRT_LUSH_DIRT_SURFACE);

    public static final SurfaceRules.RuleSource BLACK_ICE_BANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.SHATTERED_GLACIER), SurfaceRules.sequence(BYGRuleSources.bands(BYGBlocks.BLACK_ICE.defaultBlockState(), BYGBlocks.PACKED_BLACK_ICE.defaultBlockState())));
    public static final SurfaceRules.RuleSource SIERRA_BADLANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.SIERRA_BADLANDS), SurfaceRules.sequence(NOISE_COARSE_DIRT, SurfaceRules.ifTrue(SurfaceRules.not(byg_invokeSurfaceNoiseAbove(-0.95D)), GRASS_DIRT_DIRT_SURFACE), SurfaceRules.bandlands()));

    public static final SurfaceRules.RuleSource OVERWORLD_ABOVE_PRELIMINARY_SURFACE = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(SWAMP_SURFACE_RULES, NOISE_STONE, NOISE_PEAT, NOISE_COARSE_DIRT_PODZOL, NOISE_COARSE_DIRT_PEAT, OVERGROWN_STONE, DACITE_RIDGES_SURFACE, NOISE_COARSE_DIRT_BIOME_FILTER, MOJAVE_DESERT, LUSH, BLACK_ICE_BANDS, SIERRA_BADLANDS, WINDSWEPT_SAND_BIOME_FILTER, RED_ROCK_SURFACE));
    public static final SurfaceRules.RuleSource OVERWORLD_SURFACE_RULES = SurfaceRules.sequence(OVERWORLD_ABOVE_PRELIMINARY_SURFACE);

    public static final SurfaceRules.RuleSource BULBIS_PHYCELIUM = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.BULBIS_GARDENS), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.BULBIS_PHYCELIUM.defaultBlockState())))));
    public static final SurfaceRules.RuleSource NIGHTSHADE_PHYLIUM = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.NIGHTSHADE_FOREST), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.NIGHTSHADE_PHYLIUM.defaultBlockState())))));
    public static final SurfaceRules.RuleSource IMPARIUS_PHYLIUM = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.IMPARIUS_GROVE), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.IMPARIUS_PHYLIUM.defaultBlockState())))));
    public static final SurfaceRules.RuleSource IVIS_PHYLIUM = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.IVIS_FIELDS), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.IVIS_PHYLIUM.defaultBlockState())))));
    public static final SurfaceRules.RuleSource SHULKREN_PHYLIUM = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.SHULKREN_FOREST), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.SHULKREN_PHYLIUM.defaultBlockState())))));
    public static final SurfaceRules.RuleSource ETHEREAL_ISLANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.ETHEREAL_ISLANDS), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.ETHER_PHYLIUM.defaultBlockState()))), SurfaceRules.state(BYGBlocks.ETHER_STONE.defaultBlockState())));
    public static final SurfaceRules.RuleSource CRYPTIC_FILL = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CRYPTIC_WASTES), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D), SurfaceRules.state(BYGBlocks.CRYPTIC_MAGMA_BLOCK.defaultBlockState())), SurfaceRules.state(BYGBlocks.CRYPTIC_STONE.defaultBlockState())));

    public static final SurfaceRules.RuleSource BRIMSTONE_FILL = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.BRIMSTONE_CAVERNS), SurfaceRules.state(BYGBlocks.BRIMSTONE.defaultBlockState()));
    public static final SurfaceRules.RuleSource QUARTZITE_SAND_FILL = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.QUARTZ_DESERT), SurfaceRules.state(BYGBlocks.QUARTZITE_SAND.defaultBlockState()));
    public static final SurfaceRules.RuleSource EMBUR_BOG = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.EMBUR_BOG), SurfaceRules.sequence(SurfaceRules.ifTrue(ABOVE_31, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.EMBUR_NYLIUM.defaultBlockState()))), SurfaceRules.state(BYGBlocks.BLUE_NETHERRACK.defaultBlockState())));
    public static final SurfaceRules.RuleSource CRIMSON_GARDENS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CRIMSON_GARDENS), SurfaceRules.sequence(SurfaceRules.ifTrue(ABOVE_31, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.defaultBlockState()))), SurfaceRules.state(Blocks.BLACKSTONE.defaultBlockState())));
    public static final SurfaceRules.RuleSource SYTHIAN_TORRIDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.SYTHIAN_TORRIDS), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.SYTHIAN_NYLIUM.defaultBlockState())));

    public static final SurfaceRules.RuleSource MAGMA_WASTES = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.MAGMA_WASTES),
        BYGRuleSources.weightedRuleSource(SimpleWeightedRandomList.<SurfaceRules.RuleSource>builder()
            .add(SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.MAGMATIC_STONE.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.MAGMATIC_STONE.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(BYGBlocks.MAGMATIC_STONE.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.state(BYGBlocks.MAGMATIC_STONE.defaultBlockState()))
            ), 4)
            .add(SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.MAGMA_BLOCK.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.MAGMA_BLOCK.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(Blocks.MAGMA_BLOCK.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.state(Blocks.MAGMA_BLOCK.defaultBlockState()))
            ), 1)
            .build()));

    public static final SurfaceRules.RuleSource WAILING_GARTH = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.WAILING_GARTH), SurfaceRules.sequence(
        BYGRuleSources.weightedRuleSource(SimpleWeightedRandomList.<SurfaceRules.RuleSource>builder()
            .add(SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState()))
            ), 4)
            .add(SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SOUL_SAND.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.SOUL_SAND.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(Blocks.SOUL_SAND.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.state(Blocks.SOUL_SAND.defaultBlockState()))
            ), 2)
            .add(SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.WAILING_NYLIUM.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState()))
            ), 2)
            .build()),
        SurfaceRules.ifTrue(ABOVE_31, SurfaceRules.state(BYGBlocks.SCORIA_STONE.defaultBlockState()))));

    public static final SurfaceRules.RuleSource GLOWSTONE_GARDENS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.GLOWSTONE_GARDENS),
        BYGRuleSources.weightedRuleSource(SimpleWeightedRandomList.<SurfaceRules.RuleSource>builder()
            .add(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.MYCELIUM_NETHERRACK.defaultBlockState())), 1)
            .add(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.WARPED_NYLIUM.defaultBlockState())), 1)
            .add(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState())), 1)
            .build()));

    public static final SurfaceRules.RuleSource SUBZERO_HYPOGEAL = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.SUBZERO_HYPOGEAL),
        SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.SUBZERO_ASH_BLOCK.defaultBlockState())),
            SurfaceRules.state(BYGBlocks.TRAVERTINE.defaultBlockState())
        ));

    public static final SurfaceRules.RuleSource ARISIAN_UNDERGROWTH = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.ARISIAN_UNDERGROWTH),
        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, BYGRuleSources.weightedRuleSource(SimpleWeightedRandomList.<SurfaceRules.RuleSource>builder()
            .add(SurfaceRules.state(BYGBlocks.MAGMATIC_STONE.defaultBlockState()), 1)
            .add(SurfaceRules.state(BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState()), 9)
            .build())));

    public static final SurfaceRules.RuleSource WEEPING_MIRE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.WEEPING_MIRE),
        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, BYGRuleSources.weightedRuleSource(SimpleWeightedRandomList.<SurfaceRules.RuleSource>builder()
            .add(SurfaceRules.state(Blocks.SOUL_SOIL.defaultBlockState()), 1)
            .add(SurfaceRules.state(BYGBlocks.OVERGROWN_NETHERRACK.defaultBlockState()), 9)
            .build())));

    public static final SurfaceRules.RuleSource WARPED_DESERT = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.WARPED_DESERT),
        SurfaceRules.sequence(
            SurfaceRules.ifTrue(byg_invokeSurfaceNoiseAbove(-0.95D), SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.WARPED_SOUL_SAND.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.WARPED_SOUL_SAND.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(BYGBlocks.WARPED_SOUL_SAND.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.state(BYGBlocks.WARPED_SOUL_SAND.defaultBlockState()))
            )),
            SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(BYGBlocks.WARPED_SOUL_SOIL.defaultBlockState())),
            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(BYGBlocks.WARPED_SOUL_SOIL.defaultBlockState())),
            SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SurfaceRules.state(BYGBlocks.WARPED_SOUL_SOIL.defaultBlockState())),
            SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.state(BYGBlocks.WARPED_SOUL_SOIL.defaultBlockState()))

        )
    );
    public static final SurfaceRules.RuleSource END_SURFACE_RULES = SurfaceRules.sequence(BULBIS_PHYCELIUM, NIGHTSHADE_PHYLIUM, IMPARIUS_PHYLIUM, IVIS_PHYLIUM, SHULKREN_PHYLIUM, ETHEREAL_ISLANDS, CRYPTIC_FILL);
    public static final SurfaceRules.RuleSource NETHER_SURFACE_RULES = SurfaceRules.sequence(BEDROCK_FLOOR, BEDROCK_ROOF, SurfaceRules.ifTrue(ABOVE_31, SurfaceRules.sequence(WEEPING_MIRE, ARISIAN_UNDERGROWTH, SYTHIAN_TORRIDS, WARPED_DESERT, GLOWSTONE_GARDENS, CRIMSON_GARDENS)), WAILING_GARTH, MAGMA_WASTES, EMBUR_BOG, SUBZERO_HYPOGEAL, BRIMSTONE_FILL, QUARTZITE_SAND_FILL);

    private static SurfaceRules.RuleSource createNoiseConditions(ResourceKey<NormalNoise.NoiseParameters> parametersResourceKey, List<FloatProvider> ranges, SurfaceRules.RuleSource source) {

//        0.0125F, -1, 1
        List<SurfaceRules.RuleSource> sources = new ArrayList<>();

        for (FloatProvider range : ranges) {
            sources.add(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(parametersResourceKey, range.getMinValue(), range.getMaxValue()), source));
        }

        return SurfaceRules.sequence(sources.toArray(SurfaceRules.RuleSource[]::new));
    }

}
