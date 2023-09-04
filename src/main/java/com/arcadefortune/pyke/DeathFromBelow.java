package com.arcadefortune.pyke;

import com.arcadefortune.pyke.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.util.sat4j.core.ConstrGroup;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Weight;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

public class DeathFromBelow implements ModInitializer {


    public static final String MOD_ID = "pyke";

    public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "other")).icon( () -> new ItemStack(ModItems.DEATH_FROM_BELOW))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(ModItems.DEATH_FROM_BELOW));
                stacks.add(new ItemStack(Items.DIAMOND));
            })
            .build();

    //todo add here more MODITEMS
    private static final Enchantment PLUNDERER = new PlundererEnchantment(
            Enchantment.Rarity.UNCOMMON,
            EnchantmentTarget.FISHING_ROD,
            new EquipmentSlot[]{
                    EquipmentSlot.MAINHAND
            }
    );




    @Override
    public void onInitialize() {
        ModItems.registerItems();
        Registry.register(Registry.ENCHANTMENT, new Identifier("pyke", "plunderer"), PLUNDERER);
    }
}

