package me.voten.vcore.commands;

import me.voten.vcore.utils.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.voten.vcore.Main;

public class TpacceptCommand implements CommandExecutor {
	
	public BukkitRunnable task;

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		Player tep = (Player) sender;
		User u1 = User.getUserByUUID(tep.getUniqueId());
		assert u1 != null;
		if(!u1.getTeleportsfromplayers().isEmpty()){
			if(u1.getTeleportsfromplayers().size() == 1){
				Player p = u1.getTeleportsfromplayers().get(0);
				teleport(u1, p, tep);
			}
			else{
				if(args.length == 1){
					for(Player p :u1.getTeleportsfromplayers()){
						if(args[0].equals("*")) {
							teleport(u1, p, tep);
						}else{
							if(p.getName().equals(args[0]) || p.getDisplayName().equals(args[0])){
								teleport(u1, p, tep);
							}
						}
					}
				}else {
					tep.sendMessage("§aPróbuje się do ciebie teleportować kilka osób, wpisz /tpaccept (nick) lub /tpaccept *");
				}
			}
		}
		
		return false;
	}

	public void teleport(User u1, Player p, Player tep){
		p.sendMessage("§aTeleportacja nastapi za 10 sekund");
		User u2 = User.getUserByUUID(p.getUniqueId());
		task = new BukkitRunnable() {
			@Override
			public void run() {
				assert u2 != null;
				u2.setPlayerteleporting(false);
				u2.setTeleporttoplayer(null);
				u1.getTeleportsfromplayers().remove(p);
				p.teleport(tep.getLocation());
				p.sendMessage("§aPrzeteleportowano do gracza " + tep.getDisplayName());
			}
		};
		task.runTaskLater(Main.getInst(), 200);
	}

}
