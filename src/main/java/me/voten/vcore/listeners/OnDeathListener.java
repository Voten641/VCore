package me.voten.vcore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.voten.vcore.Main;

public class OnDeathListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	  public void onDeath(PlayerDeathEvent e) {
	    Player p = e.getEntity();
	    BukkitRunnable task = new BukkitRunnable() {
			public void run() {
				p.spigot().respawn();
			}
		};
		task.runTaskLater(Main.getInst(), 1*20);
	    p.sendTitle("§c§lZginales!", "§cNie poddawaj sie, graj dalej :)");
	}
	
}
