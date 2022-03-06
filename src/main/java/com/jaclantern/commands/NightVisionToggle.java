package com.jaclantern.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static com.jaclantern.JacLantern.*;

public class NightVisionToggle implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        boolean infinite = getInstance().getConfig().getBoolean("Infinite");
        int duration = getInstance().getConfig().getInt("Duration");
        String enableMessage = getInstance().getConfig().getString("Messages.enable-message").replace("&", "§");
        String disableMessage = getInstance().getConfig().getString("Messages.disable-message").replace("&", "§");



        if(cmd.getName().equalsIgnoreCase("nv")) {

            if(!player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                if(infinite) {
                    duration = 1000000;
                    player.sendMessage(enableMessage.replace("%duration%", "*"));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, duration, 0, true, false));
                    return true;
                }
                player.sendMessage(enableMessage.replace("%duration%", Integer.toString(duration / 60)));
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * duration, 0, true, false));
            } else {
                player.sendMessage(disableMessage);
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            }
        }


        return false;
    }
}
