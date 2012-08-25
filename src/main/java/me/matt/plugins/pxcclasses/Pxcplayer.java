/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.matt.plugins.pxcclasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bukkit.entity.Player;

import com.avaje.ebean.validation.NotEmpty;
import com.avaje.ebean.validation.NotNull;
/**
 *
 * @author Matt
 */
@Entity()
@Table(name = "PxcClasses")
public class Pxcplayer {
    
    @Id
    private int id;
    
    @NotEmpty
    private String pclass;
    
    @NotNull
    private int plevel;
    
    @NotEmpty
    private String pname;
    
    public Pxcplayer() {}
    
    public Pxcplayer(String playerName, String playerClass, int playerLevel) {
        this.pname = playerName;
        this.pclass = playerClass;
        this.plevel = playerLevel;
    }

    

    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public static Pxcplayer getPlayerFromDatabase(Player player) {
		String n = player.getName();
    	return Pxcclasses.getInstance().getDatabase().find(Pxcplayer.class).where().ieq("pname", n).findUnique();
    }
    public static Pxcplayer getPlayerFromDatabase(String n) {
		
    	return Pxcclasses.getInstance().getDatabase().find(Pxcplayer.class).where().ieq("pname", n).findUnique();
    }

	public static Pxcplayer createPlayer(String name, String text, int level) {
		
		Pxcplayer player = new Pxcplayer(name, text, level);
		
		if (Pxcplayer.getPlayerFromDatabase(player.getPname()) != null) return null;
		
		Pxcclasses.getInstance().getDatabase().save(player);
		return player;
		
	}

    /**
     * @return the pclass
     */
    public String getPclass() {
        return pclass;
    }

    /**
     * @param pclass the pclass to set
     */
    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    /**
     * @return the plevel
     */
    public int getPlevel() {
        return plevel;
    }

    /**
     * @param plevel the plevel to set
     */
    public void setPlevel(int plevel) {
        this.plevel = plevel;
    }

    /**
     * @return the pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pname the pname to set
     */
    public void setPname(String pname) {
        this.pname = pname;
    }
    
    
}
