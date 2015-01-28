package ua.nure.zavizionov.SummaryTask4.web.command;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.Errors;
import ua.nure.zavizionov.SummaryTask4.Path;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;

public class AddWagonCommand extends Command {
	
	private static final Logger LOG = Logger.getLogger(AddWagonCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String forward = null;
		String errorMessage = null;
		String message = null;
		int errorCode;
		DBService service = DBService.getInstance();
		LOG.debug("Command starts");
		String trainIdString = request.getParameter("trainId");
		String wagonTypeIdString = request.getParameter("wagonTypeId");
		String wagonNumberString = request.getParameter("wagonNumber");
		
		if(trainIdString == null || trainIdString.isEmpty()){
			errorMessage = "Train id is undefined.";
			LOG.error(errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		if(wagonTypeIdString == null || wagonTypeIdString.isEmpty()){
			errorMessage = "Wagon type is not chosen.";
			LOG.error(errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		if(wagonNumberString== null || wagonNumberString.isEmpty()){
			errorMessage = "Wagon number is not chosen.";
			LOG.error(errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}
		
		int trainId = 0;
		int wagonTypeId = 0;
		int wagonNumber = 0;
		try {
			trainId = Integer.parseInt(trainIdString);
			wagonTypeId = Integer.parseInt(wagonTypeIdString);
			wagonNumber = Integer.parseInt(wagonNumberString);
		} catch (Exception e) {
			errorMessage = "Some of inputed values has bad format";
			LOG.error(errorMessage);
			request.setAttribute("errorMessage", errorMessage);
			forward = Path.ERROR_PAGE;
			return forward;
		}



		errorCode = service.addWagon(trainId, wagonTypeId, wagonNumber);

		switch (errorCode) {
		case Errors.ERROR:
			message = "Can't add wagon.";
			break;
		case Errors.SUCCESS:
			message = "Wagon added succesfull";
		}

		LOG.debug("Command finished");
		response.sendRedirect(Path.LIST_TRAIN_WAGONS_COMMAND + "&message=" + message + "&trainId=" + trainId);
		return forward;
	}

}
