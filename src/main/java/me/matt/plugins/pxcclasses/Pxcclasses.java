package me.matt.plugins.pxcclasses;

import com.avaje.ebean.EbeanServer;
import com.lennardf1989.bukkitex.MyDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Pxcclasses extends JavaPlugin implements Listener {
    private static Pxcclasses plugin = null;
    private MyDatabase database;
    public static HashMap<Player, Pxcplayer> Players = new HashMap<Player, Pxcplayer>();
    
    private final Logger log = Logger.getLogger("Minecraft");
    private String logPrefix = "[PXC-Classes] ";
    
    
    public static Pxcclasses getInstance() {
		return plugin;	
    }
    
    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        plugin = this;
        SetupDatabase();
        getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("Cast").setExecutor(new CastCommand(this));
        this.getCommand("Create").setExecutor(new CreateCommand(this));
    }
    
    
    private void SetupDatabase() {
        Configuration config = databaseConfiguration();
        database = new MyDatabase(this) {
            protected java.util.List<Class<?>> getDatabaseClasses() {
                List<Class<?>> list = new ArrayList<Class<?>>();
                list.add(Pxcplayer.class);
                        
                return list;
            };
        };
        
        database.initializeDatabase(config.getString("database.driver"), config.getString("database.url"), config.getString("database.username"), config.getString("database.password"), config.getString("database.isolation"), false, false);
    }
    private YamlConfiguration databaseConfiguration() {
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(new File("bukkit.yml"));
        return configuration;
    }
    
    @Override
    public EbeanServer getDatabase() {
        return database.getDatabase();
    }
    
    public void Log(Level level, String ... messages) {
        for (String message : messages) {
            log.log(level, logPrefix + message);
        }
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Pxcplayer pxcPlayer = Pxcplayer.getPlayerFromDatabase(e.getPlayer());
        if (pxcPlayer == null) {
        	e.getPlayer().sendMessage("You have not created your character, do so now with the '/Create' command.");
        	return;
        }
        Players.put(e.getPlayer(), pxcPlayer);
    }
    
}

