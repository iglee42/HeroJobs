package fr.iglee42.herojobs.commands;

import fr.iglee42.herojobs.utils.Job;
import fr.iglee42.herojobs.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetxpCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Main.INSTANCE.getJobs().forEach(j -> p.sendMessage("Vous avez " + j.getLevels().get(p) + " niveau avec " + j.getXp().get(p) + " xp dans le metier de " + j.getName()));
        }
        return true;
    }
}
