package voronoiaoc.byg.common.world.feature.features.overworld.trees.util.mappings.treefeature;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

import java.util.List;

public class BYGHugeTreeFeatureConfig extends BYGBaseTreeFeatureConfig {
    public final int field_227275_a_;
    public final int field_227276_b_;

    protected BYGHugeTreeFeatureConfig(BlockStateProvider blockStateProvider, BlockStateProvider blockStateProvider2, List<TreeDecorator> list, int p_i225833_4_, int p_i225833_5_, int p_i225833_6_) {
        super(blockStateProvider, blockStateProvider2, list, p_i225833_4_);
        this.field_227275_a_ = p_i225833_5_;
        this.field_227276_b_ = p_i225833_6_;
    }

    public static <T> BYGHugeTreeFeatureConfig func_227277_a_(Dynamic<T> dynamic) {
        BaseTreeFeatureConfig basetreefeatureconfig = BaseTreeFeatureConfig.deserialize(dynamic);
        return new BYGHugeTreeFeatureConfig(basetreefeatureconfig.trunkProvider, basetreefeatureconfig.leavesProvider, basetreefeatureconfig.decorators, basetreefeatureconfig.baseHeight, dynamic.get("height_interval").asInt(0), dynamic.get("crown_height").asInt(0));
    }

    public static <T> BYGHugeTreeFeatureConfig deserializeDarkOak(Dynamic<T> data) {
        return func_227277_a_(data).setSapling((net.minecraftforge.common.IPlantable) net.minecraft.block.Blocks.DARK_OAK_SAPLING);
    }

    public static <T> BYGHugeTreeFeatureConfig deserializeSpruce(Dynamic<T> data) {
        return func_227277_a_(data).setSapling((net.minecraftforge.common.IPlantable) net.minecraft.block.Blocks.SPRUCE_SAPLING);
    }

    public static <T> BYGHugeTreeFeatureConfig deserializeJungle(Dynamic<T> data) {
        return func_227277_a_(data).setSapling((net.minecraftforge.common.IPlantable) net.minecraft.block.Blocks.JUNGLE_SAPLING);
    }

    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        Dynamic<T> dynamic = new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("height_interval"), ops.createInt(this.field_227275_a_), ops.createString("crown_height"), ops.createInt(this.field_227276_b_))));
        return dynamic.merge(super.serialize(ops));
    }

    @Override
    protected BYGHugeTreeFeatureConfig setSapling(net.minecraftforge.common.IPlantable value) {
        super.setSapling(value);
        return this;
    }

    public static class Builder extends BYGBaseTreeFeatureConfig.Builder {
        private List<TreeDecorator> field_227278_c_ = ImmutableList.of();
        private int field_227279_d_;
        private int field_227280_e_;
        private int field_227281_f_;

        public Builder(BlockStateProvider p_i225834_1_, BlockStateProvider p_i225834_2_) {
            super(p_i225834_1_, p_i225834_2_);
        }

        public BYGHugeTreeFeatureConfig.Builder func_227282_a_(List<TreeDecorator> p_227282_1_) {
            this.field_227278_c_ = p_227282_1_;
            return this;
        }

        public BYGHugeTreeFeatureConfig.Builder baseHeight(int baseHeightIn) {
            this.field_227279_d_ = baseHeightIn;
            return this;
        }

        public BYGHugeTreeFeatureConfig.Builder func_227283_b_(int p_227283_1_) {
            this.field_227280_e_ = p_227283_1_;
            return this;
        }

        public BYGHugeTreeFeatureConfig.Builder func_227284_c_(int p_227284_1_) {
            this.field_227281_f_ = p_227284_1_;
            return this;
        }

        @Override
        public BYGHugeTreeFeatureConfig.Builder setSapling(net.minecraftforge.common.IPlantable value) {
            super.setSapling(value);
            return this;
        }

        public BYGHugeTreeFeatureConfig build() {
            return new BYGHugeTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.field_227278_c_, this.field_227279_d_, this.field_227280_e_, this.field_227281_f_).setSapling(this.sapling);
        }
    }
}