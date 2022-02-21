package me.voten.vcore.commands;

import me.voten.vcore.guis.ChatGui;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.voten.vcore.Main;


public class ChatCommand implements CommandExecutor {

	public ChatCommand() {}
	
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
	  {
	    if (!(sender instanceof Player)) {
	      sender.sendMessage(Main.message("console_error_command"));
	      return true;
	    }
		Player p = (Player) sender;
	    if(args.length == 1 && args[0].equalsIgnoreCase("clear")) {
	    	if(sender.hasPermission("vcore.chatclear")) {
				for(Player pl : Bukkit.getOnlinePlayers()){
					if(!pl.hasPermission("vcore.chatclear")){
						for (int x = 0; x < 150; x++){
							pl.sendMessage("");
						}
					}
					pl.sendMessage(Main.messagereplace("chat_clear", "%name", p.getName()));
				}
	    	}
	    	else {
	    		p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").
						replace("&", "§"));
	    		}
	    }
	    else if(args.length == 1 && args[0].equalsIgnoreCase("on")) {
	    	if(sender.hasPermission("vcore.chatenable")) {
		    	if(!Main.getInst().chatstatus) {
		    		Bukkit.broadcastMessage(Main.messagereplace("chat_on", "%name", p.getName()));
		    		Main.getInst().chatstatus = true;
		    	}
		    	else {
		    		sender.sendMessage(Main.message("chat_already_on"));
		    	}
	    	}
	    	else {
	    		p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").
						replace("&", "§"));
	    	}
	    }
	    else if(args.length == 1 && args[0].equalsIgnoreCase("off")) {
	    	if(sender.hasPermission("vcore.chatdisable")) {
		    	if(Main.getInst().chatstatus) {
		    		Main.getInst().chatstatus = false;
		    		Bukkit.broadcastMessage(Main.messagereplace("chat__off", "%name", p.getName()));
		    	}
		    	else {
		    		sender.sendMessage(Main.message("chat_already_off"));
		    	}
		    }
	    	else {
	    		p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").
						replace("&", "§"));
	    	}
	    }
	    else {
	    	ChatGui.menuchat(p);
	    }
	    return false;
	  }
}
