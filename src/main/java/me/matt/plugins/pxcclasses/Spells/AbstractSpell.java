/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses.Spells;

import org.bukkit.entity.Player;

/**
 *
 * @author Matt
 */
public interface AbstractSpell {    
    
    public void Cast(Player player);
    public String getName();
    public int getDuration();
    public int getPower();
    public int getLevel();
    
}
