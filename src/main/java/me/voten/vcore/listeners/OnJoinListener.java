package me.voten.vcore.listeners;

import me.voten.vcore.utils.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.voten.vcore.Main;

public class OnJoinListener implements Listener {
	
	public OnJoinListener() {}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		User user = new User(e.getPlayer());
		 if(e.getPlayer().hasPermission("core.vip")) {
			 user.setEnderchestslots(36);
		 }
		 if(e.getPlayer().hasPermission("core.svip")) {
			 user.setEnderchestslots(45);
		 }
		 if(e.getPlayer().hasPermission("core.leg")) {
			 user.setEnderchestslots(54);
		 }
		e.setJoinMessage(null);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		User user = User.getUserByUUID(e.getPlayer().getUniqueId());
		if(user.isCheatcheck()) {
			Main.getInst().getServer().broadcastMessage("§cGracz " + e.getPlayer().getDisplayName() + " wylogowal sie podczas sprawdzania!");
			User.getUserByUUID(user.getPlayerCheatCheck().getUniqueId()).setCheckingplayer(null);
			user.setCheatcheck(false);
			user.setPlayerCheatCheck(null);
		}
		user.saveUser();
		e.setQuitMessage(null);
	}

}
