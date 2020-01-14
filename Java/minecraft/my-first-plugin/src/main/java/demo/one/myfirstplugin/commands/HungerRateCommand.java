package demo.one.myfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class HungerRateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // https://minecraft.gamepedia.com/Hunger#Mechanics
            player.setSaturation(player.getSaturation() * 0);

        } else
            sender.sendMessage(ChatColor.RED + "You need to be a Player to execute this command.");
        return true;
    }
}
