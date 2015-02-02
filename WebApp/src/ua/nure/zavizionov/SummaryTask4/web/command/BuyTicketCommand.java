package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.exception.ElementNotFoundException;
import ua.nure.zavizionov.SummaryTask4.db.exception.NoTicketsException;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class BuyTicketCommand extends Command{
	
	private static final Logger LOG = Logger.getLogger(BuyTicketCommand.class);
	private static final long serialVersionUID = 5764383523220075064L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		int messageCode = 0;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String wagonId = request.getParameter("wagonId");
		if(wagonId == null){
			errorMessage = "No wagon selected";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		String fullName = request.getParameter("fullName");
		if(fullName == null){
			errorMessage = "Type full name of passenger";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		
		LOG.trace("Recieved wagon id: " + wagonId + " and passenger name " + fullName);
		try{
			service.buyTicket(Integer.parseInt(wagonId), 1);
		}catch(NumberFormatException e){
			errorMessage = "Bad id format";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			LOG.error(errorMessage, e);
			return forward;
		} catch (ElementNotFoundException e) {
			errorMessage = "No such wagon";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		} catch (NoTicketsException e) {
			errorMessage = "There is no free seats in this wagon";
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		

		
		//TODO Some PDF or just forward to another page with unique ticket info.
		
		LOG.debug("Command finished");
		response.sendRedirect(Path.TICKET_INFO);
		return forward;
	}

}
