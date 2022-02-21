package me.voten.vcore.commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;


import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.Repairable;

import me.voten.vcore.Main;

public class RepairCommand implements CommandExecutor {
	
	public RepairCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		Player p = (Player) sender;
		ItemStack it = p.getInventory().getItemInMainHand();
		if(p.hasPermission("vcore.repair")) {
			if(it != null && it instanceof Damageable){
				Damageable dm = (Damageable) it.getItemMeta();
				assert dm != null;
				dm.setDamage(0);
				it.setItemMeta(dm);
				p.sendMessage(Main.message("repair"));
			}
		}
		else {
			p.sendMessage(Main.message("permission_message"));
		}
		return false;
	}

}
