package fr.iglee42.herojobs.events;

import fr.iglee42.herojobs.utils.Job;
import fr.iglee42.herojobs.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Map;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        for (Job j : Main.INSTANCE.getJobs()){
            if (p.getInventory().getItemInMainHand().hasItemMeta()){
                if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()){
                    if (p.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6§bSmelting"))continue;
                }
            }
            if (p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) continue;
            int level = j.getLevels().get(p);
            Material mat = event.getBlock().getType();
            if (j.getBreakBlockXp().get(level) == null)
                continue;

            if (j.getBreakBlockXp().get(level).isEmpty()) {
                continue;
            }
            Map<Material,Integer> blockMap = j.getBreakBlockXp().get(level);
            if (blockMap == null) continue;
            if (blockMap.get(mat) == null) continue;
            int xp = blockMap.get(mat);
            if (j == Main.INSTANCE.getJobs().get(2)){
                //if (mat == Material.MELON_BLOCK) xp = (int) blockMap.get(mat);
                //if (mat == Material.SUGAR_CANE_BLOCK) xp = (int) blockMap.get(mat);
                if (mat == Material.POTATO && !(event.getBlock().getData() == 7))continue;
                if (mat == Material.WHEAT && !(event.getBlock().getData() == 7))continue;
                if (mat == Material.CARROT && !(event.getBlock().getData() == 7))continue;
                if (mat == Material.BEETROOT_BLOCK && !(event.getBlock().getData() == 3))continue;
                if (mat == Material.COCOA && !(event.getBlock().getData() == 8 || event.getBlock().getData() == 9 || event.getBlock().getData() == 10 || event.getBlock().getData() == 11))continue;
            }
            if (xp == 0) continue;


           j.addXp(p,xp);
        }
    }

}
