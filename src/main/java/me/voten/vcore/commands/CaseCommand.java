package me.voten.vcore.commands;

import me.voten.vcore.guis.CaseGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CaseCommand implements CommandExecutor{
	
	public CaseCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player) sender;
		CaseGui.casemenu(p);
		return true;
	}

}
