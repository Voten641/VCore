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
	    Player p = (Player) sender;
	    
	    if (!(sender instanceof Player)) {
	      sender.sendMessage("§4Blad: §cNie mozesz wykonac tego z consoli!");
	      return true;
	    }
	    if(args.length == 1 && args[0].equalsIgnoreCase("clear")) {
	    	if(sender.hasPermission("vcore.chatclear")) {
				for(Player pl : Bukkit.getOnlinePlayers()){
					if(!pl.hasPermission("vcore.chatclear")){
						for (int x = 0; x < 150; x++){
							pl.sendMessage("");
						}
					}
					pl.sendMessage("§7Chat zostal wyczyszczony przez §a" + sender.getName());
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
		    		Bukkit.broadcastMessage("§7Chat zostal wlaczony przez §a" + sender.getName());
		    		Main.getInst().chatstatus = true;
		    	}
		    	else {
		    		sender.sendMessage("§cChat jest juz wlaczony!");
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
		    		Bukkit.broadcastMessage("§7Chat zostal wylaczony przez §a" + sender.getName());
		    	}
		    	else {
		    		sender.sendMessage("§cChat jest juz wylaczony!");
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
