package voronoiaoc.byg.common.world.feature.features.overworld.trees.util.mappings.treefeature;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

import java.util.List;

public class BYGBaseTreeFeatureConfig implements IFeatureConfig {
    public final BlockStateProvider trunkProvider;
    public final BlockStateProvider leavesProvider;
    public final List<TreeDecorator> decorators;
    public final int baseHeight;
    public transient boolean forcePlacement;
    protected net.minecraftforge.common.IPlantable sapling = (net.minecraftforge.common.IPlantable) net.minecraft.block.Blocks.OAK_SAPLING;

    protected BYGBaseTreeFeatureConfig(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn, List<TreeDecorator> decoratorsIn, int baseHeightIn) {
        this.trunkProvider = trunkProviderIn;
        this.leavesProvider = leavesProviderIn;
        this.decorators = decoratorsIn;
        this.baseHeight = baseHeightIn;
    }

    public static <T> BYGBaseTreeFeatureConfig deserialize(Dynamic<T> p_227376_0_) {
        BlockStateProviderType<?> blockstateprovidertype = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(p_227376_0_.get("trunk_provider").get("type").asString().orElseThrow(RuntimeException::new)));
        BlockStateProviderType<?> blockstateprovidertype1 = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(p_227376_0_.get("leaves_provider").get("type").asString().orElseThrow(RuntimeException::new)));
        return new BYGBaseTreeFeatureConfig(blockstateprovidertype.func_227399_a_(p_227376_0_.get("trunk_provider").orElseEmptyMap()), blockstateprovidertype1.func_227399_a_(p_227376_0_.get("leaves_provider").orElseEmptyMap()), p_227376_0_.get("decorators").asList((p_227374_0_) -> {
            return Registry.TREE_DECORATOR_TYPE.getOrDefault(new ResourceLocation(p_227374_0_.get("type").asString().orElseThrow(RuntimeException::new))).func_227431_a_(p_227374_0_);
        }), p_227376_0_.get("base_height").asInt(0));
    }

    public static <T> BYGBaseTreeFeatureConfig deserializeJungle(Dynamic<T> data) {
        return deserialize(data).setSapling((net.minecraftforge.common.IPlantable) net.minecraft.block.Blocks.JUNGLE_SAPLING);
    }

    public void forcePlacement() {
        this.forcePlacement = true;
    }

    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();
        builder.put(ops.createString("trunk_provider"), this.trunkProvider.serialize(ops)).put(ops.createString("leaves_provider"), this.leavesProvider.serialize(ops)).put(ops.createString("decorators"), ops.createList(this.decorators.stream().map((p_227375_1_) -> {
            return p_227375_1_.serialize(ops);
        }))).put(ops.createString("base_height"), ops.createInt(this.baseHeight));
        return new Dynamic<>(ops, ops.createMap(builder.build()));
    }

    public net.minecraftforge.common.IPlantable getSapling() {
        return this.sapling;
    }

    protected BYGBaseTreeFeatureConfig setSapling(net.minecraftforge.common.IPlantable value) {
        this.sapling = value;
        return this;
    }

    public static class Builder {
        public final BlockStateProvider trunkProvider;
        public final BlockStateProvider leavesProvider;
        private final List<TreeDecorator> decorators = Lists.newArrayList();
        protected net.minecraftforge.common.IPlantable sapling = (net.minecraftforge.common.IPlantable) net.minecraft.block.Blocks.OAK_SAPLING;
        private int baseHeight = 0;

        public Builder(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn) {
            this.trunkProvider = trunkProviderIn;
            this.leavesProvider = leavesProviderIn;
        }

        public BYGBaseTreeFeatureConfig.Builder baseHeight(int baseHeightIn) {
            this.baseHeight = baseHeightIn;
            return this;
        }

        public BYGBaseTreeFeatureConfig.Builder setSapling(net.minecraftforge.common.IPlantable value) {
            this.sapling = value;
            return this;
        }

        public BYGBaseTreeFeatureConfig build() {
            return new BYGBaseTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.decorators, this.baseHeight).setSapling(sapling);
        }
    }
}