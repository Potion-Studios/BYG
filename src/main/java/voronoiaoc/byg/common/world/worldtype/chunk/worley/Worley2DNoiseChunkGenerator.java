//package voronoiaoc.byg.common.world.worldtype.chunk.worley;
//
//import it.unimi.dsi.fastutil.longs.LongIterator;
//import it.unimi.dsi.fastutil.objects.ObjectArrayList;
//import it.unimi.dsi.fastutil.objects.ObjectList;
//import it.unimi.dsi.fastutil.objects.ObjectListIterator;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.crash.CrashReport;
//import net.minecraft.crash.ReportedException;
//import net.minecraft.util.SharedSeedRandom;
//import net.minecraft.util.Util;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.ChunkPos;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.util.math.MutableBoundingBox;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.IWorld;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.provider.BiomeProvider;
//import net.minecraft.world.chunk.ChunkPrimer;
//import net.minecraft.world.chunk.ChunkSection;
//import net.minecraft.world.chunk.IChunk;
//import net.minecraft.world.gen.*;
//import net.minecraft.world.gen.feature.ConfiguredFeature;
//import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.SphereReplaceFeature;
//import net.minecraft.world.gen.feature.jigsaw.JigsawJunction;
//import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
//import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
//import net.minecraft.world.gen.feature.structure.Structure;
//import net.minecraft.world.gen.feature.structure.StructurePiece;
//import net.minecraft.world.gen.feature.structure.StructureStart;
//import voronoiaoc.byg.common.world.worldtype.noise.WorleyNoise;
//import voronoiaoc.byg.common.world.worldtype.noise.simplex.WorleyDisklessDepositor;
//import voronoiaoc.byg.common.world.worldtype.noise.simplex.chunkgen.SplerpBaseSimplex;
//
//import java.util.Iterator;
//import java.util.Random;
//
//public abstract class Worley2DNoiseChunkGenerator<T extends GenerationSettings> extends ChunkGenerator<T> {
//
//    private static final double BLEND_NOISE_MAIN_AMPLITUDE = 6.35 * 0.87890625;
//    private static final double OUTPUT_NOISE_MAIN_AMPLITUDE = 64.0 * 0.87890625;
//
//    private static final float[] field_222561_h = Util.make(new float[13824], (p_222557_0_) -> {
//        for (int i = 0; i < 24; ++i) {
//            for (int j = 0; j < 24; ++j) {
//                for (int k = 0; k < 24; ++k) {
//                    p_222557_0_[i * 24 * 24 + j * 24 + k] = (float) func_222554_b(j - 12, k - 12, i - 12);
//                }
//            }
//        }
//    });
//
//    private static final BlockState AIR;
//    private final int worldHeight;
//    protected final SharedSeedRandom randomSeed;
//
//    private final int nOctavesOutput;
//    private final int nOctavesBlend;
//    private final WorleyNoise[] fssnOctaves1;
//    private final WorleyNoise[] fssnOctaves2;
//    private final WorleyNoise[] fssnOctavesBlend;
//    private final double[] outputUncertaintyBounds;
//    private double[] blendUncertaintyBounds;
//
//    private final int horizontalBiomeGranularity;
//    private final int horizontalBiomeSourceSections;
//    private final int horizontalBiomeSourceArraySize;
//    private final SplerpBaseSimplex biomeSplerpBaseSimplex;
//
//    private final INoiseGenerator surfaceDepthNoise;
//    protected final BlockState defaultBlock;
//    protected final BlockState defaultFluid;
//
//    private final double hScale, vScale, hScaleBlend, vScaleBlend;
//
//    WorleyDisklessDepositor disklessDepositor;
//
//    /*
//     * Constructor, called by inheriting class constructors
//     */
//
//    public Worley2DNoiseChunkGenerator(IWorld worldIn, BiomeProvider biomeProvider, int horizontalBiomeGranularityPowerOfTwo, int worldHeight, T settings, int nOctavesOutput, int nOctavesBlend, double hScale, double vScale, double hScaleBlend, double vScaleBlend) {
//        super(worldIn, biomeProvider, settings);
//        this.defaultBlock = settings.getDefaultBlock();
//        this.defaultFluid = settings.getDefaultFluid();
//        this.worldHeight = worldHeight;
//        this.randomSeed = new SharedSeedRandom(this.seed);
//
//        this.nOctavesOutput = nOctavesOutput;
//        this.nOctavesBlend = nOctavesBlend;
//
//        this.hScale = hScale;
//        this.vScale = vScale / 2.0;
//        this.hScaleBlend = hScaleBlend;
//        this.vScaleBlend = vScaleBlend / 2.0;
//
//        fssnOctaves1 = new WorleyNoise[nOctavesOutput];
//        fssnOctaves2 = new WorleyNoise[nOctavesOutput];
//        fssnOctavesBlend = new WorleyNoise[nOctavesBlend];
//        for (int i = 0; i < Math.max(nOctavesOutput, nOctavesBlend); i++) {
//            if (i < nOctavesOutput) {
//                fssnOctaves1[i] = new WorleyNoise(randomSeed);
//                fssnOctaves2[i] = new WorleyNoise(randomSeed); //TODO I think if nOctavesBlend=0, we don't even need any of octaves2
//            }
//            if (i < nOctavesBlend) fssnOctavesBlend[i] = new WorleyNoise(randomSeed);
//        }
//
//        this.horizontalBiomeGranularity = horizontalBiomeGranularityPowerOfTwo;
//        this.horizontalBiomeSourceSections = 16 / horizontalBiomeGranularity;
//        this.horizontalBiomeSourceArraySize = horizontalBiomeSourceSections + 3;
//        this.biomeSplerpBaseSimplex = SplerpBaseSimplex.forStride(horizontalBiomeGranularityPowerOfTwo);
//
//        // for nOctavesOutput=4, this would generate
//        // { OUTPUT_NOISE_MAIN_AMPLITUDE * (1.0 + 0.5 + 0.25 + 0.125), OUTPUT_NOISE_MAIN_AMPLITUDE * (0.5 + 0.25 + 0.125), OUTPUT_NOISE_MAIN_AMPLITUDE * (0.25 + 0.125), OUTPUT_NOISE_MAIN_AMPLITUDE * (0.125) };
//        outputUncertaintyBounds = new double[nOctavesOutput];
//        {
//            double boundBase = 0.0;
//            for (int i = nOctavesOutput - 1; i >= 0; i--) {
//                boundBase += 1.0 / (1 << i);
//                outputUncertaintyBounds[i] = OUTPUT_NOISE_MAIN_AMPLITUDE * boundBase;
//            }
//        }
//
//        // for nOctavesBlend=3, this would generate { BLEND_NOISE_MAIN_AMPLITUDE * (0.5 + 0.25), BLEND_NOISE_MAIN_AMPLITUDE * (0.25) };
//        // The entry (which would be the first) that includes the biggest octave, is omitted because we don't need it. Notice i>=1 and [i-1]
//        if (nOctavesBlend != 0) {
//            blendUncertaintyBounds = new double[nOctavesBlend - 1];
//            {
//                double boundBase = 0.0;
//                for (int i = nOctavesBlend - 1; i >= 1; i--) {
//                    boundBase += 1.0 / (1 << i);
//                    blendUncertaintyBounds[i - 1] = BLEND_NOISE_MAIN_AMPLITUDE * boundBase;
//                }
//            }
//        }
//
//        // Actually generates 2D Simplex noise, which is good. Does not generate the Oldperlin.
//        // ChunkFastSimplexStyleNoise provides a 2D function with a slightly more lattice-symmetric gradient set,
//        // but matching the frequency and output range is proving slightly less than straightforward.
//        this.surfaceDepthNoise = new PerlinNoiseGenerator(this.randomSeed, 3, 0);
//
//        // TODO it would be nice if biomeProvider.BIOMES_TO_SPAWN_IN had even close to every biome.
//        // If a better option than Forge is not found, we can make this static.
//        disklessDepositor = new WorleyDisklessDepositor(net.minecraftforge.registries.ForgeRegistries.BIOMES.getValues(), randomSeed);
//    }
//
//    /*
//     * Generate a whole chunk
//     */
//
//    public void makeBase(IWorld worldIn, IChunk chunkIn) {
//        int sealevel = this.getSeaLevel();
//        ObjectList<AbstractVillagePiece> villagePieceList = new ObjectArrayList(10);
//        ObjectList<JigsawJunction> jigsawJunctionList = new ObjectArrayList(32);
//        ChunkPos chunkpos = chunkIn.getPos();
//        int chunkX = chunkpos.x;
//        int chunkZ = chunkpos.z;
//        int worldChunkX = chunkX << 4;
//        int worldChunkZ = chunkZ << 4;
//        Iterator structureIterator = Feature.ILLAGER_STRUCTURES.iterator();
//
//        // Start with some structure generation related tasks
//        label175:
//        while (structureIterator.hasNext()) {
//            Structure<?> structure = (Structure) structureIterator.next();
//            String s = structure.getStructureName();
//            LongIterator longiterator = chunkIn.getStructureReferences(s).iterator();
//
//            label173:
//            while (true) {
//                StructureStart structurestart;
//                do {
//                    do {
//                        if (!longiterator.hasNext()) {
//                            continue label175;
//                        }
//
//                        long j1 = longiterator.nextLong();
//                        ChunkPos chunkpos1 = new ChunkPos(j1);
//                        IChunk ichunk = worldIn.getChunk(chunkpos1.x, chunkpos1.z);
//                        structurestart = ichunk.getStructureStart(s);
//                    } while (structurestart == null);
//                } while (!structurestart.isValid());
//
//                Iterator var20 = structurestart.getComponents().iterator();
//
//                while (true) {
//                    StructurePiece structurepiece;
//                    do {
//                        do {
//                            if (!var20.hasNext()) {
//                                continue label173;
//                            }
//
//                            structurepiece = (StructurePiece) var20.next();
//                        } while (!structurepiece.func_214810_a(chunkpos, 12));
//                    } while (!(structurepiece instanceof AbstractVillagePiece));
//
//                    AbstractVillagePiece abstractvillagepiece = (AbstractVillagePiece) structurepiece;
//                    JigsawPattern.PlacementBehaviour jigsawpattern$placementbehaviour = abstractvillagepiece.getJigsawPiece().getPlacementBehaviour();
//                    if (jigsawpattern$placementbehaviour == JigsawPattern.PlacementBehaviour.RIGID) {
//                        villagePieceList.add(abstractvillagepiece);
//                    }
//
//                    Iterator var24 = abstractvillagepiece.getJunctions().iterator();
//
//                    while (var24.hasNext()) {
//                        JigsawJunction jigsawjunction = (JigsawJunction) var24.next();
//                        int k1 = jigsawjunction.getSourceX();
//                        int l1 = jigsawjunction.getSourceZ();
//                        if (k1 > worldChunkX - 12 && l1 > worldChunkZ - 12 && k1 < worldChunkX + 15 + 12 && l1 < worldChunkZ + 15 + 12) {
//                            jigsawJunctionList.add(jigsawjunction);
//                        }
//                    }
//                }
//            }
//        }
//
//        // Generate all the biome data we need.
//        int xcb = worldChunkX / horizontalBiomeGranularity;
//        int zcb = worldChunkZ / horizontalBiomeGranularity;
//        double[][] biomeBlendMap1 = new double[horizontalBiomeSourceArraySize][horizontalBiomeSourceArraySize];
//        double[][] biomeBlendMap2 = new double[horizontalBiomeSourceArraySize][horizontalBiomeSourceArraySize];
//        for (int z = 0; z < horizontalBiomeSourceArraySize; z++) {
//            for (int x = 0; x < horizontalBiomeSourceArraySize; x++) {
//                double[] biomeBlendValues = this.getColumnBiomeParams(xcb + x - 1, zcb + z - 1);
//                biomeBlendMap1[z][x] = biomeBlendValues[0];
//                biomeBlendMap2[z][x] = biomeBlendValues[1];
//            }
//        }
//
//        // Interpolate biome blends with a spline
//        double[][] biomeBlendValues1 = new double[16][16];
//        double[][] biomeBlendValues2 = new double[16][16];
//        for (int zc = 0; zc < horizontalBiomeSourceSections; zc++) {
//            for (int xc = 0; xc < horizontalBiomeSourceSections; xc++) {
//
//                double[] biSplerpValues1 = new double[16];
//                double[] biSplerpValues2 = new double[16];
//                for (int zo = 0; zo < 4; zo++) {
//                    for (int xo = 0; xo < 4; xo++) {
//                        biSplerpValues1[xo * 4 + zo] = biomeBlendMap1[zc + zo][xc + xo];
//                        biSplerpValues2[xo * 4 + zo] = biomeBlendMap2[zc + zo][xc + xo];
//                    }
//                }
//
//                SplerpBaseSimplex.BiSplerp biSplerp1 = new SplerpBaseSimplex.BiSplerp(biomeSplerpBaseSimplex, biomeSplerpBaseSimplex, biSplerpValues1);
//                SplerpBaseSimplex.BiSplerp biSplerp2 = new SplerpBaseSimplex.BiSplerp(biomeSplerpBaseSimplex, biomeSplerpBaseSimplex, biSplerpValues2);
//
//                for (int z = 0; z < horizontalBiomeGranularity; z++) {
//                    SplerpBaseSimplex.Splerp splerp1 = biSplerp1.at(z);
//                    SplerpBaseSimplex.Splerp splerp2 = biSplerp2.at(z);
//                    for (int x = 0; x < horizontalBiomeGranularity; x++) {
//                        biomeBlendValues1[zc * horizontalBiomeGranularity + z][xc * horizontalBiomeGranularity + x] = splerp1.at(x);
//                        biomeBlendValues2[zc * horizontalBiomeGranularity + z][xc * horizontalBiomeGranularity + x] = splerp2.at(x);
//                    }
//                }
//            }
//        }
//
//        ChunkPrimer chunkprimer = (ChunkPrimer) chunkIn;
//        Heightmap oceanFloorHeightmap = chunkprimer.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG);
//        Heightmap worldSurfaceHeightmap = chunkprimer.getHeightmap(Heightmap.Type.WORLD_SURFACE_WG);
//        BlockPos.Mutable blockPosMutable = new BlockPos.Mutable();
//        ObjectListIterator<AbstractVillagePiece> villagePieceIterator = villagePieceList.iterator();
//        ObjectListIterator<JigsawJunction> jigsawJunctionIterator = jigsawJunctionList.iterator();
//
//        // 16xHx16 chunks are divided into 16x16x16 sections. Start at the top one.
//        ChunkSection chunksection = chunkprimer.getSection((worldHeight - 1) >> 4);
//        chunksection.lock();
//
//        for (int y = worldHeight - 1; y >= 0; y--) {
//            int chunkSectionIndex = y >> 4;
//            int chunkSectionY = y & 15;
//
//            if (chunksection.getYLocation() >> 4 != chunkSectionIndex) {
//                chunksection.unlock();
//                chunksection = chunkprimer.getSection(chunkSectionIndex);
//                chunksection.lock();
//            }
//
//            for (int z = 0; z < 16; z++) {
//                int worldZ = worldChunkZ + z;
//                for (int x = 0; x < 16; x++) {
//                    int worldX = worldChunkX + x;
//
//                    // Compute blending noise. We don't always need to calculate all of the octaves.
//                    double startingValue = -getHeightThreshold(biomeBlendValues1[z][x], biomeBlendValues2[z][x], y);
//                    double noiseValue = computeGoodEnoughNoise(worldX, y, worldZ, startingValue);
//
//                    // Optimization: If the threshold was too big for the noise to kick in, we should be nowhere near placing a structure.
//                    if (noiseValue != startingValue) {
//                        noiseValue = MathHelper.clamp(noiseValue / 200.0D, -1.0D, 1.0D);
//
//                        // Structure-related
//                        int vXBound, vYBound, vZBound;
//                        for (noiseValue = noiseValue / 2.0D - noiseValue * noiseValue * noiseValue / 24.0D; villagePieceIterator.hasNext(); noiseValue += func_222556_a(vXBound, vYBound, vZBound) * 0.8D) {
//                            AbstractVillagePiece abstractvillagepiece1 = villagePieceIterator.next();
//                            MutableBoundingBox mutableboundingbox = abstractvillagepiece1.getBoundingBox();
//                            vXBound = Math.max(0, Math.max(mutableboundingbox.minX - worldX, worldX - mutableboundingbox.maxX));
//                            vYBound = y - (mutableboundingbox.minY + abstractvillagepiece1.getGroundLevelDelta());
//                            vZBound = Math.max(0, Math.max(mutableboundingbox.minZ - worldZ, worldZ - mutableboundingbox.maxZ));
//                        }
//                        villagePieceIterator.back(villagePieceList.size());
//                        while (jigsawJunctionIterator.hasNext()) {
//                            JigsawJunction jigsawjunction1 = jigsawJunctionIterator.next();
//                            vXBound = worldX - jigsawjunction1.getSourceX();
//                            vYBound = y - jigsawjunction1.getSourceGroundY();
//                            vZBound = worldZ - jigsawjunction1.getSourceZ();
//                            noiseValue += func_222556_a(vXBound, vYBound, vZBound) * 0.4D;
//                        }
//                        jigsawJunctionIterator.back(jigsawJunctionList.size());
//                    }
//
//                    // Set block
//                    BlockState blockstate;
//                    if (noiseValue > 0) {
//                        blockstate = this.defaultBlock;
//                    } else if (y < sealevel) {
//                        blockstate = this.defaultFluid;
//                    } else {
//                        blockstate = AIR;
//                    }
//
//                    // Update heightmaps
//                    if (blockstate != AIR) {
//                        if (blockstate.getLightValue() != 0) {
//                            blockPosMutable.setPos(worldX, y, worldZ);
//                            chunkprimer.addLightPosition(blockPosMutable);
//                        }
//
//                        chunksection.setBlockState(x, chunkSectionY, z, blockstate, false);
//                        oceanFloorHeightmap.update(x, y, z, blockstate);
//                        worldSurfaceHeightmap.update(x, y, z, blockstate);
//                    }
//
//
//                }
//            }
//        }
//
//        chunksection.unlock();
//    }
//
//    /*
//     * Seems to be for updating a heightmap based on a single column
//     */
//
//    public int func_222529_a(int worldX, int worldZ, Heightmap.Type heightMapType) {
//
//        int sealevel = this.getSeaLevel();
//        int chunkBlockX = worldX & 15;
//        int chunkBlockZ = worldZ & 15;
//        int xc = worldX / horizontalBiomeGranularity;
//        int zc = worldZ / horizontalBiomeGranularity;
//
//        // Biome parameters for just the one column
//        double[] biSplerpValues1 = new double[16];
//        double[] biSplerpValues2 = new double[16];
//        for (int zo = 0; zo < 4; zo++) {
//            for (int xo = 0; xo < 4; xo++) {
//                double[] biomeBlendValues = this.getColumnBiomeParams(xc + xo - 1, zc + zo - 1);
//                biSplerpValues1[xo * 4 + zo] = biomeBlendValues[0];
//                biSplerpValues2[xo * 4 + zo] = biomeBlendValues[1];
//            }
//        }
//        SplerpBaseSimplex.BiSplerp biSplerp1 = new SplerpBaseSimplex.BiSplerp(biomeSplerpBaseSimplex, biomeSplerpBaseSimplex, biSplerpValues1);
//        SplerpBaseSimplex.BiSplerp biSplerp2 = new SplerpBaseSimplex.BiSplerp(biomeSplerpBaseSimplex, biomeSplerpBaseSimplex, biSplerpValues2);
//        int granularityMask = (horizontalBiomeGranularity - 1);
//        double biomeBlendValue1 = biSplerp1.at(chunkBlockZ & granularityMask).at(chunkBlockX & granularityMask);
//        double biomeBlendValue2 = biSplerp2.at(chunkBlockZ & granularityMask).at(chunkBlockX & granularityMask);
//
//        for (int y = worldHeight - 1; y >= 0; y--) {
//            double threshold = getHeightThreshold(biomeBlendValue1, biomeBlendValue2, y);
//            double noiseValue = computeGoodEnoughNoise(worldX, y, worldZ, -threshold);
//
//            if (noiseValue > 0 || y < sealevel) {
//                BlockState blockstate;
//                if (noiseValue > 0) {
//                    blockstate = this.defaultBlock;
//                } else {
//                    blockstate = this.defaultFluid;
//                }
//
//                if (heightMapType.getHeightLimitPredicate().test(blockstate)) {
//                    return y + 1;
//                }
//            }
//        }
//
//        return 0;
//    }
//
//
//    /*
//     * Generate the noise in a smart enough way to efficiently get all the info we need
//     * All we really need is the sign (and a rough value for village generation)
//     */
//
//    private double computeGoodEnoughNoise(int worldX, int worldY, int worldZ, double startingValue) {
//
//        // Final noise value begins with the threshold.
//        double actualValue = startingValue;
//
//        // If the noise couldn't possibly turn the threshold from air to solid (or vice-versa), we can skip modulating it.
//        if (actualValue > outputUncertaintyBounds[0] || actualValue < -outputUncertaintyBounds[0]) return actualValue;
//
//        // Compute blending noise. We don't always need to calculate all of the octaves.
//        double blendingValue = 0.0;
//        if (nOctavesBlend != 0) {
//            int octave = 0;
//            double freq = 1.0 / 512.0 * 0.7937005259840998;
//            double amp = BLEND_NOISE_MAIN_AMPLITUDE;
//            do {
//                blendingValue += fssnOctavesBlend[octave].sample2D(worldX * hScaleBlend * freq, worldZ * hScaleBlend * freq) * amp;
//                freq *= 2.0;
//                amp /= 2.0;
//                octave++;
//            } while (octave < nOctavesBlend && blendingValue > -blendUncertaintyBounds[octave - 1] && blendingValue < blendUncertaintyBounds[octave - 1]);
//            blendingValue = blendingValue <= -0.5 ? 0 : (blendingValue >= 0.5 ? 1 : blendingValue + 0.5); // clamp and +0.5 to be [0, 1]
//
//            // Soften cliff face blending. Reduces fragmented cliff tips, and further reduces small floating sections, without the need for 4x8x4 trilerp.
//            blendingValue = blendingValue * blendingValue * (3 - blendingValue * 2); // TODO if the JVM doesn't skip executing this when =0 or =1, refactor.
//        }
//
//        // Compute regular noise(s). We don't always need to calculate all of the octaves. And most of the time, we only need to calculate one of the two noises.
//        {
//            int octave = 0;
//            double freq = 1.0 / 131072.0 * 0.7937005259840998;
//            double amp = OUTPUT_NOISE_MAIN_AMPLITUDE;
//            do {
//                if (blendingValue < 1)
//                    actualValue += (1 - blendingValue) * fssnOctaves1[octave].sample2D(worldX * hScale * freq, worldZ * hScale * freq) * amp;
//                if (blendingValue > 0)
//                    actualValue += blendingValue * fssnOctaves2[octave].sample2D(worldX * hScale * freq, worldZ * hScale * freq) * amp;
//                freq *= 2.0;
//                amp /= 2.0;
//                octave++;
//            } while (octave < nOctavesOutput && actualValue > -outputUncertaintyBounds[octave] && actualValue < outputUncertaintyBounds[octave]);
//
//        }
//        return actualValue;
//    }
//
//    /*
//     * Need to disable disks. Ordinarily defined in ChunkGenerator
//     */
//
//    @Override
//    public void decorate(WorldGenRegion region) {
//
//        int i = region.getMainChunkX();
//        int j = region.getMainChunkZ();
//        int k = i * 16;
//        int l = j * 16;
//        BlockPos blockpos = new BlockPos(k, 0, l);
//        Biome biome = this.getBiome(region.getBiomeManager(), blockpos.add(8, 8, 8));
//        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
//        long i1 = sharedseedrandom.setDecorationSeed(region.getSeed(), k, l);
//        GenerationStage.Decoration[] var11 = GenerationStage.Decoration.values();
//        int var12 = var11.length;
//
//        for (int var13 = 0; var13 < var12; ++var13) {
//            GenerationStage.Decoration stage = var11[var13];
//
//            try {
//                // This is the changed part. Brought in from Biome.class and modified to skip disks
//
//                int iFeatures = 0;
//                for (ConfiguredFeature<?, ?> configuredfeature : biome.getFeatures(stage)) {
//                    sharedseedrandom.setFeatureSeed(i1, iFeatures, stage.ordinal());
//
//                    // Generate everything except for the disk deposits. We've put a replacement in the surface generator.
//                    if (stage != GenerationStage.Decoration.UNDERGROUND_ORES || !(((DecoratedFeatureConfig) configuredfeature.config).feature.feature instanceof SphereReplaceFeature)) {
//                        try {
//                            configuredfeature.place(region, this, sharedseedrandom, blockpos);
//                        } catch (Exception e) {
//                            CrashReport crashreport = CrashReport.makeCrashReport(e, "Feature placement");
//                            crashreport.makeCategory("Feature").addDetail("Id", Registry.FEATURE.getKey(configuredfeature.feature)).addDetail("Description", () -> {
//                                return configuredfeature.feature.toString();
//                            });
//                            throw new ReportedException(crashreport);
//                        }
//                    }
//
//                    iFeatures++;
//                }
//
//            } catch (Exception e) {
//                CrashReport crashreport = CrashReport.makeCrashReport(e, "Biome decoration");
//                crashreport.makeCategory("Generation").addDetail("CenterX", Integer.valueOf(i)).addDetail("CenterZ", Integer.valueOf(j)).addDetail("Step", stage).addDetail("Seed", Long.valueOf(i1)).addDetail("Biome", Registry.BIOME.getKey(biome));
//                throw new ReportedException(crashreport);
//            }
//        }
//    }
//
//    /*
//     * Generate surface block patterns (including new non-circular surface deposits)
//     */
//
//    public void generateSurface(WorldGenRegion region, IChunk chunk) {
//        int sealevel = this.getSeaLevel();
//        ChunkPos chunkpos = chunk.getPos();
//        int i = chunkpos.x;
//        int j = chunkpos.z;
//        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
//        sharedseedrandom.setBaseChunkSeed(i, j);
//        ChunkPos chunkpos1 = chunk.getPos();
//        int k = chunkpos1.getXStart();
//        int l = chunkpos1.getZStart();
//        BlockPos.Mutable blockposMutable = new BlockPos.Mutable();
//
//        for (int i1 = 0; i1 < 16; ++i1) {
//            for (int j1 = 0; j1 < 16; ++j1) {
//                int k1 = k + i1;
//                int l1 = l + j1;
//                int i2 = chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, i1, j1) + 1;
//
//                //TODO figure out a way to get the top of each block when there are overhangs.
//                // When generating the chunk's volume, we can build up a list of top blocks.
//                // This list will be in order such that top-blocks in the same column will be grouped,
//                // and in their own order based on height.
//                // This, combined with using 3D noise to pick surface textures, will enable overhangs
//                // to not either block or copy the surface below them.
//
//                double d1 = this.surfaceDepthNoise.noiseAt((double) k1 * 0.0625D, (double) l1 * 0.0625D, 0.0625D, (double) i1 * 0.0625D) * 15.0D; // This is Simplex
//                blockposMutable = blockposMutable.setPos(k + i1, i2, l + j1);
//                Biome biome = region.getBiome(blockposMutable);
//                biome.buildSurface(sharedseedrandom, chunk, k1, l1, i2, d1, this.getSettings().getDefaultBlock(), this.getSettings().getDefaultFluid(), this.getSeaLevel(), this.world.getSeed());
//
//                // Non-disk deposits
//                i2 = chunk.getTopBlockY(Heightmap.Type.OCEAN_FLOOR_WG, i1, j1);
//                blockposMutable = blockposMutable.setPos(k + i1, i2, l + j1);
//                if (i2 < sealevel - 1) {
//                    disklessDepositor.apply(chunk, biome, blockposMutable); // Note: May modify blockposMutable. Refactor DisklessDepositor if that becomes unacceptable.
//                }
//            }
//        }
//
//        this.makeBedrock(chunk, sharedseedrandom);
//    }
//
//    /*
//     * Needed Ports
//     */
//
//    protected abstract double[] getColumnBiomeParams(int xn, int zn);
//
//    protected abstract double getHeightThreshold(double param1, double param2, int y);
//
//    protected void makeBedrock(IChunk chunkIn, Random rand) {
//        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
//        int i = chunkIn.getPos().getXStart();
//        int j = chunkIn.getPos().getZStart();
//        T t = this.getSettings();
//        int k = t.getBedrockFloorHeight();
//        int l = t.getBedrockRoofHeight();
//        Iterator var9 = BlockPos.getAllInBoxMutable(i, 0, j, i + 15, 0, j + 15).iterator();
//
//        while (true) {
//            BlockPos blockpos;
//            int j1;
//            do {
//                if (!var9.hasNext()) {
//                    return;
//                }
//
//                blockpos = (BlockPos) var9.next();
//                if (l > 0) {
//                    for (j1 = l; j1 >= l - 4; --j1) {
//                        if (j1 >= l - rand.nextInt(5)) {
//                            chunkIn.setBlockState(blockpos$mutable.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
//                        }
//                    }
//                }
//            } while (k >= 256);
//
//            for (j1 = k + 4; j1 >= k; --j1) {
//                if (j1 <= k + rand.nextInt(5)) {
//                    chunkIn.setBlockState(blockpos$mutable.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
//                }
//            }
//        }
//    }
//
//    // Used in structure generation
//    private static double func_222556_a(int p_222556_0_, int p_222556_1_, int p_222556_2_) {
//        int i = p_222556_0_ + 12;
//        int j = p_222556_1_ + 12;
//        int k = p_222556_2_ + 12;
//        return i >= 0 && i < 24 ? (j >= 0 && j < 24 ? (k >= 0 && k < 24 ? (double) field_222561_h[k * 24 * 24 + i * 24 + j] : 0.0D) : 0.0D) : 0.0D;
//    }
//
//    // Used in pregenerating a table for the above, which is used in structure generation
//    private static double func_222554_b(int p_222554_0_, int p_222554_1_, int p_222554_2_) {
//        double d0 = p_222554_0_ * p_222554_0_ + p_222554_2_ * p_222554_2_;
//        double d1 = (double) p_222554_1_ + 0.5D;
//        double d2 = d1 * d1;
//        double d3 = Math.pow(2.718281828459045D, -(d2 / 16.0D + d0 / 16.0D));
//        double d4 = -d1 * MathHelper.fastInvSqrt(d2 / 2.0D + d0 / 2.0D) / 2.0D;
//        return d4 * d3;
//    }
//
//    static {
//        AIR = Blocks.AIR.getDefaultState();
//    }
//}