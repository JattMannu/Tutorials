package com.example.examplemod.blocks;

import com.example.examplemod.Tutorial;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= Tutorial.mod_id,bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("tutorial")
public class Blocks {

    public static final Block MY_BLOCK= register("my_block",
            new MyBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f,15.0f).sound(SoundType.METAL)));

    public static final BlockItem MY_BLOCK_ITEM= register1("my_block_item",
            new BlockItem(MY_BLOCK, new Item.Properties().maxStackSize(16).group(Tutorial.TAB)));


    private static Block register(String key, Block item) {
        item.setRegistryName(key);
        ForgeRegistries.BLOCKS.register(item);
        return ForgeRegistries.BLOCKS.getValue(item.getRegistryName());
    }

    private static BlockItem register1(String key, BlockItem item) {
        item.setRegistryName(key);
        ForgeRegistries.ITEMS.register(item);
        return (BlockItem)ForgeRegistries.ITEMS.getValue(item.getRegistryName());
    }
}
