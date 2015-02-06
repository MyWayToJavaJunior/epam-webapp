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

public class AddRouteCompositionCommand extends Command {
	
	private static final Logger LOG = Logger.getLogger(AddRouteCompositionCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String routeIdString = request.getParameter("routeId");
		String stationIdString = request.getParameter("stationId");
		String departureTimeString = request.getParameter("departureTime");
		String arrivalTimeString = request.getParameter("arrivalTime");
		String stayString = request.getParameter("stay");
		int routeId = 0;
		
		if (stationIdString == null || departureTimeString == null ||
				 arrivalTimeString == null || stayString == null){
			return Path.LIST_ROUTE_INFO_PAGE;
		}
		
		LOG.debug("Parsing info");
		
		DateFormat format = new SimpleDateFormat("HH:mm");
		Date departureTime = null;
		Date arrivalTime = null;
		int stationId = 0;
		int stay = 0;
		
		try {
			departureTime = format.parse(departureTimeString);
			arrivalTime = format.parse(arrivalTimeString);
			stationId = Integer.parseInt(stationIdString);
			stay = Integer.parseInt(stayString);
			routeId = Integer.parseInt(routeIdString);
		} catch (ParseException e) {
			LOG.error("Error during parsing", e);
			errorMessage = "Wrong input data format.";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}

		try {
			service.addRouteComposition(routeId, stationId, arrivalTime, departureTime, stay);
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
