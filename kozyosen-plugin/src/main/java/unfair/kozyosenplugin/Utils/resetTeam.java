package unfair.kozyosenplugin.Utils;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import unfair.kozyosenplugin.Kozyosen_plugin;

public class resetTeam {

    public static void reset(){
        for (OfflinePlayer player : Kozyosen_plugin.red.getPlayers()) {
            Kozyosen_plugin.red.removePlayer(player);
        }
        for (OfflinePlayer player : Kozyosen_plugin.blue.getPlayers()) {
            Kozyosen_plugin.blue.removePlayer(player);
        }
        Kozyosen_plugin.Redplayers.clear();
        Kozyosen_plugin.Blueplayers.clear();

    }

}
