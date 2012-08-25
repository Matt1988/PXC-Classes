/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses.Spells;

import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;

/**
 *
 * @author Matt
 */
public class FireballSpell extends Spell {
    
    public FireballSpell() {
        super.duration = 0;
        super.level = 0;
        super.name = "Fireball";
        super.power = 5;
    }
    
    
    @Override
    public void Cast(Player player ) {
        player.launchProjectile(SmallFireball.class);
    }
}
