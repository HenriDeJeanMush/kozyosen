package unfair.kozyosenplugin.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import unfair.kozyosenplugin.Kozyosen_plugin;

public class setSpawnLocation {


    public static void setSpawn(String team, Player sender){
        if(team.equalsIgnoreCase("red")||team.equalsIgnoreCase("blue")){
            Kozyosen_plugin.plugin.getConfig().set(team+"spawnlocation",sender.getLocation());
            sender.sendMessage(ChatColor.GREEN+team+ChatColor.GRAY+"のspawn地点を設定しました");
            Kozyosen_plugin.ReloadSaveConfig();
        }else {
            sender.sendMessage(ChatColor.RED+"[blue,red]");
        }

    }

}
