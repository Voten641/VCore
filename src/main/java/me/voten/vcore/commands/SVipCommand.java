package me.voten.vcore.commands;

import me.voten.vcore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SVipCommand implements CommandExecutor{
	
	public SVipCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player) sender;
		for(String s : Main.messages("svip")) {
			p.sendMessage(s);
		}
			return false;
	}

}
