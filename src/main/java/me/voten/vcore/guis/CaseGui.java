package me.voten.vcore.guis;

import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.voten.vcore.ItemBuilder;

public class CaseGui{
	
	public CaseGui() {}

	public static InventoryView casemenu(Player p) {
			Inventory inv = org.bukkit.Bukkit.createInventory(null, 27, "§c§lDrop Ze Skrzynek");
			
			ItemStack bc = new ItemBuilder(Material.BEACON).setLore("§7Szansa: §c0.5%").setName("§aB§bE§cA§dC§eO§6N").toItemStack();
			ItemStack kl1 = new ItemBuilder(Material.DIAMOND_PICKAXE).setLore("§7Szansa: §c1%").setName("§a§lWeedCraft §7§l- Kilof 10/5/3").addEnchant(Enchantment.DIG_SPEED, 10).addEnchant(Enchantment.DURABILITY, 5).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).toItemStack();
			ItemStack bania = new ItemBuilder(Material.DIAMOND_HELMET).setLore("§7Szansa: §c3%").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
			ItemStack klata = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setLore("§7Szansa: §c3%").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
			ItemStack spodnie = new ItemBuilder(Material.DIAMOND_LEGGINGS).setLore("§7Szansa: §c3%").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
			ItemStack buty = new ItemBuilder(Material.DIAMOND_BOOTS).setLore("§7Szansa: §c3%").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
			ItemStack miecz = new ItemBuilder(Material.DIAMOND_SWORD).setLore("§7Szansa: §c4%").addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).toItemStack();
			ItemStack knock = new ItemBuilder(Material.DIAMOND_SWORD).setLore("§7Szansa: §c4%").addEnchant(Enchantment.KNOCKBACK, 2).toItemStack();
			ItemStack kl2 = new ItemBuilder(Material.DIAMOND_PICKAXE).setLore("§7Szansa: §c8%").addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).toItemStack();
			ItemStack cb = new ItemBuilder(Material.COBBLESTONE, 4).setLore("§7Szansa: §c9%").toItemStack();
			ItemStack pe = new ItemBuilder(Material.ENDER_PEARL, 4).setLore("§7Szansa: §c2.5%").toItemStack();
			ItemStack jb = new ItemBuilder(Material.APPLE, 16).setLore("§7Szansa: §c10%").toItemStack();
			ItemStack tnt = new ItemBuilder(Material.TNT, 16).setLore("§7Szansa: §c10%").toItemStack();
			ItemStack zl = new ItemBuilder(Material.GOLD_INGOT, 16).setLore("§7Szansa: §c5%").toItemStack();
			ItemStack di = new ItemBuilder(Material.DIAMOND, 8).setLore("§7Szansa: §c5%").toItemStack();
			ItemStack em = new ItemBuilder(Material.EMERALD, 12).setLore("§7Szansa: §c5%").toItemStack();
			ItemStack ir = new ItemBuilder(Material.IRON_INGOT, 24).setLore("§7Szansa: §c5%").toItemStack();
			ItemStack obs = new ItemBuilder(Material.OBSIDIAN, 12).setLore("§7Szansa: §c10%").toItemStack();
			ItemStack kox = new ItemStack(Material.GOLDEN_APPLE, 2, (short)1);
			ItemMeta i1 = kox.getItemMeta();
			i1.setLore(Arrays.asList("§7Szansa: §c2.5%"));
			kox.setItemMeta(i1);
			ItemStack ref = new ItemStack(Material.GOLDEN_APPLE, 5, (short)0);
			ItemMeta i2 = kox.getItemMeta();
			i2.setLore(Arrays.asList("§7Szansa: §c3%"));
			ref.setItemMeta(i2);
			
			inv.setItem(0, bc);
			inv.setItem(1, kl1);
			inv.setItem(2, bania);
			inv.setItem(3, klata);
			inv.setItem(4, spodnie);
			inv.setItem(5, buty);
			inv.setItem(6, miecz);
			inv.setItem(7, knock);
			inv.setItem(8, kl2);
			inv.setItem(9, pe);
			inv.setItem(10, jb);
			inv.setItem(11, tnt);
			inv.setItem(12, zl);
			inv.setItem(13, di);
			inv.setItem(14, em);
			inv.setItem(15, ir);
			inv.setItem(16, obs);
			inv.setItem(17, kox);
			inv.setItem(18, ref);
			inv.setItem(19, cb);
			
			return p.openInventory(inv);
	}

}
