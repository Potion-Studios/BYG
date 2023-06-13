package potionstudios.byg.common.world;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import potionstudios.byg.BYG;

import java.util.Map;

public class BYGDamageTypes {

    public static final Map<ResourceKey<DamageType>, DamageTypeFactory> DAMAGE_TYPE_FACTORIES = new Reference2ObjectOpenHashMap<>();


    public static final ResourceKey<DamageType> CATTAIL_EXPLOSION = register("cattail_explosion", damageTypeBootstapContext -> new DamageType("byg.cattail_campfire", DamageScaling.ALWAYS, 0.1F));

    private static ResourceKey<DamageType> register(String id, DamageTypeFactory factory) {
        ResourceKey<DamageType> damageTypeResourceKey = ResourceKey.create(Registries.DAMAGE_TYPE, BYG.createLocation(id));
        DAMAGE_TYPE_FACTORIES.put(damageTypeResourceKey, factory);
        return damageTypeResourceKey;
    }

    public static void loadClass() {}

    @FunctionalInterface
    public interface DamageTypeFactory {

        DamageType generate(BootstapContext<DamageType> damageTypeBootstapContext);
    }
}
