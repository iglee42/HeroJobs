package fr.iglee42.herojobs.utils;

import fr.iglee42.herojobs.Main;
import org.bukkit.entity.Player;

public class JobPlayer {

    private Player player;
    private boolean isNew;

    public JobPlayer(Player player, boolean isNew) {
        this.player = player;
        this.isNew = isNew;
        Main.INSTANCE.getPlayers().add(this);
    }

    public void delete(){
        Main.INSTANCE.getPlayers().remove(this);
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isNew() {
        return isNew;
    }


    public static JobPlayer getPlayer(Player p){
        return Main.INSTANCE.getPlayers().stream().filter(pj -> pj.getPlayer() == p).findFirst().get();
    }
}
