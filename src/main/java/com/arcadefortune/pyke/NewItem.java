package com.arcadefortune.pyke;

import com.arcadefortune.pyke.registry.ModItems;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.*;
import net.minecraft.server.command.EffectCommand;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;

import java.util.List;


public class NewItem extends Item {

    public NewItem(Settings settings) {
        super(settings.rarity(Rarity.EPIC));
    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        playerEntity.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, 1.0F, 1.0F);
        playerEntity.setVelocity(playerEntity.getVelocity().x, 1, playerEntity.getVelocity().z);
        playerEntity.getItemCooldownManager().set(this, 200);
        //todo make it 2 minutes
        playerEntity.giveItemStack(new ItemStack(Items.DIAMOND));
        playerEntity.clearActiveItem();
        //playerEntity.dropStack(new ItemStack(Items.HEART_OF_THE_SEA));

        return TypedActionResult.success(playerEntity.getStackInHand(hand));

    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext toolTipContext) {
        tooltip.add(new TranslatableText("Kills enemies below 4 §4(+AD)§r hearts."));
        tooltip.add(new TranslatableText("Kills grant you 10 Gold (§e+PLUNDERER§r)."));
        tooltip.add(new TranslatableText("Kills resets it, for up to 20 seconds."));

        if(Screen.hasShiftDown())
        {
            tooltip.add(new TranslatableText("Cooldown is 120 §l(-CD)§r seconds").formatted(Formatting.GRAY));
            tooltip.add(new TranslatableText("Cost: §l1§r enderpearl").formatted(Formatting.GRAY));
        }
        else {
            tooltip.add(new TranslatableText("Press Shift for more information").formatted(Formatting.GRAY));
        }
    }
}