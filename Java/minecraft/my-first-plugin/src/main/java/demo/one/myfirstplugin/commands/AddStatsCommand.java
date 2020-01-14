package demo.one.myfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddStatsCommand implements CommandExecutor {

    private Attribute attribute;
    private double incrementValue;

    public AddStatsCommand(Attribute attribute, double incrementValue) {
        this.attribute = attribute;
        this.incrementValue = incrementValue;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Attributable attributable = (Attributable) sender;
            AttributeInstance attributeInstance = attributable.getAttribute(this.attribute);
            attributeInstance.setBaseValue(attributeInstance.getBaseValue() + incrementValue);
        } else
            sender.sendMessage(ChatColor.RED + "You need to be a Player to execute this command.");
        return true;
    }
}
