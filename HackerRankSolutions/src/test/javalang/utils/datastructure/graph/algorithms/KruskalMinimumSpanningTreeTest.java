package javalang.utils.datastructure.graph.algorithms;


import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javalang.utils.datastructure.graph.Edge;
import javalang.utils.datastructure.graph.UndirectedGraph;

public class KruskalMinimumSpanningTreeTest {


	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@BeforeEach
	public void tearDown() throws Exception {
		
	}

	@BeforeEach
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
	
	@BeforeEach
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
