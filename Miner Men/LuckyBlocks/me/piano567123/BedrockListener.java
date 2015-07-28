package me.piano567123;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BedrockListener implements Listener {
	
	public BedrockListener(LuckyBlocks plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEvent(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		
		if (event.getBlockPlaced() == new ItemStack(Material.BEDROCK)) {
			if (!player.hasPermission("generalPermissions.placeBedrock")) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "Sorry, you cannot place bedrock here. " + ChatColor.AQUA + "Maybe if you really wanted to you could do /lucky open?");
			}
		}
	}
	
}
