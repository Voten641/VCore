package me.voten.vcore.guis;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import me.voten.vcore.ItemBuilder;

public class KitGui {

	public KitGui() {}

	public static InventoryView kitmenu(Player p) {
			Inventory inv = org.bukkit.Bukkit.createInventory(null, 9, "§c§lKity");
			
			ArrayList<String> gr = new ArrayList<String>();
			gr.add("§aZawiera:");
			gr.add("");
			gr.add("§7- Drewniana Siekiera");
			gr.add("§7- 64xMieso");
			gr.add("§7- EnderChest");
			
			ArrayList<String> vp = new ArrayList<String>();
			vp.add("§aZawiera:");
			vp.add("");
			vp.add("§7- Zbroja 4/3");
			vp.add("§7- Miecz 5/2");
			vp.add("§7- Miecz Knock");
			vp.add("§7- 1xKox");
			vp.add("§7- 4xRefil");
			vp.add("§7- Kilof 5/3/3");
			
			ArrayList<String> sp = new ArrayList<String>();
			sp.add("§aZawiera:");
			sp.add("");
			sp.add("§7- Zbroja 4/3");
			sp.add("§7- Miecz 5/2");
			sp.add("§7- Miecz Knock");
			sp.add("§7- 2xKox");
			sp.add("§7- 8xRefil");
			sp.add("§7- Kilof 5/3/3");
			
			ArrayList<String> le = new ArrayList<String>();
			le.add("§aZawiera:");
			le.add("");
			le.add("§7- 10xWeedCase");
			le.add("§7- Kilof 10/3/3");
			le.add("§7- Luk Punch");
			le.add("§7- Strzala");
			
			ItemStack gracz = new ItemBuilder(Material.LEATHER_HELMET).setLore(gr).setName("§7Kit Gracz").toItemStack();
			ItemStack vip = new ItemBuilder(Material.IRON_HELMET).setLore(vp).setName("§7Kit Vip").toItemStack();
			ItemStack svip = new ItemBuilder(Material.GOLDEN_HELMET).setLore(sp).setName("§7Kit Svip").toItemStack();
			ItemStack legenda = new ItemBuilder(Material.DIAMOND_HELMET).setLore(le).setName("§7Kit Legenda").toItemStack();
			
			inv.setItem(1, gracz);
			inv.setItem(3, vip);
			inv.setItem(5, svip);
			inv.setItem(7, legenda);
			
			return p.openInventory(inv);
	}
}
