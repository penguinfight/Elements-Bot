package de.Penguin_Fight.main;

import javax.security.auth.login.LoginException;

import de.Penguin_Fight.listeners.GiveawayCompleteListener;
import de.Penguin_Fight.listeners.HelpListener;
import de.Penguin_Fight.listeners.HeyListener;
import de.Penguin_Fight.listeners.HiListener;
import de.Penguin_Fight.listeners.InfoListener;
import de.Penguin_Fight.listeners.IwantListener;
import de.Penguin_Fight.listeners.JoinListener;
import de.Penguin_Fight.listeners.MemberCounterListener;
import de.Penguin_Fight.listeners.ReportListener;
import de.Penguin_Fight.listeners.RuleCompleteListener;
import de.Penguin_Fight.listeners.RuleListener;
import de.Penguin_Fight.listeners.SurveyCompleteListener;
import de.Penguin_Fight.listeners.SurveyListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;

public class Anglerhandel {

	public static JDABuilder builder;

	
	public static void main(String[] args) throws LoginException {		
		String token = "ODA0MzUyNDM5MDE2MjI2ODE3.YBLFlQ.5MvXYoIozrqPEv1w5STDLBI0t78";
								
		builder = JDABuilder.createDefault(token);
		
		builder.setCompression(Compression.NONE);
		
		builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
							
		builder.setActivity(Activity.watching("Eclipse"));
		builder.setStatus(OnlineStatus.ONLINE);

		Anglerhandel.registerListeners();
		
		builder.build();
	}
	
	public static void registerListeners() {
		builder.addEventListeners(new HeyListener());
		builder.addEventListeners(new HiListener());
		builder.addEventListeners(new JoinListener());
		builder.addEventListeners(new RuleCompleteListener());
		builder.addEventListeners(new InfoListener());
		builder.addEventListeners(new HelpListener());
		builder.addEventListeners(new RuleListener());
		builder.addEventListeners(new IwantListener());
		builder.addEventListeners(new SurveyListener());
		builder.addEventListeners(new MemberCounterListener());
		builder.addEventListeners(new SurveyCompleteListener());
		builder.addEventListeners(new GiveawayCompleteListener());
		builder.addEventListeners(new ReportListener());
	}
	
}