package me.voten.vcore.guis;

import me.voten.vcore.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import me.voten.vcore.ItemBuilder;

public class EfektyGui {
	
	public static InventoryView efektygui(Player p) {
		Inventory inv = org.bukkit.Bukkit.createInventory(null, 9, Main.message("effect_title"));
		
		ItemStack haste = new ItemBuilder(Material.GOLDEN_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 10).addLoreLine(Main.messagereplace("effect_price", "%price", "16")).setName("§a§lHaste II").toItemStack();
		ItemStack speed = new ItemBuilder(Material.POTION).setDurability((short)8226).addLoreLine(Main.messagereplace("effect_price", "%price", "4")).setName("§a§lSpeed II").toItemStack();
		ItemStack jump = new ItemBuilder(Material.POTION).setDurability((short)8235).addLoreLine(Main.messagereplace("effect_price", "%price", "4")).setName("§a§lJump II").toItemStack();
		ItemStack night = new ItemBuilder(Material.POTION).setDurability((short)8262).addLoreLine(Main.messagereplace("effect_price", "%price", "1")).setName("§a§lNight Vision").toItemStack();
		
		inv.setItem(1, haste);
		inv.setItem(3, speed);
		inv.setItem(5, jump);
		inv.setItem(7, night);
		
		return p.openInventory(inv);
	}

}
