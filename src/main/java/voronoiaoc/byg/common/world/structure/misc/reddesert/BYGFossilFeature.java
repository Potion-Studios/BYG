package voronoiaoc.byg.common.world.structure.misc.reddesert;

import com.mojang.serialization.Codec;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.*;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BYGFossilFeature extends Feature<NoFeatureConfig> {
    private static final ResourceLocation STRUCTURE_SPINE_01 = new ResourceLocation("fossil/spine_1");
    private static final ResourceLocation STRUCTURE_SPINE_02 = new ResourceLocation("fossil/spine_2");
    private static final ResourceLocation STRUCTURE_SPINE_03 = new ResourceLocation("fossil/spine_3");
    private static final ResourceLocation STRUCTURE_SPINE_04 = new ResourceLocation("fossil/spine_4");
    private static final ResourceLocation STRUCTURE_SKULL_01 = new ResourceLocation("fossil/skull_1");
    private static final ResourceLocation STRUCTURE_SKULL_02 = new ResourceLocation("fossil/skull_2");
    private static final ResourceLocation STRUCTURE_SKULL_03 = new ResourceLocation("fossil/skull_3");
    private static final ResourceLocation STRUCTURE_SKULL_04 = new ResourceLocation("fossil/skull_4");
    private static final ResourceLocation[] FOSSILS = new ResourceLocation[]{STRUCTURE_SPINE_01, STRUCTURE_SPINE_02, STRUCTURE_SPINE_03, STRUCTURE_SPINE_04, STRUCTURE_SKULL_01, STRUCTURE_SKULL_02, STRUCTURE_SKULL_03, STRUCTURE_SKULL_04};

    public BYGFossilFeature(Codec<NoFeatureConfig> p_i49873_1_) {
        super(p_i49873_1_);
    }

    public boolean func_241855_a(ISeedReader worldIn,  ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        Random random = worldIn.getRandom();
        Rotation[] arotation = Rotation.values();
        Rotation rotation = arotation[random.nextInt(arotation.length)];
        int i = random.nextInt(FOSSILS.length);
        TemplateManager templatemanager = ((ServerWorld) worldIn.getWorld()).getStructureTemplateManager();
        Template template = templatemanager.getTemplateDefaulted(FOSSILS[i]);
        ChunkPos chunkpos = new ChunkPos(pos);
        MutableBoundingBox mutableboundingbox = new MutableBoundingBox(chunkpos.getXStart(), 0, chunkpos.getZStart(), chunkpos.getXEnd(), 256, chunkpos.getZEnd());
        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation).setBoundingBox(mutableboundingbox).setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
        BlockPos blockpos = template.transformedSize(rotation);
        int j = random.nextInt(16 - blockpos.getX());
        int k = random.nextInt(16 - blockpos.getZ());
        int l = 256;

        for (int i1 = 0; i1 < blockpos.getX(); ++i1) {
            for (int j1 = 0; j1 < blockpos.getZ(); ++j1) {
                l = Math.min(l, worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX() + i1 + j, pos.getZ() + j1 + k));
            }
        }

        int k1 = Math.max(l - 15 - random.nextInt(10), 10);
        BlockPos blockpos1 = template.getZeroPositionWithTransform(pos.add(j, k1, k), Mirror.NONE, rotation);
        IntegrityProcessor integrityprocessor = new IntegrityProcessor(0.9F);
        placementsettings.clearProcessors().addProcessor(integrityprocessor);
        template.func_237144_a_(worldIn, blockpos1, placementsettings, rand);
        placementsettings.removeProcessor(integrityprocessor);
        IntegrityProcessor integrityprocessor1 = new IntegrityProcessor(0.1F);
        placementsettings.clearProcessors().addProcessor(integrityprocessor1);
        return true;
    }
}