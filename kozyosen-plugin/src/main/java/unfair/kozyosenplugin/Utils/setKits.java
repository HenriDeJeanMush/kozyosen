package unfair.kozyosenplugin.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import unfair.kozyosenplugin.Kozyosen_plugin;

public class setKits {

    public static void set(Player sender){

        Kozyosen_plugin.plugin.getConfig().set("kit",sender.getInventory().getContents());
        Kozyosen_plugin.ReloadSaveConfig();
        sender.sendMessage(ChatColor.GREEN+"kit save complete");

    }

}
