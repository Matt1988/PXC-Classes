/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses.Classes;

/**
 *
 * @author Matt
 */
public enum CLASS_TYPE {
    WARRIOR("Warrior"),
    MAGE("Mage"),
    ROGUE("Rogue");
    
    private String text;
    
    CLASS_TYPE(String text) {
    	this.text = text;
    }
    
    public String getText() {
    	return this.text;
    }
    
    public static CLASS_TYPE fromString(String text) {
    	if (text != null) {
    		for (CLASS_TYPE	b : CLASS_TYPE.values()) {
    			if (text.equalsIgnoreCase(b.text)) {
    				return b;
    			}
    		}
    	}
    	return null;
    }
}
