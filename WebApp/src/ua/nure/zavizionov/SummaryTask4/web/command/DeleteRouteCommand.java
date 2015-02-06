package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.client.am.SqlException;
import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.exception.DataIntegrityException;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class DeleteRouteCommand extends Command {

	private static final Logger LOG = Logger
			.getLogger(DeleteRouteCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String routeIdString = request.getParameter("routeId");
		int routeId = 0;
		LOG.debug("Parsing info");
		try {
			routeId = Integer.parseInt(routeIdString);
		} catch (NumberFormatException e) {
			LOG.error("Error during parsing", e);
			errorMessage = "Wrong input data format.";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}

		try {
			service.deleteRoute(routeId);
		} catch (SqlException e) {
			LOG.error("Error occured", e);
			errorMessage = "Error occured while deleting.";
			request.setAttribute("errorMessage", errorMessage);
			return Path.ERROR_PAGE;
		} catch (DataIntegrityException e) {
			LOG.error("Error occured", e);
			errorMessage = e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
			return Path.ERROR_PAGE;
		}

		LOG.debug("Command finished");
		response.sendRedirect(Path.LIST_ROUTES_COMMAND);
		return forward;
	}
}
