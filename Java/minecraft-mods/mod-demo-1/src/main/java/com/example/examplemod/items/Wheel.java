package com.example.examplemod.items;

import com.example.examplemod.Tutorial;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= Tutorial.mod_id,bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Tutorial.mod_id)
public class Wheel extends Item {

    private Wheel instance;

    public Wheel(Properties properties) {
        super(properties);
    }

    public Wheel() {
        super(new Properties().group(Tutorial.TAB));
        this.setRegistryName("wheel");
    }

    public Wheel getInstance(){
        if(this.instance == null)
          this.instance = new Wheel();

        return this.instance;
    }

    @SubscribeEvent
    public static void registerItem(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new Wheel());
    }
}
