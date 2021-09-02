package fr.iglee42.herojobs;

import fr.iglee42.herojobs.jobs.*;
import fr.iglee42.herojobs.menu.MagicienPotionMenu;
import fr.iglee42.herojobs.utils.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends JavaPlugin implements Listener {

    public static Main INSTANCE;

    private BasicDataSource connectionPool;
    private MySQL mysql;

    private List<Job> jobs = new ArrayList<>();
    private List<JobPlayer> players = new ArrayList<>();

    public Map<Class<? extends CustomInventory>, CustomInventory> registeredMenus = new HashMap<>();

    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        Registers.registerEvents(this);
        Registers.registerCommands(this);
        Bukkit.getPluginManager().registerEvents(this,this);
        initConnection();
        createJobs();
        initTables();
        initJobs();
        addMenu(new MagicienPotionMenu());
        super.onEnable();
    }

    private void initJobs() {
        for (Job job : jobs) {
            job.init();
        }
    }


    private void initTables() {
        for (Job j : jobs){
            mysql.createTable(j.getName().toLowerCase());
        }
    }

    private void createJobs() {
        jobs.add(new MineurJob());
        jobs.add(new ChasseurJob());
        jobs.add(new FarmerJob());
        jobs.add(new MagicienJob());
        // jobs.add(new BucheronJob());
    }

    private void initConnection(){
        connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName("com.mysql.jdbc.Driver");
        connectionPool.setUsername(getConfig().getString("mysql.username"));
        connectionPool.setPassword(getConfig().getString("mysql.password"));
        connectionPool.setUrl("jdbc:mysql://"+ getConfig().getString("mysql.host") +":"+getConfig().getString("mysql.port")+"/"+getConfig().getString("mysql.dbname")+"?autoReconnect=true");
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

    public Job getJobByClassName(String className){
        for (Job j : jobs){
            if (j.getClass().getName().equals(className)) return j;
        }
        return null;
    }

    public int[] getPlayerXp(Job j, Player p){
        int[] i  = new int[2];
        i[0] = j.getXp().get(p);
        i[1] = j.getLevels().get(p);
        return i;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getInventory();
        ItemStack current = event.getCurrentItem();

        if (event.getCurrentItem() == null)
            return;

        registeredMenus.values().stream().filter(menu -> inv.getName().equalsIgnoreCase(menu.name())).forEach(menu -> menu.onClick(player, inv, current, event.getSlot(), event));

    }

    public void addMenu(CustomInventory m) {
        this.registeredMenus.put(m.getClass(), m);
    }

    public void open(Player player, Class<? extends CustomInventory> gClass) {

        if (!this.registeredMenus.containsKey(gClass))
            return;

        CustomInventory menu = this.registeredMenus.get(gClass);
        Inventory inv = Bukkit.createInventory(null, menu.getSize(), menu.name());
        menu.contents(player, inv);
        player.openInventory(inv);

    }
}
