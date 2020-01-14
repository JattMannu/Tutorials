package demo.one.myfirstplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.Arrays;

public class GetStatsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //((Player)sender).addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 12000, 3));
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.GREEN + "Get Stats command triggered.");
            Attributable attributable = (Attributable) sender;
            Arrays.stream(Attribute.values())
                    .forEach(attribute -> {
                        if (attributable.getAttribute(attribute) != null)
                            sender.sendMessage(attribute.name() + " : " + attributable.getAttribute(attribute).getValue());
                        else
                            sender.sendMessage(attribute.name() + " : NULL");
                    });
        } else
            sender.sendMessage(ChatColor.RED + "You need to be a Player to execute this command.");
        return true;
    }
}
