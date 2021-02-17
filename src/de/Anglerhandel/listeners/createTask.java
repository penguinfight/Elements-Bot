package de.Anglerhandel.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class createTask extends ListenerAdapter{
	
	public static int taskNumber = 1;
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String Message = event.getMessage().getContentRaw();
		String[] args = Message.split(" ");
		
		
		if(args[0].equalsIgnoreCase("$cTask")) {
			if(args.length >= 1) {
				if(event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
					EmbedBuilder cTask = new EmbedBuilder();
					String Aufgabe = args[1];
					String Belohnung = args[2];
					String Personenanzahl = args[3];
			
					cTask.setTitle("Aufgabe #" + taskNumber);
					cTask.addField("Aufgabe: ", Aufgabe, false);
					cTask.addField("Belohnung: ", Belohnung + "$ Citybuild Money", false);
					cTask.addField("Personenanzahl: ", Personenanzahl + " Personen", false);
					cTask.setThumbnail(event.getAuthor().getAvatarUrl());
			
					String Art = args[4];
					if(Art.equalsIgnoreCase("Building")) {
						cTask.setColor(33546);
					}
					if(Art.equalsIgnoreCase("Farming")) {
						cTask.setColor(24999);
					}
			
					Long MessageID = event.getMessageIdLong();
			
					event.getChannel().purgeMessagesById(MessageID);
			
					event.getChannel().sendMessage(cTask.build()).queue();
					taskNumber = taskNumber + 1;
					cTask.clear();
				}
			}
		}
	}
	
	public void GenericMessageReactionEvent(MessageReaction event) {
		
		
		
	}
	
}



