package com.origin.worldsrelics.item;

import com.origin.worldsrelics.WorldsRelics;
import com.origin.worldsrelics.item.custom.RodOfDiscordItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import com.origin.worldsrelics.WorldsRelics;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WorldsRelics.MODID);

    public static final RegistryObject<Item> PRIMAL_ROCK = ITEMS.register("primal_rock",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRACKED_PRIMAL_ROCK = ITEMS.register("cracked_primal_rock",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROD_OF_DISCORD = ITEMS.register("rod_of_discord",
            () -> new RodOfDiscordItem(new Item.Properties().durability(1024)));


    public static final void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
