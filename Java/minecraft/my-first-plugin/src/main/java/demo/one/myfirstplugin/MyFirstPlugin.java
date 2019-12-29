package demo.one.myfirstplugin;

import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class MyFirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("onEnable triggered");
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable triggered");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("getstats") && sender instanceof Attributable) {
            Attributable attributable = (Attributable) sender;
            Arrays.stream(Attribute.values())
                    .forEach(attribute -> getLogger().info(attribute.name() +
                            " : " + attributable.getAttribute(attribute).getValue()));
        }

        return true;
    }
}
