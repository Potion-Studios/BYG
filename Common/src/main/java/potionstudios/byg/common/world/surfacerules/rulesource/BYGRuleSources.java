package potionstudios.byg.common.world.surfacerules.rulesource;

import net.minecraft.core.Registry;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import potionstudios.byg.BYG;
import potionstudios.byg.reg.RegistrationProvider;

public class BYGRuleSources {

    public static WeightedRuleSource weightedRuleSource(SimpleWeightedRandomList<SurfaceRules.RuleSource> ruleSource) {
        return new WeightedRuleSource(ruleSource);
    }

    public static BlockRuleSourceWithTick stateWithTick(BlockState state) {
        return stateWithTick(state, 0);
    }

    public static BlockRuleSourceWithTick stateWithTick(BlockState state, int tickDelay) {
        return new BlockRuleSourceWithTick(state, tickDelay);
    }

    public static BandsRuleSource bands(BlockState... bandStates) {
        return new BandsRuleSource(bandStates);
    }

    public static void bootStrap() {
    }


    static {
        final var provider = RegistrationProvider.get(Registry.RULE_REGISTRY, BYG.MOD_ID);

        provider.register("state_provider", WeightedRuleSource.CODEC::codec);
        provider.register("bands", BandsRuleSource.CODEC::codec);
        provider.register("between_repeating_noise_range", BetweenRepeatingNoiseRange.CODEC::codec);
        provider.register("result_state_with_tick", BlockRuleSourceWithTick.CODEC::codec);
    }
}
