/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses.Classes;
import me.matt.plugins.pxcclasses.Spells.HasteSpell;
    
    
/**
 *
 * @author Matt
 */
public class WarriorClass extends Class{
    
    
    public WarriorClass() {
        super.name = "Warrior";
        super.hpMultiplier = 20;
        super.energyMultiplier = 5;
        super.noFireDamage = false;
        super.noFallDamage = false;
        super. speedOffset = 0;
        super.jumpHeight = 0;
        super.meleeDamageMultiplier = 1.20f;
        super.rangedDamageMultiplier = 1;
        super.magicDamageMultiplier = 0;
        SetSpells();
    }

    private void SetSpells() {
        spells.put("Haste", new HasteSpell());
    }
    
    
}
