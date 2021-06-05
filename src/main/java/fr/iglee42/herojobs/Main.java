package fr.iglee42.herojobs;

import fr.iglee42.herojobs.jobs.*;
import fr.iglee42.herojobs.utils.Job;
import fr.iglee42.herojobs.utils.JobPlayer;
import fr.iglee42.herojobs.utils.MySQL;
import fr.iglee42.herojobs.utils.Registers;
import org.apache.commons.dbcp2.BasicDataSource;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    private BasicDataSource connectionPool;
    private MySQL mysql;

    private List<Job> jobs = new ArrayList<>();
    private List<JobPlayer> players = new ArrayList<>();

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        Registers.registerEvents(this);
        Registers.registerCommands(this);
        initConnection();
        initJobs();
        initTables();
        jobs.get(0).init();
        super.onEnable();
    }


    private void initTables() {
        for (Job j : jobs){
            mysql.createTable(j.getName());
        }
    }

    private void initJobs() {
        jobs.add(new MineurJob());
        jobs.add(new BucheronJob());
        jobs.add(new ChasseurJob());
        jobs.add(new FarmerJob());
        jobs.add(new MagicienJob());
    }

    private void initConnection(){
        connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName("com.mysql.jdbc.Driver");
        connectionPool.setUsername(getConfig().getString("mysql.username"));
        connectionPool.setPassword(getConfig().getString("mysql.password"));
        connectionPool.setUrl("jdbc:mysql://"+ getConfig().getString("mysql.host") +"/"+getConfig().getString("mysql.dbname")+"?autoReconnect=true");
        connectionPool.setInitialSize(1);
        connectionPool.setMaxTotal(10);
        mysql = new MySQL(connectionPool);
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public MySQL getMysql() {
        return mysql;
    }

    public List<JobPlayer> getPlayers() {
        return players;
    }
}
