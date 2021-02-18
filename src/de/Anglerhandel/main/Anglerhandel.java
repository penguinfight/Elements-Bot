package de.Anglerhandel.main;

import javax.security.auth.login.LoginException;

import de.Anglerhandel.listeners.HeyListener;
import de.Anglerhandel.listeners.HiListener;
import de.Anglerhandel.listeners.JoinListener;
import de.Anglerhandel.listeners.RuleComplete;
import de.Anglerhandel.listeners.createTask;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;

public class Anglerhandel {

	public static JDABuilder builder;

	
	public static void main(String[] args) throws LoginException {		
		String token = System.getEnv("TOKEN");
								
		builder = JDABuilder.createDefault(token);
		
		builder.setCompression(Compression.NONE);
		
		builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
							
		builder.setActivity(Activity.watching("Eclipse"));
		builder.setStatus(OnlineStatus.DO_NOT_DISTURB);

		Anglerhandel.registerListeners();
		
		builder.build();
		
	}
	
	public static void registerListeners() {
		builder.addEventListeners(new HeyListener());
		builder.addEventListeners(new createTask());
		builder.addEventListeners(new HiListener());
		builder.addEventListeners(new JoinListener());
		builder.addEventListeners(new RuleComplete());
	}
	
}
