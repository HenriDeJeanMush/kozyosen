package unfair.kozyosenplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

public class selfkillcommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(commandSender instanceof Player){
            if(((Player) commandSender).getHealth()==20){
                ((Player) commandSender).setHealth(0);
                return true;
            }else {
                commandSender.sendMessage(ChatColor.RED+"hpがmaxではないのでできません");
            }
        }
        return false;
    }
}
