package me.voten.vcore.listeners;

import java.util.Random;

import me.voten.vcore.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import me.voten.vcore.ItemBuilder;
import me.voten.vcore.commands.CasesCommand;

public class OnPlaceListener implements Listener{

	public OnPlaceListener() {}
	
	@EventHandler()
	public void BlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		ItemStack i = e.getItemInHand();
		Location loc = e.getBlockPlaced().getLocation();
		
		if(i.getType().equals(Material.CHEST) && i.getItemMeta().equals(CasesCommand.Cases())) {
			if (e.isCancelled()) {
				return;
			}
			else {
				e.setCancelled(true);
				ItemStack isp = p.getItemInHand().clone();
				isp.setAmount(1);
				p.getInventory().removeItem(new ItemStack[] { isp });
			}
			
			Random rand = new Random();
			int number = rand.nextInt(1000)+1;
			ItemStack bc = new ItemStack(Material.BEACON);
			ItemStack kl1 = new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§a§lWeedCraft §7§l- Kilof 10/5/3").addEnchant(Enchantment.DIG_SPEED, 10).addEnchant(Enchantment.DURABILITY, 5).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).toItemStack();
			ItemStack bania = new ItemBuilder(Material.DIAMOND_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
			ItemStack klata = new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
			ItemStack spodnie = new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
			ItemStack buty = new ItemBuilder(Material.DIAMOND_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
			ItemStack miecz = new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).toItemStack();
			ItemStack knock = new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.KNOCKBACK, 2).toItemStack();
			ItemStack kl2 = new ItemBuilder(Material.DIAMOND_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).toItemStack();
			ItemStack cb = new ItemStack(Material.COBBLESTONE, 4);
			ItemStack pe = new ItemStack(Material.ENDER_PEARL, 4);
			ItemStack jb = new ItemStack(Material.APPLE, 16);
			ItemStack tnt = new ItemStack(Material.TNT, 16);
			ItemStack zl = new ItemStack(Material.GOLD_INGOT, 16);
			ItemStack di = new ItemStack(Material.DIAMOND, 8);
			ItemStack em = new ItemStack(Material.EMERALD, 12);
			ItemStack ir = new ItemStack(Material.IRON_INGOT, 24);
			ItemStack obs = new ItemStack(Material.OBSIDIAN, 12);
			ItemStack kox = new ItemStack(Material.GOLDEN_APPLE, 2, (short)1);
			ItemStack ref = new ItemStack(Material.GOLDEN_APPLE, 5, (short)0);
			String wiad;
			if(number <= 5) {
				p.getWorld().dropItem(loc, bc);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §c§lBEACON";
			}
			else if(number > 5 && number < 15) {
				p.getWorld().dropItem(loc, kl1);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §c§l Kilof 10/5/3";
			}
			else if(number > 15 && number < 45) {
				p.getWorld().dropItem(loc, bania);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §cHelm 4/3";
			}
			else if(number > 45 && number < 65) {
				p.getWorld().dropItem(loc, klata);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §cKlate 4/3";
			}
			else if(number > 75 && number < 95) {
				p.getWorld().dropItem(loc, spodnie);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §cSpodnie 4/3";
			}
			else if(number > 105 && number < 125) {
				p.getWorld().dropItem(loc, buty);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §cButy 4/3";
			}
			else if(number > 135 && number < 160) {
				p.getWorld().dropItem(loc, kox);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §c2xKoxy";
			}
			else if(number > 160 && number < 190) {
				p.getWorld().dropItem(loc, ref);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §c5xRefy";
			}
			else if(number > 190 && number < 230) {
				p.getWorld().dropItem(loc, miecz);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §cMiecz 5/2";
			}
			else if(number > 230 && number < 270) {
				p.getWorld().dropItem(loc, knock);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §cMiecz KnockBack";
			}
			else if(number > 270 && number < 320) {
				p.getWorld().dropItem(loc, zl);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §e16xZloto";
			}
			else if(number > 320 && number < 370) {
				p.getWorld().dropItem(loc, di);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §b8xDiament";
			}
			else if(number > 370 && number < 420) {
				p.getWorld().dropItem(loc, em);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §a12xEmerald";
			}
			else if(number > 420 && number < 470) {
				p.getWorld().dropItem(loc, ir);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §724xZelazo";
			}
			else if(number > 470 && number < 550) {
				p.getWorld().dropItem(loc, kl2);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §7Kilof 5/3/3";
			}
			else if(number > 550 && number < 650) {
				p.getWorld().dropItem(loc, jb);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §716xJablko";
			}
			else if(number > 650 && number < 750) {
				p.getWorld().dropItem(loc, tnt);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §716xTnT";
			}
			else if(number > 750 && number < 775) {
				p.getWorld().dropItem(loc, pe);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §c4xPerela";
			}
			else if(number > 775 && number < 875) {
				p.getWorld().dropItem(loc, obs);
				wiad = "§a" + p.getDisplayName() + "§7 Wylosowal >> §812xObsydian";
			}
			else {
				p.getWorld().dropItem(loc, cb);
				wiad = "§a" + "§a" + p.getDisplayName() + "§7 Wylosowal >> §816xCobblestone";
			}
			
			for(Player po : Bukkit.getOnlinePlayers()){
				if(User.getUserByUUID(po.getUniqueId()).isCasechatmessages()) {
					po.sendMessage(wiad);
				}
			}
			
		}
		
	}
	
}
