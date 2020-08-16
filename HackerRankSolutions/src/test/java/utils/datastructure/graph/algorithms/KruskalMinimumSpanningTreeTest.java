package utils.datastructure.graph.algorithms;

import static org.junit.Assert.*;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.datastructure.graph.Edge;
import utils.datastructure.graph.UndirectedGraph;

public class KruskalMinimumSpanningTreeTest {


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
	public void testSimpleNodes() {
		UndirectedGraph theGraph = new UndirectedGraph(5);

		//Sample1
		theGraph.addEdge(0, 1, 2);
		theGraph.addEdge(0, 2, 10);
		theGraph.addEdge(0, 3, 1);
		theGraph.addEdge(0, 4, 2);
		theGraph.addEdge(1, 2, 4);
		
		KruskalMinimumSpanningTree algo = new KruskalMinimumSpanningTree(theGraph);
		List<Edge> mst = algo.kruskalMST();
		

		System.out.println(mst.toString());
		IntSummaryStatistics totalCost = mst.stream().collect(Collectors.summarizingInt(p-> {return p.getWeight();}));
		System.out.println("Minimum Cost="+totalCost.getSum());
		assertEquals(totalCost.getSum(), 9);
	}
	
	@Test
	public void testSimpleNodes2() {
		UndirectedGraph theGraph = new UndirectedGraph(5);

		//Sample1
		theGraph.addEdge(0, 1, 1);
		theGraph.addEdge(0, 2, 2);
		theGraph.addEdge(0, 3, 3);
		theGraph.addEdge(0, 4, 4);
		theGraph.addEdge(1, 2, 5);
		theGraph.addEdge(1, 4, 7);
		theGraph.addEdge(2, 3, 6);


		KruskalMinimumSpanningTree algo = new KruskalMinimumSpanningTree(theGraph);
		List<Edge> mst = algo.kruskalMST();
		

		System.out.println(mst.toString());
		IntSummaryStatistics totalCost = mst.stream().collect(Collectors.summarizingInt(p-> {return p.getWeight();}));
		System.out.println("Minimum Cost="+totalCost.getSum());
		assertEquals(totalCost.getSum(), 10);
	}

}
