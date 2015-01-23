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
		String forward = null;
		String errorMessage = null;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String stationName = request.getParameter("stationName");
		if(stationName == null){
			forward = Path.ADD_STATION_PAGE;
			return forward;
		}
		if(stationName.isEmpty()){
			errorMessage = "Station name is empty.";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		LOG.trace("Recieved station name: " + stationName);
		errorMessage = service.addStation(stationName);
//		request.setAttribute("errorMessage", errorMessage);
		
		LOG.debug("Command finished");
		response.sendRedirect(Path.ADD_STATION_COMMAND);
		return forward;
	}

}
