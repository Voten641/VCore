package me.voten.vcore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import me.voten.vcore.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.*;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedServerPing;

import me.voten.vcore.listeners.*;
import me.voten.vcore.utils.Crafting;
import me.voten.vcore.utils.Metrics;
import me.voten.vcore.commands.*;

public class Main extends JavaPlugin{

	private ArrayList<String> ping = new ArrayList<String>(); {
		int i = 1;
		while(getConfig().getString("ping"+i) != null){
			ping.add(getConfig().getString("ping"+i).replace("&", "�"));
			i++;
		}
	}
	public Map<Player, Player> spr = new HashMap<>();
	private int clear = 0;
	public boolean chatstatus = true;
	private static Main inst;
	
	public Main() {
		inst = this;
	}
	public static Main getInst() {
	    if (inst == null) return new Main();
	    return inst;
	  }
	
	@SuppressWarnings("unused")
	private ProtocolManager protocolManager;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		try {
	        Metrics metrics = new Metrics(this);
	        metrics.start();
	    } catch (IOException e) {
	        // Failed to submit the stats :-(
	    }
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		saveConfig();
		/*ProtocolLibrary.getProtocolManager().addPacketListener(
			      new PacketAdapter(this, PacketType.Status.Server.OUT_SERVER_INFO) {
			        @Override
			        public void onPacketSending(PacketEvent event) {
			            handlePing(event.getPacket().getServerPings().read(0));
			        }
			    });*/
		Server s = Bukkit.getServer();
		World sw = s.getWorld("world");
		PluginManager pm = s.getPluginManager();
		sw.setGameRuleValue("showDeathMessages", "false");
		sw.setGameRuleValue("doDaylightCycle", "false");
		sw.setGameRuleValue("doMobSpawning", "false");
		sw.setTime(18000);
		pm.registerEvents(new OnDamageListener(), this);
		pm.registerEvents(new TopListeners(), this);
		pm.registerEvents(new OnDeathListener(), this);
		pm.registerEvents(new OnChatListener(), this);
		pm.registerEvents(new OnMenuClick(), this);
		pm.registerEvents(new OnPlaceListener(), this);
		pm.registerEvents(new OnJoinListener(), this);
		pm.registerEvents(new StoneGenerator(), this);
		pm.registerEvents(new OnMoveListener(), this);
		pm.registerEvents(new BreakBlock(), this);
		pm.registerEvents(new CloseGui(), this);
		pm.registerEvents(new SchowekClick(), this);
		pm.registerEvents(new Schowek(), this);
		saveDefaultConfig();
		ClearItems();
		getCommand("sprawdz").setExecutor(new SprawdzCommand());
		getCommand("schowek").setExecutor(new SchowekCommand());
		getCommand("ec").setExecutor(new EcCommand());
		getCommand("helpop").setExecutor(new HelpopCommand());
		getCommand("tpdeny").setExecutor(new TpdenyCommand());
		getCommand("tpaccept").setExecutor(new TpacceptCommand());
		getCommand("tpa").setExecutor(new TpaCommand());
		getCommand("efekty").setExecutor(new EfektyCommand());
		getCommand("drop").setExecutor(new DropCommand());
		getCommand("kit").setExecutor(new KitCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("chat").setExecutor(new ChatCommand());
		getCommand("nick").setExecutor(new NickCommand());
		getCommand("gm").setExecutor(new GameModeCommand());
		getCommand("gamemode").setExecutor(new GameModeCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("repair").setExecutor(new RepairCommand());
		getCommand("repairall").setExecutor(new RepairAllCommand());
		getCommand("vc").setExecutor(new VcCommand());
		getCommand("cases").setExecutor(new CasesCommand());
		getCommand("pomoc").setExecutor(new PomocCommand());
		getCommand("msg").setExecutor(new MsgCommand());
		getCommand("vip").setExecutor(new VipCommand());
		getCommand("svip").setExecutor(new SVipCommand());
		getCommand("legenda").setExecutor(new LegendaCommand());
		getCommand("case").setExecutor(new CaseCommand());
		getCommand("top").setExecutor(new TopkaCommand());
		getCommand("info").setExecutor(new InfoCommand());
		getLogger().log(Level.FINE, "Uruchomiono");
		s.addRecipe(Crafting.CraftingStone());
		for(Player p : Bukkit.getOnlinePlayers()){
			User user = new User(p);
		}
	}
	
	public void onDisable() {
		for(Player p : Bukkit.getOnlinePlayers()){
			User.getUserByUUID(p.getUniqueId()).saveUser();
		}
		getLogger().log(Level.FINE, "Wylaczono");
	}

	public void ClearItems() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
			if(clear==1) {
				Bukkit.broadcastMessage("§cUsuwanie itemow za 30 sekund");
				clear++;
			}
			else if(clear==10) {
				Bukkit.broadcastMessage("§cUsuwanie itemow za 20 sekund");
				clear++;
			}
			else if(clear==20) {
				Bukkit.broadcastMessage("§cUsuwanie itemow za 10 sekund");
				clear++;
			}
			else if(clear==25) {
				Bukkit.broadcastMessage("§cUsuwanie itemow za 5 sekund");
				clear++;
			}
			else if(clear==26) {
				Bukkit.broadcastMessage("§cUsuwanie itemow za 4 sekund");
				clear++;
			}
			else if(clear==27) {
				Bukkit.broadcastMessage("§cUsuwanie itemow za 3 sekund");
				clear++;
			}
			else if(clear==28) {
				Bukkit.broadcastMessage("§cUsuwanie itemow za 2 sekund");
				clear++;
			}
			else if(clear==29) {
				Bukkit.broadcastMessage("§cUsuwanie itemow za 1 sekund");
				clear++;
			}
			else if(clear==30) {
				World world = Bukkit.getServer().getWorld("world");
				assert world != null;
				List<Entity> entList = new ArrayList<>();
				int usuniete = 0;
				for(Entity current : entList) {
					if(current instanceof Item) {
						current.remove();
						usuniete++;
					}
				}
				if(usuniete == 1) {
					Bukkit.broadcastMessage("§cUsunieto "+ usuniete +" item z ziemi!");
				}
				else if(usuniete == 2 || usuniete == 3 || usuniete == 4) {
					Bukkit.broadcastMessage("§cUsunieto "+ usuniete +" itemy z ziemi!");
				}
				else {
					Bukkit.broadcastMessage("§cUsunieto "+ usuniete +" itemow z ziemi!");
				}
				clear++;
			}
			else if(clear==570) {
				clear=1;
			}
			else {
				clear++;
			}
		}, 0, 20);
	}

	@SuppressWarnings("deprecation")
	private void handlePing(WrappedServerPing read) {
		String motd1 = Main.getInst().getConfig().getString("MOTD-1").replaceAll("&", "�");
		String motd2 = Main.getInst().getConfig().getString("MOTD-2").replaceAll("&", "�");
		List<WrappedGameProfile> players = new ArrayList<WrappedGameProfile>();
		for(int i=0; i<ping.size();i++) {
			players.add(new WrappedGameProfile("1", ping.get(i)));
		}
	    read.setMotD(motd1 + "\n" + motd2);
	    if(read.getPlayersOnline() < 500) {
	    	read.setPlayersMaximum(read.getPlayersOnline()+3);
	    }
	    else {
	    	read.setPlayersMaximum(500);
	    }
	    read.setPlayers(players);
	    if(read.getPlayersOnline() > Main.getInst().getConfig().getInt("Max-Players")) {
	    	read.setPlayersOnline(Main.getInst().getConfig().getInt("Max-Players"));
	    }
	}

}
