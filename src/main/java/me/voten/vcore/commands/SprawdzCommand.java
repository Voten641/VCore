package me.voten.vcore.commands;

import java.util.ArrayList;
import java.util.Map;

import me.voten.vcore.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.voten.vcore.Main;

public class SprawdzCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		Player p = (Player) sender;
		User u1 = User.getUserByUUID(p.getUniqueId());
		ArrayList<Player> online = new ArrayList<>();
		for(Player p2s : Bukkit.getOnlinePlayers()) {
			online.add(p2s);
		}
		if(p.hasPermission("vcore.checking")) {
			if(args.length == 1) {
				Player p2 = Bukkit.getPlayer(args[0]);
				User user = User.getUserByUUID(p2.getUniqueId());
				if(online.contains(p2)) {
					if(!user.isCheatcheck()) {
						if(!user.cheatcheckby.equals(p)){
							for(int i=0;i<100;i++) {
								p2.sendMessage("§cJestes sprawdzany przez §a" + p.getDisplayName());
							}
							Main.getInst().getServer().broadcastMessage("§aGracz §c" + p2.getDisplayName() + "§a jest sprawdzany przez §e" + p.getDisplayName());
							user.setCheatcheck(true);
							user.setPlayerCheatCheck(p);
						}else {
							p.sendMessage("§cTen gracz jest juz sprawdzany!");
						}
					}else {
						p.sendMessage("§cJuz sprawdzasz jednego gracza!");
					}
					
				}else if(args[0].equalsIgnoreCase("czysty")){
					if(u1.getCheckingplayer()!=null) {
						Main.getInst().getServer().broadcastMessage("§aGracz §c" + u1.getCheckingplayer().getDisplayName() + " §ajest czysty");
						u1.setCheckingplayer(null);
						User u2 = User.getUserByUUID(u1.getCheckingplayer().getUniqueId());
						u2.setCheatcheck(false);
						u2.setPlayerCheatCheck(null);
					}
					else {
						p.sendMessage("§cNikogo nie sprawdzasz!");
					}
				}
				else {
					p.sendMessage("§cGracz " + args[0] + " nie jest online");
				}
			}else {
				p.sendMessage("§cPoprawne uzycie /sprawdz [nick] lub /sprawdz czysty");
			}
		}else {
			p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").replace("&", "§"));
		}
		
		return false;
	}

}
