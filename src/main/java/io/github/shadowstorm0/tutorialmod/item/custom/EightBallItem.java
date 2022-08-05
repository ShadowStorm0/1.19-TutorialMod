package io.github.shadowstorm0.tutorialmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.security.SecureRandom;

public class EightBallItem extends Item {
    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            //Random number and cooldown
            displayRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20); //20 tics == 1 sec
        }
        return super.use(level, player, hand);
    }

    private void displayRandomNumber(Player player){
        player.sendSystemMessage(Component.literal("Your number is " + getRandom()));
    }

    private int getRandom(){
        SecureRandom random = new SecureRandom();
        return random.nextInt(10);
    }
}