package me.voten.vcore.guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TopkaGui {
	
	public TopkaGui() {}

	public static InventoryView topmenu(Player p) {
		
			/*ArrayList<String> DKey = DataLoader.getTop("deaths", "Key");
			ArrayList<String> DVal = DataLoader.getTop("deaths", "Val");
			ArrayList<String> KKey = DataLoader.getTop("kills", "Key");
			ArrayList<String> KVal = DataLoader.getTop("kills", "Val");
			ArrayList<String> SKey = DataLoader.getTop("stone", "Key");
			ArrayList<String> SVal = DataLoader.getTop("stone", "Val");
		
			Inventory inv = Bukkit.createInventory(null, 9, "�c�lTopka");
			ItemStack deaths = new ItemStack(Material.SKULL_ITEM, 1);
			ItemMeta i1 = deaths.getItemMeta();
			ArrayList<String> lore = new ArrayList<>();
			lore.add("�e1. " + DKey.get(0) + " - " + DVal.get(0));
			lore.add("�72. " + DKey.get(1) + " - " + DVal.get(1));
			lore.add("�63. " + DKey.get(2) + " - " + DVal.get(2));
			i1.setLore(lore);
			i1.setDisplayName("�cTop Smierci");
			deaths.setItemMeta(i1);
			

			ItemStack kills = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta i2 = kills.getItemMeta();
			ArrayList<String> lore2 = new ArrayList<>();
			lore2.add("�e1. " + KKey.get(0) + " - " + KVal.get(0));
			lore2.add("�72. " + KKey.get(1) + " - " + KVal.get(1));
			lore2.add("�63. " + KKey.get(2) + " - " + KVal.get(2));
			i2.setLore(lore2);
			i2.setDisplayName("�cTop zabojstw");
			kills.setItemMeta(i2);
			

			ItemStack stone = new ItemStack(Material.STONE, 1);
			ItemMeta i3 = stone.getItemMeta();
			ArrayList<String> lore3 = new ArrayList<>();
			lore3.add("�e1. " + SKey.get(0) + " - " + SVal.get(0));
			lore3.add("�72. " + SKey.get(1) + " - " + SVal.get(1));
			lore3.add("�63. " + SKey.get(2) + " - " + SVal.get(2));
			i3.setLore(lore3);
			i3.setDisplayName("�cTop wykopanego stone");
			stone.setItemMeta(i3);
			
			inv.setItem(2, deaths);
			inv.setItem(4, kills);
			inv.setItem(6, stone);
			
			return p.openInventory(inv);
			 */
		return null;
	}
}
