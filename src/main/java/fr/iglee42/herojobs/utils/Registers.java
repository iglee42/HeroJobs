package fr.iglee42.herojobs.utils;

import fr.iglee42.herojobs.Main;
import fr.iglee42.herojobs.commands.GetxpCMD;
import fr.iglee42.herojobs.events.BlockBreak;
import fr.iglee42.herojobs.events.JoinEvent;
import fr.iglee42.herojobs.events.QuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class Registers {
    public static void registerEvents(Main instance) {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BlockBreak(),instance);
        pm.registerEvents(new JoinEvent(), instance);
        pm.registerEvents(new QuitEvent(), instance);
    }

    public static void registerCommands(Main instance){
        instance.getCommand("getxp").setExecutor(new GetxpCMD());
    }
}
