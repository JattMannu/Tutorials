package com.example.examplemod.util;

import com.example.examplemod.Tutorial;
import com.example.examplemod.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Tutorial.mod_id);


    public static void init(){
        // Adds items to the game
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items only
    // ItemGroup.MATERIALS => ores
//    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
//            () -> new ItemBase(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new ItemBase());


}
