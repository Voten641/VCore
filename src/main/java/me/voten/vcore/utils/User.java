package me.voten.vcore.utils;

import com.google.common.collect.Maps;
import me.voten.vcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

public class User {

    private final Player player;
    private int deaths;
    private int kills;
    private int stone;
    private int enchga;
    private int ga;
    private int pearl;
    private int enderchestslots;
    private boolean automaticchatmessages;
    private boolean casechatmessages;
    private boolean privatemessages;
    private boolean killmessages;
    private boolean dropmessages;
    private boolean globalmessages;
    private boolean cobbledrop;
    private boolean spawnteleporting;
    private boolean playerteleporting;
    private Player teleporttoplayer;
    private List<Player> teleportsfromplayers;
    private boolean cheatcheck;
    public Player cheatcheckby;
    private Player checkingplayer;
    private final HashMap<Item, Boolean> drops = Maps.newHashMap();
    private static HashMap<UUID, User> userByUUID = Maps.newHashMap();
    private HashMap<Integer, ItemStack> enderchestitems = Maps.newHashMap();

    public User(Player p){
        player = p;
        userByUUID.put(p.getUniqueId(), this);
        for (Item item : Item.allItems){
            drops.put(item, true);
        }
        File folder = new File(Main.getPlugin(Main.class).getDataFolder(), "playerData");
        if(!folder.exists()) if(!folder.mkdirs()) Bukkit.getLogger().log(Level.WARNING, "Error while creating playerData folder");
        File file = new File(Main.getPlugin(Main.class).getDataFolder(), "playerData/" + p.getUniqueId() + ".yml");
        if(!file.exists()){
            try{
                file.createNewFile();
                    FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                    config.set("deaths", 0);
                    config.set("kills", 0);
                    config.set("stone", 0);
                    config.set("enchga", 0);
                    config.set("ga", 0);
                    config.set("pearl", 0);
                    config.set("enderchestslots", 27);
                    config.set("automaticchatmessages", true);
                    config.set("casechatmessages", true);
                    config.set("privatemessages", true);
                    config.set("killmessages", true);
                    config.set("dropmessages", true);
                    config.set("globalmessages", true);
                    for(int i = 0; i < enderchestslots; i++){
                        config.set("enderchestitem"+i, new ItemStack(Material.AIR));
                    }
                    config.save(file);
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        deaths = config.getInt("deaths");
        kills =config.getInt("kills");
        stone = config.getInt("stone");
        enchga = config.getInt("enchga");
        ga = config.getInt("ga");
        pearl = config.getInt("pearl");
        enderchestslots = config.getInt("enderchestslots");
        automaticchatmessages = config.getBoolean("automaticchatmessages");
        casechatmessages = config.getBoolean("casechatmessages");
        privatemessages = config.getBoolean("privatemessages");
        killmessages = config.getBoolean("killmessages");
        dropmessages = config.getBoolean("dropmessages");
        globalmessages = config.getBoolean("globalmessages");
        cobbledrop = true;
        cheatcheck = false;
        cheatcheckby = null;
        checkingplayer = null;
        for(int i = 0; i < enderchestslots; i++){
            enderchestitems.put(i, config.getItemStack("enderchestitem"+i));
        }
    }

    public void saveUser(){
        File file = new File(Main.getPlugin(Main.class).getDataFolder(), "playerData/" + player.getUniqueId() + ".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("deaths", deaths);
        config.set("kills", kills);
        config.set("stone", stone);
        config.set("enchga", enchga);
        config.set("ga", ga);
        config.set("pearl", pearl);
        config.set("enderchestslots", enderchestslots);
        config.set("automaticchatmessages", automaticchatmessages);
        config.set("casechatmessages", casechatmessages);
        config.set("privatemessages", privatemessages);
        config.set("killmessages", killmessages);
        config.set("dropmessages", dropmessages);
        config.set("globalmessages", globalmessages);
        for(int i = 0; i < enderchestslots; i++){
            config.set("enderchestitem"+i, enderchestitems.get(i));
        }
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, ItemStack> getEnderchest(){
        return enderchestitems;
    }

    public void setEnderchestitem(Integer slot, ItemStack it){
        enderchestitems.replace(slot, it);
    }

    public void setDrop(Item item, Boolean bol){
        drops.replace(item, bol);
    }

    public boolean getDrop(Item item){
        return drops.get(item);
    }

    public static User getUserByUUID(UUID uuid){
        if(userByUUID.containsKey(uuid)) return userByUUID.get(uuid);
        return null;
    }

    public Player getPlayer() {
        return player;
    }

    public int getEnderchestslots() {
        return enderchestslots;
    }

    public void setEnderchestslots(int enderchestslots) {
        this.enderchestslots = enderchestslots;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public boolean isCobbledrop() {
        return cobbledrop;
    }

    public void setCobbledrop(boolean cobbledrop) {
        this.cobbledrop = cobbledrop;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public int getEnchga() {
        return enchga;
    }

    public void setEnchga(int enchga) {
        this.enchga = enchga;
    }

    public int getGa() {
        return ga;
    }

    public void setGa(int ga) {
        this.ga = ga;
    }

    public int getPearl() {
        return pearl;
    }

    public void setPearl(int pearl) {
        this.pearl = pearl;
    }

    public boolean isAutomaticchatmessages() {
        return automaticchatmessages;
    }

    public void setAutomaticchatmessages(boolean automaticchatmessages) {
        this.automaticchatmessages = automaticchatmessages;
    }

    public boolean isCasechatmessages() {
        return casechatmessages;
    }

    public void setCasechatmessages(boolean casechatmessages) {
        this.casechatmessages = casechatmessages;
    }

    public boolean isPrivatemessages() {
        return privatemessages;
    }

    public void setPrivatemessages(boolean privatemessages) {
        this.privatemessages = privatemessages;
    }

    public boolean isKillmessages() {
        return killmessages;
    }

    public void setKillmessages(boolean killmessages) {
        this.killmessages = killmessages;
    }

    public boolean isDropmessages() {
        return dropmessages;
    }

    public void setDropmessages(boolean dropmessages) {
        this.dropmessages = dropmessages;
    }

    @NotNull
    public boolean isGlobalmessages() {
        return globalmessages;
    }

    public void setGlobalmessages(boolean globalmessages) {
        this.globalmessages = globalmessages;
    }

    public boolean isSpawnteleporting() {
        return spawnteleporting;
    }

    public void setSpawnteleporting(boolean spawnteleporting) {
        this.spawnteleporting = spawnteleporting;
    }

    public boolean isPlayerteleporting() {
        return playerteleporting;
    }

    public void setPlayerteleporting(boolean playerteleporting) {
        this.playerteleporting = playerteleporting;
    }

    public Player getTeleporttoplayer() {
        return teleporttoplayer;
    }

    public void setTeleporttoplayer(Player teleporttoplayer) {
        this.teleporttoplayer = teleporttoplayer;
    }

    public List<Player> getTeleportsfromplayers() {
        return teleportsfromplayers;
    }

    public boolean isCheatcheck() {
        return cheatcheck;
    }

    public void setCheatcheck(boolean cheatcheck) {
        this.cheatcheck = cheatcheck;
    }

    public void setPlayerCheatCheck(Player cheatcheckby) {
        this.cheatcheckby = cheatcheckby;
    }

    public Player getPlayerCheatCheck() {
        return cheatcheckby;
    }

    public Player getCheckingplayer() {
        return checkingplayer;
    }

    public void setCheckingplayer(Player checkingplayer) {
        this.checkingplayer = checkingplayer;
    }
}
