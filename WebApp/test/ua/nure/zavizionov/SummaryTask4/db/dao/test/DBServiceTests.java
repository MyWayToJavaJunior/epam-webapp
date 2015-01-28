package ua.nure.zavizionov.SummaryTask4.db.dao.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.nure.zavizionov.SummaryTask4.db.dao.DaoFactory;
import ua.nure.zavizionov.SummaryTask4.db.dao.TrainDao;
import ua.nure.zavizionov.SummaryTask4.db.dao.WagonDao;
import ua.nure.zavizionov.SummaryTask4.db.entity.Wagon;
import ua.nure.zavizionov.SummaryTask4.db.entity.WagonType;
import ua.nure.zavizionov.SummaryTask4.db.util.DBService;
import junit.framework.TestCase;

public class DBServiceTests extends TestCase {
	

	static Connection con = null;
	static DaoFactory factory = DaoFactory.getInstance();
	DBService service = DBService.getInstance();
	
	static{
		con = Init.getConnection();
		
	}
	
	
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("done");
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
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindTrainsByDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRouteComposition() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStation() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRoutes() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRoute() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuyTicket() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWagonsByTrain() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTrain() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddWagon() {
		service.addWagon(3, 1, 4);
	}

}
