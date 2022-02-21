package me.voten.vcore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import me.voten.vcore.Main;

public class StoneGenerator implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		final Block b = e.getBlock();
	    Location loc = b.getLocation();
	    final Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() - 1.0D, loc.getZ());
	    if ((b.getType() == Material.STONE) && 
	      (loc1.getBlock().getType() == Material.SPONGE)) {
	      Bukkit.getScheduler().runTaskLater(Main.getInst(), new Runnable()
	      {
	        public void run()
	        {
	          if (loc1.getBlock().getType() == Material.SPONGE) {
	            b.setType(Material.STONE);
	          }
	        }
	      }, 5*10);
	    }
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Block b = e.getBlock();
		ItemStack i = e.getItemInHand();
		final Location loc = b.getLocation();
		final Location loc1 = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1.0D, loc.getZ());
		if(loc1.getBlock().getType().equals(Material.AIR) && b.getType() != null && b.getType().equals(Material.SPONGE)) {
			if(i.getItemMeta().getDisplayName().equals(Main.message("stone_generator_name"))) {
				e.getPlayer().sendMessage(Main.message("stone_generator"));
				Bukkit.getScheduler().runTaskLater(Main.getInst(), new Runnable() {
	
					@Override
					public void run() {
						if (loc.getBlock().getType() == Material.SPONGE) {
				            loc1.getBlock().setType(Material.STONE);
				          }
					}
					
				}, 5*10);
			}
		}
		else {
			return;
		}
	}

}
