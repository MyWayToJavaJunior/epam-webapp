package ua.nure.zavivionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zavivionov.SummaryTask4.Path;

public class NoCommand extends Command {

	private static final long serialVersionUID = 3375285018808777255L;

	private static final Logger LOG = Logger.getLogger(NoCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		LOG.debug("Command starts.");
		
		String errorMessage = "No such command";
		request.setAttribute("errorMessage", errorMessage);
		LOG.error("Request attribute errorMessage is " + errorMessage);
		
		LOG.debug("Command finished");
		return Path.ERROR_PAGE;
	}

}
