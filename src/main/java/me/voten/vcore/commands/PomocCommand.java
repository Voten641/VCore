package me.voten.vcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PomocCommand implements CommandExecutor{
	
	public PomocCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
			Player p = (Player) sender;
			p.sendMessage("");
			p.sendMessage("§8§§r§8§m--------§r§8§  §a§lPomoc  §8§§r§8§m--------§r§8§");
			p.sendMessage("");
			p.sendMessage("§8/drop §7- Wyswietla drop ze stone");
			p.sendMessage("§8/disco §7- DiscoZbroja");
			p.sendMessage("§8/gildia §7- Komendy gildii");
			p.sendMessage("§8/helpop §7- Wiadomosc do administracji");
			p.sendMessage("§8/efekty §7- Kupno efektow");
			p.sendMessage("§8/gracz §7- Informacje o graczu");
			p.sendMessage("§8/info §7- Informacje o gildii");
			p.sendMessage("§8/kit §7- Zestawy");
			p.sendMessage("§8/vip §7- Informacje o randze Vip");
			p.sendMessage("§8/svip §7- Informacje o randze SVip");
			p.sendMessage("§8/legenda §7- Informacje o randze EVip");
			return false;
	}

}
