package voronoiaoc.byg.common.world.worldtype.layers.traits;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;

// Definitely not QuadParentedLayer
public interface Merge4Layers {
    default <R extends IArea> IAreaFactory<R> apply(IExtendedNoiseRandom<R> context, IAreaFactory<R> parent0, IAreaFactory<R> parent1, IAreaFactory<R> parent2, IAreaFactory<R> parent3) {
        return () -> {
            R sampler0 = parent0.make();
            R sampler1 = parent1.make();
            R sampler2 = parent2.make();
            R sampler3 = parent3.make();
            return context.func_212859_a_((x, z) -> {
                context.setPosition(x, z);
                return this.apply(context, sampler0, sampler1, sampler2, sampler3, x, z);
            }, sampler0);
        };
    }

    int apply(IExtendedNoiseRandom<?> rand, IArea sampler0, IArea sampler1, IArea sampler2, IArea sampler3, int x, int z);
}
