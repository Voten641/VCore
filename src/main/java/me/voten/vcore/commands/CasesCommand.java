package me.voten.vcore.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CasesCommand implements CommandExecutor {
	
	public CasesCommand() {}
	
	public static ItemMeta Cases() {
		ItemStack i = new ItemStack(Material.ACACIA_DOOR);
	    ItemMeta on = i.getItemMeta();
	    	ArrayList<String> loreon = new ArrayList<String>();
		    loreon.add("§7§ Postaw aby otworzyc");
		    loreon.add("§7§ Drop mozna sprawdzic pod komenda §a/case");
		    on.setLore(loreon);
		    on.setDisplayName("§a§lWeedCase");
		    
		return on;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p;
		if(sender.hasPermission("core.cases")) {
			if(args.length == 1) {
				p = (Player) sender;
				ItemStack Cases = new ItemStack(Material.CHEST, Integer.parseInt(args[0]));
				Cases.setItemMeta(Cases());
				p.getWorld().dropItem(p.getLocation(), Cases);
			}
			else if(args.length == 2) {
				if (sender instanceof ConsoleCommandSender || sender instanceof Player) {
					p = Bukkit.getPlayer(args[0]);
					ItemStack Cases = new ItemStack(Material.CHEST, Integer.parseInt(args[1]));
					Cases.setItemMeta(Cases());
					p.getWorld().dropItem(p.getLocation(), Cases);
				}
			}
		}
		return false;
	}

}
