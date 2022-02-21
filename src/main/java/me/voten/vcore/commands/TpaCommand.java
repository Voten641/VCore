package me.voten.vcore.commands;

import me.voten.vcore.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.voten.vcore.Main;

public class TpaCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

		Player p = (Player) sender;
		if(args.length == 1) {
			Player tep = Bukkit.getPlayer(args[0]);
			int j = 0;
			for(Player p2 : Bukkit.getOnlinePlayers()) {
				if(p2.getPlayer() == tep) {
					j++;
				}
			}
			if(j == 0) {
				sender.sendMessage(Main.message("pplayer_offline"));
				return true;
			}
			if(p!=tep) {
				p.sendMessage(Main.message("tpa_sent_p1"));
				for(String s : Main.messagesreplace("tpa_sent_p2", "%nick", p.getDisplayName())){
					tep.sendMessage(s);
				}
				User u1 = User.getUserByUUID(p.getUniqueId());
				User u2 = User.getUserByUUID(tep.getUniqueId());
				u1.setTeleporttoplayer(tep);
				u1.setPlayerteleporting(true);
				u2.getTeleportsfromplayers().add(p);
			}
		}
		else {
			p.sendMessage(Main.messagereplace("usage", "%command", "/tpa [nick]"));
		}
		
		return false;
	}

}
