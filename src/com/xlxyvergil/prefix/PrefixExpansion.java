package com.xlxyvergil.prefix;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class PrefixExpansion extends PlaceholderExpansion {
    /**
     * Since we register the expansion inside our own plugin, we
     * can simply use this method here to get an instance of our
     * plugin.
     *
     * @param plugin
     *        The instance of our plugin.
     */
    /**
     * Because this is an internal class,
     * you must override this method to let PlaceholderAPI know to not unregister your expansion class when
     * PlaceholderAPI is reloaded
     *
     * @return true to persist through reloads
     */

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

    private static String varMessage;
    public static String prefix;
    public static String Suffix;

    @Override
    public String onPlaceholderRequest(Player player, String identifier){
        if (player == null) return "";
        String[] args = new String[0];
        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            String Message = "%player_displayname%";
            varMessage = PlaceholderAPI.setPlaceholders(target, Message);
            String[] varp = varMessage.split("", 1);
            int varm = varMessage.length();
            prefix = varp[0] + varp[1] + varp[2] + varp[3] + varp[4] + varp[5];
            prefix = String.valueOf(Integer.parseInt(identifier));
            Suffix = varp[varm - 5] + varp[varm - 4] + varp[varm - 3] + varp[varm - 2] + varp[varm - 1] + varp[varm];
            Suffix = String.valueOf(Integer.parseInt(identifier));
        }
        // %someplugin_placeholder1%
        if(identifier.equals("prefix")){
            return prefix;
        }
 //           return plugin.getConfig().getString("prefix", "value doesnt exist");

        // %someplugin_placeholder2%
        if(identifier.equals("Suffix")){
            return Suffix;
        }
        // We return null if an invalid placeholder (f.e. %someplugin_placeholder3%)
        // was provided
        return null;
    }
}
