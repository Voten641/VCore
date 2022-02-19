package me.voten.vcore.guis;

import java.util.Collections;

import me.voten.vcore.utils.User;
import me.voten.vcore.utils.XMaterial;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatGui {
	
	public ChatGui() {}

	private static String setItem(Boolean bol){
		String s = String.valueOf(bol);
		s=s.replace("true", "LIME_STAINED_GLASS_PANE");
		s=s.replace("false", "RED_STAINED_GLASS_PANE");
		return s;
	}
	private static String setStatus(Boolean bol){
		String s = String.valueOf(bol);
		s=s.replace("true", "§aWlaczone");
		s=s.replace("false", "§cWylaczone");
		return s;
	}

	public static InventoryView menuchat(Player p) {
		
		Inventory inv = org.bukkit.Bukkit.createInventory(null, 9, "§c§lKonfiguracja Chatu");
		User user = User.getUserByUUID(p.getUniqueId());

		ItemStack automessitem = XMaterial.valueOf(setItem(user.isAutomaticchatmessages())).parseItem();
		ItemMeta im = automessitem.getItemMeta();
		assert im != null;
		im.setLore(Collections.singletonList("§7Status: " + setStatus(user.isAutomaticchatmessages())));
		im.setDisplayName("§aWiadomosci automatyczne");
		automessitem.setItemMeta(im);
		inv.setItem(0, automessitem);

		ItemStack caseitem = XMaterial.valueOf(setItem(user.isCasechatmessages())).parseItem();
		im = caseitem.getItemMeta();
		assert im != null;
		im.setLore(Collections.singletonList("§7Status: " + setStatus(user.isCasechatmessages())));
		im.setDisplayName("§aWiadomosci ze skrzynek");
		caseitem.setItemMeta(im);
		inv.setItem(1, caseitem);

		ItemStack privateitem = XMaterial.valueOf(setItem(user.isPrivatemessages())).parseItem();
		im = privateitem.getItemMeta();
		assert im != null;
		im.setLore(Collections.singletonList("§7Status: " + setStatus(user.isPrivatemessages())));
		im.setDisplayName("§aWiadomosci prywatne");
		privateitem.setItemMeta(im);
		inv.setItem(2, privateitem);

		ItemStack killitem = XMaterial.valueOf(setItem(user.isKillmessages())).parseItem();
		im = killitem.getItemMeta();
		assert im != null;
		im.setLore(Collections.singletonList("§7Status: " + setStatus(user.isKillmessages())));
		im.setDisplayName("§aWiadomosci o zabójstwach");
		killitem.setItemMeta(im);
		inv.setItem(3, killitem);

		ItemStack dropitem = XMaterial.valueOf(setItem(user.isDropmessages())).parseItem();
		im = dropitem.getItemMeta();
		assert im != null;
		im.setLore(Collections.singletonList("§7Status: " + setStatus(user.isDropmessages())));
		im.setDisplayName("§aWiadomosci o Dropie");
		dropitem.setItemMeta(im);
		inv.setItem(4, dropitem);

		ItemStack globalitem = XMaterial.valueOf(setItem(user.isGlobalmessages())).parseItem();
		im = globalitem.getItemMeta();
		assert im != null;
		im.setLore(Collections.singletonList("§7Status: " + setStatus(user.isGlobalmessages())));
		im.setDisplayName("§aWiadomosci globalne");
		globalitem.setItemMeta(im);
		inv.setItem(5, globalitem);

	    ItemStack br = XMaterial.valueOf("GRAY_STAINED_GLASS_PANE").parseItem();
	    ItemMeta ibr = br.getItemMeta();
		assert ibr != null;
		ibr.setDisplayName("§7Brak");
	    br.setItemMeta(ibr);
	    inv.setItem(6, br);
	    inv.setItem(7, br);
	    inv.setItem(8, br);
		
		return p.openInventory(inv);
	}

}
