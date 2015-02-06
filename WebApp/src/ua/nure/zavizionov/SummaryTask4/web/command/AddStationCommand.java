package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.exception.ElementAlreadyExistsException;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class AddStationCommand extends Command {
	private static final Logger LOG = Logger.getLogger(AddStationCommand.class);

	private static final long serialVersionUID = 2385685594225780462L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String message = null;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String stationName = request.getParameter("stationName");
		if(stationName == null){
			LOG.debug("No station yet. Forwardind to jsp");
			forward = Path.ADD_STATION_PAGE;
			return forward;
		}
		if(stationName.isEmpty()){
			message = "Station name is empty";
		}else{
			LOG.trace("Recieved station name: " + stationName);
			try {
				service.addStation(stationName);
				message = "Station added succesfull";
			} catch (ElementAlreadyExistsException e) {
				message = "Station already exists";
			}
			
		}
		LOG.debug("Command finished");
		response.sendRedirect(Path.ADD_STATION_COMMAND+"&message="+message);
		return forward;
	}

}
