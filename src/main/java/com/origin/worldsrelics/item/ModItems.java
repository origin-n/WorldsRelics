package com.origin.worldsrelics.item;

import com.origin.worldsrelics.WorldsRelics;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WorldsRelics.MODID);

    public static final RegistryObject<Item> PRIMAL_ROCK = ITEMS.register("primal_rock",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> CRACKED_PRIMAL_ROCK = ITEMS.register("cracked_primal_rock",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));


    public static final void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
