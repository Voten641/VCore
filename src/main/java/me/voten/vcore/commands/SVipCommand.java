package me.voten.vcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SVipCommand implements CommandExecutor{
	
	public SVipCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
			Player p = (Player) sender;
			p.sendMessage("");
			p.sendMessage("�8��r�8�m--------�r�8�  �e�lSVIP  �8��r�8�m--------�r�8�");
			p.sendMessage("");
			p.sendMessage("�8��7Dostep do komend:");
			p.sendMessage("�a/kit vip, �a/kit svip, /heal, /feed");
			p.sendMessage("�a/workbench, /enderchest");
			p.sendMessage("");
			p.sendMessage("�8��aDostep do DiscoZbroji");
			p.sendMessage("�8��aPosiada 50% mniej przedmiot�w na gildie");
			p.sendMessage("�8��aPrefix na chat: �eSVip "+ sender.getName()+ "�r � �e wiadomosc");
			p.sendMessage("�8��aPowiekszony Enderchest do 45 slotow");
			p.sendMessage("");
			p.sendMessage("�8��aRange kupisz na stronie: �c�nhttp://WeedCraft.eu");
			p.sendMessage("");
			return false;
	}

}
