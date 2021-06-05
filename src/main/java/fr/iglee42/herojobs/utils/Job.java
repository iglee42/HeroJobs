package fr.iglee42.herojobs.utils;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class Job {

    private String name;
    private Map<Player,Integer> levels,xp;
    private Map<Integer,Integer> xpLevels;
    private int maxLevel;
    private Map<Integer,Map<Material,Integer>> breakBlockXp;
    private Map<Integer,Map<EntityType,Integer>> entityKillXp;
    private Map<Integer,Map<Material,Integer>> craftXp;



    public Job(String name, int maxLevel) {
        this.name = name;
        this.maxLevel = maxLevel;
        this.levels = new HashMap<>();
        this.xp = new HashMap<>();
        this.xpLevels = new HashMap<>();
        this.breakBlockXp = new HashMap<>();
        this.entityKillXp = new HashMap<>();
        this.craftXp = new HashMap<>();
        init();
    }

    public void addXp(Player p, int xpToAdd){
        if (xpToAdd == 0) return;
        ActionBar bar = new ActionBar("§2Vous avez gagné §6" + xpToAdd + " §2d'xp pour le metier de §6" + this.name);
        bar.sendToPlayer(p);
        int currentXp = xp.get(p);
        int level = levels.get(p);
        if ((currentXp + xpToAdd) > xpLevels.get(level) ){
            int newXp = currentXp + xpToAdd;
            int xpNewLevel = newXp - xpLevels.get(level);
            levels.remove(p);
            levels.put(p,level + 1);
            if (xpNewLevel != 0){
                addXp(p,xpNewLevel);
            }
            return;
        }
        xp.remove(p);
        xp.put(p,currentXp + xpToAdd);
    }

    public String getName() {
        return name;
    }

    public Map<Player, Integer> getLevels() {
        return levels;
    }

    public Map<Player, Integer> getXp() {
        return xp;
    }

    public Map<Integer, Integer> getXpLevels() {
        return xpLevels;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
    public Map<Integer, Map<Material, Integer>> getBreakBlockXp() {
        return breakBlockXp;
    }

    public Map<Integer, Map<EntityType, Integer>> getEntityKillXp() {
        return entityKillXp;
    }

    public Map<Integer, Map<Material, Integer>> getCraftXp() {
        return craftXp;
    }

    public void init(){
        this.xpLevels.put(0,200);
        this.xpLevels.put(1,400);
        this.xpLevels.put(2,800);
        this.xpLevels.put(3,1200);
        this.xpLevels.put(4,1400);
        this.xpLevels.put(5,1600);
        this.xpLevels.put(6,1800);
        this.xpLevels.put(7,2000);
        this.xpLevels.put(8,2200);
        this.xpLevels.put(9,2400);
        this.xpLevels.put(10,2600);
        this.xpLevels.put(11,2800);
        this.xpLevels.put(12,3000);
        this.xpLevels.put(13,3200);
        this.xpLevels.put(14,3400);
        this.xpLevels.put(15,3600);
        this.xpLevels.put(16,3800);
        this.xpLevels.put(17,4000);
        this.xpLevels.put(18,4200);
        this.xpLevels.put(19,4400);
        this.xpLevels.put(20,4600);
    }
}
