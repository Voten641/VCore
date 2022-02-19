package me.voten.vcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.voten.vcore.Main;


public class VcCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

		if(sender.hasPermission("core.admin")) {
			if(args.length != 0 && args[0].equalsIgnoreCase("reload")) {
				Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getServer().getPluginManager().getPlugin("VCore"));
				Bukkit.getServer().getPluginManager().enablePlugin(Bukkit.getServer().getPluginManager().getPlugin("VCore"));
				Main.getInst().reloadConfig();
				return true;
			}
			else if(args.length != 0 && args[0].equalsIgnoreCase("off")) {
				Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getServer().getPluginManager().getPlugin("VCore"));
			}else if(args.length != 0 && args[0].equalsIgnoreCase("on")) {
				Bukkit.getServer().getPluginManager().enablePlugin(Bukkit.getServer().getPluginManager().getPlugin("VCore"));
			}
			else {
				return true;
			}
		}
		else {
			sender.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").replace("&", "§"));
		}
		
		return false;
	}

}
