package unfair.kozyosenplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import unfair.kozyosenplugin.Utils.setKits;
import unfair.kozyosenplugin.Utils.setSpawnLocation;
import unfair.kozyosenplugin.Utils.setTeam;
import unfair.kozyosenplugin.Utils.start;

import java.net.http.WebSocket;

public class getCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(commandSender instanceof Player){
            if(args.length==0){
                commandSender.sendMessage("--kozyosen command--");
                commandSender.sendMessage("/kozyosen setspawn [blue,red]");
                commandSender.sendMessage("/kozyosen setkit");
                commandSender.sendMessage("/kozyosen setteam");
                commandSender.sendMessage("/kozyosen start confirm");
                return true;
            } else if (args.length==2) {
                if(args[0].equalsIgnoreCase("setspawn")) {
                    setSpawnLocation.setSpawn(args[1], (Player) commandSender);
                    return true;
                }else if(args[0].equalsIgnoreCase("start")){
                    start.set(args[1],(Player) commandSender);
                    return true;
                }
            }else if(args.length==1){
                if(args[0].equalsIgnoreCase("setkit")){
                    setKits.set((Player) commandSender);
                    return true;
                }
                if(args[0].equalsIgnoreCase("setteam")){
                    setTeam.set((Player) commandSender);
                    return true;
                }
            }
        }


        return false;
    }
}
