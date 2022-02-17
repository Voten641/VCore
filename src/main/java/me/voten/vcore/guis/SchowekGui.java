package me.voten.vcore.guis;

import java.util.ArrayList;
import java.util.List;

import me.voten.vcore.utils.User;
import me.voten.vcore.utils.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SchowekGui {
	
	public static InventoryView menu(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 9, "§c§lSchowek");
		
		ItemStack sz = XMaterial.valueOf("GRAY_GLASS_PANE").parseItem();
		ItemMeta sz2 = sz.getItemMeta();
		assert sz2 != null;
		sz2.setDisplayName("§7----------------------");
		sz.setItemMeta(sz2);
		
		User user = User.getUserByUUID(p.getUniqueId());
		
		List<String> lorekox = new ArrayList<String>();
		assert user != null;
		lorekox.add("§7W schowku: §c" + user.getEnchga());
		lorekox.add("§aPrawy §8przycisk myszy - Zabierz 1");
		lorekox.add("§aLewy §8przycisk myszy - Zabierz do limitu");
		
		List<String> loreref = new ArrayList<String>();
		loreref.add("§7W schowku: §c" + user.getGa());
		loreref.add("§aPrawy §8przycisk myszy - Zabierz 1");
		loreref.add("§aLewy §8przycisk myszy - Zabierz do limitu");
		
		List<String> loreper = new ArrayList<String>();
		loreper.add("§7W schowku: §c" + user.getPearl());
		loreper.add("§aPrawy §8przycisk myszy - Zabierz 1");
		loreper.add("§aLewy §8przycisk myszy - Zabierz do limitu");
		
		
		ItemStack kox = XMaterial.valueOf("ENCHANTED_GOLDEN_APPLE").parseItem();
		ItemMeta kox2 = kox.getItemMeta();
		assert kox2 != null;
		kox2.setDisplayName("§c§lKoxy:");
		kox2.setLore(lorekox);
		kox.setItemMeta(kox2);
		
		ItemStack ref = XMaterial.valueOf("GOLDEN_APPLE").parseItem();
		ItemMeta ref2 = ref.getItemMeta();
		assert ref2 != null;
		ref2.setDisplayName("§c§lRefy:");
		ref2.setLore(loreref);
		ref.setItemMeta(ref2);
		
		ItemStack per = XMaterial.valueOf("ENDER_PEARL").parseItem();
		ItemMeta per2 = per.getItemMeta();
		assert per2 != null;
		per2.setDisplayName("§c§lPerly:");
		per2.setLore(loreper);
		per.setItemMeta(per2);
		
		inv.setItem(0, sz);
		inv.setItem(1, kox);
		inv.setItem(2, sz);
		inv.setItem(3, sz);
		inv.setItem(4, ref);
		inv.setItem(5, sz);
		inv.setItem(6, sz);
		inv.setItem(7, per);
		inv.setItem(8, sz);
		
		return p.openInventory(inv);
	}

}
