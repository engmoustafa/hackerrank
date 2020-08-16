package datastructure;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;


public class CastleOnTheGridTest {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
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
		assertEquals(3, result);

	}

}
