package com.example.examplemod.items;

import com.example.examplemod.Tutorial;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= Tutorial.mod_id,bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("tutorial")
public class Items {
    public static final Item BREAD = register("bread", new Item((new Item.Properties()).group(Tutorial.TAB).food(Foods.BREAD)));

    public static final Item RAW_PLAIN_PIZZA = register("raw_plain_pizza",
            new Item(new Item.Properties().group(Tutorial.TAB).food(com.example.examplemod.items.Foods.RAW_PLAIN_PIZZA)));

    public static final Item PLAIN_PIZZA = register("plain_pizza",
            new Item(new Item.Properties().group(Tutorial.TAB).food(com.example.examplemod.items.Foods.PLAIN_PIZZA)));
    public static final Item FISH_PIZZA = register("fish_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.FISH_PIZZA)));
    public static final Item BEEF_PIZZA = register("beef_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.BEEF_PIZZA)));


    public static final Item RABBIT_PIZZA = register("rabbit_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.RABBIT_PIZZA)));


    public static final Item MEAT_GALORE_PIZZA = register("meat_galore_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.MEAT_GALORE_PIZZA)));
    public static final Item COD_PIZZA = register("cod_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.COD_PIZZA)));
    public static final Item CARROT_PIZZA = register("carrot_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.CARROT_PIZZA)));
    public static final Item CURRY_PIZZA = register("curry_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.CURRY_PIZZA)));



    public static final Item CHICKEN_PIZZA = register("chicken_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.CHICKEN_PIZZA)));

    public static final Item VEGGIE_PIZZA = register("veggie_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.VEGGIE_PIZZA)));

    public static final Item SALMON_PIZZA = register("salmon_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.SALMON_PIZZA)));

    public static final Item PORKCHOP_PIZZA = register("porkchop_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.PORKCHOP_PIZZA)));

    public static final Item MUTTON_PIZZA = register("mutton_pizza",
            new Item((new Item.Properties()).group(Tutorial.TAB).food(com.example.examplemod.items.Foods.MUTTON_PIZZA)));


    private static Item register(String key, Item item) {
        item.setRegistryName(key);
        ForgeRegistries.ITEMS.register(item);
        return ForgeRegistries.ITEMS.getValue(item.getRegistryName());
    }

}

