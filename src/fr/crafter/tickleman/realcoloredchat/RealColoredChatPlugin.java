package fr.crafter.tickleman.realcoloredchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RealColoredChatPlugin extends JavaPlugin implements Listener
{

	//------------------------------------------------------------------------------------- onCommand
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("colset") && sender.isOp()) {
			for (Player player : getServer().getOnlinePlayers()) {
				setPlayerColorAuto(player, sender);
			}
			return true;
		} else {
			return false;
		}
	}

	//------------------------------------------------------------------------------------- onDisable
	@Override
	public void onDisable()
	{
	}

	//-------------------------------------------------------------------------------------- onEnable
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
	}

	// --------------------------------------------------------------------------- onPlayerLoginEvent
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerLoginEvent(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		setPlayerColorAuto(player, null);
	}

	//-------------------------------------------------------------------------------- setPlayerColor
	public boolean setPlayerColor(Player player, String permColor, ChatColor color, CommandSender tell)
	{
		boolean result = false;
		if (
			player.hasPermission("chatcolor." + permColor)
			|| player.hasPermission("color." + permColor)
		) {
			if (tell != null) {
				tell.sendMessage("set " + player.getName() + "'s chat color to " + permColor);
			}
			player.setDisplayName(color + player.getName() + ChatColor.WHITE);
			result = true;
		}
		if (
			player.hasPermission("listcolor." + permColor)
			|| player.hasPermission("color." + permColor)
		) {
			if (tell != null) {
				tell.sendMessage("set " + player.getName() + "'s list color to " + permColor);
			}
			player.setPlayerListName(color + player.getName());
			result = true;
		}
		return result;
	}

	//---------------------------------------------------------------------------- setPlayerColorAuto
	public void setPlayerColorAuto(Player player, CommandSender tell)
	{
		setPlayerColor(player, "red", ChatColor.RED, tell);
		setPlayerColor(player, "blue", ChatColor.BLUE, tell);
		setPlayerColor(player, "gold", ChatColor.GOLD, tell);
		setPlayerColor(player, "aqua", ChatColor.AQUA, tell);
		setPlayerColor(player, "darkaqua", ChatColor.DARK_AQUA, tell);
		setPlayerColor(player, "black", ChatColor.BLACK, tell);
		setPlayerColor(player, "darkblue", ChatColor.DARK_BLUE, tell);
		setPlayerColor(player, "darkgray", ChatColor.DARK_GRAY, tell);
		setPlayerColor(player, "darkred", ChatColor.DARK_RED, tell);
		setPlayerColor(player, "darkgreen", ChatColor.DARK_GREEN, tell);
		setPlayerColor(player, "purple", ChatColor.DARK_PURPLE, tell);
		setPlayerColor(player, "pink", ChatColor.LIGHT_PURPLE, tell);
		setPlayerColor(player, "gray", ChatColor.GRAY, tell);
		setPlayerColor(player, "green", ChatColor.GREEN, tell);
		setPlayerColor(player, "white", ChatColor.WHITE, tell);
		setPlayerColor(player, "yellow", ChatColor.YELLOW, tell);
	}

}
