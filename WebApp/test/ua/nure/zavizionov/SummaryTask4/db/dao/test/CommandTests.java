package ua.nure.zavizionov.SummaryTask4.db.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.nure.zavizionov.SummaryTask4.web.command.CommandContainer;

public class CommandTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddWagonCommand() {
		CommandContainer.get("addWagon");
		
	}

}
