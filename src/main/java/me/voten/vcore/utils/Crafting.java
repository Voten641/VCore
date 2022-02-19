package me.voten.vcore.utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;


public class Crafting {

	public static Recipe CraftingStone() {
		ItemStack Stoniarka = new ItemStack(Material.SPONGE, 1);
		ItemMeta im = Stoniarka.getItemMeta();
		im.setDisplayName("§a§lStoniarka");
		im.setLore(Arrays.asList("§8Postaw na ziemi aby zaczelo generowac stone!"));
		Stoniarka.setItemMeta(im);
		
		ShapedRecipe Stoniarka2 = new ShapedRecipe(Stoniarka);
	    Stoniarka2.shape(new String[] { "AAA", "ABA", "AAA" });

	    Stoniarka2.setIngredient('A', Material.STONE);
	    Stoniarka2.setIngredient('B', Material.DIAMOND);
		return Stoniarka2;
	}
}
