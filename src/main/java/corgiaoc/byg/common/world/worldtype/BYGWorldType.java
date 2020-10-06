//package voronoiaoc.byg.common.world.worldtype;
//
//import net.minecraft.world.World;
//import net.minecraft.world.WorldType;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.dimension.DimensionType;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.OverworldChunkGenerator;
//import net.minecraft.world.gen.OverworldGenSettings;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public final class BYGWorldType extends WorldType {
//    public static final Set<Biome> BIOMES = new HashSet<>();
//
//    public BYGWorldType() {
//        super("byg");
//    }
//
//    @Override
//    public ChunkGenerator createChunkGenerator(World world) {
//        if (world.dimension.getType() == DimensionType.OVERWORLD) {
//            long seed = world.getSeed();
//            return new OverworldChunkGenerator(world, new BYGBiomeProvider(BIOMES, seed), new OverworldGenSettings());
//        }
//        return super.createChunkGenerator(world);
//    }
//}
