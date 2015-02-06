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

public class EditTrainCommand extends Command {
	
	private static final Logger LOG = Logger.getLogger(EditTrainCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		String message = null;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String trainIdString = request.getParameter("trainId");
		String departureDateString = request.getParameter("departureDate");
		String arrivalDateString = request.getParameter("arrivalDate");
		String routeIdString = request.getParameter("routeId");
		int routeId = 0;
		int trainId = 0;
		if(routeIdString == null || departureDateString == null ||
				arrivalDateString == null){
			LOG.trace("No parameters, just opening page");
			forward = Path.EDIT_TRAIN_PAGE;
			return forward;
		}

		LOG.debug("Parsing data");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date departureDate = null;
		Date arrivalDate = null;
		if (departureDateString == null || departureDateString.isEmpty()) {
			errorMessage = "Some inputed data is wrong";
			LOG.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		try {
			departureDate = format.parse(departureDateString);
			arrivalDate = format.parse(arrivalDateString);
			routeId = Integer.parseInt(routeIdString);
			trainId = Integer.parseInt(trainIdString);
		} catch (ParseException e) {
			LOG.error("Error during parsing date", e);
			errorMessage = "Wrong date format.";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		
		try {
			service.editTrain(trainId, routeId, departureDate, arrivalDate);
		} catch (SqlException e) {
			message = "Cant put data to DB.";
		}


		LOG.debug("Command finished");
		response.sendRedirect(Path.LIST_TRAINS_COMMAND);
		return forward;
	}

}
