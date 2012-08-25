package me.matt.plugins.pxcclasses;

import me.matt.plugins.pxcclasses.Classes.CLASS_TYPE;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateCommand implements CommandExecutor {
	Pxcclasses plugin;
	public CreateCommand(Pxcclasses plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s,
			String[] args) {
		
		if (sender instanceof Player) {
			String v = args[0];
			
			Player player = (Player)sender;
			
			CLASS_TYPE type = CLASS_TYPE.fromString(v);
			if (type == null) {
				player.sendMessage("No such class");
				return true;
			}
			
			
			Pxcplayer pxcPlayer = Pxcplayer.createPlayer(player.getName(), type.getText(), 1);
			if(pxcPlayer == null) {
				player.sendMessage("You have already chosen your class!");
				return true;
			}
			Pxcclasses.Players.put(player, pxcPlayer); 
			player.sendMessage("You have chosen class" + type.getText());
		}
		
		return true;
	}

}
