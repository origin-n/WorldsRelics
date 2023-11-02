package com.origin.worldsrelics.datagen;

import com.origin.worldsrelics.WorldsRelics;
import com.origin.worldsrelics.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WorldsRelics.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        blockWithItem(ModBlocks.PRIMAL_STONE);
        blockWithItem(ModBlocks.POLISHED_PRIMAL_STONE);
        blockWithItem(ModBlocks.PRIMAL_STONE_BRICKS);
        blockWithItem(ModBlocks.PRIMAL_STONE_TILES);
        blockWithItem(ModBlocks.CRACKED_PRIMAL_STONE_BRICKS);
        blockWithItem(ModBlocks.CRACKED_PRIMAL_STONE_TILES);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
