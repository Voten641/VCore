package me.voten.vcore.guis;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DiscoGui {
	
	public DiscoGui() {}

	public static InventoryView discomenu(Player p) {
			Inventory inv = org.bukkit.Bukkit.createInventory(null, 9, "§c§lDiscoZbroja");
			ItemStack kox = new ItemStack(Material.GOLDEN_APPLE, 2, (short)1);
			ItemMeta i1 = kox.getItemMeta();
			i1.setLore(Arrays.asList("§7Szansa: §c2.5%"));
			kox.setItemMeta(i1);
			ItemStack ref = new ItemStack(Material.GOLDEN_APPLE, 5, (short)0);
			ItemMeta i2 = kox.getItemMeta();
			i2.setLore(Arrays.asList("§7Szansa: §c3%"));
			ref.setItemMeta(i2);
			
			inv.setItem(3, kox);
			inv.setItem(7, ref);
			
			return p.openInventory(inv);
	}
}
