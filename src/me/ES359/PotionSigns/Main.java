package me.ES359.PotionSigns;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ES359 on 11/17/14.
 */
public class Main extends JavaPlugin {


    public void onEnable() {


        Bukkit.getServer().getPluginManager().registerEvents(new SignListener(),this);

    }

    public void onDisable() {

    }


}
