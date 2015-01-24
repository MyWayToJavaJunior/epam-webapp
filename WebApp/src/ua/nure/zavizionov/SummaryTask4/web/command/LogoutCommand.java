package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;

public class LogoutCommand extends Command {

	private static final long serialVersionUID = 802868213263939253L;
	
	private static final Logger LOG = Logger.getLogger(LogoutCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		LOG.debug("Command starts.");
		
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		
		LOG.debug("Command finished.");
		return Path.WELCOME_PAGE;
	}

}
