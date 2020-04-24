package com.example.examplemod.items;

import com.example.examplemod.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase(Properties properties) {
        super(properties);
    }

    public ItemBase() {
        super(new Item.Properties().group(Tutorial.TAB));
    }
}
