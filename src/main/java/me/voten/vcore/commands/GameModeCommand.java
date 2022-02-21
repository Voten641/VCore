package me.voten.vcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.voten.vcore.Main;

public class GameModeCommand implements CommandExecutor{
	
	public GameModeCommand() {}
	
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
	  {
		Player p = (Player) sender;
		if(sender.hasPermission("core.gm")) {
			if(args.length == 2) {
				p = Bukkit.getPlayer(args[1]);
				changegm(p, args[0]);
			}
			else if(args.length == 1) {
				p = (Player) sender;
				changegm(p, args[0]);
			}
			else {
				sender.sendMessage(Main.message("gamemode_error"));
			}
		}
		else {
			p.sendMessage(Main.message("permission_message"));
		}
		
		return true;
	  }

	  public void changegm(Player p, String arg){
		switch (arg){
			case "0":
			case "survival":
			case "s":
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(Main.messagereplace("gamemode_change", "%gm", p.getGameMode().toString()));
				break;
			case "1":
			case "creative":
			case "c":
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage(Main.messagereplace("gamemode_change", "%gm", p.getGameMode().toString()));
				break;
			case "2":
			case "adventure":
			case "a":
				p.setGameMode(GameMode.ADVENTURE);
				p.sendMessage(Main.messagereplace("gamemode_change", "%gm", p.getGameMode().toString()));
				break;
			case "3":
			case "spectator":
			case "sp":
				p.setGameMode(GameMode.SPECTATOR);
				p.sendMessage(Main.messagereplace("gamemode_change", "%gm", p.getGameMode().toString()));
				break;
		}
	  }

}