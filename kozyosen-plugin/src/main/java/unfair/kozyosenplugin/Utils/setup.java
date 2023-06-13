package unfair.kozyosenplugin.Utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import unfair.kozyosenplugin.Kozyosen_plugin;

import java.util.ArrayList;

public class setup {

    public static void tp(){

        for(int i=0;i<Kozyosen_plugin.Blueplayers.size();i++){
            Bukkit.getPlayer(Kozyosen_plugin.Blueplayers.get(i)).teleport(Kozyosen_plugin.plugin.getConfig().getLocation("bluespawnlocation"));
            Kozyosen_plugin.plugin.getConfig().getLocation("bluespawnlocation").getWorld().playSound(Kozyosen_plugin.plugin.getConfig().getLocation("bluespawnlocation"), Sound.BLOCK_ANVIL_USE,1,1);
        }
        for(int i=0;i<Kozyosen_plugin.Redplayers.size();i++){
            Bukkit.getPlayer(Kozyosen_plugin.Redplayers.get(i)).teleport(Kozyosen_plugin.plugin.getConfig().getLocation("redspawnlocation"));
            Kozyosen_plugin.plugin.getConfig().getLocation("redspawnlocation").getWorld().playSound(Kozyosen_plugin.plugin.getConfig().getLocation("redspawnlocation"), Sound.BLOCK_ANVIL_USE,1,1);
        }

    }
    public static void loadkit() {
        for (int i = 0; i < Kozyosen_plugin.Blueplayers.size(); i++) {
            Player player = Bukkit.getPlayer(Kozyosen_plugin.Blueplayers.get(i));
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setSaturation(6);
            for (PotionEffect e : player.getActivePotionEffects()) {
                player.removePotionEffect(e.getType());
            }
            ArrayList<ItemStack> content = null;
            ItemStack[] items = null;
            content = (ArrayList<ItemStack>) Kozyosen_plugin.plugin.getConfig().getList("kit");
            items = new ItemStack[content.size()];

            for (int n = 0; n < content.size(); n++) {
                ItemStack item = content.get(n);
                if (item != null) {
                    items[n] = item;
                } else {
                    items[n] = null;
                }
            }
            player.getInventory().setContents(items);
        }
        for (int i = 0; i < Kozyosen_plugin.Redplayers.size(); i++) {
            Player player = Bukkit.getPlayer(Kozyosen_plugin.Redplayers.get(i));
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setSaturation(6);
            for (PotionEffect e : player.getActivePotionEffects()) {
                player.removePotionEffect(e.getType());
            }
            ArrayList<ItemStack> content = null;
            ItemStack[] items = null;
            content = (ArrayList<ItemStack>) Kozyosen_plugin.plugin.getConfig().getList("kit");
            items = new ItemStack[content.size()];

            for (int n = 0; n < content.size(); n++) {
                ItemStack item = content.get(n);
                if (item != null) {
                    items[n] = item;
                } else {
                    items[n] = null;
                }
            }
            player.getInventory().setContents(items);
        }
    }
}
