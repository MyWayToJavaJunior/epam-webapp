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
import ua.nure.zavizionov.SummaryTask4.db.entity.Train;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class AddStationCommand extends Command {
	private static final Logger LOG = Logger.getLogger(AddStationCommand.class);

	private static final long serialVersionUID = 2385685594225780462L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = "addStation";
		String message = null;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String stationName = request.getParameter("stationName");
		if(stationName.isEmpty()){
			message = "Station name is empty.";
		}
		LOG.trace("Recieved station name: " + stationName);
		request.setAttribute("message", message);
		
		LOG.debug("Command finished");
		forward = Path.LIST_TRAINS_PAGE;
		return forward;
	}

}
