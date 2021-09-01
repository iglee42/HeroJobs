package fr.iglee42.herojobs.utils;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class Title{
    @Deprecated
    public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message)
    {
        sendTitle(player, fadeIn, stay, fadeOut, message, null);
    }

    @Deprecated
    public static void sendSubtitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message) {
        sendTitle(player, fadeIn, stay, fadeOut, null, message);
    }

    @Deprecated
    public static void sendFullTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
        sendTitle(player, fadeIn, stay, fadeOut, title, subtitle);
    }

    public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
        net.minecraft.server.v1_12_R1.PlayerConnection connection = ((org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer) player).getHandle().playerConnection;

        net.minecraft.server.v1_12_R1.PacketPlayOutTitle packetPlayOutTimes = new net.minecraft.server.v1_12_R1.PacketPlayOutTitle(net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut);
        connection.sendPacket(packetPlayOutTimes);

        if (subtitle != null) {
            subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
            subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
            net.minecraft.server.v1_12_R1.IChatBaseComponent titleSub = net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
            net.minecraft.server.v1_12_R1.PacketPlayOutTitle packetPlayOutSubTitle = new net.minecraft.server.v1_12_R1.PacketPlayOutTitle(net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
            connection.sendPacket(packetPlayOutSubTitle);
        }

        if (title != null) {
            title = title.replaceAll("%player%", player.getDisplayName());
            title = ChatColor.translateAlternateColorCodes('&', title);
            IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
            PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
            connection.sendPacket(packetPlayOutTitle);
        }
    }


    boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

