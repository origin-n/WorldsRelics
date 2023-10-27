package com.origin.worldsrelics.block;

import com.origin.worldsrelics.WorldsRelics;
import com.origin.worldsrelics.item.ModCreativeModeTab;
import com.origin.worldsrelics.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WorldsRelics.MODID);

    public static final RegistryObject<Block> PRIMAL_STONE = registerBlock("primal_stone",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops(),
                        UniformInt.of(1,4)),
                        ModCreativeModeTab.WORLDS_RELICS_TAB);

    public static final RegistryObject<Block> PRIMAL_STONE_BRICKS = registerBlock("primal_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()),
                        ModCreativeModeTab.WORLDS_RELICS_TAB);

    public static final RegistryObject<Block> CRACKED_PRIMAL_STONE_BRICKS = registerBlock("cracked_primal_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.WORLDS_RELICS_TAB);

    public static final RegistryObject<Block> PRIMAL_STONE_TILES = registerBlock("primal_stone_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.WORLDS_RELICS_TAB);

    public static final RegistryObject<Block> CRACKED_PRIMAL_STONE_TILES = registerBlock("cracked_primal_stone_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.WORLDS_RELICS_TAB);

    public static final RegistryObject<Block> POLISHED_PRIMAL_STONE = registerBlock("polished_primal_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.WORLDS_RELICS_TAB);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
