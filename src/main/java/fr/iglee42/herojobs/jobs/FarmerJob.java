package fr.iglee42.herojobs.jobs;

import fr.iglee42.herojobs.utils.Job;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class FarmerJob extends Job {
    public FarmerJob(){
        super("Farmer",20);
    }

    @Override
    public void init() {
        initBreak();
        super.init();
    }

    @Override
    public void initBreak() {
        super.initBreak();
        for (int i = 0;i <= 4 ; i++){

            Map<Material,Integer> maps = new HashMap<>();
            maps.put(Material.WHEAT,5);
            maps.put(Material.CARROT,7);
            maps.put(Material.BEETROOT_BLOCK,6);
            this.getBreakBlockXp().put(i,maps);
        }
        for (int i = 5;i <= 9 ; i++){

            Map<Material,Integer> maps = new HashMap<>();
            maps.put(Material.WHEAT,4);
            maps.put(Material.CARROT,6);
            maps.put(Material.BEETROOT_BLOCK,4);
            maps.put(Material.POTATO,6);
            this.getBreakBlockXp().put(i,maps);
        }
        for (int i = 10; i <= 14; i++){

            Map<Material,Integer> maps = new HashMap<>();
            maps.put(Material.WHEAT,3);
            maps.put(Material.CARROT,3);
            maps.put(Material.BEETROOT_BLOCK,3);
            maps.put(Material.POTATO,4);
            maps.put(Material.COCOA,7);
            this.getBreakBlockXp().put(i,maps);
        }
        for (int i = 15; i < 20; i++){

            Map<Material,Integer> maps = new HashMap<>();
            maps.put(Material.WHEAT,2);
            maps.put(Material.CARROT,1);
            maps.put(Material.POTATO,2);
            maps.put(Material.BEETROOT_BLOCK,1);
            maps.put(Material.COCOA,6);
            this.getBreakBlockXp().put(i,maps);
        }
    }
}
