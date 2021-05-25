package de.Penguin_Fight.listeners;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GiveawayCompleteListener extends ListenerAdapter{
	
	private static Long memberID;
	private static Long roleID = 820261929359507496L;
	
	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent event) {
		if(event.getMessageIdLong() == 824337266045616189L) {
			memberID = event.getMember().getIdLong();
			event.getGuild().addRoleToMember(memberID, event.getGuild().getRoleById(roleID)).queue();
		}
	}
	
	@Override
	public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
		if(event.getMessageIdLong() == 824337266045616189L) {
			event.getGuild().addRoleToMember(memberID, event.getGuild().getRoleById(roleID)).queue();
			event.getGuild().removeRoleFromMember(memberID, event.getGuild().getRoleById(roleID)).queue();
		}
	}
}
