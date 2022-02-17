package me.voten.vcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VipCommand implements CommandExecutor{
	
	public VipCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
			Player p = (Player) sender;
			p.sendMessage("");
			p.sendMessage("�8��r�8�m--------�r�8�  �6�lVIP  �8��r�8�m--------�r�8�");
			p.sendMessage("");
			p.sendMessage("�8��7Dostep do komend:");
			p.sendMessage("�a/kit vip");
			p.sendMessage("�a/workbench");
			p.sendMessage("�a/enderchest");
			p.sendMessage("");
			p.sendMessage("�8��aPrefix na chat: �6Vip "+ sender.getName()+ "�r � �6 wiadomosc");
			p.sendMessage("�8��aPowiekszony Enderchest do 36 slotow");
			p.sendMessage("");
			p.sendMessage("�8��aRange kupisz na stronie: �c�nhttp://WeedCraft.eu");
			p.sendMessage("");
			return false;
	}

}
