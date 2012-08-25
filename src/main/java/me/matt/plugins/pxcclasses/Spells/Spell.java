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
public class Spell implements AbstractSpell {
    
    
    protected String name;
    protected int duration;
    protected int power;
    protected int level;

    public void Cast(Player player) {
    
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getPower() {
        return power;
    }
    
    public int getLevel() {
        return level;
    }
    
}
