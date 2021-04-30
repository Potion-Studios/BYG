package corgiaoc.byg.data;

import corgiaoc.byg.BYG;
import corgiaoc.byg.data.providers.BYGBlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGDataGenerator {


    @SubscribeEvent
    public static void data(GatherDataEvent event) {
        event.getGenerator().addProvider(new BYGBlockTagsProvider(event.getGenerator(), event.getExistingFileHelper()));
    }

//    public static void main(String[] args) throws IOException {
//        Path generated = new File("generated").toPath();
//        DataGenerator bygGenerator = createBYGGenerator(generated, new HashSet<>(), true, true, true, true);
//        DatagenModLoader.begin(ImmutableSet.of(BYG.MOD_ID), generated, new HashSet<>(), new HashSet<>(), new HashSet<>(), true, true, true, true, true, true);
//        bygGenerator.run();
//    }
//
//
//    public static DataGenerator createBYGGenerator(Path path, Collection<Path> inputs, boolean includeClient, boolean includeServer, boolean includeDev, boolean includeReports) {
//        DataGenerator datagenerator = new DataGenerator(path, inputs);
//        if (includeClient || includeServer) {
//        }
//
//        if (includeClient) {
//        }
//
//        if (includeServer) {
//            BYGBlockTagsProvider blocktagsprovider = ;
//            datagenerator.addProvider(blocktagsprovider);
//        }
//
//        if (includeDev) {
//        }
//
//        if (includeReports) {
//        }
//
//        return datagenerator;
//    }
}
