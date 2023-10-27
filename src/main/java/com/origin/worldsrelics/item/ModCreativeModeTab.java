package com.origin.worldsrelics.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab WORLDS_RELICS_TAB = new CreativeModeTab("WORLDS_RELICS") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PRIMAL_ROCK.get());
        }
    };
}
