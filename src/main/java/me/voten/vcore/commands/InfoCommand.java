package me.voten.vcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {

		Player p = (Player) arg0;

		p.sendMessage("Type: " + p.getItemInHand().getType());
		p.sendMessage("Meta: " + p.getItemInHand().getItemMeta());
		p.sendMessage("Durability: " + p.getItemInHand().getDurability());

		return false;
	}

}