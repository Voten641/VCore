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
				p.sendMessage(Main.messagereplace("nick_set", "%nick", nick));
			}
			else if(args.length == 1) {
				if(!(sender instanceof Player)) return false;
				Player p = (Player) sender;
				nick = args[1].replace("&", "§")+"§r";
				p.setDisplayName(nick);
				p.sendMessage(Main.messagereplace("nick_set", "%nick", nick));
			}
			else if(args.length == 0) {
				sender.sendMessage(Main.message("nick_missing_new"));
			}
			else{
				sender.sendMessage(Main.message("nick_too_many_args"));
			}
		}
		else {
			sender.sendMessage(Main.message("permission_message"));
		}
		
		return true;
	  }

}
