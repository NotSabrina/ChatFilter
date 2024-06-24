package me.supramental.chatfilter;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ChatFilter extends JavaPlugin {
    private List<String> badWords;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadBadWords();
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("ChatFilter OUT");
    }

    public List<String> getBadWords() {
        return badWords;
    }

    public void loadBadWords() {
        FileConfiguration config = getConfig();
        badWords = config.getStringList("bad-words");
    }
}
