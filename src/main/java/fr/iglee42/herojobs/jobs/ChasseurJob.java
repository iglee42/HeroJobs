package fr.iglee42.herojobs.jobs;

import fr.iglee42.herojobs.utils.Job;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class ChasseurJob extends Job {

    public ChasseurJob(){
        super("Chasseur",20);
    }

    @Override
    public void init() {
        initKill();
        super.init();
    }

    @Override
    public void initKill() {
        super.initKill();
        for (int i = 0;i <= 4 ; i++){

            Map<EntityType,Integer> maps = new HashMap<>();
            maps.put(EntityType.PIG,2);
            maps.put(EntityType.COW,2);
            maps.put(EntityType.SHEEP,2);
            maps.put(EntityType.CHICKEN,2);
            maps.put(EntityType.PIG_ZOMBIE,3);
            maps.put(EntityType.SQUID,3);
            this.getEntityKillXp().put(i,maps);
        }
        for (int i = 5;i <= 9 ; i++){

            Map<EntityType,Integer> maps = new HashMap<>();
            maps.put(EntityType.ENDERMAN,5);
            maps.put(EntityType.ZOMBIE,4);
            maps.put(EntityType.SPIDER,4);
            maps.put(EntityType.WITHER_SKELETON,4);
            maps.put(EntityType.SLIME,3);
            maps.put(EntityType.WITCH,3);
            maps.put(EntityType.PIG_ZOMBIE,2);
            maps.put(EntityType.MAGMA_CUBE,6);
            maps.put(EntityType.BLAZE,2);
            maps.put(EntityType.PIG,1);
            maps.put(EntityType.COW,1);
            maps.put(EntityType.SHEEP,1);
            maps.put(EntityType.CHICKEN,1);
            maps.put(EntityType.SQUID,1);
            this.getEntityKillXp().put(i,maps);
        }
        for (int i = 10; i <= 14; i++){

            Map<EntityType,Integer> maps = new HashMap<>();
            maps.put(EntityType.ZOMBIE,3);
            maps.put(EntityType.SPIDER,3);
            maps.put(EntityType.ENDERMAN,4);
            maps.put(EntityType.CREEPER,5);
            maps.put(EntityType.SKELETON,5);
            maps.put(EntityType.WITCH,2);
            maps.put(EntityType.WITHER_SKELETON,2);
            maps.put(EntityType.SLIME,1);
            maps.put(EntityType.CAVE_SPIDER,4);
            maps.put(EntityType.MAGMA_CUBE,5);


            this.getEntityKillXp().put(i,maps);
        }
        for (int i = 15; i < 20; i++){

            Map<EntityType,Integer> maps = new HashMap<>();
            maps.put(EntityType.ZOMBIE,2);
            maps.put(EntityType.SPIDER,2);
            maps.put(EntityType.ENDERMAN,3);
            maps.put(EntityType.CREEPER,3);
            maps.put(EntityType.SKELETON,3);
            maps.put(EntityType.CAVE_SPIDER,2);
            maps.put(EntityType.MAGMA_CUBE,4);
            maps.put(EntityType.WITHER,5);
            this.getEntityKillXp().put(i,maps);
        }
    }
}
