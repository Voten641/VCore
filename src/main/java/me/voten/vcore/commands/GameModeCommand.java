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
				if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§7Zmieniono tryb gry na §aSurvival");
				}
				else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§7Zmieniono tryb gry na §aCreative");
				}
				else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage("§7Zmieniono tryb gry na §aAdventure");
				}
				else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage("§7Zmieniono tryb gry na §aAdventure");
				}
			}
			else if(args.length == 1) {
				p = (Player) sender;
				if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§7Zmieniono tryb gry na §aSurvival");
				}
				else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§7Zmieniono tryb gry na §aCreative");
				}
				else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage("§7Zmieniono tryb gry na §aAdventure");
				}
				else if(args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("spectator")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage("§7Zmieniono tryb gry na §aAdventure");
				}
			}
			else {
				sender.sendMessage("§cMusisz podac tryb gry!");
			}
		}
		else {
			p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").replace("&", "§"));
		}
		
		return true;
	  }

}