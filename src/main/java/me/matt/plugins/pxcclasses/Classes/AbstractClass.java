/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses.Classes;

import me.matt.plugins.pxcclasses.Spells.AbstractSpell;
import java.util.HashMap;

/**
 *
 * @author Matt
 */


public interface AbstractClass {
    
    public String getName();
    public int getHpMultiplier();
    public int getJumpHeight();
    public int getSpeedOffset();
    public boolean getNoFallDamage();
    public boolean getNoFireDamage();
    
    public float getMeleeDamageMultiplier();
    public float getRangedDamageMultiplier();
    public float getMagicDamageMultiplier();
    
    public int getEnergyMultiplier();
    
    public HashMap<String, AbstractSpell> getSpells();

}
