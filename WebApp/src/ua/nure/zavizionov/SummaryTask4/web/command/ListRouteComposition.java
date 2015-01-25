package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class ListRouteComposition extends Command{
	
	private static final long serialVersionUID = -4930196585000252508L;
	private static final Logger LOG = Logger.getLogger(ListRoutesCommand.class);
	DBService service = DBService.getInstance();
			
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String forward = null;
		String errorMessage = null;
		int routeId = 0;
		Route route;
		LOG.debug("Command starts");

		routeId = Integer.parseInt(request.getParameter("routeId"));
		LOG.debug("Geting bean.");
		route = service.findRoute(routeId);
		request.setAttribute("route", route);
		LOG.debug("Command finished");
		forward = Path.LIST_ROUTE_INFO;
		return forward;
		
	}
	

}
