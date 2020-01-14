package demo.one.myfirstplugin;

import demo.one.myfirstplugin.commands.AddStatsCommand;
import demo.one.myfirstplugin.commands.GUICommand;
import demo.one.myfirstplugin.commands.GetStatsCommand;
import demo.one.myfirstplugin.commands.HungerRateCommand;
import demo.one.myfirstplugin.events.DisableInventory;
import demo.one.myfirstplugin.events.SpeedMiner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class MyFirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        addRecipe();

        getServer().getPluginManager().registerEvents(new DisableInventory("Stats GUI"), this);
        //getServer().getPluginManager().registerEvents(new SpeedMiner(this),this);
        getServer().getPluginManager().registerEvents(new CustomItemsPlugin(this), this);

        getCommand("get_stats").setExecutor(new GetStatsCommand());
        getCommand("add_max_health").setExecutor(new AddStatsCommand(Attribute.GENERIC_MAX_HEALTH, 1));
        getCommand("add_armour").setExecutor(new AddStatsCommand(Attribute.GENERIC_ARMOR, 1));
        getCommand("add_attack_speed").setExecutor(new AddStatsCommand(Attribute.GENERIC_ATTACK_SPEED, 1));
        getCommand("add_armour_toughness").setExecutor(new AddStatsCommand(Attribute.GENERIC_ARMOR_TOUGHNESS, 1));
        getCommand("add_movement_speed").setExecutor(new AddStatsCommand(Attribute.GENERIC_MOVEMENT_SPEED, 0.01));
        getCommand("add_luck").setExecutor(new AddStatsCommand(Attribute.GENERIC_LUCK, 1));
        getCommand("hunger_rate").setExecutor(new HungerRateCommand());


        getCommand("gui").setExecutor(new GUICommand());

        getLogger().info("onEnable triggered");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\n My First Plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable triggered");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\n My First Plugin disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        getLogger().info("onCommand triggered");
        if (command.getName().equals("getstats") && sender instanceof Attributable) {
            Attributable attributable = (Attributable) sender;
            Arrays.stream(Attribute.values())
                    .forEach(attribute -> getLogger().info(attribute.name() +
                            " : " + attributable.getAttribute(attribute).getValue()));
        }

        return true;
    }


    public void addRecipe() {
//        ItemStack farmer_block = new ItemStack(Material.IRON_BLOCK, 1);
//        ItemMeta itemMeta = farmer_block.getItemMeta();
//        itemMeta.setDisplayName("Farmer Block");
//        itemMeta.setLore(Arrays.asList("Collects wheat around it"));
//        farmer_block.setItemMeta(itemMeta);

        ItemStack farmer_block = CustomItemsPlugin.CustomItem.FARMER_BLOCK.getItemStack();

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("myplug"), farmer_block);

        shapedRecipe.shape("AA ", "   ", "   ");

        //shapedRecipe.setIngredient('*', Material.AIR);
        shapedRecipe.setIngredient('A', Material.STICK);



        //ItemStack wheat_seeds_1 = new ItemStack(CustomItemsPlugin.CustomItem.FARMER_BLOCK, 1);
        getServer().addRecipe(shapedRecipe);

    }
    //PlayerBedEnterEvent
    //player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 12000, 3));
}

