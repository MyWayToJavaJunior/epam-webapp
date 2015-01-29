package ua.nure.zavizionov.SummaryTask4.db.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.RouteDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.UserDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.Role;
import ua.nure.zavizionov.SummaryTask4.db.entity.Route;
import ua.nure.zavizionov.SummaryTask4.db.entity.Station;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;
import junit.framework.TestCase;

public class RouteDaoTests extends TestCase {
	
	static Connection con = null;
	private static RouteDao dao = null;
	static DaoFactory factory = DaoFactory.getInstance();
	static Route testRoute = null;
	static Station testStation1 = null;
	static Station testStation2 = null;
	
	static{
		System.out.println("do");
		con = Init.getConnection();
		dao = factory.getRouteDao(con);
		testRoute = new Route();
		testStation1 = new Station();
		testStation2 = new Station();
		testStation1.setId(1);
		testStation2.setId(2);
		testRoute.setDepartureStation(testStation1);
		testRoute.setArrivalStation(testStation2);
		testRoute.setDepartureTime(new Date(1500000));
		testRoute.setArrivalTime(new Date(1000000));
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
	public void testRouteDao() {
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
	public void testPrepareStatementForInsertPreparedStatementRoute() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareStatementForUpdatePreparedStatementRoute() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRoute() throws SQLException {
		Route route = dao.persist(testRoute);
		assertEquals();
		dao.delete(route);
	}
	
}
