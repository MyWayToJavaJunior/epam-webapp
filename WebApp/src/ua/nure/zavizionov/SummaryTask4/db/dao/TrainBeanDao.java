package ua.nure.zavizionov.SummaryTask4.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.zavizionov.SummaryTask4.db.bean.TrainBean;

public class TrainBeanDao extends AbstractDao<TrainBean> {

	private static final Logger LOG = Logger.getLogger(TrainBeanDao.class);
	
	public TrainBeanDao(Connection connection) {
		super(connection);
	}

	@Override
	public TrainBean create() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		StringBuffer sb = new StringBuffer();
		sb.append("select trains.id, route_id, depDate, dep_time, ");
		sb.append("arrDate, arr_time, dep_station_name, arr_station_name ");
		sb.append("from trains inner join routes ");
		sb.append("on trains.route_id = routes.id ");
		sb.append("join (select stations.name as dep_station_name ");
		sb.append("from  routes inner join stations ");
		sb.append("on routes.dep_station_id = stations.id) as dep ");
		sb.append("join (select stations.name as arr_station_name ");
		sb.append("from  routes inner join stations ");
		sb.append("on routes.arr_station_id = stations.id) as arr");
		return sb.toString();
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<TrainBean> parseResultSet(ResultSet rs) {
		LOG.debug("Parsing starts");
		List<TrainBean> result = new ArrayList<TrainBean>();
		try {
			while (rs.next()){
				TrainBean bean = new TrainBean();
				bean.setId(rs.getInt(Fields.ID));
				bean.setRouteId(rs.getInt(Fields.TRAIN_ROUTE_ID));
				bean.setDepartureDate(rs.getDate(Fields.TRAIN_DEPARTURE_DATE));
				bean.setDepartureTime(rs.getTime(Fields.ROUTE_DEPARTURE_TIME));
				bean.setArrivalDate(rs.getDate(Fields.TRAIN_ARRIVAL_DATE));
				bean.setArrivalTime(rs.getTime(Fields.ROUTE_ARRIVAL_TIME));
				bean.setDepartureStationName(rs.getString(Fields.TRAIN_BEAN_DEPARTURE_STATION_NAME));
				bean.setArrivalStationName(rs.getString(Fields.TRAIN_BEAN_ARRIVAL_STATION_NAME));
				result.add(bean);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while parsing", e);
		}
		LOG.debug("Parsed.");
		return result;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			TrainBean object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			TrainBean object) {
		// TODO Auto-generated method stub
		
	}
	
	public List<TrainBean> findTrainsByDate(Date startDate, Date endDate) throws SQLException{
		List<TrainBean> list = new ArrayList<TrainBean>();
		String sql = getSelectQuery();
		sql += " WHERE depDate between ? and ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setDate(1, new java.sql.Date(startDate.getTime()));
			statement.setDate(2, new java.sql.Date(endDate.getTime()));
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		}catch (SQLException e){
			throw new SQLException(e);
		}
		return list;
	}
	
}
	
	


