package me.piano567123;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class LuckyBlocks extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Finding possibilities.");
		new BedrockListener(this);
		Permission bedrockPermission = new Permission("generalAbilities.placeBedrock");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("All data confirmed.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("lucky") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (args[1] == null) {
				player.sendMessage(ChatColor.YELLOW + "Lucky Blocks 1.0 Help:");
				player.sendMessage(ChatColor.GREEN + "/lucky open: " + ChatColor.BLUE + "Opens a lucky block if you have one.");
				player.sendMessage(ChatColor.GREEN + "/lucky craft: " + ChatColor.BLUE + "Crafts a lucky block if you have a diamond block in your hand.");
				player.sendMessage(" ");
				player.sendMessage(ChatColor.YELLOW + "piano567123 (Owner of Miner Men) Coded this plugin.");
				player.sendMessage(ChatColor.YELLOW + "Credit to the person who made the Lucky Block mod for the idea.");
				player.sendMessage(ChatColor.YELLOW + "This is another of my custom plugins for Miner Men.");
			}
			
			if (args[1].equalsIgnoreCase("craft")) {
				
				if (player.getItemInHand() == new ItemStack(Material.DIAMOND_BLOCK)) {
					player.setItemInHand(new ItemStack(Material.BEDROCK));
					player.sendMessage(ChatColor.AQUA + "Your lucky block has been created. Thank you.");
				}
				
			}
			
			return true;
			
		}
		
		return false;
	}
}
