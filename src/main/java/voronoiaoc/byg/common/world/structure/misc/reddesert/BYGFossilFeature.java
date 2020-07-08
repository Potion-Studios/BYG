package voronoiaoc.byg.common.world.structure.misc.reddesert;//package voronoiaoc.byg.common.world.structure.misc.reddesert;
//
//import com.mojang.datafixers.Dynamic;
//import net.minecraft.util.Mirror;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.Rotation;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.ChunkPos;
//import net.minecraft.util.math.BlockBox;
//import net.minecraft.world.IWorld;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.GenerationSettings;
//import net.minecraft.world.gen.Heightmap;
//import net.minecraft.world.gen.feature.Feature;
////import net.minecraft.world.gen.feature.template.*;
//import net.minecraft.world.server.ServerWorld;
//
//import java.util.Random;
//import java.util.function.Function;
//
//public class BYGFossilFeature extends Feature<DefaultFeatureConfig> {
//    private static final Identifier STRUCTURE_SPINE_01 = new Identifier("fossil/spine_1");
//    private static final Identifier STRUCTURE_SPINE_02 = new Identifier("fossil/spine_2");
//    private static final Identifier STRUCTURE_SPINE_03 = new Identifier("fossil/spine_3");
//    private static final Identifier STRUCTURE_SPINE_04 = new Identifier("fossil/spine_4");
//    private static final Identifier STRUCTURE_SKULL_01 = new Identifier("fossil/skull_1");
//    private static final Identifier STRUCTURE_SKULL_02 = new Identifier("fossil/skull_2");
//    private static final Identifier STRUCTURE_SKULL_03 = new Identifier("fossil/skull_3");
//    private static final Identifier STRUCTURE_SKULL_04 = new Identifier("fossil/skull_4");
//    private static final Identifier[] FOSSILS = new Identifier[]{STRUCTURE_SPINE_01, STRUCTURE_SPINE_02, STRUCTURE_SPINE_03, STRUCTURE_SPINE_04, STRUCTURE_SKULL_01, STRUCTURE_SKULL_02, STRUCTURE_SKULL_03, STRUCTURE_SKULL_04};
//
//    public BYGFossilFeature(Codec<DefaultFeatureConfig> p_i49873_1_) {
//        super(p_i49873_1_);
//    }
//
//    public boolean generate(ServerWorldAccess worldIn, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {

//        Random random = worldIn.getRandom();
//        Rotation[] arotation = Rotation.values();
//        Rotation rotation = arotation[random.nextInt(arotation.length)];
//        int i = random.nextInt(FOSSILS.length);
//        StructureManager templatemanager = ((ServerWorld)worldIn.getWorld()).getSaveHandler().getStructureStructureManager();
//        Template template = templatemanager.getTemplateDefaulted(FOSSILS[i]);
//        ChunkPos chunkpos = new ChunkPos(pos);
//        BlockBox mutableboundingbox = new BlockBox(chunkpos.getXStart(), 0, chunkpos.getZStart(), chunkpos.getXEnd(), 256, chunkpos.getZEnd());
//        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation).setBoundingBox(mutableboundingbox).setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
//        BlockPos blockpos = template.transformedSize(rotation);
//        int j = random.nextInt(16 - blockpos.getX());
//        int k = random.nextInt(16 - blockpos.getZ());
//        int l = 256;
//
//        for(int i1 = 0; i1 < blockpos.getX(); ++i1) {
//            for(int j1 = 0; j1 < blockpos.getZ(); ++j1) {
//                l = Math.min(l, worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX() + i1 + j, pos.getZ() + j1 + k));
//            }
//        }
//
//        int k1 = Math.max(l - 15 - random.nextInt(10), 10);
//        BlockPos blockpos1 = template.getZeroPositionWithTransform(pos.add(j, k1, k), Mirror.NONE, rotation);
//        IntegrityProcessor integrityprocessor = new IntegrityProcessor(0.9F);
//        placementsettings.clearProcessors().addProcessor(integrityprocessor);
//        template.addBlocksToWorld(worldIn, blockpos1, placementsettings, 4);
//        placementsettings.removeProcessor(integrityprocessor);
//        IntegrityProcessor integrityprocessor1 = new IntegrityProcessor(0.1F);
//        placementsettings.clearProcessors().addProcessor(integrityprocessor1);
//        return true;
//    }
//}