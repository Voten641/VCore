package me.voten.vcore.listeners;

import java.util.ArrayList;
import java.util.List;

import me.voten.vcore.utils.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SchowekClick implements Listener{
	
	public SchowekClick() {}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		ItemStack kox = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2);
		ItemStack ref = new ItemStack(Material.GOLDEN_APPLE, 12);
		ItemStack per = new ItemStack(Material.ENDER_PEARL, 5);
		User user = User.getUserByUUID(p.getUniqueId());
	    if (item != null)
	    {
	      ItemMeta meta = item.getItemMeta();
	      if (meta != null){
	    	  if ((e.getView().getTitle() != null) && (e.getView().getTitle().equals("§c§lSchowek"))){
	    		  if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals("§c§lKoxy:"))){
		    		  e.setCancelled(true);
	    			  if(e.getClick() == ClickType.LEFT) {
	    				  if(user.getEnchga() > 2) {
	    					  p.getInventory().addItem(kox);
	    					  user.setEnchga(user.getEnchga()-2);
	    				  }
	    				  else if(user.getEnchga() <= 0) {
	    					  p.sendMessage("§cNie masz koxow§c do wyplacenia");
	    					  }
	    				  else {
	    					  ItemStack kox2 = kox;
	    					  kox2.setAmount(user.getEnchga());
	    					  p.getInventory().addItem(kox2);
	    					  user.setEnchga(user.getEnchga()-kox2.getAmount());
	    				  }
	    			  }
	    			  else if(e.getClick() == ClickType.RIGHT) {
	    				  if(user.getEnchga() >= 1) {
	    					  ItemStack kox3 = kox;
	    					  kox3.setAmount(1);
	    					  p.getInventory().addItem(kox3);
	    					  user.setEnchga(user.getEnchga()-1);
	    				  }
	    				  else {
	    					  p.sendMessage("§cNie masz koxow§c do wyplacenia");
	    				  }
	    			  }
		    		  List<String> lorekox = new ArrayList<String>();
		    			lorekox.add("§7W schowku: §c" + user.getEnchga());
		    			lorekox.add("§aPrawy §8przycisk myszy - Zabierz 1");
		    			lorekox.add("§aLewy §8przycisk myszy - Zabierz do limitu");
    				  ItemMeta koxmeta = e.getCurrentItem().getItemMeta();
    				  koxmeta.setLore(lorekox);
    				  e.getCurrentItem().setItemMeta(koxmeta);
	    		  }
	    		  if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals("§c§lRefy:"))){
		    		  e.setCancelled(true);
	    			  if(e.getClick() == ClickType.LEFT) {
	    				  if(user.getGa() > 12) {
	    					  p.getInventory().addItem(ref);
	    					  user.setGa(user.getGa()-12);
	    				  }
	    				  else if(user.getGa() <= 0) {
	    					  p.sendMessage("§cNie masz refow§c do wyplacenia");
	    					  }
	    				  else {
	    					  ItemStack ref2 = ref;
	    					  ref2.setAmount(user.getGa());
	    					  p.getInventory().addItem(ref2);
	    					  user.setGa(user.getGa()-ref2.getAmount());
	    				  }
	    			  }
	    			  else if(e.getClick() == ClickType.RIGHT) {
	    				  if(user.getGa() >= 1) {
	    					  ItemStack ref3 = ref;
	    					  ref3.setAmount(1);
	    					  p.getInventory().addItem(ref3);
	    					  user.setGa(user.getGa()-1);
	    				  }
	    				  else {
	    					  p.sendMessage("§cNie masz refow§c do wyplacenia");
	    				  }
	    			  }
		    		  List<String> lorekox = new ArrayList<String>();
		    			lorekox.add("§7W schowku: §c" + user.getGa());
		    			lorekox.add("§aPrawy §8przycisk myszy - Zabierz 1");
		    			lorekox.add("§aLewy §8przycisk myszy - Zabierz do limitu");
    				  ItemMeta koxmeta = e.getCurrentItem().getItemMeta();
    				  koxmeta.setLore(lorekox);
    				  e.getCurrentItem().setItemMeta(koxmeta);
	    		  }
	    		  if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals("§c§lPerly:"))){
		    		  e.setCancelled(true);
	    			  if(e.getClick() == ClickType.LEFT) {
	    				  if(user.getPearl() > 5) {
	    					  p.getInventory().addItem(per);
	    					  user.setPearl( user.getPearl()-5);
	    				  }
	    				  else if(user.getPearl() <= 0) {
	    					  p.sendMessage("§cNie masz perel§c do wyplacenia");
	    					  }
	    				  else {
	    					  ItemStack per2 = per;
	    					  per2.setAmount(user.getPearl());
	    					  p.getInventory().addItem(per2);
	    					  user.setPearl( user.getPearl()-per2.getAmount());
	    				  }
	    			  }
	    			  else if(e.getClick() == ClickType.RIGHT) {
	    				  if(user.getPearl() >= 1) {
	    					  ItemStack per3 = per;
	    					  per3.setAmount(1);
	    					  p.getInventory().addItem(per3);
	    					  user.setPearl( user.getPearl()-1);
	    				  }
	    				  else {
	    					  p.sendMessage("§cNie masz perel§c do wyplacenia");
	    				  }
	    			  }

		    		  List<String> lorekox = new ArrayList<String>();
		    			lorekox.add("§7W schowku: §c" + user.getPearl());
		    			lorekox.add("§aPrawy §8przycisk myszy - Zabierz 1");
		    			lorekox.add("§aLewy §8przycisk myszy - Zabierz do limitu");
    				  ItemMeta koxmeta = e.getCurrentItem().getItemMeta();
    				  koxmeta.setLore(lorekox);
    				  e.getCurrentItem().setItemMeta(koxmeta);
	    		  }
	    		  if ((meta.getDisplayName() != null) && (meta.getDisplayName().equals("§7----------------------"))){
	    			  e.setCancelled(true);
	    		  }
	    	  }
	      }
	    }
	}
}
