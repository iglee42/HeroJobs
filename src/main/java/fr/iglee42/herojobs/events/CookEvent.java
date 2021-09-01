package fr.iglee42.herojobs.events;

import fr.iglee42.herojobs.Main;
import fr.iglee42.herojobs.utils.Job;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceExtractEvent;

import java.util.Map;

public class CookEvent implements Listener {

    @EventHandler
    public void onCook(FurnaceExtractEvent event){
        Player p = event.getPlayer();
        for (Job j : Main.INSTANCE.getJobs()){
            int level = j.getLevels().get(p);
            Material mat = event.getItemType();
            if (j.getCookXp().get(level) == null ) return;
            if (j.getCookXp().get(level).isEmpty() ) return;
            Map<Material,Integer> blockMap = j.getCookXp().get(level);
            if (blockMap.get(mat) == null) return;
            int xp = blockMap.get(mat) * event.getItemAmount();
            j.addXp(p,xp);
        }
    }
}
