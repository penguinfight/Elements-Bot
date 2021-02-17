package de.Anglerhandel.listeners;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JoinListener extends ListenerAdapter{
		
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Member member = event.getMember();
		TextChannel channel;
		
		if((channel = event.getGuild().getDefaultChannel()) != null) {
			if(!event.getUser().isBot()) {
				EmbedBuilder JoinMessage = new EmbedBuilder();
				JoinMessage.setTitle("Willkommen");
				JoinMessage.addField("Bitte les dir die Regeln durch und reagiere mit :white_check_mark:!", "created by PenguinBot", false);
				JoinMessage.setThumbnail("https://cdn.discordapp.com/emojis/810909658256506891.png?v=1");
				channel.sendMessage(member.getAsMention()).queue();
				channel.sendMessage(JoinMessage.build()).queue();
			}
		}
	}

}
