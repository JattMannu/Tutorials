package demo.one.myfirstplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class SpeedMiner implements Listener {

    private Plugin plugin;

    public SpeedMiner(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BlockBreak(BlockBreakEvent e) {
        Material type = e.getBlock().getType();
        e.getPlayer().sendMessage(ChatColor.BOLD + type.name());
        ItemStack itemInMainHand = e.getPlayer().getInventory().getItemInMainHand();
        ItemMeta meta = itemInMainHand.getItemMeta();
//        if (meta != null) {
//            ((Damageable) meta).setDamage(((Damageable) itemInMainHand.getItemMeta()).getDamage() - 1);
//            itemInMainHand.setItemMeta(meta);
//        }

        final Stack<Location> bList = new Stack<>();
        final Set<Location> bSet = new HashSet<>();
        bList.push(e.getBlock().getLocation());
        bSet.add(e.getBlock().getLocation());

        new BukkitRunnable() {
            @Override
            public void run() {
                int timeout = 10;
                while (!bList.isEmpty() && timeout > 0) {
                    timeout--;
                    Location location = bList.pop();
                    Block block = location.getBlock();
//                    for (BlockFace face : BlockFace.values()) {
//                        if (block.getRelative(face).getType() == type) {
//                            //e.getPlayer().sendMessage(ChatColor.GREEN + block.getRelative(face).getType().name());
//                            bList.push(block.getRelative(face));
//                        }
//                    }
                    Arrays.stream(BlockFace.values()).forEach(blockFace -> {

                        if (block.getRelative(blockFace, 1).getType() == type
                                && !bSet.contains(block.getRelative(blockFace, 1).getLocation())) {

                            //itemInMainHand.setDurability((short) (itemInMainHand.getDurability() + 1));
                            //e.getPlayer().sendMessage(itemInMainHand.getDurability() + "");
                            bSet.add(block.getRelative(blockFace, 1).getLocation());
                            bList.push(block.getRelative(blockFace, 1).getLocation());

                        }
                    });


                    //((Damageable) meta).setDamage(((Damageable) itemInMainHand.getItemMeta()).getDamage() - 1);
                    //block.breakNaturally(itemInMainHand);

                    e.getPlayer().sendMessage(block.getLocation().toString());

                    //block.setType(Material.AIR);
                }
                bSet.forEach(location -> {
                    //e.getPlayer().sendMessage(ChatColor.GOLD + location.toString());
                    location.getBlock().breakNaturally(itemInMainHand);
                    itemInMainHand.setDurability((short) (itemInMainHand.getDurability() + 1));
                });

               // this.cancel();
            }
        }.runTask(this.plugin);
        //.runTaskTimer(this.plugin, 1, 1);


        //https://gitlab.com/Ticxo/ModelAPI/blob/master/src/com/ticxo/modelapi/api/animation/AnimationMap.java
    }

}
