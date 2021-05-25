package de.Penguin_Fight.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RuleListener extends ListenerAdapter{
		
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
			
			if(event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
			
				if(message.equalsIgnoreCase("$rules")) {
					EmbedBuilder Rule = new EmbedBuilder();
					Rule.setColor(33555);
					Rule.setTitle("DISCORD-REGELN:");
					Rule.setFooter("~Elements-Bot");
					Rule.setDescription("Bitte lest euch diese Regeln durch, da diese für alle Mitglieder dieses Discords verpflichtend sind.\n" + 
							"\n" + 
							"**§1.1** Wir erteilen Strafen in angemessener Härte\n" + 
							"**§1.2** Unwissenheit schützt in keinem Fall vor Strafe\n" + 
							"**§1.3** Das Team darf Strafen in Form von Bans, Mutes oder Kicks erteilen und muss sich vor der betreffenden Person nicht rechtfertigen\n" + 
							"\n" + 
							"**§2.1** Die folgenden aufgezählten Sachen gelten für Profilbilder, Nachrichten, Namen, Links und Anhänge\n" + 
							"   -Diskriminierung in allen möglichen Varianten ist strengstens verboten\n" + 
							"   -Rassismus, Sexismus sowie Beleidigungen sind strengstens verboten\n" + 
							"   -jegliche Arten von Pornografie sowie NSFW sind strengstens verboten\n" + 
							"\n" + 
							"**§3.1** Spam ist serverweit verboten. Dazu zählen:\n" + 
							"   -das mehrfache senden einer Nachricht\n" + 
							"   -das mehrfache Verlassen und Betreten dieses Discordes innerhalb kürzester Zeit\n" + 
							"   -das mehrfache Betreten und Verlassen von Sprachchanneln\n" + 
							"**§3.2** Das Pingen von Teammitgliedern ohne Grund ist verboten\n" + 
							"**§3.3** Der Kanal #💩⎪spam  ist für Bot-Commands sowie off-Topic da. Dieser Kanal wird normalerweise nicht moderiert. Wenn es zu Regelverstößen in diesem Kanal kommt, bitte einem User mit der Rolle: \"Kundensupport\" oder einem Manager bescheid geben\n" + 
							"**§3.4** Das Pingen von Teammitgliedern und das sofortige Löschen der Nachricht danach ist verboten. (Ghostpingen)\n" + 
							"**§3.5** Links zu anderen Discord-Servern sind verboten\n" + 
							"**§3.6** Solange Diskussionen sachlich bleiben, sind diese erlaubt\n" + 
							"\n" + 
							"**§4.1** Bot-Commands werden bitte ausschließend in dem Kanal: #💩⎪spam geschrieben.");
					channel.sendMessage(Rule.build()).queue();
					return;
				}
			}
		}
	}
}
