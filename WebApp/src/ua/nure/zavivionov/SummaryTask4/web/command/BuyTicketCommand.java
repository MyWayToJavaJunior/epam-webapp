package ua.nure.zavivionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zavivionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class BuyTicketCommand extends Command{
	
	private static final Logger LOG = Logger.getLogger(BuyTicketCommand.class);
	private static final long serialVersionUID = 5764383523220075064L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		int message = 0;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String wagonId = request.getParameter("wagonId");
		if(wagonId == null){
			forward = Path.ERROR_PAGE;
			return forward;
		}
		
		LOG.trace("Recieved wagon id: " + wagonId);
//		errorMessage = service.addStation(stationName);
		try{
			message = service.buyTicket(Integer.parseInt(wagonId), 1);
		}catch(NumberFormatException e){
			LOG.error("Bad id format", e);
		}
		//TODO
//		request.setAttribute("errorMessage", errorMessage);
		
		LOG.debug("Command finished");
		response.sendRedirect(Path.TICKET_INFO);
		return forward;
	}

}
