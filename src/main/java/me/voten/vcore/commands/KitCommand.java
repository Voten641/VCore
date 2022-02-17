package me.voten.vcore.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.voten.vcore.ItemBuilder;
import me.voten.vcore.Main;
import me.voten.vcore.guis.KitGui;

public class KitCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		Player p = (Player) arg0;
		
		ArrayList<ItemStack> gr = new ArrayList<ItemStack>();
		ItemStack gr1 = new ItemBuilder(Material.ENDER_CHEST).toItemStack();
		ItemStack gr2 = new ItemBuilder(Material.STONE_AXE).toItemStack();
		ItemStack gr3 = new ItemBuilder(Material.COOKED_BEEF).toItemStack();
		gr.add(gr1);
		gr.add(gr2);
		gr.add(gr3);
		
		ArrayList<ItemStack> v = new ArrayList<ItemStack>();
		ItemStack v1 = new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
		ItemStack v2 = new ItemBuilder(Material.DIAMOND_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
		ItemStack v3 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
		ItemStack v4 = new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
		ItemStack v5 = new ItemBuilder(Material.DIAMOND_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
		ItemStack v6 = new ItemBuilder(Material.DIAMOND_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
		ItemStack vkox = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
		ItemStack vref = new ItemStack(Material.GOLDEN_APPLE, 4, (short)0);
		v.add(v1);
		v.add(v2);
		v.add(v3);
		v.add(v4);
		v.add(v5);
		v.add(v6);
		v.add(vkox);
		v.add(vref);
		
		ArrayList<ItemStack> sv = new ArrayList<ItemStack>();
		ItemStack svkox = new ItemStack(Material.GOLDEN_APPLE, 2, (short)1);
		ItemStack svref = new ItemStack(Material.GOLDEN_APPLE, 8, (short)0);
		sv.add(v1);
		sv.add(v2);
		sv.add(v3);
		sv.add(v4);
		sv.add(v5);
		sv.add(v6);
		sv.add(svkox);
		sv.add(svref);
		
		ArrayList<ItemStack> l = new ArrayList<ItemStack>();
		ItemStack l1 = new ItemBuilder(Material.DIAMOND_PICKAXE).addEnchant(Enchantment.DIG_SPEED, 10).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5).addEnchant(Enchantment.DURABILITY, 3).toItemStack();
		ItemStack l2 = new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_KNOCKBACK, 2).toItemStack();
		ItemStack l3 = new ItemBuilder(Material.ARROW).toItemStack();
		l.add(l1);
		l.add(l2);
		l.add(l3);
		
		if(arg3.length == 0) {
			KitGui.kitmenu(p);
		}
		/*else {
			if(arg3[0].equalsIgnoreCase("gracz")) {
				if(DataLoader.getint(p, "dgracz") == 0) {
					DataLoader.setint(p, "dgracz", 3600);
					for(int i=0; i<3; i++) {
						boolean isEmpty = false;
			            for (ItemStack item : p.getInventory().getContents()) {
			                if(item == null) {
			                    isEmpty = true;
			                    break;
			                }
			            }
			            if(isEmpty) {
			            	p.getInventory().addItem(gr.get(i));
			            } else {
			            	p.getWorld().dropItem(p.getLocation(), gr.get(i));
			            }
					}
				}
				else {
					Integer czas = DataLoader.getint(p, "dgracz");
					Zmienczas(czas,p);
				}
			}else if(arg3[0].equalsIgnoreCase("vip")) {
				if(p.hasPermission("core.vip")) {
					if(DataLoader.getint(p, "dvip") == 0) {
						DataLoader.setint(p, "dvip", 3600*12);
						for(int i=0; i<8; i++) {
							boolean isEmpty = false;
				            for (ItemStack item : p.getInventory().getContents()) {
				                if(item == null) {
				                    isEmpty = true;
				                    break;
				                }
				            }
				            if(isEmpty) {
				            	p.getInventory().addItem(v.get(i));
				            } else {
				            	p.getWorld().dropItem(p.getLocation(), v.get(i));
				            }
						}
					}else {
						Integer czas = DataLoader.getint(p, "dvip");
						Zmienczas(czas,p);
					}
				}
				else {
					p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage"));
				}
			}else if(arg3[0].equalsIgnoreCase("svip")) {
				if(p.hasPermission("core.svip")) {
					if(DataLoader.getint(p, "dsvip") == 0) {
						DataLoader.setint(p, "dsvip", 3600*12);
						for(int i=0; i<8; i++) {
							boolean isEmpty = false;
				            for (ItemStack item : p.getInventory().getContents()) {
				                if(item == null) {
				                    isEmpty = true;
				                    break;
				                }
				            }
				            if(isEmpty) {
				            	p.getInventory().addItem(sv.get(i));
				            } else {
				            	p.getWorld().dropItem(p.getLocation(), sv.get(i));
				            }
						}
					}else {
						Integer czas = DataLoader.getint(p, "dsvip");
						Zmienczas(czas,p);
					}
			}else {
				p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage"));
			}
			}else if(arg3[0].equalsIgnoreCase("legenda")) {
				if(p.hasPermission("core.leg")) {
					if(DataLoader.getint(p, "dleg") == 0) {
						DataLoader.setint(p, "dleg", 3600*24);
						for(int i=0; i<3; i++) {
							boolean isEmpty = false;
				            for (ItemStack item : p.getInventory().getContents()) {
				                if(item == null) {
				                    isEmpty = true;
				                    break;
				                }
				            }
				            if(isEmpty) {
				            	p.getInventory().addItem(l.get(i));
				            } else {
				            	p.getWorld().dropItem(p.getLocation(), l.get(i));
				            }
						}
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "cases "+p.getName()+" 10");
					}else {
						Integer czas = DataLoader.getint(p, "dleg");
						Zmienczas(czas,p);
					}
				}else {
					p.sendMessage(Main.getInst().getConfig().getString("PermissionMessage"));
				}
			}
			}*/
		return false;
	}

	private void Zmienczas(Integer czas, Player p) {
		int h;
		int m;
		int s;
		
		h = (czas % 86400 ) / 3600 ;
		m = ((czas % 86400 ) % 3600 ) / 60; 
		s = ((czas % 86400 ) % 3600 ) % 60  ;
		p.sendMessage("�cTen kit mozesz odebrac za "+ h+":"+m+":"+s);
		
	}

}
