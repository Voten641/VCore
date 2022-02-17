package me.voten.vcore.commands;

import me.voten.vcore.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MsgCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String arg2, String[] args) {
		if(args.length >= 2) {
			Player rec = Bukkit.getPlayer(args[0]);
			StringBuilder message = new StringBuilder();
			for(int i = 1; i < args.length; i++) {
				message.append(args[i]).append(" ");
			}
			int j = 0;
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(p.getPlayer() == rec) {
					j++;
				}
			}
			if(j == 0) {
				sender.sendMessage("§cGracz nie jest online!");
				return true;
			}

			assert rec != null;
			User user = User.getUserByUUID(rec.getUniqueId());
			if(!sender.getName().equals(rec.getName())) {
				assert user != null;
				if(user.isPrivatemessages()) {
					rec.sendMessage("§a" + sender.getName() + " §7-> §a" + rec.getName() + " §7" + message);
					sender.sendMessage("§a" + sender.getName() + " §7-> §a" + rec.getName() + " §7" + message);
				}
				else {
					sender.sendMessage("§a" + rec.getName() + "§c ma wylaczone wiadomosci prywatne");
				}
			}else {
				sender.sendMessage("§cNie mozesz wyslac wiadomosci do siebie!");
			}
		}
		else {
			sender.sendMessage("§cMusisz podac nick i wpisac wiadomosc do gracza!");
		}
		
		return false;
	}

}
