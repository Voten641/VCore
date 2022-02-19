package me.voten.vcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.voten.vcore.Main;

public class NickCommand implements CommandExecutor{
	
	public NickCommand() {}
	
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
	  {
		if(sender.hasPermission("core.nick")) {
			String nick;
			if(args.length == 2) {
				Player p = Bukkit.getPlayer(args[0]);
				nick = args[1].replace("&", "§")+"§r";
				p.setDisplayName(nick);
				p.sendMessage("§cUstawiono nick jako: "+ nick);
			}
			else if(args.length == 1) {
				sender.sendMessage("§cMusisz podac nowa nazwe!");
			}
			else if(args.length == 0) {
				sender.sendMessage("§cMusisz podac nick gracza!");
			}
			else{
				sender.sendMessage("§cPodales zbyt duzo argumentow!");
			}
		}
		else {
			sender.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").replace("&", "§"));
		}
		
		return true;
	  }

}
