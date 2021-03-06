package information;

import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckForNull;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public enum PWIServer {
	ETHERBLADE("Etherblade", "PST")
	, TWILIGHT_TEMPLE("Twilight Temple", "PST")
	, DAWNGLORY("Dawnglory", "CET")
	, TIDESWELL("Tideswell", "America/New_York");

	private final String name;
	private final String timezone;
	PWIServer(String name, String timezone) {
		this.name = name;
		this.timezone = timezone;
	}

	public String getName() {
		return name;
	}

	public String getTimezoneString() {
		return timezone;
	}


	/**
	 * Finds a server mentioned in a String.
	 *
	 * @param string The string to analyze.
	 * @return (1) The enum item matching the name or
	 * <br>(2) <b>null</b> if no item matches the name.
	 */
	@CheckForNull
	public static PWIServer getServer(String string) {
		string = string.toLowerCase();
		PWIServer server = null;
		if (string.contains("da"))
			server = DAWNGLORY;
		else if (string.contains("et"))
			server = ETHERBLADE;
		else if (string.contains("tw") || string.contains("tt"))
			server = TWILIGHT_TEMPLE;
		else if (string.contains("ti"))
			server = TIDESWELL;
		return server;
	}


	/**
	 * Finds servers mentioned in a String.
	 *
	 * @param string The string to analyze.
	 * @return The enum items matching the name.
	 */
	@NotNull
	public static List<PWIServer> getServers(String string) {
		string = string.toLowerCase();
		List<PWIServer> pwiServers = new ArrayList<>();
		if (string.contains("da"))
			pwiServers.add(DAWNGLORY);
		if (string.contains("tw") || string.contains("tt"))
			pwiServers.add(TWILIGHT_TEMPLE);
		if (string.contains("et"))
			pwiServers.add(ETHERBLADE);
		if (string.contains("ti"))
			pwiServers.add(TIDESWELL);
		return pwiServers;
	}

	public TimeZone getTimeZone() {
		return TimeZone.getTimeZone(timezone);
	}

	public Calendar getCurrentTime() {
		return Calendar.getInstance(getTimeZone());
	}
}
