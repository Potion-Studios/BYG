package potionstudios.byg.datagen.util;

import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraftforge.common.data.ExistingFileHelper;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.mixin.access.StructureTemplateAccess;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class StructureTemplateUtil {

    public static final Map<String, Set<Block>> TO_KEEP = Util.make(new LinkedHashMap<>(), map -> {
        map.put("ancient/ancient_sequoia", Set.of(BYGWoodTypes.REDWOOD.log().get(), Blocks.RED_WOOL, Blocks.YELLOW_WOOL, Blocks.WHITE_WOOL));

        for (int i = 1; i <= 6; i++) {
            map.put("skyris/skyris_canopy_" + i, Set.of(BYGWoodTypes.SKYRIS.log().get(), BYGWoodTypes.SKYRIS.leaves().get(), Blocks.RED_WOOL, Blocks.YELLOW_WOOL, Blocks.WHITE_WOOL));
            map.put("skyris/skyris_trunk_" + i, Set.of(BYGWoodTypes.SKYRIS.log().get(), Blocks.RED_WOOL, Blocks.YELLOW_WOOL, Blocks.WHITE_WOOL));
        }

        for (int i = 1; i <= 5; i++) {
            map.put("witch-hazel/witch-hazel_canopy_" + i, Set.of(BYGWoodTypes.WITCH_HAZEL.log().get(), BYGWoodTypes.WITCH_HAZEL.leaves().get(), Blocks.RED_WOOL, Blocks.YELLOW_WOOL, Blocks.WHITE_WOOL));
            map.put("witch-hazel/witch-hazel_trunk_" + i, Set.of(BYGWoodTypes.WITCH_HAZEL.log().get(), Blocks.RED_WOOL, Blocks.YELLOW_WOOL, Blocks.WHITE_WOOL));
        }

        for (int i = 1; i <= 4; i++) {
            map.put("jacaranda/jacaranda_canopy_" + i, Set.of(BYGWoodTypes.JACARANDA.log().get(), BYGWoodTypes.JACARANDA.leaves().get(), Blocks.RED_WOOL, Blocks.YELLOW_WOOL, Blocks.WHITE_WOOL));
            map.put("jacaranda/jacaranda_trunk_" + i, Set.of(BYGWoodTypes.JACARANDA.log().get(), Blocks.RED_WOOL, Blocks.YELLOW_WOOL, Blocks.WHITE_WOOL));
        }
    });


    public static void removeBlocks(ExistingFileHelper existingFileHelper) {
        removeBlocks(TO_KEEP, existingFileHelper);
    }

    public static void removeBlocks(Map<String, Set<Block>> toKeep, ExistingFileHelper existingFileHelper) {
        toKeep.forEach((structure, blocks) -> {

            String target = "structures/features/trees/%s.nbt".formatted(structure);
            try (final InputStream inputStream = existingFileHelper.getResource(new ResourceLocation("byg", target), PackType.SERVER_DATA).open()) {

                CompoundTag compoundTag = null;
                if (inputStream != null) {
                    CompoundTag read = NbtIo.read(new DataInputStream(new GZIPInputStream(inputStream)));
                    StructureTemplate structureTemplate = new StructureTemplate();
                    structureTemplate.load(read);


                    int minX = Integer.MAX_VALUE;
                    int minY = Integer.MAX_VALUE;
                    int minZ = Integer.MAX_VALUE;
                    int maxX = Integer.MIN_VALUE;
                    int maxY = Integer.MIN_VALUE;
                    int maxZ = Integer.MIN_VALUE;

                    for (StructureTemplate.Palette byg_getPalette : ((StructureTemplateAccess) structureTemplate).byg_getPalettes()) {
                        List<StructureTemplate.StructureBlockInfo> structureBlockInfos = byg_getPalette.blocks();
                        for (int i = 0; i < structureBlockInfos.size(); i++) {
                            StructureTemplate.StructureBlockInfo structureBlockInfo = structureBlockInfos.get(i);
                            if (!blocks.contains(structureBlockInfo.state.getBlock())) {
                                structureBlockInfos.remove(i);
                            } else {
                                minX = Math.min(structureBlockInfo.pos.getX(), minX);
                                minY = Math.min(structureBlockInfo.pos.getY(), minY);
                                minZ = Math.min(structureBlockInfo.pos.getZ(), minZ);

                                maxX = Math.max(structureBlockInfo.pos.getX(), maxX);
                                maxY = Math.max(structureBlockInfo.pos.getY(), maxY);
                                maxZ = Math.max(structureBlockInfo.pos.getZ(), maxZ);
                            }
                        }
                    }
                    compoundTag = new CompoundTag();
                    structureTemplate.setAuthor("AOCAWOL & Corgi Taco");
                    structureTemplate.save(compoundTag);
                    ListTag listtag = new ListTag();
                    listtag.add(IntTag.valueOf(maxX - minX));
                    listtag.add(IntTag.valueOf(maxY - minY));
                    listtag.add(IntTag.valueOf(maxZ - minZ));
                    compoundTag.put("size", listtag);

                    Path path = Paths.get(FileSystems.getDefault().getPath("").toAbsolutePath().getParent().getParent().toString(), "Common/src/main/resources/data/byg/structures/features/trees/%s.nbt".formatted(structure));
                    NbtIo.writeCompressed(compoundTag, path.toFile());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
