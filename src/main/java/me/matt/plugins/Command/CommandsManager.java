/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.Command;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Matt
 */
public class CommandsManager {

    /**
     * Used to store commands which you can look up by alias.
     */
    protected Map<String, Method> commands = new HashMap<String, Method>();
    /**
     * Used to store instances associated with a method.
     */
    protected Map<Method, Object> instances = new HashMap<Method, Object>();
    /**
     * Cached annotations
     */
    protected Map<Method, Command> commandAnnotations = new HashMap<Method, Command>();
    
    
    /**
     * Pass "cls" to registerMethods().
     * @param cls 
     */
    public void register(Class<?> cls) {
        registerMethods(cls);
    }
    
    /**
     * Register each method marked with annotation @Command.
     * @param cls 
     * 
     * TODO: add unregister function.
     */
    void registerMethods(Class<?> cls) {
        for (Method m : cls.getMethods()) {
            if (!m.isAnnotationPresent(Command.class)) {
                continue;
            }

            Command cmd = m.getAnnotation(Command.class);

            for (String alias : cmd.aliases()) {
                commands.put(alias, m);
            }
            instances.put(m, cls);
            commandAnnotations.put(m, cmd);
        }
    }
    
    /**
     * Search for and execute command with alias "cmd".
     * log error message if we hit an exception
     * 
     * 
     * @param cmd
     * @param sender
     * @param args
     * @return boolean - Returns the success of the command. if unsuccessful, display
     * command/usage information to the sender.
     * TODO: add usage information.
     */
    
    public boolean execute(String cmd, CommandSender sender, String[] args) {
        if (commands.containsKey(cmd)) {
            Method m = commands.get(cmd);
            try {
                if(checkPermissions(sender, m)) {
                    return (Boolean)m.invoke(instances.get(m), sender, args);
                }
                else {
                    sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                }
            } catch (IllegalAccessException ex) {
                sender.sendMessage("Exception!");
                Logger.getLogger(CommandsManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                sender.sendMessage("Exception!");
                Logger.getLogger(CommandsManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                sender.sendMessage("Exception!");
                Logger.getLogger(CommandsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sender.sendMessage(ChatColor.RED + "That command does not exist.");
        }
        return false;
    }
    
    
    /**
     * Check the permissions of "sender" under annotation @CommandPermissions.
     * 
     * @param sender
     * @param method
     * @return boolean - Return whether or not user has permission to use command.
     * if no @CommandPermissions annotation is present, the system assumes no permission is needed
     * and returns true.
     */
    public boolean checkPermissions(CommandSender sender, Method method) {
        CommandPermissions perms = method.getAnnotation(CommandPermissions.class);
        if (perms == null) {
            return true;
            
        }
        
        for(String perm : perms.value()) {
            if(sender.hasPermission(perm)) {
                return true;
            }
        }
        
         return false;
    }
}
