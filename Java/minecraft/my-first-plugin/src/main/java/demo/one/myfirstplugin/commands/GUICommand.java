package demo.one.myfirstplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory gui = Bukkit.createInventory(player, 9, "Stats GUI");

            ItemStack movement_speed = new ItemStack(Material.RABBIT_FOOT);
            ItemStack toughness = new ItemStack(Material.IRON_CHESTPLATE);
            ItemStack health = new ItemStack(Material.COOKED_CHICKEN);

            movement_speed.getItemMeta().setDisplayName(ChatColor.RED + "Improve Movement speed");
            toughness.getItemMeta().setDisplayName(ChatColor.BLUE + "Improve Toughness");
            gui.addItem(movement_speed, toughness, health);

            player.openInventory(gui);
        }
        return true;
    }
}
