package information.ownerconfiguration;

import events.MessageReceivedEvent;
import information.Bot;
import net.dv8tion.jda.api.entities.Guild;

public class Guilds {
	public static long mainGuildId;

	private Guilds() {}

	public static boolean isMainGuild(MessageReceivedEvent event) {
		return isMainGuild(event.getGuild());
	}

	public static boolean isMainGuild(Guild guild) {
		return isMainGuild(guild.getIdLong());
	}

	public static boolean isMainGuild(long guildId) {
		return guildId == mainGuildId;
	}

	public static Guild getMainGuild() {
		return Bot.getJdaInstance().getGuildById(mainGuildId);
	}
}
