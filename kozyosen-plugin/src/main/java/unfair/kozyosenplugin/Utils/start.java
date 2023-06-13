package unfair.kozyosenplugin.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import unfair.kozyosenplugin.Kozyosen_plugin;

public class start {

    public static void set(String args1, Player sender){

        if(args1.equalsIgnoreCase("confirm")){
            if(Kozyosen_plugin.plugin.getConfig().getLocation("bluespawnlocation") ==null){
                sender.sendMessage(ChatColor.RED+"bluespawnlocationがnullです");
                return;
            }
            if(Kozyosen_plugin.plugin.getConfig().getLocation("redspawnlocation") ==null){
                sender.sendMessage(ChatColor.WHITE +"redspawnlocationがnullです");
                return;
            }
            if(Kozyosen_plugin.plugin.getConfig().getList("kit") ==null){
                sender.sendMessage(ChatColor.RED+"kitがnullです");
                return;
            }
            //lets go
            setup.tp();
            setup.loadkit();
            Kozyosen_plugin.onWar=true;

        }

    }

}
