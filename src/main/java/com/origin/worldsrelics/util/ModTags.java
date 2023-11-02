package com.origin.worldsrelics.util;

import com.origin.worldsrelics.WorldsRelics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> WORLDS_RELICS_STONE = tag("worlds_relics_stone");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(WorldsRelics.MODID, name));
        }

    }
    public static class Items {
        public static final TagKey<Item> WORLDS_RELICS_RELIC = tag("worlds_relics_relic");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(WorldsRelics.MODID, name));
        }

    }
}
