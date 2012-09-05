package me.matt.plugins.pxcclasses;

import com.avaje.ebean.EbeanServer;
import com.lennardf1989.bukkitex.MyDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.matt.plugins.Command.CommandsManager;
import me.matt.plugins.Command.MyCommands;
import me.matt.plugins.Command.RPCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Pxcclasses extends JavaPlugin implements Listener {
    CommandsManager commands;
    private static Pxcclasses plugin = null;
    private MyDatabase database;
    public static HashMap<Player, Pxcplayer> Players = new HashMap<Player, Pxcplayer>();
    
    private final Logger log = Logger.getLogger("Minecraft");
    private String logPrefix = "[PXC-Classes] ";
    
    /**
     * Return an instance of the plugin.
     * @return 
     */
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
        
        
        setupCommands();
       

    }
    
    /**
     * Setup the database.
     * TODO: create directory if it doesn't exist.
     */
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
    
    
    /**
     * Load "bukkit.yml" for use with the database.
     * @return 
     */
    private YamlConfiguration databaseConfiguration() {
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(new File("bukkit.yml"));
        return configuration;
    }
    
    /**
     * Retrieve an instance of the database.
     * @return 
     */
    @Override
    public EbeanServer getDatabase() {
        return database.getDatabase();
    }
    
    /**
     * Log an error in the console.
     * @param level
     * @param messages 
     */
    public void Log(Level level, String ... messages) {
        for (String message : messages) {
            log.log(level, logPrefix + message);
        }
    }
    
    
    /**
     * Notify a player that they have not yet chosen a class. 
     * if a class has been chosen, do nothing.
     * @param e 
     * 
     * 
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Pxcplayer pxcPlayer = Pxcplayer.getPlayerFromDatabase(e.getPlayer());
        if (pxcPlayer == null) {
        	e.getPlayer().sendMessage(ChatColor.RED + "You have not created your character, do so now with the" + ChatColor.YELLOW + "'/px create'" + ChatColor.RED + "command.");
        	return;
        }
        e.getPlayer().sendMessage(ChatColor.BLUE + "Welcome back " + ChatColor.RED + e.getPlayer().getName() + ChatColor.BLUE + ".");
        Players.put(e.getPlayer(), pxcPlayer);
    }

    private void setupCommands() {
        commands = new CommandsManager();
        commands.register(MyCommands.class);
        commands.register(RPCommands.class);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (cmd.getAliases().contains("px")) {
            if (args.length >= 1) {
                boolean success = commands.execute(args[0], sender, args);
            }
            else {
                String[] args2 = {"help"};
                boolean success = commands.execute(args2[0], sender, args2);
            }
            
        }
    return true;
    }
    
    public CommandsManager getCommandsManager() {
        return commands;
    }
    
    
   
    
}

