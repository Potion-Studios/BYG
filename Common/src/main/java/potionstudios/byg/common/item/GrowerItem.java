package potionstudios.byg.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.client.util.BYGClientUtil;
import potionstudios.byg.common.block.sapling.GrowingPatterns;
import potionstudios.byg.util.FeatureGrowerFromBlockPattern;

import java.util.List;
import java.util.Map;

public class GrowerItem extends BlockItem {

    public GrowerItem(FeatureGrowerFromBlockPattern block, Properties properties) {
        super((Block) block, properties);
    }

    public GrowerItem(Block block, Properties properties) {
        super(block, properties);
        if (!(block instanceof FeatureGrowerFromBlockPattern)) {
            throw new IllegalArgumentException("Block must be an instance of FeatureGrowerFromBlock!");
        }
    }

    @Override
    public void appendHoverText(ItemStack $$0, @Nullable Level $$1, List<Component> components, TooltipFlag $$3) {
        super.appendHoverText($$0, $$1, components, $$3);

        Map<ResourceLocation, List<GrowingPatterns.GrowingPatternEntry>> patterns = GrowingPatterns.getConfig().patternsForBlock();
        ResourceLocation blockKey = Registry.BLOCK.getKey(this.getBlock());
        if (patterns.containsKey(blockKey)) {
            Minecraft mc = Minecraft.getInstance();
            KeyMapping keyShift = mc.options.keyShift;
            if (BYGClientUtil.isKeyOrMouseButtonDown(mc, keyShift)) {
                components.add(Component.translatable("byg.saplingpattern.tooltip"));

                List<GrowingPatterns.GrowingPatternEntry> patternEntries = patterns.get(blockKey);
                for (int i = 0; i < patternEntries.size(); i++) {
                    GrowingPatterns.GrowingPatternEntry growingPatternEntry = patternEntries.get(i);
                    for (String s : growingPatternEntry.pattern()) {
                        Component textComponent = Component.literal(s.replace(" ", "-"));
                        components.add(textComponent);
                    }
                    if (i < patternEntries.size() - 1) {
                        components.add(Component.literal(""));
                    }
                }
            } else {
                components.add(Component.translatable("byg.saplingpattern.suggest.hold.shift", keyShift.getTranslatedKeyMessage()).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
            }
        }
    }
}