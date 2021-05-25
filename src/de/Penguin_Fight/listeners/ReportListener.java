package de.Penguin_Fight.listeners;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReportListener extends ListenerAdapter{
		
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		String[] args = message.split(" ");
		TextChannel channel1 = event.getTextChannel();

		
		if(args[0].equalsIgnoreCase("$report")) {
					
			if(event.isFromType(ChannelType.TEXT)) {
				
				TextChannel channel2 = event.getGuild().getTextChannelById(819132461337411584l);
				long Author = event.getAuthor().getIdLong();
				List<Permission> allow = new ArrayList<Permission>();
				List<Permission> deny = new ArrayList<Permission>();
				
				allow.add(Permission.VIEW_CHANNEL);
				allow.add(Permission.MESSAGE_WRITE);
				allow.add(Permission.MESSAGE_READ);
				
				if(args.length == 2) {
					String channelNameNew = "Report von " + event.getAuthor().getName() + " an " + args[1];
					event.getGuild().createCopyOfChannel(channel2).setName(channelNameNew).addMemberPermissionOverride(Author, allow, deny).queue();
					channel1.sendMessage("Du hast " + args[1] + " reportet, indem du einen neuen Testchannel erstellt hast, bitte schreibe dort den Chat sowie das Datum, an dem er die Nachricht geschrieben hat rein.").queue();
				}else {
				}
			}
		}
		if(message.equalsIgnoreCase("$report")) {
			channel1.sendMessage("Bitte verwende $report <User>").queue();
		}
	}
}
