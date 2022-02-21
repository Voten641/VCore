package me.voten.vcore.guis;

import me.voten.vcore.Main;
import me.voten.vcore.utils.User;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Map;


public class EcGui{
	
	public EcGui() {}

	public static InventoryView casemenu(Player p) {
		User user = User.getUserByUUID(p.getUniqueId());
			Inventory inv = org.bukkit.Bukkit.createInventory(null, user.getEnderchestslots(), Main.message("enderchest_title"));

			for(Map.Entry<Integer, ItemStack> entry : user.getEnderchest().entrySet()){
				inv.setItem(entry.getKey(), entry.getValue());
			}
			
			return p.openInventory(inv);
	}

}
