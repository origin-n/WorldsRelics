package com.origin.worldsrelics.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RodOfDiscordItem extends Item {
    public RodOfDiscordItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            // Teleport player up to ten block in direction they are looking

            player.getCooldowns().addCooldown(this, 20);
        }


        return super.use(level, player, hand);
    }


}
