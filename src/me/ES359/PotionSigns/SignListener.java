package me.ES359.PotionSigns;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;


/**
 * Created by ES359 on 11/17/14.
 */
public class SignListener implements Listener {


    public void logEvent() {
        Bukkit.getServer().getConsoleSender().sendMessage("EVENT CALLED FOR POTIONSIGNS.");
    }

    @EventHandler
    public void sign(SignChangeEvent event) {
        if(event.getLine(0).equalsIgnoreCase("[PotionSigns]")) {
            if(event.getLine(1).equalsIgnoreCase("Nightvision")) {
                event.setLine(0, "§9[PotionSigns]");
                event.setLine(1,"§bNightVision!");
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9[PotionSigns] &bSign &acreated!"));
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9[PotionSigns] &3Night vision sign &acreated!"));
              //  logEvent();
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if(event.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign)event.getClickedBlock().getState();

            if(s.getLine(0).equalsIgnoreCase("§9[PotionSigns]")) {
                if(s.getLine(1).equalsIgnoreCase("§bNightVision!")) {

                    Potion p = new Potion(PotionType.NIGHT_VISION);
                    p.setSplash(true);

                    event.getPlayer().getInventory().addItem(p.toItemStack(3));
                    event.getPlayer().updateInventory();
                    event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9[PotionSigns] &aPotion added to Inventory"));
                   // logEvent();
                }
            }
        }
    }

}
