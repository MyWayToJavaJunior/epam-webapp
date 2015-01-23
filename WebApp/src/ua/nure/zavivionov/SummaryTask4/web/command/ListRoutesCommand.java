package ua.nure.zavivionov.SummaryTask4.web.command;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zavivionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class ListRoutesCommand extends Command{

	private static final long serialVersionUID = -5161024839921415206L;
	private static final Logger LOG = Logger.getLogger(ListRoutesCommand.class);
	DBService service = DBService.getInstance();
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		List<Route> routesList;
		LOG.debug("Command starts");
		//TODO
		LOG.trace("No filters, listing all routes");
		
		LOG.debug("Geting beans.");
		routesList = service.findRoutes();
		
		request.setAttribute("routesList", routesList);
		
		LOG.debug("Command finished");
		forward = Path.LIST_ROUTES_PAGE;
		return forward;
	}
	
	

}
