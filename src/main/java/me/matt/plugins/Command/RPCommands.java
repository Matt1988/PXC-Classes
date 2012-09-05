/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.Command;

import java.lang.reflect.Method;
import me.matt.plugins.pxcclasses.Classes.CLASS_TYPE;
import me.matt.plugins.pxcclasses.Pxcclasses;
import me.matt.plugins.pxcclasses.Pxcplayer;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Matt
 */
public class RPCommands {
     
    /**
     * 
     * 
     * @param sender
     * @param args
     * @return - boolean, return the success of the command. If true is passed
     * the system assumes that the command was successful, if false is passed command
     * usage and description is displayed to "sender".
     * 
     */
    @Command(
       aliases = {"create"},
       desc = "Used to create your character.",
       usage = "/px create [class] - Would create your character with the specified [class]."
    )
    @CommandPermissions("rp.create")
    public static boolean create(CommandSender sender, String[] args) {
       if (sender instanceof Player) {
                       String v = args[1];

                       Player player = (Player)sender;

                       CLASS_TYPE type = CLASS_TYPE.fromString(v);
                       if (type == null) {
                               player.sendMessage(ChatColor.RED + "No such class");
                               return true;
                       }


                       Pxcplayer pxcPlayer = Pxcplayer.createPlayer(player.getName(), type.getText(), 1);
                       if(pxcPlayer == null) {
                               player.sendMessage(ChatColor.RED + "You have already chosen your class!");
                               return true;
                       }
                       Pxcclasses.Players.put(player, pxcPlayer); 
                       player.sendMessage(ChatColor.ITALIC + "You have chosen class " + ChatColor.BLUE + type.getText());
               }

               return true;
    }
    
    /**
     * Return help information.
     * @param sender
     * @param args
     * @return - boolean, return the success of the command. If true is passed
     * the system assumes that the command was successful, if false is passed command
     * usage and description is displayed to "sender".
     * 
     * TODO: Add specific command help.
     */
    @Command(
        aliases = {"help"},
        desc = "Basic Help.",
        usage = "/px help - Shows some basic help."
    )
    public static boolean help(CommandSender sender, String[] args) {
        CommandsManager commands = Pxcclasses.getInstance().getCommandsManager();
        if(args.length <= 1) {
            for(Command c : commands.commandAnnotations.values()) {
                String message = ChatColor.RED + "/px " + ChatColor.WHITE + c.aliases()[0]+ ChatColor.RED + " - " + c.desc();

                    if (message.length() > 50) {
                        message = message.substring(0, 47);
                        message += "...";
                    }
                    sender.sendMessage(message);
            }


            sender.sendMessage(ChatColor.GREEN + "To get more detailed help use '/px help [command]'");
            sender.sendMessage(ChatColor.GREEN + "You can use the 'Page Up' and 'Page Down' keys to scroll through your chat to see the rest of the help.");
            return true;
        }
        else {
            String cmdName = args[1];
            if (commands.commands.containsKey(cmdName)) {
                Method m = commands.commands.get(cmdName);
                Command cmd = commands.commandAnnotations.get(m);
                sender.sendMessage(ChatColor.RED + "Help for command: " + ChatColor.YELLOW + cmd.aliases()[0]);
                sender.sendMessage(ChatColor.RED + "Aliases: " + ChatColor.YELLOW + cmd.aliases());
                sender.sendMessage(ChatColor.RED + "Description: " + ChatColor.YELLOW + cmd.desc());
                sender.sendMessage(ChatColor.RED + "Usage: " + ChatColor.YELLOW + cmd.usage());
                
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    
    /**
     * TODO: implement cast command.
     * @param sender
     * @param args
     * @return - boolean, return the success of the command. If true is passed
     * the system assumes that the command was successful, if false is passed command
     * usage and description is displayed to "sender".
     * 
     */
    @Command(
       aliases = {"cast", "c"},
       desc = "Used to create your character.",
       usage = "/px create [class] - Would create your character with the specified [class]."
    )
    @CommandPermissions("rp.cast")
    public static boolean cast(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Not yet implemented!");
        return true;
    }
    
    /**
     * TODO: implement bind spell.
     * @param sender
     * @param args
     * @return 
     */
    @Command(
       aliases = {"bind", "b"},
       desc = "Used to bind a spell to the currently held item.",
       usage = "/px bind [spell] - bind specified [spell] to item in hand."
    )
    @CommandPermissions("rp.bind")
    public static boolean bind(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Not yet implemented!");
        return true;
    }
}