package me.voten.vcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.voten.vcore.Main;

public class FlyCommand implements CommandExecutor {
	
	public FlyCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		Player p = (Player) sender;
		if(p.hasPermission("core.fly")) {
			p.setAllowFlight(!p.getAllowFlight());
			p.sendMessage(Main.message("fly_change"));
		}
		else {
			p.sendMessage(Main.message("permission_message"));
		}
		
		return false;
	}
	
	

}
