/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses.Spells;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author Matt
 */
public class HasteSpell extends Spell{
    
    PotionEffect potionEffect;
    
    public HasteSpell() {
        super.duration = 240;
        super.level = 0;
        super.name = "Haste";
        super.power = 45;
        potionEffect = new PotionEffect(PotionEffectType.SPEED, duration, power);
    }
    
    @Override
    public void Cast(Player player) {
        if (!player.getActivePotionEffects().contains(potionEffect)) {
            player.addPotionEffect(potionEffect);
            player.sendMessage("Speed increased!");
        }
        else {
            player.sendMessage("Spell is already in effect");
        }
    }
}
