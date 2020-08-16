package utils.datastructure.graph.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;

import utils.datastructure.graph.Edge;
import utils.datastructure.graph.UndirectedGraph;

/**
 * This algorithm is to find the minimum weighted Edges needed to keep the graph fully connected
Kruskal’s Algorithm
Kruskal’s Algorithm builds the spanning tree by adding edges one by one into a growing spanning tree. Kruskal's algorithm follows greedy approach as in each iteration it finds an edge which has least weight and add it to the growing spanning tree.

Algorithm Steps:

Sort the graph edges with respect to their weights.
Start adding edges to the MST from the edge with the smallest weight until the edge of the largest weight.
Only add edges which doesn't form a cycle , edges which connect only disconnected components.
So now the question is how to check if  vertices are connected or not ?

This could be done using DFS which starts from the first vertex, then check if the second vertex is visited or not. But DFS will make time complexity large as it has an order of  where  is the number of vertices,  is the number of edges. So the best solution is "Disjoint Sets": 
Disjoint sets are sets whose intersection is the empty set so it means that they don't have any element in common
 * @author moustafaessa1
 *
 */
public class KruskalMinimumSpanningTree {
	UndirectedGraph theGraph;
	
    public KruskalMinimumSpanningTree(UndirectedGraph theGraph) {
		super();
		this.theGraph = theGraph;
	}

	public List<Edge> kruskalMST(){
    	//Step 1: Sort Edges by Weight O(E Log E)
    	List<Edge> sortedList = new ArrayList(theGraph.getGraphEdges().values());
    	Collections.sort(sortedList, Comparator.comparingInt(o -> ((Edge)o).getWeight()));
    	List<Edge> minimumEdges = new ArrayList();
    	
    	List<Set<Integer>> disjointSets =  new ArrayList();
    			
    	//Step2: start adding edges while monitoring the disjoint sets. If ended up with one set that contains all nodes, then the minimum is reached
    	Set<Integer> sourceSet=null,destinationSet=null;
    	//O(E * N ) >Can be optimized to O(E Log N).. 
    	//Worst case keep adding to the same Set. 1 Set N nodes to search. Can be optimized to have a hashmap each node refers to which set
    	for(Edge e: sortedList) {
    		//Search for Source Point Set
    		sourceSet = findSetThatContainsNode(e.getSource(),disjointSets);
    		//Search for Destination Point set
    		destinationSet = findSetThatContainsNode(e.getDestination(),disjointSets);
    		
    		//If both are there, then
    		if(sourceSet !=null && destinationSet !=null) {
    			if(sourceSet == destinationSet) {
        			//If both belong to the same set then ignore this edge and pick the next
    				continue;
    			}else{
    				//Add the edge
    				minimumEdges.add(e);
    				
    				//Merge the 2 sets (Move destinationSet to sourceSet as both are now connected
    				sourceSet.addAll(destinationSet);
    				
    				//Remove the destination set from the list
    				disjointSets.remove(destinationSet);
    			}
    		}else if(sourceSet ==null && destinationSet ==null) {
    			//If both nodes does not belong to any exiting set, Create new Set
    			sourceSet = new HashSet();
    			sourceSet.add(e.getSource());
    			sourceSet.add(e.getDestination());
    			
    			//Add the newly created sets
    			disjointSets.add(sourceSet);
    			
    			//Add the edge to the minimum
				minimumEdges.add(e);
    		}else {
    			//One node exists and the other don't, then add the missing node to the exiting set
    			if(sourceSet !=null) {
    				sourceSet.add(e.getDestination());
    			}
    			if(destinationSet !=null) {
    				destinationSet.add(e.getSource());
    				sourceSet= destinationSet;
    			}
    			
				minimumEdges.add(e);
    		}
    		//In all cases we keep sourceSet reference to refer to the Set the contains both nodes of the added edge
    		if(sourceSet.size() == theGraph.getNodesCount()) {
    			//IF the set contains all nodes, then all required edges to keep the graph connected has been collected
    			break;
    		}
    		
    	}
    	return minimumEdges;
    }
    
    private Set<Integer> findSetThatContainsNode(Integer nodeId,List<Set<Integer>> disjointSets){
    	for(Set<Integer> searchSet:disjointSets) {
    		if(searchSet.contains(nodeId)) {
    			return searchSet;
    		}
    	}
    	return null;
    }
    
    private boolean findNodeIntoSet(Integer nodeId, Set<Integer> targetSet) {
    	return targetSet.contains(nodeId);
    }
}
