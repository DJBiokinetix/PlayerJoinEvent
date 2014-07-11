package me.DJBiokinetix;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Evento extends JavaPlugin implements Listener{

	@Override
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	public void onDisable(){
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		shootFireworks();
		String jugador = e.getPlayer().getName();
		String mensaje = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "Far" + ChatColor.DARK_RED + ChatColor.BOLD + "Fire" + ChatColor.DARK_GRAY + "]" + " " + ChatColor.GREEN + "&NOMBRE" + " " + ChatColor.YELLOW + "ha entrado al servidor";
		mensaje = mensaje.replaceAll("&NOMBRE", jugador);
		e.setJoinMessage(mensaje);
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		String jugador = e.getPlayer().getName();
		String mensaje = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "Far" + ChatColor.DARK_RED + ChatColor.BOLD + "Fire" + ChatColor.DARK_GRAY + "]" + " " + ChatColor.RED + "&NOMBRE" + " " + ChatColor.YELLOW + "ha salido del servidor";
		mensaje = mensaje.replaceAll("&NOMBRE", jugador);
		e.setQuitMessage(mensaje);
	}
                              private void shootFireworks(){
					                		for (Player player : Bukkit.getOnlinePlayers()) {
					                			Firework fw = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
					                			FireworkMeta fm = fw.getFireworkMeta();
					                			Random r = new Random();
					                			int fType = r.nextInt(5) + 1;
					                			Type type = null;
					                			switch (fType) {
					                			case 1:
					                				type = Type.BALL;
					                				break;
					                			case 2:
					                				type = Type.BALL_LARGE;
					                				break;
					                			case 3:
					                				type = Type.BURST;
					                				break;
					                			case 4:
					                				type = Type.CREEPER;
					                				break;
					                			case 5:
					                				type = Type.STAR;
					                				break;
					                			}
					                			Color c11 = getColour(fType);
					                			Color c21 = getColour(fType);
					                			FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c11).withFade(c21).with(type).trail(r.nextBoolean()).build();
					                			fm.addEffect(effect);
					                			int power = r.nextInt(2) + 1;
					                			fm.setPower(power);
					                			fw.setFireworkMeta(fm);
					                		}
					                	}
					                	
					                	public Color getColour(int c){
					                switch (c){
					                case 1:
					                	return Color.AQUA;
					                case 2:
					                	return Color.BLACK;
					                case 3:
					                	return Color.BLUE;
					                case 4:
					                	return Color.FUCHSIA;
					                case 5:
					                	return Color.GRAY;
					                case 6:
					                	return Color.GREEN;
					                case 7:
					                	return Color.LIME;
					                case 8:
					                	return Color.MAROON;
					                case 9:
					                	return Color.NAVY;
					                case 10:
					                	return Color.OLIVE;
					                case 11:
					                	return Color.ORANGE;
					                case 12:
					                	return Color.PURPLE;
					                case 13:
					                	return Color.RED;
					                case 14:
					                	return Color.SILVER;
					                case 15:
					                	return Color.TEAL;
					                case 16:
					                	return Color.WHITE;
					                case 17:
					                	return Color.YELLOW;
					                		}
					                return null;
					                }
}
