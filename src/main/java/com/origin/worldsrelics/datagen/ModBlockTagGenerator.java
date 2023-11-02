package com.origin.worldsrelics.datagen;

import com.origin.worldsrelics.WorldsRelics;
import com.origin.worldsrelics.block.ModBlocks;
import com.origin.worldsrelics.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WorldsRelics.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        this.tag(ModTags.Blocks.WORLDS_RELICS_STONE)
                .add(ModBlocks.PRIMAL_STONE.get()).addTag(Tags.Blocks.STONE);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PRIMAL_STONE.get())
                .add(ModBlocks.PRIMAL_STONE_BRICKS.get())
                .add(ModBlocks.PRIMAL_STONE_TILES.get())
                .add(ModBlocks.POLISHED_PRIMAL_STONE.get())
                .add(ModBlocks.CRACKED_PRIMAL_STONE_BRICKS.get())
                .add(ModBlocks.CRACKED_PRIMAL_STONE_TILES.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PRIMAL_STONE.get())
                .add(ModBlocks.PRIMAL_STONE_BRICKS.get())
                .add(ModBlocks.PRIMAL_STONE_TILES.get())
                .add(ModBlocks.POLISHED_PRIMAL_STONE.get())
                .add(ModBlocks.CRACKED_PRIMAL_STONE_BRICKS.get())
                .add(ModBlocks.CRACKED_PRIMAL_STONE_TILES.get());

    }
}
