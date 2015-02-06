package ua.nure.zavizionov.SummaryTask4.db.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.RouteDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.TrainDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.entity.RouteComposition;
import ua.nure.zavizionov.SummaryTask4.db.entity.Station;
import ua.nure.zavizionov.SummaryTask4.db.entity.Train;
import junit.framework.TestCase;

public class TrainDaoTest extends TestCase {

	 Connection con = null;
	 private  TrainDao dao = null;
	 DaoFactory factory = DaoFactory.getInstance();
	 Route testRoute = null;
	 Station testStation1 = null;
	 Station testStation2 = null;
	 Train testTrain = null;
	
	{
		con = Init.getConnection();
		dao = factory.getTrainDao(con);
		testRoute = new Route();
		testStation1 = new Station();
		testStation2 = new Station();
		testStation1.setId(1);
		testStation2.setId(2);
		testRoute.setDepartureStation(testStation1);
		testRoute.setArrivalStation(testStation2);
		testRoute.setDepartureTime(new Date(1500000));
		testRoute.setArrivalTime(new Date(1000000));
		testTrain.setRoute(testRoute);
		testTrain.setDepartureDate(new Date(15000000));
		testTrain.setArrivalDate(new Date(15000000));
	}

	@Test
	public void testGetSelectQuery() {
		String query = dao.getSelectQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testGetUpdateQuery() {
		String query = dao.getUpdateQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testGetDeleteQuery() {
		String query = dao.getDeleteQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testGetCreateQuery() {
		String query = dao.getCreateQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testTrainDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseResultSetResultSet() {
		fail("Not yet implemented");
	}


	@Test
	public void testFindTrainsByDate() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddTrain() throws SQLException {
		Train train = dao.persist(testTrain);
		try{
			assertEquals(train.getArrivalDate(), testTrain.getArrivalDate());
			assertEquals(train.getDepartureDate(), testTrain.getDepartureDate());
			assertEquals(train.getRoute().getId(), testTrain.getRoute().getId());
		}finally{
			dao.delete(train);
		}
	}
	
	@Test
	public void testEditTrain() {
		fail("Not yet implemented");
	}
	

}
