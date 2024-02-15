package potionstudios.byg.common.world.feature.gen.overworld.trees.decorators;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.TreeDecoratorTypeAccess;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

public class BYGTreeDecoratorTypes {

    public static final RegistrationProvider<TreeDecoratorType<?>> PROVIDER = RegistrationProvider.get(Registries.TREE_DECORATOR_TYPE, BYG.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<BYGTrunkVineDecorator>> TRUNK_VINE = register("trunk_vine", BYGTrunkVineDecorator.CODEC);
    public static final RegistryObject<TreeDecoratorType<BYGLeavesVineDecorator>> LEAVE_VINE = register("leave_vine", BYGLeavesVineDecorator.CODEC);
    public static final RegistryObject<TreeDecoratorType<AttachedToLogsDecorator>> ATTACHED_TO_LOGS = register("attached_to_logs", AttachedToLogsDecorator.CODEC);
    public static final RegistryObject<TreeDecoratorType<AttachedToFruitLeavesDecorator>> ATTACHED_TO_FRUIT_LEAVES = register("attached_to_fruit_leaves", AttachedToFruitLeavesDecorator.CODEC);

    private static <P extends TreeDecorator> RegistryObject<TreeDecoratorType<P>> register(String id, Codec<P> codec) {
        return PROVIDER.register(id, () -> TreeDecoratorTypeAccess.byg_create(codec));
    }

    public static void loadClass() {
    }
}
