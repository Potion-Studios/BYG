package potionstudios.byg.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;

import java.io.IOException;

public class BYGAssetsProvider extends BlockModelProvider {
    private final ItemProvider item;
    public BYGAssetsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BYG.MOD_ID, existingFileHelper);
        this.item = new ItemProvider(generator, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        for (final var type : BYGWoodTypes.values()) {
            final var log = cubeColumn(type.log().getId().getPath(), BYG.createLocation("block/" + type + "/log"), BYG.createLocation("block/" + type + "/log_top"));
            item.withExistingParent(type.log().getId().getPath(), log.getLocation())
                .transforms()
                .transform(ModelBuilder.Perspective.THIRDPERSON_LEFT)
                .rotation(10, -45, 170)
                .translation(0, 1.5f, -2.75f)
                .scale(0.375f, 0.375f, 0.375f)
                .end()
                .transform(ModelBuilder.Perspective.THIRDPERSON_RIGHT)
                .rotation(10, -45, 170)
                .translation(0, 1.5f, -2.75f)
                .scale(0.375f, 0.375f, 0.375f)
                .end()
                .end();
        }
    }

    public ItemModelBuilder item(String path) {
        return item.getBuilder(path);
    }

    @Override
    public void run(HashCache cache) throws IOException {
        super.run(cache);
        item.generateAll(cache);
    }

    private static final class ItemProvider extends ItemModelProvider {

        public ItemProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, BYG.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerModels() {

        }

        @Override
        public void generateAll(HashCache cache) {
            super.generateAll(cache);
        }
    }
}
