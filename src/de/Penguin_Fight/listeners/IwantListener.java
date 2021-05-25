package de.Penguin_Fight.listeners;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class IwantListener extends ListenerAdapter{
		
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel1 = event.getTextChannel();
			String channelNameNew = "Bestellung von " + event.getAuthor().getName();
			TextChannel channel2 = event.getGuild().getTextChannelById(819132461337411584l);
			long Author = event.getAuthor().getIdLong();
			List<Permission> allow = new ArrayList<Permission>();
			List<Permission> deny = new ArrayList<Permission>();
			
			allow.add(Permission.VIEW_CHANNEL);
			allow.add(Permission.MESSAGE_WRITE);
			allow.add(Permission.MESSAGE_READ);
			
			
			if(message.equalsIgnoreCase("$Iwant")) {
				channel1.sendMessage("Du hast einen neuen Textchannel erstellt. Bitte schreibe dein Wunschitem sowie deinen Wunschpreis dort rein!").queue();
				event.getGuild().createCopyOfChannel(channel2).setName(channelNameNew).addMemberPermissionOverride(Author, allow, deny).queue();
			}
		}
	}
}
