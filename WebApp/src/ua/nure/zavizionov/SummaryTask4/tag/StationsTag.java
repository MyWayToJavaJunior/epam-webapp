package ua.nure.zavizionov.SummaryTask4.tag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.StationDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.Station;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class StationsTag extends SimpleTagSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void doTag() throws JspException, IOException {
		DaoFactory factory = DaoFactory.getInstance();
		List<Station> stations = null;
		
		try {
			StationDao dao = factory.getStationDao(factory.getConnection());
			stations = dao.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JspWriter out = getJspContext().getOut();
		out.println("<select name = " + name + " >");
		for(Station s : stations){
			out.println("<option value = '" + s.getId()
					+ "'>" + s.getName() + "</option>");
		}
		out.println("</select>");
		
	}

}
