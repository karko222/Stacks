package code.alexandeh.stacks;

import code.alexandeh.stacks.listeners.MobListeners;
import code.alexandeh.stacks.commands.StacksCommand;
import code.alexandeh.stacks.managers.ConfigManager;
import code.alexandeh.stacks.managers.StackManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Alex on 8/17/2015.
 */
public class Stacks extends JavaPlugin {

    private static Stacks instance;
    private ConfigManager configManager;
    private StackManager stackManager;

    public void onEnable() {
        instance = this;

        configManager = new ConfigManager();
        stackManager = new StackManager();

        new MobListeners();
        new StacksCommand();
    }

    public static Stacks getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public StackManager getStackManager() {
        return stackManager;
    }

}
