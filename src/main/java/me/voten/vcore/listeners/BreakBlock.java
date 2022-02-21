package me.voten.vcore.listeners;

import me.voten.vcore.Main;
import me.voten.vcore.utils.Item;
import me.voten.vcore.utils.User;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlock implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();
		User user = User.getUserByUUID(p.getUniqueId());
		if(e.getBlock().getType().equals(Material.STONE)) {
			for(Item item : Item.allItems){
				if(Math.random() * 100 < item.getChance() && user.getDrop(item)){
					if(user.isDropmessages()) p.sendMessage(Main.messagereplace("droped", "%item", item.getName()));
					p.getWorld().dropItem(b.getLocation(), item.getItem());
				}
				if(item.getItem().getType().equals(b.getType()) || !user.isCobbledrop()){
					e.setCancelled(true);
					b.setType(Material.AIR);
				}
			}
		}
	}

}
