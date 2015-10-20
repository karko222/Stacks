package code.alexandeh.stacks.commands;

import code.alexandeh.stacks.Stacks;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Alex on 8/17/2015.
 */
public class StacksCommand implements CommandExecutor {

    private Stacks main = Stacks.getInstance();

    public StacksCommand() {
        main.getCommand("stacks").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {

        if (cmd.equalsIgnoreCase("stacks")) {
            sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "------------------------");
            sender.sendMessage(ChatColor.GOLD + "Stacks " + ChatColor.YELLOW + "(" + ChatColor.GOLD + main.getDescription().getVersion() + ChatColor.YELLOW + ")");
            sender.sendMessage(ChatColor.GOLD + "Created by " + ChatColor.GOLD + "Flap ");
            sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "------------------------");
        }

        return false;
    }
}
