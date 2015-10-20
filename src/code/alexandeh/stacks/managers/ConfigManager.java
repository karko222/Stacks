package code.alexandeh.stacks.managers;

import code.alexandeh.stacks.Stacks;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by Alex on 8/17/2015.
 */
public class ConfigManager {

    Stacks main = Stacks.getInstance();
    File file;
    YamlConfiguration configuration;

    public ConfigManager() {
        file = new File(main.getDataFolder(), "config.yml");
        if (!(file.exists())) {
            main.saveDefaultConfig();
        }
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public String getString(String path) {
        if (configuration.contains(path)) {
            return ChatColor.translateAlternateColorCodes('&', configuration.getString(path));
        }
        return "ERROR";
    }

    public int getInt(String path) {
        if (configuration.contains(path)) {
            return configuration.getInt(path);
        }
        return 0;
    }

    public double getDouble(String path) {
        if (configuration.contains(path)) {
            return configuration.getDouble(path);
        }
        return 0;
    }

    public boolean getBoolean(String path) {
        return configuration.contains(path) && configuration.getBoolean(path);
    }



}
