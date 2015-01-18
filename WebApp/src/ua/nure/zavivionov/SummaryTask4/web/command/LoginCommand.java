package ua.nure.zavivionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.zavivionov.SummaryTask4.Path;

public class LoginCommand extends Command {

	private static final long serialVersionUID = 6563596502700707329L;
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		LOG.debug("Command starts");
		
		HttpSession session = request.getSession();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		LOG.trace("Get parameter login: " + login);
		
		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			errorMessage = "Login/password cannot be empty";
			request.setAttribute("errorMessage", errorMessage);
			LOG.error("Error occured: " + errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		
		return forward;
		
	}

}
