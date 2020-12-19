package com.xlxyvergil.prefix;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Prefixonable extends JavaPlugin implements Listener {
    public static String prefix;
    public static String suffix;

    @Override
    public void onEnable() {
        // Small check to make sure that PlaceholderAPI is installed
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PrefixExpansion(this).register();
            String label;String[] args = new String[0];//配置变量，用于解析"%player_displayname%"
            if (args.length == 0) {
                System.out.println("33333333");
                String message = "%player_displayname%";
                Player target = Bukkit.getPlayer(args[0]);
                message = PlaceholderAPI.setPlaceholders(target, message);
                char[] varp = message.toCharArray();
                int n = message.length();
                prefix = "" + varp[0] + varp[1] + varp[2] + varp[3] + varp[4] + varp[5];
                System.out.println("prefix ok");
                suffix = "" + varp[n - 6] + varp[n - 5] + varp[n - 4] + varp[n - 3] + varp[n - 2] + varp[n - 1] + varp[n];
                System.out.println("suffix ok");
                Bukkit.getPluginManager().registerEvents(this, this);
            }else {
                /*
                 * We inform about the fact that PlaceholderAPI isn't installed and then
                 * disable this plugin to prevent issues.
                 */
                getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
                Bukkit.getPluginManager().disablePlugin(this);
            }
        }
    }
}
