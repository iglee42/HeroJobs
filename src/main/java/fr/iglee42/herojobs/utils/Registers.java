package fr.iglee42.herojobs.utils;

import fr.iglee42.herojobs.Main;
import fr.iglee42.herojobs.commands.JobsCmd;
import fr.iglee42.herojobs.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class Registers {
    public static void registerEvents(Main instance) {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BlockBreak(),instance);
        pm.registerEvents(new JoinEvent(), instance);
        pm.registerEvents(new QuitEvent(), instance);
        pm.registerEvents(new CookEvent(), instance);
        pm.registerEvents(new KillEvent(), instance);
    }

    public static void registerCommands(Main instance){
        instance.getCommand("jobs").setExecutor(new JobsCmd());
    }
}
