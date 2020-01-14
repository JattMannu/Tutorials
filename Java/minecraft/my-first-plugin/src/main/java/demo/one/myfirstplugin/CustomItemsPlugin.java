package demo.one.myfirstplugin;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CustomItemsPlugin implements Listener {

    Plugin plugin;

    public CustomItemsPlugin(Plugin plugin) {
        this.plugin = plugin;
    }


    public enum CustomItem {
        HARDENED_WOOD(Material.WOODEN_AXE, ChatColor.RED + "Hardened Wood",
                Arrays.asList(ChatColor.GREEN + "Used to make better tools!"),
                Arrays.asList(Material.STICK)),
        FARMER_BLOCK(Material.IRON_BLOCK, "Farmer Block",
                Arrays.asList(ChatColor.GREEN + "Used to collect Wheat"),
                Arrays.asList(Material.STICK));

        private Material material;
        private String displayName;
        private List<String> lore;
        private List<Material> usedToMake;

        CustomItem(Material material, String displayName,
                   List<String> lore, List<Material> usedToMake) {
            this.material = material;
            this.displayName = displayName;
            this.lore = lore;
            this.usedToMake = usedToMake;
        }

        public ItemStack getItemStack() {
            ItemStack itemstack = new ItemStack(material, 1);
            ItemMeta itemMeta = itemstack.getItemMeta();
            itemMeta.setDisplayName(displayName);
            itemMeta.setLore(lore);
            itemstack.setItemMeta(itemMeta);
            return itemstack;
        }

        public boolean isUsedToMakeNormally(Material material) {
            return usedToMake.contains(material);
        }
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Just for testing purposes
        Player player = event.getPlayer();
        ItemStack hardenedWood = CustomItem.HARDENED_WOOD.getItemStack();
        hardenedWood.setAmount(64);
        player.getInventory().addItem(hardenedWood);
        player.getInventory().addItem(new ItemStack(Material.LEGACY_WOOD, 64));
    }

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        // Recipe
        Recipe recipe = event.getRecipe();
        // Item we are looking out for
        CustomItem customItem = CustomItem.FARMER_BLOCK;
//        for (ItemStack itemstack : event.getInventory().getContents()) {
//            if (itemstack.isSimilar(customItem.getItemStack())) {
//                if (customItem.isUsedToMakeNormally(recipe.getResult()
//                        .getType())) {
//                    event.setResult(Result.DENY);
//                    event.getWhoClicked()
//                            .sendMessage("Player attempted to use custom item's normal material to make a default bukkit item out of the material!");
//                }
//            }
//        }
        if (event.getRecipe().getResult().getType() == Material.IRON_BLOCK
                && event.getRecipe().getResult().getItemMeta().getDisplayName().endsWith("Farmer Block")) {
            event.getWhoClicked().sendMessage(String.format("%sTrying to make %s", ChatColor.BLUE, event.getRecipe().getResult().getItemMeta().getDisplayName()));
            event.getWhoClicked().setItemOnCursor(CustomItem.FARMER_BLOCK.getItemStack());
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.IRON_BLOCK && e.getItemInHand().getItemMeta().getDisplayName().endsWith("Farmer Block")) {
            //e.getBlock().setType(Material.AIR);
            //e.getPlayer().getWorld().spawn(e.getBlock().getLocation(), TNTPrimed.class);
            //e.getBlock().getLocation().
            BlockData blockData = e.getBlock().getBlockData();
            //blockData.
            new BukkitRunnable() {
                @Override
                public void run() {
                    Location location = e.getBlock().getLocation();

                    BlockFace[] faces = new BlockFace[]{
                            BlockFace.NORTH,
                            BlockFace.SOUTH,
                            BlockFace.EAST,
                            BlockFace.WEST
                    };
                    for (BlockFace face : faces) {
                        Block block = e.getBlock().getRelative(face);
                        if (block.getType() == Material.WHEAT){
                            e.getPlayer().sendMessage(face.toString() + " has Wheat age="  + ((Ageable)block.getBlockData()).getAge());
                            if(((Ageable)block.getBlockData()).getAge() == 7){
                                block.breakNaturally();
                                block.setType(Material.WHEAT);
                            }
                        }


                    }
                }
            }.runTaskTimer(this.plugin, 50, 500);

        } else {
            e.getPlayer().sendMessage("Fail farm" + e.getItemInHand().getItemMeta().getDisplayName());
        }

        //e.setCancelled(true);
    }
}
