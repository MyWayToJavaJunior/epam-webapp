package ua.nure.zavivionov.SummaryTask4.web.command;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class CommandContainer {
	
	private static final Logger LOG = Logger.getLogger(CommandContainer.class);
	
	private static Map<String, Command> commands = new TreeMap<String, Command>();

	
	static{
		commands.put("login", new LoginCommand());
		//TODO
		
	}
	
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			LOG.trace("Command " + commandName + " not found");
			return commands.get("noCommand"); 
		}
		
		return commands.get(commandName);
	}

}
