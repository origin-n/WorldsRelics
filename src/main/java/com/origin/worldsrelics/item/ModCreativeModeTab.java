package com.origin.worldsrelics.item;

import com.origin.worldsrelics.WorldsRelics;
import com.origin.worldsrelics.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            WorldsRelics.MODID);

    public static final RegistryObject<CreativeModeTab> WORLDS_RELICS_TAB = CREATIVE_MODE_TAB.register("worlds_relics_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRACKED_PRIMAL_ROCK.get()))
                    .title(Component.translatable("worldsrelics.worlds_relics_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PRIMAL_ROCK.get());
                        pOutput.accept(ModItems.CRACKED_PRIMAL_ROCK.get());
                        pOutput.accept(ModBlocks.PRIMAL_STONE.get());
                        pOutput.accept(ModBlocks.PRIMAL_STONE_BRICKS.get());
                        pOutput.accept(ModBlocks.CRACKED_PRIMAL_STONE_BRICKS.get());
                        pOutput.accept(ModBlocks.PRIMAL_STONE_TILES.get());
                        pOutput.accept(ModBlocks.CRACKED_PRIMAL_STONE_TILES.get());
                        pOutput.accept(ModBlocks.POLISHED_PRIMAL_STONE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
            CREATIVE_MODE_TAB.register(eventBus);
    }
}
