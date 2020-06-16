package voronoiaoc.byg.common.world.feature.features.overworld.trees.util.mappings.foilageplacers115;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;
import java.util.Set;

public abstract class BYGMappedFoilagePlacer implements BYGDynamicSerializable {
    public static int field_227381_a_;
    public static int field_227382_b_;
    public static BYGMappedFoliagePlacerType<BYGMappedBlobFoilagePlacer> foilagePlacerType;

    public BYGMappedFoilagePlacer(int p_i225848_1_, int p_i225848_2_, BYGMappedFoliagePlacerType<BYGMappedBlobFoilagePlacer> foilagePlacerType2) {
        field_227381_a_ = p_i225848_1_;
        field_227382_b_ = p_i225848_2_;
        foilagePlacerType = foilagePlacerType2;
    }

    public abstract void func_225571_a_(IWorldGenerationReader p_225571_1_, Random p_225571_2_, TreeFeatureConfig p_225571_3_, int p_225571_4_, int p_225571_5_, int p_225571_6_, BlockPos p_225571_7_, Set<BlockPos> p_225571_8_);

    public abstract int func_225573_a_(Random p_225573_1_, int p_225573_2_, int p_225573_3_, TreeFeatureConfig p_225573_4_);

    protected abstract boolean func_225572_a_(Random p_225572_1_, int p_225572_2_, int p_225572_3_, int p_225572_4_, int p_225572_5_, int p_225572_6_);

    public abstract int func_225570_a_(int p_225570_1_, int p_225570_2_, int p_225570_3_, int p_225570_4_);

    protected void func_227384_a_(IWorldGenerationReader p_227384_1_, Random p_227384_2_, TreeFeatureConfig p_227384_3_, int p_227384_4_, BlockPos p_227384_5_, int p_227384_6_, int p_227384_7_, Set<BlockPos> p_227384_8_) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (int i = -p_227384_7_; i <= p_227384_7_; ++i) {
            for (int j = -p_227384_7_; j <= p_227384_7_; ++j) {
                if (!this.func_225572_a_(p_227384_2_, p_227384_4_, i, p_227384_6_, j, p_227384_7_)) {
                    blockpos$mutable.setPos(i + p_227384_5_.getX(), p_227384_6_ + p_227384_5_.getY(), j + p_227384_5_.getZ());
                    this.func_227385_a_(p_227384_1_, p_227384_2_, blockpos$mutable, p_227384_3_, p_227384_8_);
                }
            }
        }

    }

    protected void func_227385_a_(IWorldGenerationReader worldGenReader, Random rand, BlockPos blockPos, TreeFeatureConfig treeFeatureConfig, Set<BlockPos> setBlockPos) {
        if (AbstractTreeFeature.isAirOrLeaves(worldGenReader, blockPos) || AbstractTreeFeature.isTallPlants(worldGenReader, blockPos) || AbstractTreeFeature.isWater(worldGenReader, blockPos)) {
            worldGenReader.setBlockState(blockPos, treeFeatureConfig.leavesProvider.getBlockState(rand, blockPos), 19);
            setBlockPos.add(blockPos.toImmutable());
        }

    }

    public <T> T serialize(DynamicOps<T> tDynamicOps) {
        ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();
        builder.put(tDynamicOps.createString("type"), tDynamicOps.createString("yeet")).put(tDynamicOps.createString("radius"), tDynamicOps.createInt(field_227381_a_)).put(tDynamicOps.createString("radius_random"), tDynamicOps.createInt(field_227382_b_));
        return (new Dynamic<>(tDynamicOps, tDynamicOps.createMap(builder.build()))).getValue();
    }
}