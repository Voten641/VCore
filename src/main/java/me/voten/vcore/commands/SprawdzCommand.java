package me.voten.vcore.commands;

import java.util.ArrayList;
import java.util.Map;

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
		Map<Player, Player> spr = Main.getInst().spr;
		ArrayList<Player> online = new ArrayList<>();
		for(Player p2s : Bukkit.getOnlinePlayers()) {
			online.add(p2s);
		}
		if(p.hasPermission("core.pom")) {
			if(args.length == 1) {
				Player p2 = Bukkit.getPlayer(args[0]);
				if(online.contains(p2)) {
					if(!spr.containsKey(p)) {
						if(!spr.containsValue(p2)){
							for(int i=0;i<100;i++) {
								p2.sendMessage("�cJestes sprawdzany przez �a" + p.getDisplayName());
							}
							Main.getInst().getServer().broadcastMessage("�aGracz �c" + p2.getDisplayName() + "�a jest sprawdzany przez �e" + p.getDisplayName());
							spr.put(p, p2);
						}else {
							p.sendMessage("�cTen gracz jest juz sprawdzany!");
						}
					}else {
						p.sendMessage("�cJuz sprawdzasz jednego gracza!");
					}
					
				}else if(args[0].equalsIgnoreCase("czysty")){
					if(spr.containsKey(p)) {
						Main.getInst().getServer().broadcastMessage("�aGracz �c" + spr.get(p).getDisplayName() + " �ajest czysty");
						spr.remove(p);
					}
					else {
						p.sendMessage("�cNikogo nie sprawdzasz!");
					}
				}
				else {
					p.sendMessage("�cGracz " + args[0] + " nie jest online");
				}
			}else {
				p.sendMessage("�cPoprawne uzycie /sprawdz [nick] lub /sprawdz czysty");
			}
		}else {
			p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").replace("&", "�"));
		}
		
		/*if(p.hasPermission("core.pom")) {
			if(args.length == 1) {
				Player che = Bukkit.getPlayer(args[0]);
				int j = 0;
				for(Player che1 : Bukkit.getOnlinePlayers()) {
					if(che1.getPlayer() == che) {
						j++;
					}
				}if(j == 0) {
					if(args[0].equalsIgnoreCase("czysty")) {
						if(spr.containsKey(p)) {
							Player sprawdzany = spr.get(p);
							Main.getInst().getServer().broadcastMessage("�cGracz " + sprawdzany.getDisplayName() + " jest czysty");
							spr.remove(p);
							return true;
						}
						else {
							p.sendMessage("�cNikogo nie sprawdzasz");
							return true;
						}
					}
					else {
					sender.sendMessage("�cGracz nie jest online!");
					return true;
					}
				}
				if(!spr.containsValue(che)) {
					if(!spr.containsKey(p)) {
						Main.getInst().getServer().broadcastMessage("�a"+ p.getDisplayName() +" �csprawdza gracza �a" + che.getDisplayName());
						spr.put(p, che);
					}else {
						p.sendMessage("�cJuz sprawdzasz jednego gracza!");
					}
				}
				else {
					p.sendMessage("�cTen gracz jest juz sprawdzany!");
				}
			}
			else {
				p.sendMessage("�cPoprawne uzycie /sprawdz [nick] lub /sprawdz czysty");
			}
		}
		else {
			p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").replace("&", "�"));
		}*/
		
		return false;
	}

}
