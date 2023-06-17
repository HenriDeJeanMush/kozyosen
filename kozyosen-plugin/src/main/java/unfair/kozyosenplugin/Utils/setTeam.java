package unfair.kozyosenplugin.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Warden;
import unfair.kozyosenplugin.Kozyosen_plugin;

import java.util.Collections;

public class setTeam {

    public static void set(Player sender){

        Collections.shuffle(Kozyosen_plugin.Waitlist);
        int teamsize = Kozyosen_plugin.Waitlist.size();

        if(teamsize<=1){
            sender.sendMessage(ChatColor.RED+"最低人数２人以上です");
            return;
        }

        for(int i=0;i<teamsize;i++){
            if(i<teamsize/2){
                Kozyosen_plugin.red.addPlayer(Bukkit.getPlayer(Kozyosen_plugin.Waitlist.get(i)));
                Kozyosen_plugin.Redplayers.add(Kozyosen_plugin.Waitlist.get(i));
            }else {
                Kozyosen_plugin.blue.addPlayer(Bukkit.getPlayer(Kozyosen_plugin.Waitlist.get(i)));
                Kozyosen_plugin.Blueplayers.add(Kozyosen_plugin.Waitlist.get(i));
            }
        }
        sender.sendMessage(ChatColor.GREEN+"team振り分け完了");
        Kozyosen_plugin.Waitlist.clear();
        for(Player online : Bukkit.getOnlinePlayers()) {
            online.setScoreboard(Kozyosen_plugin.board);
        }

    }

}
