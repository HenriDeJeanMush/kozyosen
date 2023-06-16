package unfair.kozyosenplugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.checkerframework.checker.units.qual.K;
import unfair.kozyosenplugin.Kozyosen_plugin;
import unfair.kozyosenplugin.Utils.donewar;

import java.util.HashMap;
import java.util.UUID;

public class getBeconBreak implements Listener {

    private final HashMap<UUID, Long> cooldown;

    public getBeconBreak(){
        this.cooldown =new HashMap<>();
    }
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
    @EventHandler
    public void onBreaking(BlockDamageEvent event){
        if(!Kozyosen_plugin.onWar)return;;
        Player player = event.getPlayer();
        if(event.getBlock().getType().equals(Material.BEACON)){
            if(Kozyosen_plugin.red.hasPlayer(event.getPlayer())){
                if(!this.cooldown.containsKey((player.getUniqueId()))) {

                    this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());

                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(ChatColor.RED + "RedTeamがビーコンを壊している！");
                    }
                }else {
                        long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());

                        if(timeElapsed > 2000){
                            this.cooldown.put(player.getUniqueId(),System.currentTimeMillis());
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage(ChatColor.RED + "RedTeamがビーコンを壊している！");
                            }
                        }
                    }
            }else if(Kozyosen_plugin.blue.hasPlayer(event.getPlayer())){
                if(!this.cooldown.containsKey((player.getUniqueId()))) {

                    this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());

                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(ChatColor.BLUE+"Blueeamがビーコンを壊している！");
                    }
                }else {
                    long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());

                    if(timeElapsed > 2000){
                        this.cooldown.put(player.getUniqueId(),System.currentTimeMillis());
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage(ChatColor.BLUE + "RedTeamがビーコンを壊している！");
                        }
                    }
                }
            }
        }
    }

}
