package fr.iglee42.herojobs.events;

import fr.iglee42.herojobs.Main;
import fr.iglee42.herojobs.utils.Job;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;

public class KillEvent implements Listener {

    @EventHandler
    public void onEntityKill(EntityDamageByEntityEvent event){
        if (event.getEntity() == null) return;
        if (event.getDamager() == null) return;
        if (!(event.getDamager() instanceof Player || event.getEntity() instanceof LivingEntity))return;
        System.out.println("Damager = Player , Entity = Living");
        Player damager = (Player) event.getDamager();
        if (damager == null) return;
        if (((LivingEntity)event.getEntity()).getHealth() < event.getFinalDamage()){
            System.out.println("Mort");
            Job j = Main.INSTANCE.getJobs().get(1);
                System.out.println("Check Xp");
                int level = j.getLevels().get(damager);
                System.out.println("Level Get");
                Entity entity = event.getEntity();
                System.out.println("Entity Get");
                System.out.println("Map Level : "+ (j.getEntityKillXp().get(level) == null?"Null":"OK"));
                if (j.getEntityKillXp().get(level) == null ) return;
                System.out.println("Map Level not null");
                if (j.getEntityKillXp().get(level).isEmpty() ) return;
                System.out.println("Map Level Not Empty");
                Map<EntityType,Integer> entityMap = j.getEntityKillXp().get(level);
                System.out.println("Map Xp get");
                if (entityMap.get(entity.getType()) == null) return;
                System.out.println("Entity has xp");
                int xp = entityMap.get(entity.getType());
                System.out.println("Get Xp");
                j.addXp(damager,xp);
        }

    }
}
