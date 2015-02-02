package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.client.am.SqlException;
import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class AddTrainCommand extends Command {
	private static final Logger LOG = Logger.getLogger(AddTrainCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		String message = null;
		int errorCode;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String route = request.getParameter("routeId");
		if(route == null){
			LOG.trace("No route paramete, just opening page");
			forward = Path.ADD_TRAIN_PAGE;
			return forward;
		}
		if (route.isEmpty()) {
			errorMessage = "Route is not selected";
			LOG.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		int routeId = 0;
		try {
			routeId = Integer.parseInt(request.getParameter("routeId"));
		} catch (Exception e) {
			errorMessage = "Not proper id";
			LOG.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
		}

		String departureDateString = request.getParameter("departureDate");
		String arrivalDateString = request.getParameter("arrivalDate");
		LOG.debug("Formating date");
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date departureDate = null;
		Date arrivalDate = null;
		if (departureDateString == null || departureDateString.isEmpty()) {
			errorMessage = "Some date is empty.";
			LOG.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}

		try {
			departureDate = format.parse(departureDateString);
			arrivalDate = format.parse(arrivalDateString);
		} catch (ParseException e) {
			LOG.error("Error during parsing date", e);
			errorMessage = "Wrong date format.";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}


		try {
			service.addTrain(routeId, departureDate, arrivalDate);
			message = "Traid added succesfull";
		} catch (SqlException e) {
			message = "Cant put data to DB.";
		}


		LOG.debug("Command finished");
		response.sendRedirect(Path.ADD_TRAIN_COMMAND + "&message=" + message);
		return forward;
	}
}
