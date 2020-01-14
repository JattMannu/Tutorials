package demo.one.myfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddHealthCommand implements CommandExecutor {




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.GREEN + "Get Stats command triggered.");
            Attributable attributable = (Attributable) sender;
            AttributeInstance attribute = attributable.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            attribute.setBaseValue(attribute.getBaseValue() + 1);
        } else
            sender.sendMessage(ChatColor.RED + "You need to be a Player to execute this command.");
        return true;
    }
}
