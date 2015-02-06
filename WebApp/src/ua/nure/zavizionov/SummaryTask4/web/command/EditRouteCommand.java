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
import ua.nure.zavizionov.SummaryTask4.db.Roles;
import ua.nure.zavizionov.SummaryTask4.db.exception.ElementAlreadyExistsException;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class EditRouteCommand extends Command {
	
	private static final Logger LOG = Logger.getLogger(EditRouteCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		int errorCode;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String routeIdString = request.getParameter("routeId");
		String departureStationIdString = request.getParameter("departureStationId");
		String departureTimeString = request.getParameter("departureTime");
		String arrivalStationIdString = request.getParameter("arrivalStationId");
		String arrivalTimeString = request.getParameter("arrivalTime");
		
		if (departureStationIdString == null || departureTimeString == null ||
				arrivalStationIdString == null || arrivalTimeString == null){
			return Path.EDIT_ROUTE_PAGE;
		}
		
		LOG.debug("Parsing info");
		
		DateFormat format = new SimpleDateFormat("HH:mm");
		Date departureTime = null;
		Date arrivalTime = null;
		int routeId = 0;
		int departureStationId = 0;
		int arrivalStationId = 0;
		
		try {
			departureTime = format.parse(departureTimeString);
			arrivalTime = format.parse(arrivalTimeString);
			routeId = Integer.parseInt(routeIdString);
			departureStationId = Integer.parseInt(departureStationIdString);
			arrivalStationId = Integer.parseInt(arrivalStationIdString);
		} catch (ParseException e) {
			LOG.error("Error during parsing", e);
			errorMessage = "Wrong input data format.";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}

		try {
			service.editRoute(routeId, departureStationId, departureTime, arrivalStationId, arrivalTime);
		}catch(SqlException e){
			LOG.error("Error occured", e);
			errorMessage = "Error occured while updating.";
			request.setAttribute("errorMessage", errorMessage);
			return Path.ERROR_PAGE;
		}

		
		LOG.debug("Command finished");
		response.sendRedirect(Path.LIST_ROUTE_COMMAND + "&routeId=" + routeId);
		return forward;
	}

}
