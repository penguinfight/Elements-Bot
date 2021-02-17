package de.Anglerhandel.listeners;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RuleComplete extends ListenerAdapter{
	
	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent event) {
		if(!event.getUser().isBot()) {
			if(event.getChannel().getIdLong() == 810594899505315850l) {
				if(event.getReactionEmote().isEmoji()) {
					Long MemberID = event.getMember().getIdLong();
					Long RoleID = 810587246612054016l;
					event.getGuild().addRoleToMember(MemberID, event.getGuild().getRoleById(RoleID)).queue();
				}
			}
		}
	}
}
