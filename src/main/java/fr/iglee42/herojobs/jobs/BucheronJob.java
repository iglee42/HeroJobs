package fr.iglee42.herojobs.jobs;

import fr.iglee42.herojobs.utils.Job;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class BucheronJob extends Job {
    public BucheronJob() {
        super("Bucheron",20);
    }

    @Override
    public void init() {
        super.init();
        initBreak();
    }

    @Override
    public void initBreak() {
        super.initBreak();
            for (int i = 0;i <= 4 ; i++){

                Map<Material,Integer> maps = new HashMap<>();
                maps.put(Material.LOG,1);
                this.getBreakBlockXp().put(i,maps);
            }
            for (int i = 5;i <= 9 ; i++){

                Map<Material,Integer> maps = new HashMap<>();
                maps.put(Material.BREAD,4);
                this.getBreakBlockXp().put(i,maps);
            }
            for (int i = 10; i <= 14; i++){

                Map<Material,Integer> maps = new HashMap<>();
                maps.put(Material.PUMPKIN_PIE,3);
                this.getBreakBlockXp().put(i,maps);
            }
            for (int i = 15; i < 20; i++){

                Map<Material,Integer> maps = new HashMap<>();
                maps.put(Material.PUMPKIN_PIE,2);
                this.getBreakBlockXp().put(i,maps);
            }

        }
}
