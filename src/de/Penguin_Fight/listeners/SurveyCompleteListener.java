package de.Penguin_Fight.listeners;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SurveyCompleteListener extends ListenerAdapter{
	
	private static Long memberID;
	private static Long roleID = 820258669182713877L;
	
	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent event) {
		if(event.getMessageIdLong() == 820258031655976961L) {
			memberID = event.getMember().getIdLong();
			event.getGuild().addRoleToMember(memberID, event.getGuild().getRoleById(roleID)).queue();
		}
	}
	
	@Override
	public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
		if(event.getMessageIdLong() == 820258031655976961L) {
			event.getGuild().addRoleToMember(memberID, event.getGuild().getRoleById(roleID)).queue();
			event.getGuild().removeRoleFromMember(memberID, event.getGuild().getRoleById(roleID)).queue();
		}
	}
}
