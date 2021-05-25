package de.Penguin_Fight.listeners;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SurveyListener extends ListenerAdapter{
	
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		long channelID = event.getChannel().getIdLong();
		long MessageID = event.getMessageIdLong();
		TextChannel channel = event.getTextChannel();
		String Reaction1 = "✅";
		String Reaction2 = "❌"; 
		
		if(channelID == 814414887107035137l) {
			channel.addReactionById(MessageID, Reaction1).complete();
			channel.addReactionById(MessageID, Reaction2).complete();
		}
	}
}
