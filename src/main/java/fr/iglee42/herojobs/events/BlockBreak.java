package fr.iglee42.herojobs.events;

import fr.iglee42.herojobs.utils.Job;
import fr.iglee42.herojobs.Main;
import org.bukkit.Material;
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
            int level = j.getLevels().get(p);
            Material mat = event.getBlock().getType();
            Map<Material,Integer> blockMap = j.getBreakBlockXp().get(level);
            int xp = blockMap.get(mat);
            j.addXp(p,xp);
        }
    }

}
