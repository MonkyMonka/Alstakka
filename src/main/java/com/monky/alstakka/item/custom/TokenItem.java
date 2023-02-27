package com.monky.alstakka.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TokenItem extends Item {
    public static String playerName = "";

    public TokenItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (!playerName.isBlank()) {
            tooltip.add(Component.nullToEmpty("This Token belongs to " + playerName));
        }
        else {
            tooltip.add(Component.nullToEmpty("This Token belongs to no one. "));
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            playerName = player.getDisplayName().getString();
            player.sendSystemMessage(Component.literal("Your name is " + playerName));
        }

        return super.use(level, player, hand);
    }
}
