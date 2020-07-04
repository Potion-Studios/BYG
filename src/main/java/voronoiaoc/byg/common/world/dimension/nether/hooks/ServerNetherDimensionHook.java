package voronoiaoc.byg.common.world.dimension.nether.hooks;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.NetherDimension;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import voronoiaoc.byg.common.world.dimension.nether.biome.BYGNetherBiomeProvider;
import voronoiaoc.byg.common.world.dimension.nether.chunk.BYGNetherChunkGenerator;
import voronoiaoc.byg.common.world.dimension.nether.chunk.BYGNetherGenSettings;
import voronoiaoc.byg.config.BYGWorldConfig;

public class ServerNetherDimensionHook extends NetherDimension {

    public static ChunkGeneratorType<BYGNetherGenSettings, BYGNetherChunkGenerator> SIMPLEXTALLCAVES = new ChunkGeneratorType<>(BYGNetherChunkGenerator::new, true, BYGNetherGenSettings::new);

    private static final Vec3d NETHERDEFAULTVEC3D = new Vec3d(0.2F, 0.03F, 0.03F);

    public ServerNetherDimensionHook(World worldIn, DimensionType typeIn) {
        super(worldIn, typeIn);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        BYGNetherGenSettings nethergensettings = SIMPLEXTALLCAVES.createSettings();
        nethergensettings.setDefaultBlock(Blocks.NETHERRACK.getDefaultState());
        nethergensettings.setDefaultFluid(Blocks.LAVA.getDefaultState());
        return SIMPLEXTALLCAVES.create(world, new BYGNetherBiomeProvider(world.getSeed()), nethergensettings);
    }

    @Override
    public int getHeight() {
        return netherHeight();
    }

    @Override
    public int getActualHeight() {
        return netherHeight();
    }

    public static int netherHeight() {
        return (BYGWorldConfig.tallNether.get() ? 256 : 128);
    }
}
