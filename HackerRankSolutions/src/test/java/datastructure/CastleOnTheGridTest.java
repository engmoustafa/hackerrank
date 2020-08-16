package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CastleOnTheGridTest {

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
	public void test() {
		String[] grid;
		int startX, startY, goalX, goalY;
		//Test1
		grid = new String[]{".X.",".X.","..."};
		startX = 0; startY = 0; goalX = 0; goalY = 2;
		int result = CastleOnTheGrid.minimumMoves(grid, startX, startY, goalX, goalY);
		assertEquals("Result did not match", result, 3);
	}

}
