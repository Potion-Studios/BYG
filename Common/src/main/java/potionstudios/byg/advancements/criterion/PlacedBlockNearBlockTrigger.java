package potionstudios.byg.advancements.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SerializationContext;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;

public class PlacedBlockNearBlockTrigger {

    static final ResourceLocation ID = BYG.createLocation("placed_block_near");

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {

        public TriggerInstance(ResourceLocation $$0, EntityPredicate.Composite $$1) {
            super($$0, $$1);
        }

        @Override
        public @NotNull JsonObject serializeToJson(@NotNull SerializationContext ctx) {
            return super.serializeToJson(ctx);
        }
    }
}
