package de.Penguin_Fight.listeners;


import java.awt.Color;
import java.util.Random;

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
		Random random = new Random();
		int farbzahl;
		
		if((channel = event.getGuild().getDefaultChannel()) != null) {
			if(!event.getUser().isBot()) {
				farbzahl = random.nextInt(8);
				EmbedBuilder JoinMessage = new EmbedBuilder();
				JoinMessage.setTitle("Willkommen");
				JoinMessage.addField("Bitte lies dir die Regeln durch und reagiere dort mit :white_check_mark:, damit du auf die übrigen Channel zugreifen kannst!", "", false);
				JoinMessage.setFooter("~Elements-Bot");
				JoinMessage.setThumbnail("https://cdn.discordapp.com/emojis/810909658256506891.png?v=1");
				if(farbzahl == 0) 
					JoinMessage.setColor(Color.BLUE);
				if(farbzahl == 1)
					JoinMessage.setColor(Color.RED);
				if(farbzahl == 2)
					JoinMessage.setColor(Color.CYAN);
				if(farbzahl == 3)
					JoinMessage.setColor(Color.GREEN);
				if(farbzahl == 4)
					JoinMessage.setColor(Color.WHITE);
				if(farbzahl == 5)
					JoinMessage.setColor(Color.MAGENTA);
				if(farbzahl == 6)
					JoinMessage.setColor(Color.ORANGE);
				if(farbzahl == 7)
					JoinMessage.setColor(Color.YELLOW);
				if(farbzahl == 8)
					JoinMessage.setColor(Color.PINK);
				channel.sendMessage(member.getAsMention()).queue();
				channel.sendMessage(JoinMessage.build()).queue();
			}
		}
	}
}
