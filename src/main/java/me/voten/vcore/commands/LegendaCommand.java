package me.voten.vcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LegendaCommand implements CommandExecutor{
	
	public LegendaCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
			Player p = (Player) sender;
			p.sendMessage("");
			p.sendMessage("�8��r�8�m--------�r�8�  �d�lLegenda  �8��r�8�m--------�r�8�");
			p.sendMessage("");
			p.sendMessage("�8��7Dostep do komend:");
			p.sendMessage("�a/kit vip, �a/kit svip, �a/kit legenda, /heal");
			p.sendMessage("�a/workbench, /enderchest, /feed");
			p.sendMessage("");
			p.sendMessage("�8��aDostep do DiscoZbroji");
			p.sendMessage("�8��aPosiada 50% mniej przedmiot�w na gildie");
			p.sendMessage("�8��aPrefix na chat: �dLegenda "+ sender.getName()+ "�r � �d wiadomosc");
			p.sendMessage("�8��aPowiekszony Enderchest do 54 slotow");
			p.sendMessage("");
			p.sendMessage("�8��aRange kupisz na stronie: �c�nhttp://WeedCraft.eu");
			p.sendMessage("");
			return false;
	}

}
