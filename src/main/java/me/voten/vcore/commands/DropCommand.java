package me.voten.vcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.voten.vcore.guis.DropGui;

public class DropCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		Player p = (Player) sender;
		DropGui.menudrop(p);
		
		return false;
	}
	
}
