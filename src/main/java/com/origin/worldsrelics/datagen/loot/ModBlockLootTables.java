package com.origin.worldsrelics.datagen.loot;

import com.origin.worldsrelics.block.ModBlocks;
import com.origin.worldsrelics.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PRIMAL_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.PRIMAL_STONE_TILES.get());
        this.dropSelf(ModBlocks.CRACKED_PRIMAL_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_PRIMAL_STONE_TILES.get());
        this.dropSelf(ModBlocks.POLISHED_PRIMAL_STONE.get());

        this.add(ModBlocks.PRIMAL_STONE.get(),
                block -> createPrimalStoneDrops(ModBlocks.PRIMAL_STONE.get(), ModItems.PRIMAL_ROCK.get()));
    }

    protected LootTable.Builder createPrimalStoneDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
