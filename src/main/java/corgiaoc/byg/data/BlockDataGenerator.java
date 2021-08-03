package corgiaoc.byg.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.mojang.datafixers.util.Pair;
import corgiaoc.byg.BYG;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Used to make recipes, loot tables, and the en_us lang file in bulk,
 */
@SuppressWarnings("deprecation")
public class BlockDataGenerator {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void makeBYGLangFile(String filePath) {
        List<String> blockIDList = new ArrayList<>();
        List<String> itemIDList = new ArrayList<>();
        List<String> biomeIDList = new ArrayList<>();

        for (Block block : Registry.BLOCK) {
            String blockID = Objects.requireNonNull(Registry.BLOCK.getKey(block)).toString();

            if (blockID.contains(BYG.MOD_ID))
                blockIDList.add(blockID.replace(BYG.MOD_ID + ":", ""));
        }

        for (Item item : Registry.ITEM) {
            String itemID = Objects.requireNonNull(Registry.ITEM.getKey(item)).toString();

            if (itemID.contains(BYG.MOD_ID))
                itemIDList.add(itemID.replace(BYG.MOD_ID + ":", ""));
        }


        for (Biome biome : WorldGenRegistries.BIOME) {
            String biomeID = Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(biome)).toString();

            if (biomeID.contains(BYG.MOD_ID))
                biomeIDList.add(biomeID.replace(BYG.MOD_ID + ":", ""));
        }

        BlockDataGenerator.createLangFile(filePath, BYG.MOD_ID, blockIDList, biomeIDList, itemIDList);
    }


    /**
     * @param langPath The absolute path of the file along with the file name. I.E: "D:\\Coding\\src\\main\\resources\\assets\\modid\\lang\\en_us.json"
     * @param modID    Your mod's ID.
     * @param idList   A string list with your blocks/items
     */
    public static void createLangFile(String langPath, String modID, List<String> idList, List<String> biomeIDs, List<String> itemIDs) {

        try {
            FileWriter fileWriter = new FileWriter(langPath);
            Gson prettyPrinting = new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(StringEscapeUtils.unescapeJava("{\n\""));

            for (String id : biomeIDs) {
                String biomePath = "\"biome." + modID + "." + id;

                String blockLangLine = biomePath + "\":\"" + WordUtils.capitalize(id.replace("_", " ")) + "\",\n";
                String blockTranslation = prettyPrinting.toJson(new JsonPrimitive(blockLangLine));
                blockTranslation = StringEscapeUtils.unescapeJava(blockTranslation);
                blockTranslation = StringEscapeUtils.unescapeJava(blockTranslation.replace("\"\"", ""));
                blockTranslation = blockTranslation.replace("{", "\",\n}");
                blockTranslation = blockTranslation.replace("\" \n\"\"}", "\",\n}");
                fileWriter.write(blockTranslation);
            }

            for (String id : idList) {
                String blockPath = "\"block." + modID + "." + id;

                String blockLangLine = blockPath + "\":\"" + WordUtils.capitalize(id.replace("_", " ")) + "\",\n";
                String blockTranslation = prettyPrinting.toJson(new JsonPrimitive(blockLangLine));
                blockTranslation = StringEscapeUtils.unescapeJava(blockTranslation);
                blockTranslation = StringEscapeUtils.unescapeJava(blockTranslation.replace("\"\"", ""));
                blockTranslation = blockTranslation.replace("{", "\",\n}");
                blockTranslation = blockTranslation.replace("\" \n\"\"}", "\",\n}");
                fileWriter.write(blockTranslation);
            }

            for (int idx = 0; idx < itemIDs.size(); idx++) {
                String id = itemIDs.get(idx);
                String itemPath = "\"item." + modID + "." + id;
                String itemLangLine = itemPath + "\":\"" + WordUtils.capitalize(id.replace("_", " ")) + "\",\n";
                if (idx == idList.size() - 1)
                    itemLangLine = itemPath + "\":\"" + WordUtils.capitalize(id.replace("_", " ")) + "\"\n";
                String itemTranslation = prettyPrinting.toJson(new JsonPrimitive(itemLangLine));
                itemTranslation = StringEscapeUtils.unescapeJava(itemTranslation);


                itemTranslation = StringEscapeUtils.unescapeJava(itemTranslation.replace("\"\"", ""));
                itemTranslation = itemTranslation.replace("{", "\",\n}");
                itemTranslation = itemTranslation.replace("\" \n\"\"}", "\",\n}");

                fileWriter.write(itemTranslation);
            }

            String endBracket = StringEscapeUtils.unescapeJava("}");

            fileWriter.write(endBracket);

            //close the writer
            fileWriter.close();

        } catch (IOException e) {
            LOGGER.error(modID + "'s en_us lang file failed to generate.");
        }
    }


    /**
     * These are the default wood items.
     */
    public static final String[] WOOD_TYPES = {"_stairs", "_slab", "_button", "_pressure_plate", "_planks", "_bookshelf", "_fence", "_fence_gate", "_trapdoor", "_craft_table", "_boat", "_sign"};


    public static void createWoodRecipeGenerator(String absolutePath, String modID, String woodID, boolean hasBoat, boolean hasCraftingTable, boolean hasSign) {
        List<String> woodTypes = new ArrayList<>();

        for (String woodType : WOOD_TYPES) {
            String modifiedID = woodID + woodType;
            if (modifiedID.contains("_boat")) {
                if (hasBoat)
                    woodTypes.add(modifiedID);
            } else if (modifiedID.contains("_crafting_table")) {
                if (hasCraftingTable)
                    woodTypes.add(modifiedID);
            } else if (modifiedID.contains("_sign")) {
                if (hasSign)
                    woodTypes.add(modifiedID);
            } else
                woodTypes.add(modifiedID);
        }

        createWoodRecipeGenerator(absolutePath, modID, woodTypes);
    }

    public static void generateAllStoneRecipes(String absolutePath, String modID, String stoneID) {
        createStoneRecipeGenerator(absolutePath, modID, stoneID);
        createStoneCutterGenerator(absolutePath, modID, stoneID);
    }


    public static final String[] STONE_TYPES = {"_wall", "_stairs", "_slab", "_button", "_pressure_plate"};

    public static void createStoneRecipeGenerator(String absolutePath, String modID, String stoneID) {
        List<String> stoneTypes = new ArrayList<>();

        for (String woodType : STONE_TYPES) {
            String modifiedID = stoneID + woodType;
            stoneTypes.add(modifiedID);
        }

        createStoneRecipeGenerator(absolutePath, modID, stoneTypes);
    }

    public static final String[] STONE_CUTTER_TYPES = {"_wall", "_stairs", "_slab"};

    public static void createStoneCutterGenerator(String absolutePath, String modID, String stoneID) {
        List<String> stoneTypes = new ArrayList<>();

        for (String woodType : STONE_CUTTER_TYPES) {
            String modifiedID = stoneID + woodType;
            stoneTypes.add(modifiedID);
        }

        createStoneCutterRecipes(absolutePath, modID, stoneTypes);
    }

    private static void createStoneRecipeGenerator(String absolutePath, String modID, List<String> idList) {
        List<Pair<String, String>> filterRecipeList = new ArrayList<>();

        String slab = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"stone_slab\",\n" +
                "  \"pattern\": [\n" +
                "    \"###\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 6\n" +
                "  }\n" +
                "}";

        String stairs = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"id\",\n" +
                "  \"pattern\": [\n" +
                "    \"#  \",\n" +
                "    \"## \",\n" +
                "    \"###\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 4\n" +
                "  }\n" +
                "}";

        String button = "{\n" +
                "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                "  \"group\": \"stone_button\",\n" +
                "  \"ingredients\": [\n" +
                "    {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "  }\n" +
                "}";

        String pressurePlate = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"stone_pressure_plate\",\n" +
                "  \"pattern\": [\n" +
                "    \"##\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "  }\n" +
                "}";

        String wall = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"pattern\": [\n" +
                "    \"###\",\n" +
                "    \"###\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "    \"count\": 6\n" +
                "  }\n" +
                "}";


        filterRecipeList.add(new Pair<>("_slab", slab));
        filterRecipeList.add(new Pair<>("_stairs", stairs));
        filterRecipeList.add(new Pair<>("_button", button));
        filterRecipeList.add(new Pair<>("_pressure_plate", pressurePlate));
        filterRecipeList.add(new Pair<>("_wall", wall));
        createCustomJsonRecipeGenerator(absolutePath, modID, idList, "key", "id", filterRecipeList, false);
    }

    /**
     * This is used to setup wood recipes w/ their respective filters.
     *
     * @param absolutePath The absolute file path to print the json files too.
     * @param modID        The mod ID.
     * @param idList       List of ID's.
     */
    private static void createWoodRecipeGenerator(String absolutePath, String modID, List<String> idList) {
        List<Pair<String, String>> filterRecipeList = new ArrayList<>();
        String plankRecipe = "{\n" +
                "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                "  \"group\": \"planks\",\n" +
                "  \"ingredients\": [\n" +
                "    {\n" +
                "      \"tag\": \"key\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 4\n" +
                "  }\n" +
                "}";

        String slab = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"wooden_slab\",\n" +
                "  \"pattern\": [\n" +
                "    \"###\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 6\n" +
                "  }\n" +
                "}";

        String stairs = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"id\",\n" +
                "  \"pattern\": [\n" +
                "    \"#  \",\n" +
                "    \"## \",\n" +
                "    \"###\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 4\n" +
                "  }\n" +
                "}";

        String bookShelf = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"pattern\": [\n" +
                "    \"###\",\n" +
                "    \"XXX\",\n" +
                "    \"###\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    },\n" +
                "    \"X\": {\n" +
                "      \"item\": \"minecraft:book\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "  }\n" +
                "}";

        String button = "{\n" +
                "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                "  \"group\": \"wooden_button\",\n" +
                "  \"ingredients\": [\n" +
                "    {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "  }\n" +
                "}";

        String pressurePlate = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"wooden_pressure_plate\",\n" +
                "  \"pattern\": [\n" +
                "    \"##\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "  }\n" +
                "}";

        String fence = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"wooden_fence\",\n" +
                "  \"pattern\": [\n" +
                "    \"W#W\",\n" +
                "    \"W#W\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"minecraft:stick\"\n" +
                "    },\n" +
                "    \"W\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 3\n" +
                "  }\n" +
                "}";

        String fenceGate = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"wooden_fence_gate\",\n" +
                "  \"pattern\": [\n" +
                "    \"#W#\",\n" +
                "    \"#W#\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"minecraft:stick\"\n" +
                "    },\n" +
                "    \"W\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "  }\n" +
                "}";

        String trapDoor = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"wooden_trapdoor\",\n" +
                "  \"pattern\": [\n" +
                "    \"###\",\n" +
                "    \"###\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 2\n" +
                "  }\n" +
                "}";

        String craftingTable = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"pattern\": [\n" +
                "    \"##\",\n" +
                "    \"##\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "  }\n" +
                "}";

        String boat = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"boat\",\n" +
                "  \"pattern\": [\n" +
                "    \"# #\",\n" +
                "    \"###\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\"\n" +
                "  }\n" +
                "}";

        String door = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"wooden_door\",\n" +
                "  \"pattern\": [\n" +
                "    \"##\",\n" +
                "    \"##\",\n" +
                "    \"##\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 3\n" +
                "  }\n" +
                "}";

        String sign = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"sign\",\n" +
                "  \"pattern\": [\n" +
                "    \"###\",\n" +
                "    \"###\",\n" +
                "    \" X \"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    },\n" +
                "    \"X\": {\n" +
                "      \"item\": \"minecraft:stick\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 3\n" +
                "  }\n" +
                "}";

        String wood = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"group\": \"bark\",\n" +
                "  \"pattern\": [\n" +
                "    \"##\",\n" +
                "    \"##\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"#\": {\n" +
                "      \"item\": \"key\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"id\",\n" +
                "    \"count\": 3\n" +
                "  }\n" +
                "}";

        filterRecipeList.add(new Pair<>("_planks", plankRecipe));
        filterRecipeList.add(new Pair<>("_wood", wood));
        filterRecipeList.add(new Pair<>("_slab", slab));
        filterRecipeList.add(new Pair<>("_stairs", stairs));
        filterRecipeList.add(new Pair<>("_bookshelf", bookShelf));
        filterRecipeList.add(new Pair<>("_button", button));
        filterRecipeList.add(new Pair<>("_pressure_plate", pressurePlate));
        filterRecipeList.add(new Pair<>("_fence", fence));
        filterRecipeList.add(new Pair<>("_fence_gate", fenceGate));
        filterRecipeList.add(new Pair<>("_trapdoor", trapDoor));
        filterRecipeList.add(new Pair<>("_crafting_table", craftingTable));
        filterRecipeList.add(new Pair<>("_boat", boat));
        filterRecipeList.add(new Pair<>("_door", door));
        filterRecipeList.add(new Pair<>("_sign", sign));
        createCustomJsonRecipeGenerator(absolutePath, modID, idList, "key", "id", filterRecipeList, true);
    }

    private static void createStoneCutterRecipes(String absolutePath, String modID, List<String> idList) {
        List<Triple<String, String, String>> filterRecipeList = new ArrayList<>();
        String recipe = "{\n" +
                "  \"type\": \"minecraft:stonecutting\",\n" +
                "  \"ingredient\": {\n" +
                "    \"item\": \"key\"\n" +
                "  },\n" +
                "  \"result\": \"id\",\n" +
                "  \"count\": resultcount\n" +
                "}";

        filterRecipeList.add(new Triple<>("_stairs", "1", recipe));
        filterRecipeList.add(new Triple<>("_slab", "2", recipe));
        filterRecipeList.add(new Triple<>("_wall", "1", recipe));

        createStoneCutterRecipeGenerator(absolutePath, modID, idList, "key", "id", "resultcount", filterRecipeList);
    }

    public static void createOreRecipe(String absolutePath, String modID, List<String> idList, OreType oreType, String ingot) {
        String recipe = oreType.getRecipe();
        createCustomOreJsonLootTableGenerator(absolutePath, modID, idList, "key", "id", recipe, ingot);
    }


    /**
     * @param absolutePath     The absolute file path to print the json files too.
     * @param modID            The mod ID.
     * @param replaceInKey     This is the text that should be replaced in the recipe's ingredient. Typically in a recipe we use "key" as the replacement text.
     * @param replaceInResult  This is the text that should be replaced in the recipe's result. Typically in a recipe we use "id" as the replacement text.
     * @param filterRecipeList This a list of net.minecraft.util.Pair<String, String> with the left being the filter and the right being the recipe for the filter.
     * @param isWood           This is used to make modifications to the ingredients to properly output json for wood types.
     */
    public static void createCustomJsonRecipeGenerator(String absolutePath, String modID, List<String> idList, String replaceInKey, String replaceInResult, List<Pair<String, String>> filterRecipeList, boolean isWood) {
        idList.forEach(id -> {
            for (Pair<String, String> pair : filterRecipeList) {
                String filter = pair.getFirst();
                String recipe = pair.getSecond();

                if (isWood) {
                    if (filter.equals("_planks"))
                        recipe = recipe.replace(replaceInKey, modID + ":" + id.replace(filter, "_log"));
                    else
                        recipe = recipe.replace(replaceInKey, modID + ":" + id.replace(filter, "_planks"));
                } else
                    recipe = recipe.replace(replaceInKey, modID + ":" + id);

                recipe = recipe.replace(replaceInResult, modID + ":" + id);


                if (id.contains(filter)) {
                    String path = absolutePath + "\\" + id + ".json";
                    try {
                        FileWriter fileWriter = new FileWriter(path);
                        Gson prettyPrinting = new GsonBuilder().setPrettyPrinting().create();
                        String string = prettyPrinting.toJson(new JsonPrimitive(recipe));
                        string = StringEscapeUtils.unescapeJava(string);
                        string = string.replace("\"{", "{");
                        string = string.replace("}\"", "}");
                        fileWriter.write(string);

                        fileWriter.close();

                    } catch (IOException e) {
                        LOGGER.error("File failed at: " + path);
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void createCustomJsonRecipeGenerator(String absolutePath, String modID, List<String> idList, String replaceInKey, String replaceInResult, String replaceCount, List<Triple<String, String, String>> filterRecipeList) {
        idList.forEach(id -> {
            for (Triple<String, String, String> pair : filterRecipeList) {
                String filter = pair.getLeft();
                String count = pair.getMiddle();
                String recipe = pair.getMiddle();

                recipe = recipe.replace(replaceInKey, modID + ":" + id);

                recipe = recipe.replace(replaceInResult, id);
                recipe = recipe.replace(replaceCount, count);


                if (id.contains(filter)) {
                    String path = absolutePath + "\\" + id + ".json";
                    try {
                        FileWriter fileWriter = new FileWriter(path);
                        Gson prettyPrinting = new GsonBuilder().setPrettyPrinting().create();
                        String string = prettyPrinting.toJson(new JsonPrimitive(recipe));
                        string = StringEscapeUtils.unescapeJava(string);
                        string = string.replace("\"{", "{");
                        string = string.replace("}\"", "}");
                        fileWriter.write(string);

                        fileWriter.close();

                    } catch (IOException e) {
                        LOGGER.error("File failed at: " + path);
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void createCustomOreJsonLootTableGenerator(String absolutePath, String modID, List<String> idList, String replaceInKey, String replaceInResult, String recipe, String ingot) {
        idList.forEach(id -> {
            String modifiableRecipe = recipe;
            modifiableRecipe = modifiableRecipe.replace(replaceInKey, modID + ":" + id);

            modifiableRecipe = modifiableRecipe.replace(replaceInResult, ingot);

            String path = absolutePath + "\\" + id + ".json";
            try {
                FileWriter fileWriter = new FileWriter(path);
                Gson prettyPrinting = new GsonBuilder().setPrettyPrinting().create();
                String string = prettyPrinting.toJson(new JsonPrimitive(modifiableRecipe));
                string = StringEscapeUtils.unescapeJava(string);
                string = string.replace("\"{", "{");
                string = string.replace("}\"", "}");
                fileWriter.write(string);

                fileWriter.close();

            } catch (IOException e) {
                LOGGER.error("File failed at: " + path);
                e.printStackTrace();
            }
        });
    }


    public static void createCustomJsonRecipeGenerator(String absolutePath, String modID, List<String> idList, String replaceInKey, String replaceInResult, String replaceCount, String filter, String recipe, String count) {
        idList.forEach(id -> {
            String modifiableRecipe = recipe;
            modifiableRecipe = modifiableRecipe.replace(replaceInKey, modID + ":" + id);

            modifiableRecipe = modifiableRecipe.replace(replaceInResult, id);
            modifiableRecipe = modifiableRecipe.replace(replaceCount, count);

            if (id.contains(filter)) {
                String path = absolutePath + "\\" + id + ".json";
                try {
                    FileWriter fileWriter = new FileWriter(path);
                    Gson prettyPrinting = new GsonBuilder().setPrettyPrinting().create();
                    String string = prettyPrinting.toJson(new JsonPrimitive(modifiableRecipe));
                    string = StringEscapeUtils.unescapeJava(string);
                    string = string.replace("\"{", "{");
                    string = string.replace("}\"", "}");
                    fileWriter.write(string);

                    fileWriter.close();

                } catch (IOException e) {
                    LOGGER.error("File failed at: " + path);
                    e.printStackTrace();
                }
            }
        });
    }

    public static void createStoneCutterRecipeGenerator(String absolutePath, String modID, List<String> idList, String replaceInKey, String replaceInResult, String replaceCount, List<Triple<String, String, String>> filterRecipeList) {
        idList.forEach(id -> {
            for (Triple<String, String, String> pair : filterRecipeList) {
                String filter = pair.getLeft();
                String count = pair.getMiddle();
                String recipe = pair.getRight();

                recipe = recipe.replace(replaceInKey, modID + ":" + id);

                recipe = recipe.replace(replaceInResult, id);
                recipe = recipe.replace(replaceCount, count);


                if (id.contains(filter)) {
                    String path = absolutePath + "\\" + id + "_from_" + id.replace(filter, "_") + "stonecutting.json";
                    try {
                        FileWriter fileWriter = new FileWriter(path);
                        Gson prettyPrinting = new GsonBuilder().setPrettyPrinting().create();
                        String string = prettyPrinting.toJson(new JsonPrimitive(recipe));
                        string = StringEscapeUtils.unescapeJava(string);
                        string = string.replace("\"{", "{");
                        string = string.replace("}\"", "}");
                        fileWriter.write(string);

                        fileWriter.close();

                    } catch (IOException e) {
                        LOGGER.error("File failed at: " + path);
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    public enum OreType {
        COAL("{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": 1,\n" +
                "      \"entries\": [\n" +
                "        {\n" +
                "          \"type\": \"minecraft:alternatives\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"conditions\": [\n" +
                "                {\n" +
                "                  \"condition\": \"minecraft:match_tool\",\n" +
                "                  \"predicate\": {\n" +
                "                    \"enchantments\": [\n" +
                "                      {\n" +
                "                        \"enchantment\": \"minecraft:silk_touch\",\n" +
                "                        \"levels\": {\n" +
                "                          \"min\": 1\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"key\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"functions\": [\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:apply_bonus\",\n" +
                "                  \"enchantment\": \"minecraft:fortune\",\n" +
                "                  \"formula\": \"minecraft:ore_drops\"\n" +
                "                },\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:explosion_decay\"\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"id\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}"),
        LAPIS("{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": 1,\n" +
                "      \"entries\": [\n" +
                "        {\n" +
                "          \"type\": \"minecraft:alternatives\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"conditions\": [\n" +
                "                {\n" +
                "                  \"condition\": \"minecraft:match_tool\",\n" +
                "                  \"predicate\": {\n" +
                "                    \"enchantments\": [\n" +
                "                      {\n" +
                "                        \"enchantment\": \"minecraft:silk_touch\",\n" +
                "                        \"levels\": {\n" +
                "                          \"min\": 1\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"key\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"functions\": [\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:set_count\",\n" +
                "                  \"count\": {\n" +
                "                    \"min\": 4.0,\n" +
                "                    \"max\": 9.0,\n" +
                "                    \"type\": \"minecraft:uniform\"\n" +
                "                  }\n" +
                "                },\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:apply_bonus\",\n" +
                "                  \"enchantment\": \"minecraft:fortune\",\n" +
                "                  \"formula\": \"minecraft:ore_drops\"\n" +
                "                },\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:explosion_decay\"\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"id\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}"),
        REDSTONE("{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": 1,\n" +
                "      \"entries\": [\n" +
                "        {\n" +
                "          \"type\": \"minecraft:alternatives\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"conditions\": [\n" +
                "                {\n" +
                "                  \"condition\": \"minecraft:match_tool\",\n" +
                "                  \"predicate\": {\n" +
                "                    \"enchantments\": [\n" +
                "                      {\n" +
                "                        \"enchantment\": \"minecraft:silk_touch\",\n" +
                "                        \"levels\": {\n" +
                "                          \"min\": 1\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"key\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"functions\": [\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:set_count\",\n" +
                "                  \"count\": {\n" +
                "                    \"min\": 4.0,\n" +
                "                    \"max\": 5.0,\n" +
                "                    \"type\": \"minecraft:uniform\"\n" +
                "                  }\n" +
                "                },\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:apply_bonus\",\n" +
                "                  \"enchantment\": \"minecraft:fortune\",\n" +
                "                  \"formula\": \"minecraft:uniform_bonus_count\",\n" +
                "                  \"parameters\": {\n" +
                "                    \"bonusMultiplier\": 1\n" +
                "                  }\n" +
                "                },\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:explosion_decay\"\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"id\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}"),
        DIAMOND("{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": 1,\n" +
                "      \"entries\": [\n" +
                "        {\n" +
                "          \"type\": \"minecraft:alternatives\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"conditions\": [\n" +
                "                {\n" +
                "                  \"condition\": \"minecraft:match_tool\",\n" +
                "                  \"predicate\": {\n" +
                "                    \"enchantments\": [\n" +
                "                      {\n" +
                "                        \"enchantment\": \"minecraft:silk_touch\",\n" +
                "                        \"levels\": {\n" +
                "                          \"min\": 1\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"key\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"functions\": [\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:apply_bonus\",\n" +
                "                  \"enchantment\": \"minecraft:fortune\",\n" +
                "                  \"formula\": \"minecraft:ore_drops\"\n" +
                "                },\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:explosion_decay\"\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"id\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}"),
        EMERALD("{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": 1,\n" +
                "      \"entries\": [\n" +
                "        {\n" +
                "          \"type\": \"minecraft:alternatives\",\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"conditions\": [\n" +
                "                {\n" +
                "                  \"condition\": \"minecraft:match_tool\",\n" +
                "                  \"predicate\": {\n" +
                "                    \"enchantments\": [\n" +
                "                      {\n" +
                "                        \"enchantment\": \"minecraft:silk_touch\",\n" +
                "                        \"levels\": {\n" +
                "                          \"min\": 1\n" +
                "                        }\n" +
                "                      }\n" +
                "                    ]\n" +
                "                  }\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"key\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"minecraft:item\",\n" +
                "              \"functions\": [\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:apply_bonus\",\n" +
                "                  \"enchantment\": \"minecraft:fortune\",\n" +
                "                  \"formula\": \"minecraft:ore_drops\"\n" +
                "                },\n" +
                "                {\n" +
                "                  \"function\": \"minecraft:explosion_decay\"\n" +
                "                }\n" +
                "              ],\n" +
                "              \"name\": \"id\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}");

        private final String recipe;

        OreType(String recipe) {
            this.recipe = recipe;

        }

        public String getRecipe() {
            return recipe;
        }
    }


    public static class Triple<A, B, C> {
        private final A left;
        private final B middle;
        private final C right;

        public Triple(A left, B middle, C right) {
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        public A getLeft() {
            return this.left;
        }

        public B getMiddle() {
            return this.middle;
        }

        public C getRight() {
            return this.right;
        }

    }

}
