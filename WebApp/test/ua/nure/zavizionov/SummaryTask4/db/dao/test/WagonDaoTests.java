package ua.nure.zavizionov.SummaryTask4.db.dao.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.UserDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.WagonDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.Role;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;
import ua.nure.zavizionov.SummaryTask4.db.entity.Wagon;
import ua.nure.zavizionov.SummaryTask4.db.entity.WagonType;
import junit.framework.TestCase;

public class WagonDaoTests extends TestCase {
	
	static WagonType testWagonType = null;
	static Wagon testWagon = null;
	static Connection con = null;
	static WagonDao dao = null;
	static DaoFactory factory = DaoFactory.getInstance();
	
	static{
		
		con = Init.getConnection();
		dao = factory.getWagonDao(con);
		testWagon = new Wagon();
		testWagon.setNumber(999);
		testWagon.setSeats(20);
		testWagon.setTrainId(3);
		testWagonType = new WagonType();
		testWagonType.setId(1);
		testWagonType.setSeats(120);
		testWagonType.setTypeName("test_type");
		testWagon.setType(testWagonType);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
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
	public void testWagonDao() {
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
	public void testPrepareStatementForInsertPreparedStatementWagon() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareStatementForUpdatePreparedStatementWagon() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWagonsByTrain() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddWagon() throws SQLException {
		Wagon wagon = null;
		try {
			wagon = dao.persist(testWagon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(wagon);
		assertEquals(wagon.getSeats(), testWagon.getSeats());
		assertEquals(wagon.getTrainId(), testWagon.getTrainId());
		assertEquals(wagon.getType().getId(), testWagon.getType().getId());
		assertEquals(wagon.getNumber(), testWagon.getNumber());
		dao.delete(wagon);
	}
	
	

}
