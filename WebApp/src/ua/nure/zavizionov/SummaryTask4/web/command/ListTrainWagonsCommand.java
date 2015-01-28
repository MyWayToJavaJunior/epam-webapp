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

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.entity.Train;
import ua.nure.zavizionov.SummaryTask4.db.entity.Wagon;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class ListTrainWagonsCommand extends Command{
	
	private static final Logger LOG = Logger.getLogger(ListTrainWagonsCommand.class);
	private static final long serialVersionUID = -7584274176016388863L;
	DBService service = DBService.getInstance();
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String forward = Path.LIST_WAGONS_PAGE;
		String errorMessage = null;
		int trainId = 0;
		List<Wagon> wagons;
		LOG.debug("Command starts");
		try{
			trainId = Integer.parseInt(request.getParameter("trainId"));
		}catch (Exception e){
			errorMessage = "Bad trainId format";
			LOG.error(errorMessage, e);
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
		}
		LOG.debug("Geting beans.");
		wagons = service.findWagonsByTrain(trainId);
		request.setAttribute("wagons", wagons);
		LOG.debug("Command finished");
		return forward;
	}
	
	

}
