package me.voten.vcore.listeners;

import me.voten.vcore.Main;
import me.voten.vcore.utils.ConfigurationSerializableDataType;
import me.voten.vcore.utils.Item;
import me.voten.vcore.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.voten.vcore.guis.DropGui;
import me.voten.vcore.guis.EfektyGui;
import me.voten.vcore.guis.ChatGui;
import me.voten.vcore.guis.KitGui;

import java.util.Objects;

public class OnMenuClick implements Listener{
	
	public OnMenuClick() {}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		ItemStack item = e.getCurrentItem();

		Player p = (Player) e.getWhoClicked();
		User user = User.getUserByUUID(p.getUniqueId());
		assert user != null;
	    if (item != null)
	    {
	      ItemMeta meta = item.getItemMeta();
	      if (meta != null)
	      {
	    	  if(e.getView().getTitle() != null && e.getView().getTitle().equalsIgnoreCase(Main.message("chat_title"))) {
	    		  e.setCancelled(true);
	    	  }
	    	  if(e.getView().getTitle() != null && e.getView().getTitle().equalsIgnoreCase("§c§lKity")) {
	    		  e.setCancelled(true);
	    		  if(meta.getDisplayName() != null && meta.getDisplayName().equals("§7Kit Gracz")) {
	    			  Bukkit.dispatchCommand(p, "kit gracz");
	    			  p.closeInventory();
	    			  KitGui.kitmenu(p);
	    		  }if(meta.getDisplayName() != null && meta.getDisplayName().equals("§7Kit Vip")) {
	    			  Bukkit.dispatchCommand(p, "kit vip");
	    			  p.closeInventory();
	    			  KitGui.kitmenu(p);
	    		  }if(meta.getDisplayName() != null && meta.getDisplayName().equals("§7Kit Svip")) {
	    			  Bukkit.dispatchCommand(p, "kit svip");
	    			  p.closeInventory();
	    			  KitGui.kitmenu(p);
	    		  }if(meta.getDisplayName() != null && meta.getDisplayName().equals("§7Kit Legenda")) {
	    			  Bukkit.dispatchCommand(p, "kit legenda");
	    			  p.closeInventory();
	    			  KitGui.kitmenu(p);
	    		  }
	    	  }
	    	  if(e.getView().getTitle() != null && e.getView().getTitle().equalsIgnoreCase(Main.message("effect_title"))) {
	    		  e.setCancelled(true);
	    		  if(meta.getDisplayName() != null && meta.getDisplayName().equals("§a§lHaste II")) {
	    			  if(p.getInventory().contains(Material.EMERALD_BLOCK, 16)) {
	    				  if(p.hasPotionEffect(PotionEffectType.FAST_DIGGING)) p.removePotionEffect(PotionEffectType.FAST_DIGGING);
	    				  p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 240*20,2));
	    				  p.getInventory().removeItem(new ItemStack(Material.EMERALD_BLOCK,16));
	    			  }
	    			  else p.sendMessage("§cNie masz §a16 blokow emeraldow§c!");
	    			  p.closeInventory();
	    			  EfektyGui.efektygui(p);
	    		  }if(meta.getDisplayName() != null && meta.getDisplayName().equals("§a§lSpeed II")) {
	    			  if(p.getInventory().contains(Material.EMERALD_BLOCK, 4)) {
	    				  if(p.hasPotionEffect(PotionEffectType.SPEED)) p.removePotionEffect(PotionEffectType.SPEED);
	    				  p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 78*20,2));
	    				  p.getInventory().removeItem(new ItemStack(Material.EMERALD_BLOCK,4));
	    			  }
	    			  else p.sendMessage("§cNie masz §a4 blokow emeraldow§c!");
	    			  p.closeInventory();
	    			  EfektyGui.efektygui(p);
	    		  }if(meta.getDisplayName() != null && meta.getDisplayName().equals("§a§lJump II")) {
	    			  if(p.getInventory().contains(Material.EMERALD_BLOCK, 4)) {
	    				  if(p.hasPotionEffect(PotionEffectType.JUMP)) p.removePotionEffect(PotionEffectType.JUMP);
	    				  p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 78*20,2));
	    				  p.getInventory().removeItem(new ItemStack(Material.EMERALD_BLOCK,4));
	    			  }
	    			  else p.sendMessage("§cNie masz §a4 blokow emeraldow§c!");
	    			  p.closeInventory();
	    			  EfektyGui.efektygui(p);
	    		  }if(meta.getDisplayName() != null && meta.getDisplayName().equals("§a§lNight Vision")) {
	    			  if(p.getInventory().contains(Material.EMERALD_BLOCK, 1)) {
	    				  if(p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) p.removePotionEffect(PotionEffectType.NIGHT_VISION);
	    				  p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 480*20,2));
	    				  p.getInventory().removeItem(new ItemStack(Material.EMERALD_BLOCK,4));
	    			  }
	    			  else p.sendMessage("§cNie masz §a1 bloku emeraldow§c!");
	    			  p.closeInventory();
	    			  EfektyGui.efektygui(p);
	    		  }
	    	  }
	    	  if ((e.getView().getTitle() != null) && (e.getView().getTitle().equals(Main.message("chat_title")))){
	    		  e.setCancelled(true);
	              if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals(Main.message("automatic_messages")))){
	            	  user.setAutomaticchatmessages(!user.isAutomaticchatmessages());
	              }if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals(Main.message("case_messages")))){
	            	  user.setCasechatmessages(!user.isCasechatmessages());
	              }if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals(Main.message("private_messages")))){
	            	  user.setPrivatemessages(!user.isPrivatemessages());
	              }if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals(Main.message("kill_messages")))){
	            	  user.setKillmessages(!user.isKillmessages());
	              }if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals(Main.message("drop_messages")))){
	            	  user.setDropmessages(!user.isDropmessages());
	              }if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals(Main.message("global_messages")))){
					  user.setGlobalmessages(!user.isGlobalmessages());
	              }
				  ChatGui.menuchat(p);
	    	  }
	    	  if ((e.getView().getTitle() != null) && (e.getView().getTitle().equals(Main.message("drop_title")))){
	    		  e.setCancelled(true);
				  NamespacedKey key = new NamespacedKey(Main.getPlugin(Main.class), "itemclass");
				  PersistentDataType<byte[], Item> itemclasstype = new ConfigurationSerializableDataType<>(Item.class);
				  PersistentDataContainer pdc = e.getCurrentItem().getItemMeta().getPersistentDataContainer();
				  Item itm = pdc.get(key, itemclasstype);
				  Item itm2 = new Item(new ItemStack(Material.STONE), 1.0,1,1,1,1.0,"WRONG ITEM");
				  if(itm != itm2){
					  user.setDrop(itm, !user.getDrop(itm));
				  }
	    		  if(meta.getDisplayName() != null) {
					  if ((meta.getDisplayName().equals(Main.message("enable_all")))){
						  for(Item item2 : Item.allItems){
							  user.setDrop(item2, true);
						  }
		              }if ((meta.getDisplayName().equals(Main.message("disable_all")))){
						  for(Item item2 : Item.allItems){
							  user.setDrop(item2, false);
						  }
		              }
		              if(meta.getDisplayName().equals(Main.message("case_title"))) {
		            	  p.closeInventory();
		            	  p.chat("/case");
		            	  return;
		              }
	    		  }
	              p.openInventory(e.getInventory());
	    	  }
		
	      }
	    }
	}
}
