/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses.Classes;

import me.matt.plugins.pxcclasses.Classes.CLASS_TYPE;
import me.matt.plugins.pxcclasses.Classes.AbstractClass;
import me.matt.plugins.pxcclasses.Spells.AbstractSpell;
import java.util.HashMap;

/**
 *
 * @author Matt
 */
public class Class implements AbstractClass {
    protected HashMap<String, AbstractSpell> spells = new HashMap<String, AbstractSpell>();
    
    public CLASS_TYPE type = CLASS_TYPE.WARRIOR;
    
    protected String name = "Warrior";
    
    protected int hpMultiplier = 20;
    protected int energyMultiplier = 5;
    
    protected boolean noFireDamage = false;
    protected boolean noFallDamage = false;
    protected int speedOffset = 0;
    protected int jumpHeight = 0;
    protected float meleeDamageMultiplier = 1.20f;
    protected float rangedDamageMultiplier = 1;
    protected float magicDamageMultiplier = 0;

    /**
     * @return the spells
     */
    public HashMap<String, AbstractSpell> getSpells() {
        return spells;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the hpMultiplier
     */
    public int getHpMultiplier() {
        return hpMultiplier;
    }

    /**
     * @return the energyMultiplier
     */
    public int getEnergyMultiplier() {
        return energyMultiplier;
    }

    /**
     * @return the noFireDamage
     */
    public boolean getNoFireDamage() {
        return noFireDamage;
    }

    /**
     * @return the noFallDamage
     */
    public boolean getNoFallDamage() {
        return noFallDamage;
    }

    /**
     * @return the speedOffset
     */
    public int getSpeedOffset() {
        return speedOffset;
    }

    /**
     * @return the jumpHeight
     */
    public int getJumpHeight() {
        return jumpHeight;
    }

    /**
     * @return the meleeDamageMultiplier
     */
    public float getMeleeDamageMultiplier() {
        return meleeDamageMultiplier;
    }

    /**
     * @return the rangedDamageMultiplier
     */
    public float getRangedDamageMultiplier() {
        return rangedDamageMultiplier;
    }

    /**
     * @return the magicDamageMultiplier
     */
    public float getMagicDamageMultiplier() {
        return magicDamageMultiplier;
    }

    
    
    
    
}
