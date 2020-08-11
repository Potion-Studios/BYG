package voronoiaoc.byg;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.CommandSource;
import net.minecraft.util.Identifier;
import net.minecraft.util.WorldSavePath;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voronoiaoc.byg.common.properties.vanilla.BYGCompostables;
import voronoiaoc.byg.common.properties.vanilla.BYGFlammables;
import voronoiaoc.byg.common.properties.vanilla.BYGHoeables;
import voronoiaoc.byg.common.properties.vanilla.BYGStrippables;
import voronoiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeaturesInVanilla;
import voronoiaoc.byg.config.ConfigWeightManager;
import voronoiaoc.byg.core.byglists.BYGFeatureList;
import voronoiaoc.byg.core.byglists.BYGItemList;
import voronoiaoc.byg.core.registries.BYGBiomeRegistry;
import voronoiaoc.byg.core.registries.BYGBlockRegistry;
import voronoiaoc.byg.core.registries.BYGEntityRegistry;
import voronoiaoc.byg.core.registries.BYGItemRegistry;
import voronoiaoc.byg.data.BYGDataGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BYG implements ModInitializer {
    public static final String MODID = "byg";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup BYG_TAB = FabricItemGroupBuilder.build(new Identifier(MODID, "byg"), () -> new ItemStack(BYGItemList.BYG_LOGO));
    static int idx = 0;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing BYG...");
        ConfigWeightManager.weightConfigFile();
        //Registries
        BYGBlockRegistry.registerBlocks();
        BYGItemRegistry.registerItems();
        BYGFeatureList.RegisterFeatures.registerBYGFeatures();
        BYGBiomeRegistry.registerSubBiomes();
        BYGBiomeRegistry.registerBiomes();
        BYGBiomeRegistry.registerNetherBiomes();
        BYGBiomeRegistry.registerEndBiomes();
        BYGBiomeRegistry.addBiomeNumericalIDs();

        BYGEntityRegistry.registerEntities();

        //Misc
        BYGBiomeRegistry.addBeachesCategorically();
        BYGFeaturesInVanilla.addFeatures();

        BYGBiomeRegistry.addBYGBiomesToVanillaOverworld();

        //Block Settings
        BYGFlammables.flammablesBYG();
        BYGHoeables.effectiveBlocksBYG();
        BYGHoeables.tillablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCompostables.compostablesBYG();
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MODID, "byg_nether"), BYGNetherBiomeProvider.BYGNETHERCODEC);
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MODID, "byg_end"), BYGEndBiomeProvider.BYGENDCODEC);

//        BYGBiomeRegistry.biomeList.forEach(biome -> {
//            idx++;
//            System.out.println(idx + ". " + BuiltinRegistries.BIOME.getId(biome).toString().replace("_", "").replace("byg:", ""));
//
//        });

//        try {
//            BYGDataGenerator.dataGenBiome("D:\\Coding\\BiomeJson");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<String> modIdList = new ArrayList<>();
        FabricLoader.getInstance().getAllMods().forEach(modContainer -> {
            String modId = modContainer.getMetadata().getId();
            if (!modId.contains("fabric"))
                modIdList.add(modId);
        });



        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("gendata").then(CommandManager.argument("modid", StringArgumentType.string()).suggests((ctx, sb) -> CommandSource.suggestMatching(modIdList.stream(), sb)).executes(cs -> {
                ResourcePackManager resourcePackManager = cs.getSource().getMinecraftServer().getDataPackManager();

                try {
                    BYGDataGenerator.dataGenBiome(cs.getSource().getWorld().getServer().getSavePath(WorldSavePath.DATAPACKS).toString(),cs.getArgument("modid", String.class));
                } catch (IOException e) {
                    BYG.LOGGER.error("REEEEEEEEEEEEEEEEE");
                }
                return 1;
            })));
        });
        LOGGER.info("Initialized BYG!");
    }
}
