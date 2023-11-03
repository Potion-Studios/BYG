package potionstudios.byg.common.registration;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockProperties;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.FruitBlock;
import potionstudios.byg.common.item.BaobabFruitItem;
import potionstudios.byg.common.world.feature.features.end.BYGEndVegetationFeatures;
import potionstudios.byg.mixin.access.BlockSetTypeAccess;
import potionstudios.byg.mixin.access.SimpleParticleTypeAccess;
import potionstudios.byg.mixin.access.WoodTypeAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BYGBlockFamilies {

    public static Map<String, BYGBlockFamily> woodFamilyMap = new HashMap<>();
    public static Map<String, BYGBlockFamily> blockFamilyMap = new HashMap<>();

    public static BYGBlockFamily ASPEN = register(new BYGBlockFamily.WoodBuilder("aspen",
            getOverworldWoodType("aspen"), () -> MapColor.TERRACOTTA_YELLOW, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "aspen_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily BAOBAB = register(new BYGBlockFamily.WoodBuilder("baobab",
            getOverworldWoodType("baobab"), () -> MapColor.TERRACOTTA_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .fruit("baobab_fruit_block", "baobab_fruit", "ripe_baobab_leaves",
                    (block) -> new BaobabFruitItem(block,
                            new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                                    .saturationMod(0.5f).alwaysEat().build())))
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "baobab_sapling")
            .hangingSign()
            .leaves((id, family) -> BYGBlocks.createFruitLeaves(MapColor.COLOR_GREEN,
                    () -> family.get(BYGBlockFamily.BlockVariant.FRUIT_BLOCK).defaultBlockState()
                            .setValue(FruitBlock.AGE, 0), id, 0.01F))
            .floweringLeaves((s, family) -> BYGBlocks.createChangingLeaves(MapColor.COLOR_GREEN,
                    () -> (LeavesBlock) family.get(BYGBlockFamily.BlockVariant.FRUIT_LEAVES),
                    0.02F, "flowering_baobab_leaves"))
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily BLUE_ENCHANTED = register(new BYGBlockFamily.WoodBuilder("blue_enchanted",
            getOverworldWoodType("blue_enchanted"), () -> MapColor.COLOR_BLUE, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "blue_enchanted_sapling")
            .hangingSign()
            .imbuedLog()
            .leaves((id, family) -> BYGBlocks.createGlowingLeaves(MapColor.COLOR_GREEN, 15, id))
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .strippables((consumer, family) -> consumer.accept(family.get(BYGBlockFamily.BlockVariant.IMBUED_LOG),
                    family.get(BYGBlockFamily.BlockVariant.LOG)))
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily CIKA = register(new BYGBlockFamily.WoodBuilder("cika",
            getOverworldWoodType("cika"), () -> MapColor.TERRACOTTA_ORANGE, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "cika_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily CYPRESS = register(new BYGBlockFamily.WoodBuilder("cypress",
            getOverworldWoodType("cypress"), () -> MapColor.TERRACOTTA_LIGHT_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "cypress_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily EBONY = register(new BYGBlockFamily.WoodBuilder("ebony",
            getOverworldWoodType("ebony"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "ebony_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily FIR = register(new BYGBlockFamily.WoodBuilder("fir",
            getOverworldWoodType("fir"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "fir_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily GREEN_ENCHANTED = register(new BYGBlockFamily.WoodBuilder("green_enchanted",
            getOverworldWoodType("green_enchanted"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "green_enchanted_sapling")
            .hangingSign()
            .imbuedLog()
            .leaves((id, family) -> BYGBlocks.createGlowingLeaves(MapColor.COLOR_GREEN, 15, id))
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .strippables((consumer, family) -> consumer.accept(family.get(BYGBlockFamily.BlockVariant.IMBUED_LOG),
                    family.get(BYGBlockFamily.BlockVariant.LOG)))
            .trapdoor()
            .wood()
    );


    public static BYGBlockFamily HOLLY = register(new BYGBlockFamily.WoodBuilder("holly",
            getOverworldWoodType("holly"), () -> MapColor.TERRACOTTA_GREEN,BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "holly_sapling")
            .hangingSign()
            .leaves()
            .floweringLeaves((id, family) -> BYGBlocks.createLeaves(MapColor.TERRACOTTA_GREEN, "holly_berry_leaves"))
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily JOSHUA = register(new BYGBlockFamily.WoodBuilder("joshua",
            getOverworldWoodType("joshua"), ()-> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .fruit("joshua_fruit_block", "joshua_fruit", "ripe_joshua_leaves",
                    (block) -> new Item(new Item.Properties()
                            .food(new FoodProperties.Builder()
                                    .nutrition(2).saturationMod(0.35f).build())))
            .leaves()
            .floweringLeaves((s, family) -> BYGBlocks.createChangingLeaves(MapColor.COLOR_GREEN,
                    () -> (LeavesBlock) family.get(BYGBlockFamily.BlockVariant.FRUIT_LEAVES),
                    0.02F, "flowering_joshua_leaves"))
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "joshua_sapling")
            .processedFood("cooked_joshua_fruit", () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(5)
                            .saturationMod(0.4f).build())))
    );

    public static BYGBlockFamily NIGHTSHADE = register(new BYGBlockFamily.WoodBuilder("nightshade",
            getOverworldWoodType("nightshade"), () -> MapColor.COLOR_ORANGE, BuiltinDimensionTypes.END
            , true)
            .bookshelf()
            .bush(() -> BYGBlocks.createNightshadeBerryBush("nightshade_berry_bush"),
                    "nightshade_berries",
                    (block) -> new ItemNameBlockItem(block,
                            new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                                    .saturationMod(0.4f).build())))
            .button()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .floweringLeaves((s, family) -> BYGBlocks
                            .createGlowingLeaves(MapColor.COLOR_ORANGE, 15, "flowering_nightshade_leaves"))
            .growerItem(BYGBlockFamily.BlockTags.END_PLANT, "nightshade_sapling")
            .hangingSign()
            .imbuedLog()
            .leaves()
            .log()
            .pressurePlate()
            .processedFood("nightshade_berry_pie",
                    () -> new Item(new Item.Properties()
                            .food(new FoodProperties.Builder().nutrition(6)
                                    .saturationMod(0.3f)
                                    .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F)
                                    .build())))
            .roots(() -> BYGBlocks.createTallNightshadePlant("nightshade_roots"))
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .strippables((consumer, family) -> consumer.accept(family.get(BYGBlockFamily.BlockVariant.IMBUED_LOG),
                    family.get(BYGBlockFamily.BlockVariant.LOG)))
            .sprouts(() -> BYGBlocks.createNightshadePlant("nightshade_sprouts"))
            .trapdoor()
            .wood()
    ).spreadable(BYGBlockFamily.SpreadableTypes.STONE, () -> Blocks.END_STONE,
            MapColor.COLOR_BLUE, () -> BYGEndVegetationFeatures.NIGHTSHADE_PLANTS,
            "nightshade_phylium");

    public static BYGBlockFamily ORCHARD = register(new BYGBlockFamily.WoodBuilder("orchard",
            getOverworldWoodType("orchard"), ()-> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , false)
            .fruit("apple_fruit_block", "", "ripe_orchard_leaves",
                    null)
            .leaves()
            .floweringLeaves((s, family) -> BYGBlocks.createChangingLeaves(MapColor.COLOR_GREEN,
                    () -> (LeavesBlock) family.get(BYGBlockFamily.BlockVariant.FRUIT_LEAVES),
                    0.02F, "flowering_orchard_leaves"))
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "orchard_sapling")
    );

    public static BYGBlockFamily PALM = register(new BYGBlockFamily.WoodBuilder("palm",
            getOverworldWoodType("palm"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "palm_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily PINE = register(new BYGBlockFamily.WoodBuilder("pine",
            getOverworldWoodType("pine"), () -> MapColor.TERRACOTTA_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "pine_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily ARAUCARIA = register(new BYGBlockFamily.WoodBuilder("araucaria",
            getOverworldWoodType("araucaria"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , false)
            .leaves()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "araucaria_sapling")
    );

    public static BYGBlockFamily RAINBOW_EUCALYPTUS = register(new BYGBlockFamily.WoodBuilder("rainbow_eucalyptus",
            getOverworldWoodType("rainbow_eucalyptus"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "rainbow_eucalyptus_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily REDWOOD = register(new BYGBlockFamily.WoodBuilder("redwood",
            getOverworldWoodType("redwood"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "redwood_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily SAKURA_CHERRY = register(new BYGBlockFamily.WoodBuilder("sakura_cherry",
            getOverworldWoodType("sakura_cherry"), () -> MapColor.COLOR_PINK, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .hangingSign()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily WHITE_SAKURA_CHERRY = register(new BYGBlockFamily.WoodBuilder("white_cherry",
            getOverworldWoodType("white_cherry"), () -> MapColor.COLOR_PINK, BuiltinDimensionTypes.OVERWORLD
            ,false)
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "white_cherry_sapling")
            .leafParticles(() -> SimpleParticleTypeAccess.byg_create(false), "white_cherry_blossom_leaves")
            .leaves((id, family) -> BYGBlocks.createLeaves(MapColor.COLOR_LIGHT_GRAY, () ->
                    family.get(BYGBlockFamily.ParticleVariant.LEAVES), id)
            )
            .foliage()
    );

    public static BYGBlockFamily SKYRIS = register(new BYGBlockFamily.WoodBuilder("skyris",
            getOverworldWoodType("skyris"), () -> MapColor.COLOR_PINK, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .fruit("green_apple_fruit_block", "green_apple", "green_apple_skyris_leaves",
                    (block) -> new BaobabFruitItem(block,
                            new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                                    .saturationMod(0.5f).alwaysEat().build())))
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "skyris_sapling")
            .hangingSign()
            .leaves()
            .floweringLeaves((s, family) -> BYGBlocks.createChangingLeaves(MapColor.COLOR_PINK,
                    () -> (LeavesBlock) family.get(BYGBlockFamily.BlockVariant.FRUIT_LEAVES),
                    0.02F, "flowering_skyris_leaves"))
            .log()
            .processedFood("green_apple_pie", () ->
                    new Item(new Item.Properties()
                            .food(new FoodProperties.Builder().nutrition(6)
                                    .saturationMod(0.4f)
                                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0), 1.0F)
                                    .build())))
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .vine(BYGBlockProperties.BYGSkyrisVine::new, "skyris_vine")
            .wood()
    );

    public static BYGBlockFamily WHITE_MANGROVE = register(new BYGBlockFamily.WoodBuilder("white_mangrove",
            getOverworldWoodType("white_mangrove"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "white_mangrove_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily ZELKOVA = register(new BYGBlockFamily.WoodBuilder("zelkova",
            getOverworldWoodType("zelkova"), () -> MapColor.TERRACOTTA_RED, BuiltinDimensionTypes.OVERWORLD
            , true)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "zelkova_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood()
    );

    public static BYGBlockFamily BROWN_ZELKOVA = register(new BYGBlockFamily.WoodBuilder("brown_zelkova",
            getOverworldWoodType("brown_zelkova"), () -> MapColor.COLOR_GREEN, BuiltinDimensionTypes.OVERWORLD
            , false)
            .leaves()
            .growerItem(BYGBlockFamily.BlockTags.PLANT, "brown_zelkova_sapling")
    );


    private static BYGBlockFamily register(BYGBlockFamily.WoodBuilder builder) {
        BYGBlockFamily bygBlockFamily = builder.build();
        woodFamilyMap.put(bygBlockFamily.getBaseName(), bygBlockFamily);
        return bygBlockFamily;
    }
    private static BYGBlockFamily register(BYGBlockFamily.Builder builder) {
        BYGBlockFamily bygBlockFamily = builder.build();
        blockFamilyMap.put(bygBlockFamily.getBaseName(), bygBlockFamily);
        return bygBlockFamily;
    }

    private static @NotNull WoodType getOverworldWoodType(String name){
        String id = BYG.createLocation(name).toString().replace(':', '/');
        WoodType woodType = WoodTypeAccess.byg_invokeRegister(new WoodType(id, new BlockSetType(id)));
        BlockSetTypeAccess.byg_invokeRegister(woodType.setType());
        return woodType;
    }

    private static @NotNull WoodType getNotOverworldWoodType(String name) {
        String id = BYG.createLocation(name).toString().replace(':', '/');
        WoodType woodType = new WoodType(id, new BlockSetType(id, true, SoundType.NETHER_WOOD,
                SoundEvents.NETHER_WOOD_DOOR_CLOSE, SoundEvents.NETHER_WOOD_DOOR_OPEN,
                SoundEvents.NETHER_WOOD_TRAPDOOR_CLOSE, SoundEvents.NETHER_WOOD_TRAPDOOR_OPEN,
                SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF,
                SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.NETHER_WOOD_BUTTON_CLICK_OFF,
                SoundEvents.NETHER_WOOD_BUTTON_CLICK_ON), SoundType.NETHER_WOOD,
                SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE,
                SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN);
        BlockSetTypeAccess.byg_invokeRegister(woodType.setType());
        return woodType;
    }

    private static BlockSetType getBlockSetType(@NotNull Supplier<? extends BlockSetType> supplier) {
        BlockSetType blockSetType = supplier.get();
        BlockSetTypeAccess.byg_invokeRegister(blockSetType);
        return blockSetType;
    }

    @SuppressWarnings("empty")
    public static void register() {

    }
}
