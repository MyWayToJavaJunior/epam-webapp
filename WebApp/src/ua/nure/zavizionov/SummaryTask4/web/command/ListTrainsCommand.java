package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.entity.Train;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

import org.apache.log4j.Logger;

public class ListTrainsCommand extends Command {

	private static final long serialVersionUID = 1372362248881279231L;
	private static final Logger LOG = Logger.getLogger(ListTrainsCommand.class);
	DBService service = DBService.getInstance();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = null;
		String errorMessage = null;
		List<Train> trainList;
		LOG.debug("Command starts");
		String startDateString = request.getParameter("startDate");
		String endDateString = request.getParameter("endDate");
		LOG.trace("Recieved start date " + startDateString + " and end date " + endDateString);
		
		LOG.debug("Formating date");
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date startDate = null;
		Date endDate = null;
		if(startDateString == null || startDateString.isEmpty()){
			LOG.trace("Date is empty, show trains for week");
			startDate = new Date();
			endDate = new Date(System.currentTimeMillis()+604800016);
		}else{
			try {
				startDate = format.parse(startDateString);
				endDate = format.parse(endDateString);
			} catch (ParseException e) {
				LOG.error("Error during parsing date", e);
				errorMessage = "Wrong date format.";
				request.setAttribute("errorMessage", errorMessage);
				forward = Path.ERROR_PAGE;
				return forward;
			}
		}
		
		LOG.debug("Geting beans.");
		trainList = service.findTrainsByDate(startDate, endDate);
		
		request.setAttribute("trainList", trainList);
		
		LOG.debug("Command finished");
		forward = Path.LIST_TRAINS_PAGE;
		return forward;
	}

}
