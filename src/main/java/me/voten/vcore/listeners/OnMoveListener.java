package me.voten.vcore.listeners;

import me.voten.vcore.utils.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnMoveListener implements Listener {
	
	public OnMoveListener() {}
	
	@EventHandler
	public void OnMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		User user = User.getUserByUUID(e.getPlayer().getUniqueId());
		if(user.isSpawnteleporting()) {
			if(e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockY() != e.getTo().getBlockY() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
				user.setSpawnteleporting(false);
				p.sendMessage("§cAnulowano teleportacje");
			}
		}
		if(user.isPlayerteleporting()) {
			if(e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockY() != e.getTo().getBlockY() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
				Player tep = user.getTeleporttoplayer();
				user.setPlayerteleporting(false);
				user.setTeleporttoplayer(null);
				User.getUserByUUID(tep.getUniqueId()).getTeleportsfromplayers().remove(p);
				p.sendMessage("§cAnulowano teleportacje");
			}
		}
	}

}
