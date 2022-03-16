package potionstudios.byg.common.item;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.common.block.sapling.BYGSapling;
import potionstudios.byg.common.block.sapling.SaplingPatterns;
import potionstudios.byg.mixin.access.client.KeyMappingAccess;

import java.util.List;
import java.util.Map;

public class BYGSaplingItem extends BlockItem {


    public BYGSaplingItem(Block block, Properties properties) {
        super(block, properties);
        if (!(block instanceof BYGSapling)) {
            throw new IllegalArgumentException("Block must be an instance of BYGSapling!");
        }
    }

    @Override
    public void appendHoverText(ItemStack $$0, @Nullable Level $$1, List<Component> components, TooltipFlag $$3) {
        super.appendHoverText($$0, $$1, components, $$3);

        Map<ResourceLocation, List<SaplingPatterns.PatternEntry>> patterns = SaplingPatterns.getConfig().saplingPatterns();
        ResourceLocation blockKey = Registry.BLOCK.getKey(this.getBlock());
        if (patterns.containsKey(blockKey)) {
            Minecraft mc = Minecraft.getInstance();
            KeyMapping keyShift = mc.options.keyShift;
            if (InputConstants.isKeyDown(mc.getWindow().getWindow(), ((KeyMappingAccess) keyShift).byg_getKey().getValue())) {
                components.add(new TranslatableComponent("byg.saplingpattern.tooltip"));

                List<SaplingPatterns.PatternEntry> patternEntries = patterns.get(blockKey);
                for (int i = 0; i < patternEntries.size(); i++) {
                    SaplingPatterns.PatternEntry patternEntry = patternEntries.get(i);
                    for (String s : patternEntry.pattern()) {
                        Component textComponent = new TextComponent(s.replace(" ", "-"));
                        components.add(textComponent);
                    }
                    if (i < patternEntries.size() - 1) {
                        components.add(new TextComponent(""));
                    }
                }
            } else {
                components.add(new TranslatableComponent("byg.saplingpattern.suggest.hold.shift", keyShift.getTranslatedKeyMessage()).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
            }
        }

    }
}
