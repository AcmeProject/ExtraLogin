package net.poweredbyhate.extralogin;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ExtraLogin extends JavaPlugin implements Listener {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent ev) {
        Player p = ev.getPlayer();
        lightning(p);
        jumpBoost(p);
        musicAlert(p);
        food(p);
    }

    public void lightning(Player p) {
          if (p.hasPermission("extralogin.lightning")) {
              p.getLocation().getWorld().strikeLightning(p.getLocation());
          }
    }

    public void jumpBoost(Player p) {
        if (p.hasPermission("extralogin.potion.jump")) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 3, 1200));
        }
    }

    public void musicAlert(Player p) {
        if (p.hasPermission("extraLogin.musicalert.exp")) {
           p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1, 1);
        }
    }

    public void food(Player p) {
        if (p.hasPermission("extralogin.food")) {
             p.setFoodLevel(20);
        }
    }

}
