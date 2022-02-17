package me.voten.vcore.listeners;

import me.voten.vcore.utils.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class TopListeners implements Listener {

	@EventHandler
	  public void onDeath(PlayerDeathEvent e) {
	    Player p = e.getEntity();
		User user = User.getUserByUUID(p.getUniqueId());
		user.setDeaths(user.getDeaths()+1);
	    if(e.getEntity().getKiller() instanceof Player) {
			User user2 = User.getUserByUUID(((Player)e.getEntity().getKiller()).getUniqueId());
			user2.setKills(user2.getKills()+1);
	    }
	}
	
	@EventHandler
	public void onBlock(BlockBreakEvent e) {
		if(e.getBlock().getType().equals(Material.STONE)) {
			User user = User.getUserByUUID(e.getPlayer().getUniqueId());
			user.setStone(user.getStone()+1);
		}
	}
	
	
}
