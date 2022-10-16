package potionstudios.byg.mixin.access;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TreeDecoratorType.class)
public interface TreeDecoratorTypeAccess {


    @Invoker("<init>")
    static <P extends TreeDecorator> TreeDecoratorType<P> byg_create(Codec<P> codec) {
        throw new Error("Mixin did not apply!");
    }
}
