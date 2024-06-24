package me.supramental.chatfilter;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class ChatListener implements Listener {
    private final ChatFilter plugin;

    public ChatListener(ChatFilter plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        List<String> badWords = plugin.getBadWords();

        for (String badWord : badWords) {
            if (message.toLowerCase().contains(badWord.toLowerCase())) {
                message = message.replaceAll("(?i)" + badWord, repeatAsterisks(badWord.length()));
            }
        }

        event.setMessage(message);
    }

    private String repeatAsterisks(int length) {
        return "*".repeat(length);
    }
}
