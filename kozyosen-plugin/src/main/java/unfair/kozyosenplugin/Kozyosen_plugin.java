package unfair.kozyosenplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import unfair.kozyosenplugin.commands.getCommand;
import unfair.kozyosenplugin.commands.selfkillcommand;
import unfair.kozyosenplugin.listener.getBeconBreak;
import unfair.kozyosenplugin.listener.getGrayConcrete;
import unfair.kozyosenplugin.listener.SpawnPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public final class Kozyosen_plugin extends JavaPlugin {

    public static Kozyosen_plugin plugin;
    public static Scoreboard board ;
    public static List<UUID> Waitlist = null;
    public static org.bukkit.scoreboard.Team red ;
    public static org.bukkit.scoreboard.Team blue;
    public static List<UUID> Redplayers ;
    public static List<UUID> Blueplayers ;
    public static boolean onWar;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new getGrayConcrete(),this);
        this.getServer().getPluginManager().registerEvents(new getBeconBreak(),this);
        this.getServer().getPluginManager().registerEvents(new SpawnPlayer(),this);
        getCommand("kozyosen").setExecutor(new getCommand());
        getCommand("selfkill").setExecutor(new selfkillcommand());
        Logger.getLogger("[kozyosen-plugin]enable");
        Bukkit.getScheduler().runTask(this,()-> {
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            board = manager.getNewScoreboard();
            Waitlist = new ArrayList<UUID>();
            red = board.registerNewTeam("Red");
            blue = board.registerNewTeam("Blue");
            Redplayers = new ArrayList<UUID>();
            Blueplayers = new ArrayList<UUID>();
            onWar = false;
            //team
            Waitlist.clear();
            red.setColor(ChatColor.RED);
            blue.setColor(ChatColor.BLUE);
            for(Player online : Bukkit.getOnlinePlayers()){
                online.setScoreboard(board);
            }
        } ) ;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void ReloadSaveConfig(){
        plugin.saveConfig();
        plugin.reloadConfig();
    }
}
