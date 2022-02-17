package me.voten.vcore.listeners;

import me.voten.vcore.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.voten.vcore.Main;


public class OnChatListener implements Listener{
	
	public OnChatListener() {}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		
		for(Player pl : Bukkit.getOnlinePlayers()) {
			User user = User.getUserByUUID(pl.getUniqueId());
			if(!user.isGlobalmessages() && !e.getPlayer().hasPermission("vcore.globalmessageignore")) {
				e.getRecipients().remove(pl);
			}
		}
		Player p = e.getPlayer();
		User user = User.getUserByUUID(p.getUniqueId());
		if(!user.isGlobalmessages() && !e.getPlayer().hasPermission("vcore.globalmessageignore")) {
			e.getPlayer().sendMessage("§cNie mozesz wysylac wiadomosci jezeli masz wylaczony chat");
			e.setCancelled(true);
		}
		
		String message;
		if(!e.getPlayer().hasPermission("vcore.ignorechatstatus") && !Main.getInst().chatstatus) {
				e.setCancelled(true);
				e.getPlayer().sendMessage("§cChat jest wylaczony!");
		}
		if(e.getPlayer().hasPermission("vcore.chatcolors")) {
			message = e.getMessage().replace("&", "§");
			e.setMessage(message);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent e) {
		String defaultmess = e.getDeathMessage();
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(User.getUserByUUID(p.getUniqueId()).isKillmessages()) {
				if(defaultmess != null) {
					p.sendMessage("§7" + defaultmess);
				}
			}
		}
	}
}
