package com.origin.worldsrelics.item.custom;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RodOfDiscordItem extends Item {
    public RodOfDiscordItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            Vec3 lookVec = player.getLookAngle();
            Vec3 teleportVec = lookVec.scale(10);

            double currentX = player.getX();
            double currentY = player.getY();
            double currentZ = player.getZ();
            double newX = currentX + teleportVec.x;
            double newY = currentY + teleportVec.y;
            double newZ = currentZ + teleportVec.z;

            BlockPos newPos = new BlockPos((int) newX, (int) newY, (int) newZ);
            while (level.getBlockState(newPos).isSolidRender(level, newPos)) {
                Vec3 forwardVec = lookVec.scale(-0.6);
                newX += forwardVec.x;
                newY += forwardVec.y;
                newZ += forwardVec.z;
                newPos = new BlockPos((int) newX, (int) newY, (int) newZ);
            }

            Vec3 motionBeforeTeleport = player.getDeltaMovement();

            player.teleportTo(newX, newY, newZ);
            player.setDeltaMovement(motionBeforeTeleport);

            Random rand = new Random();
            int soundChance = rand.nextInt(2) + 1;

//            if (soundChance == 1){
//                level.playSeededSound(null, newPos.getX(), newPos.getY(), newPos.getZ(),  ModSounds.ROD_OF_DISCORD_WARP_PING.get(), SoundSource.PLAYERS, 1f, 1f, 0);
//            }
//            else{
//                level.playSeededSound(null, newPos.getX(), newPos.getY(), newPos.getZ(),  ModSounds.ROD_OF_DISCORD_WARP.get(), SoundSource.PLAYERS, 1f, 1f, 0);
//            }
            level.playSound(null, newPos.getX(), newPos.getY(), newPos.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1f, 1f);


            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }
}