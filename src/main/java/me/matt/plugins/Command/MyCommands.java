/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.Command;

import org.bukkit.command.CommandSender;

/**
 *
 * @author Matt
 */
public class MyCommands {
     
    /**
     * A simple test function.
     * 
     * @param sender
     * @param args
     * @return - boolean, return the success of the command. If true is passed
     * the system assumes that the command was successful, if false is passed command
     * usage and description is displayed to "sender".
     * 
     */
     @Command(
        aliases = {"test"},
        desc = "Tests the command system.",
        usage = "/test - Tests the command system."
    )
    @CommandPermissions("test.op")
    public static boolean test(CommandSender sender, String[] args) {
        sender.sendMessage("yep");
        return true;
    }
}
