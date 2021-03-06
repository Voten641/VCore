package me.voten.vcore.commands;

import me.voten.vcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpopCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		Player p = (Player) arg0;
		
		if(arg3.length<1) {
			p.sendMessage(Main.messagereplace("usage", "%command", "/helpop [text]"));
			return true;
		}
		
		p.sendMessage(Main.message("helpop_sent"));

		StringBuilder message = new StringBuilder();
		for(int i = 0; i < arg3.length; i++) {
			message.append(arg3[i] + " ");
		}
		for(Player pl : Bukkit.getOnlinePlayers()){
			if(pl.hasPermission("core.pom")) {
				pl.sendMessage("§8[HELPOP] §a" + p.getDisplayName() + " §c" + message);
			}
		}
		return false;
	}

}
