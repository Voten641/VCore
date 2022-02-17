package me.voten.vcore.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
			Player p = (Player) sender;
			Location l = p.getLocation();
			World w = p.getWorld();
			w.setSpawnLocation(l.getBlockX(), l.getBlockY(), l.getBlockZ());
			
			p.sendMessage("�a�lSpawn Ustawiony.");
		
		return false;
	}

}
