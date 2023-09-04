package com.arcadefortune.pyke.registry;

import com.arcadefortune.pyke.DeathFromBelow;
import com.arcadefortune.pyke.NewItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item DEATH_FROM_BELOW = new NewItem(new Item.Settings().group(ItemGroup.COMBAT).maxCount(1).rarity(Rarity.EPIC));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(DeathFromBelow.MOD_ID, "death_from_below"), DEATH_FROM_BELOW);

    }

}