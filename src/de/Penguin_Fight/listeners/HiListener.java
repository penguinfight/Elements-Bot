package de.Penguin_Fight.listeners;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HiListener extends ListenerAdapter{
	
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		String Author = event.getAuthor().getName();
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
			
			if(message.equalsIgnoreCase("hi")) {
				channel.sendMessage("Hi " + Author + "! :grinning:").queue();
				return;
			}
			
		}

		
	}


}
