package unfair.kozyosenplugin.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;
import unfair.kozyosenplugin.Kozyosen_plugin;

public class SpawnPlayer implements Listener {

    @EventHandler
    public void onDeath(PlayerRespawnEvent event){

        if(Kozyosen_plugin.Blueplayers.contains(event.getPlayer().getUniqueId())){
            event.setRespawnLocation(Kozyosen_plugin.plugin.getConfig().getLocation("bluespawnlocation"));
        }else if(Kozyosen_plugin.Redplayers.contains(event.getPlayer().getUniqueId())){
            event.setRespawnLocation(Kozyosen_plugin.plugin.getConfig().getLocation("redspawnlocation"));
        }

    }

}
