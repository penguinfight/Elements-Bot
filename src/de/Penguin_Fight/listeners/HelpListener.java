package de.Penguin_Fight.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelpListener extends ListenerAdapter{
		
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
			
			if(message.equalsIgnoreCase("$help")) {
				EmbedBuilder help = new EmbedBuilder();
				help.setColor(33555);
				help.setTitle("Befehle:");
				help.setFooter("~Elements-Bot");
				help.addField("$report <User>", "--> reportet einen Spieler.", false);
				help.addField("$CoWorker", "--> zeigt eine Übersicht über die Aufgabenbereiche von den Co-Workern.", false);
				help.addField("$Iwant", "--> erstellt eine Bestellung. Wichtig dabei ist, dass wir nur Items verkaufen, die wir auch in unserem Shop anbieten. ", false);
				help.addField("$FAQ", "--> zeigt eine Übersicht über häufig gestellte Fragen. ", false);
				help.setDescription("Bitte die Commands nicht spammen, danke!");
				channel.sendMessage(help.build()).queue();
				return;
			}
			
		}

		
	}


}
