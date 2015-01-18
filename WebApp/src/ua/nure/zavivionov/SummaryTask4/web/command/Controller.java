package ua.nure.zavivionov.SummaryTask4.web.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * Servlet implementation class Controller
 */
@WebServlet({ "/Controller", "/controller" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOG = Logger.getLogger(Controller.class);
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		LOG.debug("Controller starts");
		
		String commandName = request.getParameter("command");
		LOG.trace("Request parameter command is " + commandName);
		
		Command command = CommandContainer.get(commandName);
		LOG.trace("Command " + command + "obtained");
		
		String forward = command.execute(request, response);
		LOG.trace("Forward address obtained: " + forward);
		
		LOG.debug("Controller finished work.");
		
		if(forward != null){
			RequestDispatcher rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}

		
	}

}
