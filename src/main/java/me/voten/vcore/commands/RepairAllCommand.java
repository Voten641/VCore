package me.voten.vcore.commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import me.voten.vcore.Main;

public class RepairAllCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		if(p.hasPermission("vcore.repairall")) {
			Inventory inv = p.getInventory();
			int wi = inv.getSize() + 3;
			for(int i=0; i <= wi; i++) {
				ItemStack t = inv.getItem(i);
				if(t != null && t instanceof Damageable){
					Damageable im = (Damageable) t.getItemMeta();
					assert im != null;
					im.setDamage(0);
					t.setItemMeta(im);
				}
			}
			p.sendMessage("§7Naprawiono wszystkie przedmioty");
		}
		else {
			p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage").replace("&", "§"));
		}
		return false;
	}

}
