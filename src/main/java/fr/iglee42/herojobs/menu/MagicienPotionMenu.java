package fr.iglee42.herojobs.menu;

import fr.iglee42.herojobs.utils.CustomInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MagicienPotionMenu implements CustomInventory {
    @Override
    public String name() {
        return null;
    }

    @Override
    public void contents(Player player, Inventory inv) {

    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot, InventoryClickEvent event) {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
