package com.arcadefortune.pyke;

import com.arcadefortune.pyke.registry.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.Weight;

public class PlundererEnchantment extends Enchantment {

    protected PlundererEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] equipmentSlots) {
        super(rarity,
                target,
                equipmentSlots);
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}