package me.voten.vcore.commands;

import me.voten.vcore.utils.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.voten.vcore.Main;

public class SpawnCommand implements CommandExecutor{
	
	private static SpawnCommand inst;
	
	public SpawnCommand() {
		inst = this;
	}
	public static SpawnCommand getInst() {
	    if (inst == null) return new SpawnCommand();
	    return inst;
	 }
	public BukkitRunnable task;

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		Player p = (Player) arg0;
		User user = User.getUserByUUID(p.getUniqueId());
		user.setSpawnteleporting(true);
		p.sendMessage(Main.messagereplace("teleporting", "%seconds", "10"));
		
		
		task = new BukkitRunnable() {
	
			@Override
			public void run() {
				if(user.isSpawnteleporting()) {
					p.teleport(p.getWorld().getSpawnLocation());
					p.sendMessage("§aPrzeteleportowano");
					user.setSpawnteleporting(false);
				}
			}	
		};task.runTaskLater(Main.getInst(), 200);
		return false;
	}

}
