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
public @interface CommandPermissions {
    /**
     * @return a list of permissions. 
     */
    String[] value();
    
}
