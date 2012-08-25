/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Matt
 */
class CastCommand implements CommandExecutor {

	Pxcclasses plugin;
	
    public CastCommand(Pxcclasses plugin) {
    	this.plugin = plugin;
    }

    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        
    return true;
    }
    
}
