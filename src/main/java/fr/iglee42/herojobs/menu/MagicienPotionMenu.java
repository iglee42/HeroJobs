package fr.iglee42.herojobs.menu;

import fr.iglee42.herojobs.utils.CustomInventory;
import fr.iglee42.herojobs.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MagicienPotionMenu implements CustomInventory {
    @Override
    public String name() {
        return "&6&lMenu Dépot de potion §7(Magicien)";
    }

    @Override
    public void contents(Player player, Inventory inv) {
        ItemStack vide = new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)3).setName(" ").toItemStack();
        inv.setItem(0,vide);
        inv.setItem(1,vide);
        inv.setItem(2,vide);
        inv.setItem(3,vide);
        inv.setItem(5,vide);
        inv.setItem(6,vide);
        inv.setItem(7,vide);
        inv.setItem(8,vide);
        inv.setItem(9,vide);
        inv.setItem(10,vide);
        inv.setItem(11,vide);
        inv.setItem(13,vide);
        inv.setItem(15,vide);
        inv.setItem(16,vide);
        inv.setItem(17,vide);
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot, InventoryClickEvent event) {

    }

    @Override
    public int getSize() {
        return 18;
    }
}
