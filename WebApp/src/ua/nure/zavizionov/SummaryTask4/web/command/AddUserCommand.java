package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Errors;
import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.Roles;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class AddUserCommand extends Command {
	
	private static final Logger LOG = Logger.getLogger(AddUserCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		String message = null;
		int errorCode;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		
		if(login == null || password == null){
			LOG.trace("No login or password parameter, just opening page");
			forward = Path.REGISTER_PAGE;
			return forward;
		}
		if (password.length()<4) {
			errorMessage = "Password length is less then 4 symbols";
		}
		if (password.isEmpty()) {
			errorMessage = "Password field is empty";
		}
		if (login.isEmpty()) {
			errorMessage = "Login field is empty";
		}
		
		if (errorMessage != null){
			LOG.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}

		errorCode = service.addUser(login, password, email, fullName, Roles.USER.getId());

		switch (errorCode) {
		case Errors.ELEMENT_ALREADY_EXISTS_ERROR:
			errorMessage = "User with such login already exists.";
			break;
		case Errors.SUCCESS:
			message = "Station added succesfull";
		}
		
		if (errorMessage != null){
			LOG.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		
		LOG.debug("Command finished");
		response.sendRedirect(Path.ADD_TRAIN_COMMAND + "&message=" + message);
		return forward;
	}

}
