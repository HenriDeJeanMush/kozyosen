package unfair.kozyosenplugin.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import unfair.kozyosenplugin.Kozyosen_plugin;

public class donewar {

    public static void done(Team winteam,Player breaker){

        for(int b=0;b<Kozyosen_plugin.Blueplayers.size();b++){
            Player player = Bukkit.getPlayer(Kozyosen_plugin.Blueplayers.get(b));
            Kozyosen_plugin.blue.removePlayer(Bukkit.getPlayer(Kozyosen_plugin.Blueplayers.get(b)));
            Kozyosen_plugin.plugin.getConfig().getLocation("bluespawnlocation").getWorld().playSound(Kozyosen_plugin.plugin.getConfig().getLocation("bluespawnlocation"), Sound.BLOCK_ANVIL_USE,1,1);
            if(winteam.equals(Kozyosen_plugin.red)){
                player.sendTitle(ChatColor.RED+"Red "+ChatColor.YELLOW+"Win!!", ChatColor.BLUE+breaker.getDisplayName()+"がこわした", 1, 200, 1);
            }else if(winteam.equals(Kozyosen_plugin.blue)){
                player.sendTitle(ChatColor.BLUE+"Blue "+ChatColor.YELLOW+"Win!!", ChatColor.RED+breaker.getDisplayName()+"がこわした", 1, 200, 1);
            }
        }
        for(int r=0;r<Kozyosen_plugin.Redplayers.size();r++){
            Player player = Bukkit.getPlayer(Kozyosen_plugin.Redplayers.get(r));
            Kozyosen_plugin.red.removePlayer(Bukkit.getPlayer(Kozyosen_plugin.Redplayers.get(r)));
            Kozyosen_plugin.plugin.getConfig().getLocation("redspawnlocation").getWorld().playSound(Kozyosen_plugin.plugin.getConfig().getLocation("redspawnlocation"), Sound.BLOCK_ANVIL_USE,1,1);
            if(winteam.equals(Kozyosen_plugin.red)){
                player.sendTitle(ChatColor.RED+"Red "+ChatColor.YELLOW+"Win!!", ChatColor.BLUE+breaker.getDisplayName()+"がこわした", 1, 200, 1);
            }else if(winteam.equals(Kozyosen_plugin.blue)){
                player.sendTitle(ChatColor.BLUE+"Blue "+ChatColor.YELLOW+"Win!!", ChatColor.RED+breaker.getDisplayName()+"がこわした", 1, 200, 1);
            }
        }
        Kozyosen_plugin.Redplayers.clear();
        Kozyosen_plugin.Blueplayers.clear();
        Kozyosen_plugin.onWar=false;

    }

}
