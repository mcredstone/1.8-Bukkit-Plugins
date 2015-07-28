package me.piano567123;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomTP extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getLogger().info("Teleporters Active.");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Teleporters Inactive.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("wild") && sender instanceof Player) {
			
			Player player = (Player) sender;
            
            Location originalLocation = player.getLocation();
           
            Random random = new Random();
           
            Location teleportLocation = null;
           
            int x = random.nextInt(100) + 1;
            int y = 150;
            int z = random.nextInt(100) + 1;
           
            boolean isOnLand = false;
           
            while (isOnLand == false) {

                    teleportLocation = new Location(player.getWorld(), x, y, z);
                   
                    if (teleportLocation.getBlock().getType() != Material.AIR) {
                            isOnLand = true;
                    } else y--;
           
            }
           
            player.teleport(new Location(player.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
           
            player.sendMessage(ChatColor.GOLD + "You have been teleported to " + (int) teleportLocation.getX() + " " + (int) teleportLocation.getY() + " " + (int) teleportLocation.getZ() + "!");
           
            return true;				
			}
		
		return false;
	}
}
