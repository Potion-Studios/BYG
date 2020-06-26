//package voronoiaoc.byg.common.world.dimension.nether.hooks;
//
//import net.minecraft.block.Blocks;
//import net.minecraft.util.math.vector.Vector3d;
//import net.minecraft.world.World;
//import net.minecraft.world.dimension.DimensionType;
//import net.minecraft.world.dimension.NetherDimension;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.ChunkGeneratorType;
//import voronoiaoc.byg.common.world.dimension.nether.biome.BYGNetherBiomeProvider;
//import voronoiaoc.byg.common.world.dimension.nether.chunk.BYGNetherChunkGenerator;
//import voronoiaoc.byg.common.world.dimension.nether.chunk.BYGNetherGenSettings;
//
//public class ServerNetherDimensionHook extends NetherDimension {
//
//    public static ChunkGeneratorType<BYGNetherGenSettings, BYGNetherChunkGenerator> SIMPLEXTALLCAVES = new ChunkGeneratorType<>(BYGNetherChunkGenerator::new, true, BYGNetherGenSettings::new);
//
//    private static final Vector3d NETHERDEFAULTVector3d = new Vector3d(0.2F, 0.03F, 0.03F);
//
//    public ServerNetherDimensionHook(World worldIn, DimensionType typeIn) {
//        super(worldIn, typeIn);
//    }
//
//    @Override
//    public ChunkGenerator createChunkGenerator() {
//        BYGNetherGenSettings nethergensettings = SIMPLEXTALLCAVES.createSettings();
//        nethergensettings.setDefaultBlock(Blocks.NETHERRACK.getDefaultState());
//        nethergensettings.setDefaultFluid(Blocks.LAVA.getDefaultState());
//        return SIMPLEXTALLCAVES.create(world, new BYGNetherBiomeProvider(world.getSeed()), nethergensettings);
//    }
//}
