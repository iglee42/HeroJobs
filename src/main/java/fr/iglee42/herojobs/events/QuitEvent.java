package fr.iglee42.herojobs.events;

import fr.iglee42.herojobs.utils.Job;
import fr.iglee42.herojobs.Main;
import fr.iglee42.herojobs.utils.JobPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        for (Job j : Main.INSTANCE.getJobs()){
            System.out.println(j.getName());
            if (JobPlayer.getPlayer(event.getPlayer()).isNew()){
                Main.INSTANCE.getMysql().update("INSERT INTO `"+j.getName().toLowerCase()+"`(`player_name`, `level`, `xp`) VALUES (\""+event.getPlayer().getName()+"\","+j.getLevels().get(event.getPlayer())+","+j.getXp().get(event.getPlayer())+")");
            } else {
                Main.INSTANCE.getMysql().update("UPDATE `"+j.getName().toLowerCase()+"` SET `level`="+j.getLevels().get(event.getPlayer())+",`xp`="+j.getXp().get(event.getPlayer())+" WHERE player_name=\""+event.getPlayer().getName()+"\"");
            }
        }
        JobPlayer.getPlayer(event.getPlayer()).delete();

    }

}
