package com.xlxyvergil.prefix;


import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PrefixExpansion extends PlaceholderExpansion implements Listener {
//    private prefix plugin;
//    public PrefixExpansion(prefix plugin){
//        this.plugin = plugin;
//    }
    /**
     * This method should always return true unless we have a dependency we need to make sure is on the server for our placeholders to work!
     *
     * @return always true since we do not have any dependencies.
     */
    @Override
    public boolean canRegister() {
        return true;
    }

    /**
     * The name of the person who created this expansion should go here.
     *
     * @return The name of the author as a String.
     */
    @Override
    public String getAuthor() {
        return "xlxyvergil";
    }

    /**
     * The placeholder identifier should go here. <br>
     * This is what tells PlaceholderAPI to call our onRequest method to obtain a value if a placeholder starts with our identifier. <br>
     * This must be unique and can not contain % or _
     *
     * @return The identifier in {@code %<identifier>_<value>%} as String.
     */
    @Override
    public String getIdentifier() {
        return "prefix";
    }

    /**
     * This is the version of this expansion. <br>
     * You don't have to use numbers, since it is set as a String.
     *
     * @return The version as a String.
     */
    @Override
    public String getVersion() {
        return "1.0.0";
    }

    public static char prefix;
    public static char suffix;

    @EventHandler(priority = EventPriority.HIGHEST)
    public final void onJoin(PlayerJoinEvent event) {
        String label;
        System.out.println("1111111");
        String[] args = {"123"};
        System.out.println("2222222");
        CommandSender sender = null;
        Command command;
        System.out.println("2233333");
            if (args.length != 0) {
                System.out.println("33333333");
                String message = "%player_displayname%";
                Player target = Bukkit.getPlayer(args[0]);
                message = PlaceholderAPI.setPlaceholders(target, message);
                char[] varp = message.toCharArray();
                int n = message.length();
                System.out.println("555555555");
                prefix = new int[];
//                        {varp[0] , varp[1] , varp[2] , varp[3] , varp[4] , varp[5]};
                System.out.println("prefix ok");
//                        new String(varp[n - 6] + varp[n - 5] + varp[n - 4] + varp[n - 3] + varp[n - 2] + varp[n - 1] + varp[n]);
                suffix =
//                        {varp[n - 6] , varp[n - 5] , varp[n - 4] , varp[n - 3] , varp[n - 2] , varp[n - 1] , varp[n]};
                System.out.println("suffix ok");
            }
        System.out.println("------------------------------" + prefix);
        System.out.println("------------------------------" + suffix);
        }

    @Override
    public String onRequest(OfflinePlayer   player,String identifier){
        if (identifier != null) {
            prefix = (char) Integer.parseInt(identifier);
            return "" + prefix;
        }
//        if(identifier.equals("prefix")){
//            return plugin.getConfig().getString("prefix", "value doesnt exist");
//        }
//        if(identifier.equals("suffix")){
//            return plugin.getConfig().getString("suffix", "value doesnt exist");
//        }
//        System.out.println("identifier ok");
//            prefix = String.valueOf(Integer.parseInt(identifier));
//            suffix = String.valueOf(Integer.parseInt(identifier));
//            System.out.println("identifier ok");
//            return "" + prefix;
//        }
        return null;
    }
}

