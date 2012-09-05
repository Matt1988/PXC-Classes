/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.Command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Matt
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    /**
     * 
     * @return returns list of aliases. 
     */
    String[] aliases();
    
    /**
     * 
     * @return returns description
     */
    String desc();
    
    /**
     * 
     * @return returns command usage information.
     */
    String usage();
}
