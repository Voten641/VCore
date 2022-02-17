package me.voten.vcore.listeners;

import me.voten.vcore.utils.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

import me.voten.vcore.Main;

public class Schowek implements Listener{
	
	public Schowek() {}
	
	public void Check(Player p) {
		PlayerInventory inv = p.getInventory();
		
		ItemStack kox = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
		ItemStack ref = new ItemStack(Material.GOLDEN_APPLE);
		User user = User.getUserByUUID(p.getUniqueId());
		
		int koxz = 0;
		int refz = 0;
		int perz = 0;
		
		int ksch = user.getEnchga();
		int rsch = user.getGa();
		int psch = user.getPearl();
		
		if(inv.contains(Material.GOLDEN_APPLE) || inv.contains(Material.ENDER_PEARL) || inv.contains(Material.ENCHANTED_GOLDEN_APPLE)) {
			for(int i1=0;i1<inv.getSize();i1++) {
				ItemStack itm = inv.getItem(i1);
				if(itm != null) {
					if(itm.getType().equals(Material.GOLDEN_APPLE)) {
						refz += itm.getAmount();
					}
					if(itm.getType().equals(Material.ENCHANTED_GOLDEN_APPLE)) {
						koxz += itm.getAmount();
					}
					if(itm.getType().equals(Material.ENDER_PEARL)) {
						perz += itm.getAmount();
					}
				}
			}
			if(koxz >= 2) {
				koxz -= 2;
				inv.removeItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE,koxz));
				ksch += koxz;
				user.setEnchga(ksch);
			}
			if(refz >= 12) {
				refz -= 12;
				inv.removeItem(new ItemStack(Material.GOLDEN_APPLE,refz));
				rsch += refz;
				user.setEnchga(rsch);
			}
			if(perz >= 5) {
				perz -= 5;
				inv.removeItem(new ItemStack(Material.ENDER_PEARL,perz));
				psch += perz;
				user.setEnchga(psch);
			}
			
		}
	}
	
	@EventHandler
	public void InventoryClose(InventoryCloseEvent e) {
		Check((Player) e.getPlayer());
		
	}
	
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void PickUp(EntityPickupItemEvent e) {
		if(e.getEntity() instanceof Player){
			BukkitRunnable task = new BukkitRunnable() {
				public void run() {
					Check((Player)e.getEntity());
				}
			};
			task.runTaskLater(Main.getInst(), 20);
		}
	}

}
