package unfair.kozyosenplugin.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import unfair.kozyosenplugin.Kozyosen_plugin;

public class getGrayConcrete implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent event){

        Block b = event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN);
        if(b.getType() == Material.GRAY_CONCRETE){
            if(Kozyosen_plugin.Waitlist.contains(event.getPlayer().getUniqueId()))return;
            event.getPlayer().sendMessage(ChatColor.AQUA+"waitlistに入りました");
            Kozyosen_plugin.Waitlist.add(event.getPlayer().getUniqueId());
        }
    }

}
