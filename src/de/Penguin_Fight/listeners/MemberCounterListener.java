package de.Penguin_Fight.listeners;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberCounterListener extends ListenerAdapter{
	
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		int Member = event.getGuild().getMemberCount();
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
			
			if(message.equalsIgnoreCase("$Member")) {
				Member = Member - 3;
				channel.sendMessage("Momentan sind **" + Member + "** User auf dem Server!").queue();
				return;
			}
			
		}

		
	}


}
