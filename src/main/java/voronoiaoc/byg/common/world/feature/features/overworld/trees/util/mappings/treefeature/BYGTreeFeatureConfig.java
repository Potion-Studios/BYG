package voronoiaoc.byg.common.world.feature.features.overworld.trees.util.mappings.treefeature;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.mappings.foilageplacers115.BYGMappedFoilagePlacer;

import java.util.List;

public class BYGTreeFeatureConfig extends BYGBaseTreeFeatureConfig {
    public final BYGMappedFoilagePlacer foliagePlacer;
    public final int heightRandA;
    public final int heightRandB;
    public final int trunkHeight;
    public final int trunkHeightRandom;
    public final int trunkTopOffset;
    public final int trunkTopOffsetRandom;
    public final int foliageHeight;
    public final int foliageHeightRandom;
    public final int maxWaterDepth;
    public final boolean ignoreVines;

    protected BYGTreeFeatureConfig(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, BYGMappedFoilagePlacer foliagePlacerIn, List<TreeDecorator> decoratorsIn, int baseHeightIn, int heightRandAIn, int heightRandBIn, int trunkHeightIn, int trunkHeightRandomIn, int trunkTopOffsetIn, int trunkTopOffsetRandomIn, int foliageHeightIn, int foliageHeightRandomIn, int maxWaterDepthIn, boolean ignoreVinesIn) {
        super(trunkProvider, leavesProvider, decoratorsIn, baseHeightIn);
        this.foliagePlacer = foliagePlacerIn;
        this.heightRandA = heightRandAIn;
        this.heightRandB = heightRandBIn;
        this.trunkHeight = trunkHeightIn;
        this.trunkHeightRandom = trunkHeightRandomIn;
        this.trunkTopOffset = trunkTopOffsetIn;
        this.trunkTopOffsetRandom = trunkTopOffsetRandomIn;
        this.foliageHeight = foliageHeightIn;
        this.foliageHeightRandom = foliageHeightRandomIn;
        this.maxWaterDepth = maxWaterDepthIn;
        this.ignoreVines = ignoreVinesIn;
    }

    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();
        builder.put(ops.createString("foliage_placer"), this.foliagePlacer.serialize(ops)).put(ops.createString("height_rand_a"), ops.createInt(this.heightRandA)).put(ops.createString("height_rand_b"), ops.createInt(this.heightRandB)).put(ops.createString("trunk_height"), ops.createInt(this.trunkHeight)).put(ops.createString("trunk_height_random"), ops.createInt(this.trunkHeightRandom)).put(ops.createString("trunk_top_offset"), ops.createInt(this.trunkTopOffset)).put(ops.createString("trunk_top_offset_random"), ops.createInt(this.trunkTopOffsetRandom)).put(ops.createString("foliage_height"), ops.createInt(this.foliageHeight)).put(ops.createString("foliage_height_random"), ops.createInt(this.foliageHeightRandom)).put(ops.createString("max_water_depth"), ops.createInt(this.maxWaterDepth)).put(ops.createString("ignore_vines"), ops.createBoolean(this.ignoreVines));
        Dynamic<T> dynamic = new Dynamic<>(ops, ops.createMap(builder.build()));
        return dynamic.merge(super.serialize(ops));
    }

    @Override
    protected BYGTreeFeatureConfig setSapling(net.minecraftforge.common.IPlantable value) {
        super.setSapling(value);
        return this;
    }

//   public static <T> BYGTreeFeatureConfig func_227338_a_(Dynamic<T> dynamic) {
//      BYGBaseTreeFeatureConfig basetreefeatureconfig = BYGBaseTreeFeatureConfig.deserialize(dynamic);
//      BYGMappedFoliagePlacerType<?> foliageplacertype;
//      return new BYGTreeFeatureConfig(basetreefeatureconfig.trunkProvider, basetreefeatureconfig.leavesProvider, foliageplacertype.func_227391_a_(dynamic.get("foliage_placer").orElseEmptyMap()), basetreefeatureconfig.decorators, basetreefeatureconfig.baseHeight, dynamic.get("height_rand_a").asInt(0), dynamic.get("height_rand_b").asInt(0), dynamic.get("trunk_height").asInt(-1), dynamic.get("trunk_height_random").asInt(0), dynamic.get("trunk_top_offset").asInt(0), dynamic.get("trunk_top_offset_random").asInt(0), dynamic.get("foliage_height").asInt(-1), dynamic.get("foliage_height_random").asInt(0), dynamic.get("max_water_depth").asInt(0), dynamic.get("ignore_vines").asBoolean(false));
//   }

//   public static <T> BYGTreeFeatureConfig deserializeJungle(Dynamic<T> data) {
//      return func_227338_a_(data).setSapling((net.minecraftforge.common.IPlantable)net.minecraft.block.Blocks.JUNGLE_SAPLING);
//   }
//
//   public static <T> BYGTreeFeatureConfig deserializeAcacia(Dynamic<T> data) {
//      return func_227338_a_(data).setSapling((net.minecraftforge.common.IPlantable)net.minecraft.block.Blocks.ACACIA_SAPLING);
//   }

    public static class Builder extends BYGBaseTreeFeatureConfig.Builder {
        private final BYGMappedFoilagePlacer foliagePlacer;
        private List<TreeDecorator> decorators = ImmutableList.of();
        private int baseHeight;
        private int heightRandA;
        private int heightRandB;
        private int trunkHeight = -1;
        private int trunkHeightRandom;
        private int trunkTopOffset;
        private int trunkTopOffsetRandom;
        private int foliageHeight = -1;
        private int foliageHeightRandom;
        private int maxWaterDepth;
        private boolean ignoreVines;

        public Builder(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn, BYGMappedFoilagePlacer foliagePlacerIn) {
            super(trunkProviderIn, leavesProviderIn);
            this.foliagePlacer = foliagePlacerIn;
        }

        public BYGTreeFeatureConfig.Builder decorators(List<TreeDecorator> decoratorsIn) {
            this.decorators = decoratorsIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder baseHeight(int baseHeightIn) {
            this.baseHeight = baseHeightIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder heightRandA(int heightRandAIn) {
            this.heightRandA = heightRandAIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder heightRandB(int heightRandBIn) {
            this.heightRandB = heightRandBIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder trunkHeight(int trunkHeightIn) {
            this.trunkHeight = trunkHeightIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder trunkHeightRandom(int trunkHeightRandomIn) {
            this.trunkHeightRandom = trunkHeightRandomIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder trunkTopOffset(int trunkTopOffsetIn) {
            this.trunkTopOffset = trunkTopOffsetIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder trunkTopOffsetRandom(int trunkTopOffsetRandomIn) {
            this.trunkTopOffsetRandom = trunkTopOffsetRandomIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder foliageHeight(int foliageHeightIn) {
            this.foliageHeight = foliageHeightIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder foliageHeightRandom(int foliageHeightRandomIn) {
            this.foliageHeightRandom = foliageHeightRandomIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder maxWaterDepth(int maxWaterDepthIn) {
            this.maxWaterDepth = maxWaterDepthIn;
            return this;
        }

        public BYGTreeFeatureConfig.Builder ignoreVines() {
            this.ignoreVines = true;
            return this;
        }

        @Override
        public BYGTreeFeatureConfig.Builder setSapling(net.minecraftforge.common.IPlantable value) {
            super.setSapling(value);
            return this;
        }

        public BYGTreeFeatureConfig build() {
            return new BYGTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.foliagePlacer, this.decorators, this.baseHeight, this.heightRandA, this.heightRandB, this.trunkHeight, this.trunkHeightRandom, this.trunkTopOffset, this.trunkTopOffsetRandom, this.foliageHeight, this.foliageHeightRandom, this.maxWaterDepth, this.ignoreVines).setSapling(this.sapling);
        }
    }
}