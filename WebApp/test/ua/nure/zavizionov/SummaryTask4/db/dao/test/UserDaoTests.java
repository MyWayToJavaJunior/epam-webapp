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
import ua.nure.zavizionov.SummaryTask4.db.entity.Role;
import ua.nure.zavizionov.SummaryTask4.db.entity.User;
import junit.framework.TestCase;

public class UserDaoTests extends TestCase {
	static Role testRole = null;
	static User testUser = null;
	static Connection con = null;
	private static UserDao dao = null;
	static DaoFactory factory = DaoFactory.getInstance();
	
	static{
		System.out.println("do");
		con = Init.getConnection();
		dao = factory.getUserDao(con);
		testUser = new User();
		testUser.setLogin("test_user");
		testUser.setPassword("pass");
		testUser.setEmail("user@email.com");
		testUser.setFullName("Test User");
		testRole = new Role();
		testRole.setId(12);
		testRole.setName("test_role");
		testUser.setRole(testRole);
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
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
		String query = dao.getSelectQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testGetDeleteQuery() {
		String query = dao.getSelectQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testGetCreateQuery() {
		String query = dao.getSelectQuery();
		assertNotNull(query);
		assertFalse(query.isEmpty());
	}

	@Test
	public void testUserDao() {
		UserDao testDao = new UserDao(Init.getConnection());
		assertNotNull(testDao);
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
	public void testPrepareStatementForInsertPreparedStatementUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareStatementForUpdatePreparedStatementUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByLogin() throws SQLException{
		
		dao.persist(testUser);
		User user = null;
		try {
			user = dao.getByLogin(testUser.getLogin());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(user.getLogin(), testUser.getLogin());
		dao.delete(user);
		
	}

}
