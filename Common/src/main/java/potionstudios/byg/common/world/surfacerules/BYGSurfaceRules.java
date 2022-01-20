package potionstudios.byg.common.world.surfacerules;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomes;

import static potionstudios.byg.mixin.access.SurfaceRuleDataAccess.invokeSurfaceNoiseAbove;

public class BYGSurfaceRules {

    public static final SurfaceRules.ConditionSource ABOVE_62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
    public static final SurfaceRules.ConditionSource ABOVE_63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);


    public static final SurfaceRules.RuleSource NOISE_PEAT = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.BOREALIS_GROVE), SurfaceRules.sequence(SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(1.75D), SurfaceRules.state(BYGBlocks.PEAT.defaultBlockState()))));
    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT_PODZOL = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CIKA_WOODS), SurfaceRules.sequence(SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(1.75D), SurfaceRules.state(Blocks.COARSE_DIRT.defaultBlockState())), SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(-0.95D), SurfaceRules.state(Blocks.PODZOL.defaultBlockState()))));
    public static final SurfaceRules.RuleSource NOISE_COARSE_DIRT_PEAT = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.CONIFEROUS_FOREST), SurfaceRules.sequence(SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(1.75D), SurfaceRules.state(Blocks.COARSE_DIRT.defaultBlockState())), SurfaceRules.ifTrue(invokeSurfaceNoiseAbove(-0.95D), SurfaceRules.state(BYGBlocks.PEAT.defaultBlockState()))));

    public static final SurfaceRules.RuleSource SWAMP_SURFACE_RULES = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.BAYOU),
            SurfaceRules.ifTrue(
                    ABOVE_62,
                    SurfaceRules.ifTrue(SurfaceRules.not(ABOVE_63),
                            SurfaceRules.ifTrue(
                                    SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D),
                                    SurfaceRules.state(Blocks.WATER.defaultBlockState())
                            )
                    )
            ));

    public static final SurfaceRules.RuleSource BYG_SURFACE_RULES = SurfaceRules.sequence(SWAMP_SURFACE_RULES, NOISE_PEAT, NOISE_COARSE_DIRT_PODZOL, NOISE_COARSE_DIRT_PEAT);

}
