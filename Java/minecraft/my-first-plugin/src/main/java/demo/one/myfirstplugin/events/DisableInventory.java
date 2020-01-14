package demo.one.myfirstplugin.events;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DisableInventory implements Listener {

    private String inventory;

    public DisableInventory(String inventory) {
        this.inventory = inventory;
    }

    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase(inventory)) {
            HumanEntity player = e.getWhoClicked();
            switch (e.getCurrentItem().getType()){
                case RABBIT_FOOT:
                    AttributeInstance attributeInstance = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    attributeInstance.setBaseValue(attributeInstance.getBaseValue() + 0.01);
                    break;
                case COOKED_CHICKEN:
                    AttributeInstance hp = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                    hp.setBaseValue(hp.getBaseValue() + 1);
                    break;
                default:
                    player.sendMessage("Not Valid Item.");
            }

            //e.getWhoClicked().sendMessage("Disabled clic k");
            e.setCancelled(true);
        }

        //e.getWhoClicked().sendMessage(e.getView().getTitle().toLowerCase() + "==" + inventory.toLowerCase());
    }
}
