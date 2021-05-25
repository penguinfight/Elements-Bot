package de.Penguin_Fight.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InfoListener extends ListenerAdapter{
		
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String message = event.getMessage().getContentDisplay();
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
			
			if(event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				
				if(message.equalsIgnoreCase("$CoWorker") || message.equalsIgnoreCase("$Co-Worker")) {
					EmbedBuilder CoWorkers = new EmbedBuilder();
					CoWorkers.setColor(33555);
					CoWorkers.setTitle("Aufgabenverteilung:");
					CoWorkers.setFooter("~Elements-Bot");
					CoWorkers.addField("Kundensupport", "Diese Rolle bekommen vertrauenswürdige Mitarbeiter, welche dazu bereit sind, den Discord ehrenamtlich zu moderieren und Spielern zu helfen.", false);
					CoWorkers.addField("Materialbeschaffung", "Wenn du gerne in der Farmwelt farmst oder noch sehr viele überschüssige Items hast, kannst du dich gerne bei uns als Co-Worker für Materialbeschaffung bewerben. Sobald du angenommen wurdest, teilen wir dir weitere Infos mit. ", false);
					CoWorkers.addField("Events", "Du kennst dich sehr gut mit Minecraft aus oder hast kreative Ideen für Events? Dann kannst du dich gerne bei uns als Co-Worker für Events bewerben. Weitere Infos bekommst du von uns, wenn deine Bewerbung angenommen wurde.", false);
					CoWorkers.addField("Logistik", "Wenn du bereit bist, Zeit in unseren Shop zu legen und vor allem beim Bauen, aber auch beim Farmen zu helfen, dann kannst du dich gerne bei uns als Co-Worker für Logistik bewerben. Du bekommst im Falle einer angenommenen Bewerbung weitere Infos von uns über Discord.", false);
					channel.sendMessage("Hey, wenn du bei unserem Shop mitarbeiten willst, kannst du zwischen mehreren verschiedenen Co-Worker-Rollen entscheiden.").queue();
					channel.sendMessage(CoWorkers.build()).queue();
					return;
				}
			}
			
			if(message.equalsIgnoreCase("$faq")) {
				EmbedBuilder faq = new EmbedBuilder();
				faq.setColor(33555);
				faq.setTitle("Häufig gestellte Fragen:");
				faq.setFooter("~Elements-Bot");
				faq.addField("Wo kann ich Bestellungen erstellen?", "Um Bestellungen zu erstellen, verwende bitte $Iwant. Dadurch wird ein neuer Textchannel erstellt. Dort solltest du dein Wunschitem reinschreiben sowie deinen Wunschpreis. Beachte, dass wir nur Items verkaufen, die es auch regulär in unserem Shop gibt.", false);
				faq.addField("Wie werde ich Co-Worker?", "Um Infos zu den Co-Workern zu bekommen, geh bitte in den Channel: #Co-Worker-werden", false);
				faq.addField("Wo kann ich Feedback hinterlassen?", "Gebe uns bitte in den Channels: Vorschläge-Discord und Vorschläge-Shop Feedback. Wir nehmen auch gerne konstruktive Kritik an.", false);
				faq.addField("Wo kann ich Spieler melden?", "Bitte verwende dafür $report <User>", false);
				channel.sendMessage(faq.build()).queue();
				return;
			}
		}
	}
}
