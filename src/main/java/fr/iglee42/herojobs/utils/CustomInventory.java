package fr.iglee42.herojobs.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface CustomInventory {
	
	String name();
	
	void contents(Player player, Inventory inv);
	
	void onClick(Player player, Inventory inv, ItemStack current, int slot, InventoryClickEvent event);
	
	int getSize();

}
