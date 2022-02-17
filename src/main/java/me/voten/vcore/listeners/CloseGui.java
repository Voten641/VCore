package me.voten.vcore.listeners;

import me.voten.vcore.utils.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class CloseGui implements Listener {
	
	@EventHandler
	public void InventoryClose(InventoryCloseEvent e) {
		if(e.getView().getTitle().equals("§c§lEnderChest")){
			Player p = (Player) e.getPlayer();
			User user = User.getUserByUUID(p.getUniqueId());
			for (int i = 0; i < user.getEnderchestslots(); i++){
				user.setEnderchestitem(i, e.getInventory().getItem(i));
			}
		}
		
	}
}
