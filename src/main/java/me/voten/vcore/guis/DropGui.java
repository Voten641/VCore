package me.voten.vcore.guis;

import java.util.ArrayList;
import java.util.Arrays;

import me.voten.vcore.utils.ConfigurationSerializableDataType;
import me.voten.vcore.utils.Item;
import me.voten.vcore.utils.User;
import me.voten.vcore.utils.XMaterial;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.voten.vcore.Main;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class DropGui {

	public static ItemStack eStone() {
		ItemStack item = new ItemStack(Material.COBBLESTONE);
		ItemMeta st = item.getItemMeta();
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("§8§lDrop: §aWlaczony");
		st.setLore(lst);
		st.setDisplayName("§7Cobblestone");
		item.setItemMeta(st);
		return item;
	}public static ItemStack dStone() {
		ItemStack item = new ItemStack(Material.COBBLESTONE);
		ItemMeta st = item.getItemMeta();
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("§8§lDrop: §cWylaczony");
		st.setLore(lst);
		st.setDisplayName("§7Cobblestone");
		item.setItemMeta(st);
		return item;
	}
	public static ItemStack eCase() {
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta st = item.getItemMeta();
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("§8> Szansa na drop:§a " + Main.getInst().getConfig().getDouble("drop.case") + "%");
		lst.add("");
		lst.add("§8§lDrop: §aWlaczony");
		st.setLore(lst);
		st.setDisplayName(Main.message("case_name"));
		item.setItemMeta(st);
		return item;
	}public static ItemStack dCase() {
		ItemStack item = new ItemStack(Material.CHEST);
		ItemMeta st = item.getItemMeta();
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("§8> Szansa na drop:§a " + Main.getInst().getConfig().getDouble("drop.case") + "%");
		lst.add("");
		lst.add("§8§lDrop: §cWylaczony");
		st.setLore(lst);
		st.setDisplayName(Main.message("case_name"));
		item.setItemMeta(st);
		return item;
	}
	
	public static InventoryView menudrop(Player p) {
		
		Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, Main.message("drop_title"));
		
		ItemStack en = XMaterial.valueOf("LIME_STAINED_GLASS_PANE").parseItem();
	    ItemMeta ien = en.getItemMeta();
	    ien.setDisplayName(Main.message("enable_all"));
	    en.setItemMeta(ien);
	    
	    ItemStack d = XMaterial.valueOf("RED_STAINED_GLASS_PANE").parseItem();
	    ItemMeta id = d.getItemMeta();
	    id.setDisplayName(Main.message("disable_all"));
	    d.setItemMeta(id);
	    
	    ItemStack s = new ItemStack(Material.CHEST);
	    ItemMeta is = s.getItemMeta();
	    is.setDisplayName(Main.message("case_title"));
	    s.setItemMeta(is);
	    
	    inv.setItem(27, en);
	    inv.setItem(28, d);
	    inv.setItem(31, s);

		User user = User.getUserByUUID(p.getUniqueId());

		for(Item item : Item.allItems){
			ItemStack it = item.getItem();
			ItemMeta im = it.getItemMeta();
			assert im != null;
			im.setDisplayName(item.getName().replace("&", "§"));
			im.setLore(Main.messagesreplace("item_lore", Arrays.asList("%chance","%status"), Arrays.asList(String.valueOf(item.getChance()),setStatus(user.getDrop(item)))));
			NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "itemclass");
			PersistentDataType<byte[], Item> itemclasstype = new ConfigurationSerializableDataType<>(Item.class);
			PersistentDataContainer pdc = im.getPersistentDataContainer();
			pdc.set(key, itemclasstype, item);
			it.setItemMeta(im);
		}

	    if(user.isCobbledrop()) {
	    	inv.setItem(35, eStone());
	    }
	    else {
	    	inv.setItem(35, dStone());
	    }

		return p.openInventory(inv);
	}

	private static String setStatus(Boolean bol){
		String s = String.valueOf(bol);
		s=s.replace("true", "§aWlaczone");
		s=s.replace("false", "§cWylaczone");
		return s;
	}
}
