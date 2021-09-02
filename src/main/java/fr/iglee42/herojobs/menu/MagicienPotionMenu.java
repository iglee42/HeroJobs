package fr.iglee42.herojobs.menu;

import fr.iglee42.herojobs.Main;
import fr.iglee42.herojobs.utils.CustomInventory;
import fr.iglee42.herojobs.utils.ItemBuilder;
import fr.iglee42.herojobs.utils.Job;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.Map;
import java.util.Objects;

public class MagicienPotionMenu implements CustomInventory {
    @Override
    public String name() {
        return "&6Menu Dépot de potion ";
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
        ItemStack retour = new ItemBuilder(Material.BARRIER).setName("§c§lRetour").toItemStack();
        inv.setItem(12,retour);
        ItemStack deposer = new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short) 5).setName("§a§lDéposer les potions").toItemStack();
        inv.setItem(14,deposer);
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot, InventoryClickEvent event) {
       if (!current.hasItemMeta()) return;
       if (!current.getItemMeta().hasDisplayName()) return;
       if (Objects.equals(current.getItemMeta().getDisplayName(), "§a§lDéposer les potions")){
           System.out.println("Valider");
           if (inv.getItem(4) == null){
               System.out.println("It null");
               event.setCancelled(true);
               return;
           }
           if (inv.getItem(4).getType() != Material.POTION){
               event.setCancelled(true);
               return;
           }
           PotionEffectType type;
           PotionMeta meta = (PotionMeta) inv.getItem(4).getItemMeta();
           type = meta.getBasePotionData().getType().getEffectType();
           for (Job j : Main.INSTANCE.getJobs()){
               int level = j.getLevels().get(player);
               if (j.getPotionXp().get(level) == null) {
                   continue;
               }
               if (j.getPotionXp().get(level).isEmpty()) {
                   continue;
               }
               Map<PotionEffectType,Integer> potionMap = j.getPotionXp().get(level);
               if (potionMap == null) continue;
               if (potionMap.get(type) == null)continue;
               int xp = potionMap.get(type);
               if (inv.getItem(4).getType() == Material.SPLASH_POTION){
                    xp += 4;
               }
               if (inv.getItem(4).getType() == Material.LINGERING_POTION){
                    xp += 6;
               }
               inv.setItem(4,null);
               j.addXp(player,xp);
               event.setCancelled(true);
           }

       }
       if (Objects.equals(current.getItemMeta().getDisplayName(), " ")){
           event.setCancelled(true);
       }
       if (Objects.equals(current.getItemMeta().getDisplayName(), "§c§lRetour")){
           Main.INSTANCE.open(player, null);
           event.setCancelled(true);
       }
    }

    @Override
    public int getSize() {
        return 18;
    }
}
