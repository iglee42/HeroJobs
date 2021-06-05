package fr.iglee42.herojobs.events;

import fr.iglee42.herojobs.utils.Job;
import fr.iglee42.herojobs.Main;
import fr.iglee42.herojobs.utils.JobPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        for (Job j : Main.INSTANCE.getJobs()){
            final boolean[] isNew = new boolean[1];
            Main.INSTANCE.getMysql().query("SELECT * FROM `"+j.getName().toLowerCase()+"` WHERE `player_name`=\""+ event.getPlayer().getName()+"\"",rs->{
                try {
                    if (rs.next()){
                        j.getLevels().put(event.getPlayer(), rs.getInt("level"));
                        j.getXp().put(event.getPlayer(), rs.getInt("xp"));
                        isNew[0] = false;
                    } else {
                        j.getLevels().put(event.getPlayer(),0);
                        j.getXp().put(event.getPlayer(), 0);
                        isNew[0] = true;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
            new JobPlayer(event.getPlayer(),isNew[0]);
        }
    }
}
