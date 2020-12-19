//package com.xlxyvergil.prefix;
//
//import me.clip.placeholderapi.PlaceholderAPI;
//import org.bukkit.Bukkit;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//import java.util.Arrays;
//
//public class pcom implements CommandExecutor {
//
//    @Override
//    public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        if (args.length == 1) {
//            String message = "%player_displayname%";
//            Player target = Bukkit.getPlayer(args[0]);
//            message = PlaceholderAPI.setPlaceholders(target, message);
//            Player player = (Player) sender;
//            String[] varp = message.split("");
//            int n = message.length();
//            System.out.println("555555555");
//            PrefixExpansion.prefix = String.valueOf(varp[0] + varp[1] + varp[2] + varp[3] + varp[4] + varp[5]);
//            PrefixExpansion.suffix = String.valueOf(varp[n - 6] + varp[n - 5] + varp[n - 4] + varp[n - 3] + varp[n - 2] + varp[n - 1] + varp[n]);
//            player.sendMessage(PrefixExpansion.prefix);
//            player.sendMessage(PrefixExpansion.suffix);
//            System.out.println("------------------------------" + PrefixExpansion.prefix);
//            System.out.println("------------------------------" + PrefixExpansion.suffix);
//        }
//        return false;
//    }
//}