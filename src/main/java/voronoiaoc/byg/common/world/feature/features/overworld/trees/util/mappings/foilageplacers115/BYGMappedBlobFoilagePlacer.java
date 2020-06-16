package voronoiaoc.byg.common.world.feature.features.overworld.trees.util.mappings.foilageplacers115;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;
import java.util.Set;

public class BYGMappedBlobFoilagePlacer extends BYGMappedFoilagePlacer {
    public BYGMappedBlobFoilagePlacer(int radius, int radius_random) {
        super(radius, radius_random, BYGMappedFoliagePlacerType.blob_foliage_placer);
    }

    public <T> BYGMappedBlobFoilagePlacer(Dynamic<T> dynamic) {
        this(dynamic.get("radius").asInt(0), dynamic.get("radius_random").asInt(0));
    }

    public void func_225571_a_(IWorldGenerationReader genReader, Random rand, TreeFeatureConfig treeFeatureConfig, int p_225571_4_, int p_225571_5_, int p_225571_6_, BlockPos blockPos, Set<BlockPos> setBlockPos) {
        for (int i = p_225571_4_; i >= p_225571_5_; --i) {
            int j = Math.max(p_225571_6_ - 1 - (i - p_225571_4_) / 2, 0);
            this.func_227384_a_(genReader, rand, treeFeatureConfig, p_225571_4_, blockPos, i, j, setBlockPos);
        }

    }

    public int func_225573_a_(Random rand, int p_225573_2_, int p_225573_3_, TreeFeatureConfig treeFeatureConfig) {
        return field_227381_a_ + rand.nextInt(field_227382_b_ + 1);
    }

    protected boolean func_225572_a_(Random rand, int p_225572_2_, int p_225572_3_, int p_225572_4_, int p_225572_5_, int p_225572_6_) {
        return Math.abs(p_225572_3_) == p_225572_6_ && Math.abs(p_225572_5_) == p_225572_6_ && (rand.nextInt(2) == 0 || p_225572_4_ == p_225572_2_);
    }

    public int func_225570_a_(int p_225570_1_, int p_225570_2_, int p_225570_3_, int p_225570_4_) {
        return p_225570_4_ == 0 ? 0 : 1;
    }
}