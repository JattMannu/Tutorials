package com.example.examplemod.init;

import com.example.examplemod.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= Tutorial.mod_id,bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Tutorial.mod_id)
public class ItemInit {


//    public static final Item example_item = null;

    @SubscribeEvent
    public static void registerItem(final RegistryEvent.Register<Item> event){

        event.getRegistry().register(new Item(new Item.Properties().group(Tutorial.TAB)).setRegistryName("example_item_1"));
        event.getRegistry().register(new Item(new Item.Properties().group(Tutorial.TAB)).setRegistryName("example_item_2"));
    }
}
