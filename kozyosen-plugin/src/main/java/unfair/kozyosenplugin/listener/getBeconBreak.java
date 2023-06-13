package unfair.kozyosenplugin.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.checkerframework.checker.units.qual.K;
import unfair.kozyosenplugin.Kozyosen_plugin;
import unfair.kozyosenplugin.Utils.donewar;

public class getBeconBreak implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(!Kozyosen_plugin.onWar)return;;
        if(event.getBlock().getType().equals(Material.BEACON)){
            if(Kozyosen_plugin.red.hasPlayer(event.getPlayer())){
                donewar.done(Kozyosen_plugin.red);
            }else if(Kozyosen_plugin.blue.hasPlayer(event.getPlayer())){
                donewar.done(Kozyosen_plugin.blue);
            }
        }
    }

}
