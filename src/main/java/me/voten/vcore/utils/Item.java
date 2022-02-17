package me.voten.vcore.utils;

import me.voten.vcore.Main;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Item implements ConfigurationSerializable {

    private final double chance;
    private final int exp;
    private final int maxY;
    private final int minY;
    private final double price;
    private final String name;
    private final ItemStack item;
    public static List<Item> allItems = new ArrayList<>();
    private static List<Material> blockdrops = new ArrayList<>();

    public Item(ItemStack it, double ch, int ex, int min, int max, double pric, String nam){
        item = it;
        chance = ch;
        exp = ex;
        maxY = max;
        minY = min;
        price = pric;
        name = nam;
    }

    public ItemStack getItem(){
        return item;
    }

    public double getChance(){
        return chance;
    }

    public int getExp(){
        return exp;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinY() {
        return minY;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {return name;}

    @NotNull
    @Override
    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("it", item);
        map.put("ch", chance);
        map.put("exp", exp);
        map.put("maxy", maxY);
        map.put("miny", minY);
        map.put("price", price);
        map.put("name", name);
        return map;
    }

    @NotNull
    public static Item deserialize(@NotNull Map<String, Object> args){
        Item icc = new Item(new ItemStack(Material.STONE), 1.0,1,1,1,1.0,"WRONG ITEM");
        for (Item ic : allItems){
            if (ic.getName().equals(args.get("mat")) && ic.getName().equals(args.get("ch"))
                    && ic.getName().equals(args.get("exp")) && ic.getName().equals(args.get("maxy"))
                    && ic.getName().equals(args.get("miny")) && ic.getName().equals(args.get("price"))
                    && ic.getName().equals(args.get("name"))){
                return ic;
            }
        }
        return icc;
    }

    public static void initializeDrops(){
        FileConfiguration config = Main.getPlugin(Main.class).getConfig();
        List<String> blocks = config.getStringList("blocks");
        for (String s : blocks){
            blockdrops.add(XMaterial.valueOf(s.toUpperCase()).parseMaterial());
        }
        ConfigurationSection items = config.getConfigurationSection("itemlist");
        assert items != null;
        Set<String> itemkeys = items.getKeys(false);
        for (String item : itemkeys){
            ConfigurationSection currentItem = items.getConfigurationSection(item);
            assert currentItem != null;
            String name = currentItem.getString("name");
            assert name != null;
            name  = name.replace("&", "§");
            allItems.add(new Item(XMaterial.valueOf(currentItem.getString("item").toUpperCase()).parseItem(),
                    currentItem.getDouble("chance"), currentItem.getInt("exp"), currentItem.getInt("min"),
                    currentItem.getInt("max"), currentItem.getDouble("money"), name));
        }
        allItems.sort(Comparator.comparing(Item::getChance));
    }
}
