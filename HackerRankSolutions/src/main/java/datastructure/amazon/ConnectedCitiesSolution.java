package datastructure.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Graph{
    int numberOfNodes = 0;
    List<Edge> graphEdges;
    
    public Graph(int nodesCount){
        this.numberOfNodes = nodesCount;
    }
    
    public void addNewEdge(int src, int destination, int cost){
        Edge e = new Edge(src,destination,cost);
        graphEdges.add(e);
    }
    
    public void minimumSpanTree(){
    	PriorityQueue<Edge> pq = new PriorityQueue<>(graphEdges.size(), Comparator.comparingInt(o -> o.cost));

        //add all the edges to priority queue, //sort the edges on weights
        for (int i = 0; i <graphEdges.size() ; i++) {
            pq.add(graphEdges.get(i));
        }

        //create a parent []
        int [] parent = new int[numberOfNodes];

        //makeset
        makeSet(parent);

        ArrayList<Edge> mst = new ArrayList<>();
        
      //process vertices - 1 edges
        int index = 0;
        while(index<numberOfNodes-1){
            Edge edge = pq.remove();
            //check if adding this edge creates a cycle
            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);

            if(x_set==y_set){
                //ignore, will create cycle
            }else {
                //add it to our final result
                mst.add(edge);
                index++;
                union(parent,x_set,y_set);
            }
        }
        //print MST
        //System.out.println("Minimum Spanning Tree: ");
        //printGraph(mst);
        

    }
    
    public void makeSet(int [] parent){
        //Make set- creating a new element with a parent pointer to itself.
        for (int i = 0; i <numberOfNodes ; i++) {
            parent[i] = i;
        }
    }

    public int find(int [] parent, int vertex){
        //chain of parent pointers from x upwards through the tree
        // until an element is reached whose parent is itself
        if(parent[vertex]!=vertex)
            return find(parent, parent[vertex]);;
        return vertex;
    }

    public void union(int [] parent, int x, int y){
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }

    public void printGraph(ArrayList<Edge> edgeList){
        for (int i = 0; i <edgeList.size() ; i++) {
            Edge edge = edgeList.get(i);
            System.out.println("Edge-" + i + " source: " + edge.source +
                    " destination: " + edge.destination +
                    " weight: " + edge.cost);
        }
    }
}
class Edge implements Comparable<Edge>{
    int source,destination, cost;
    
    public Edge(int src,int dest, int cost){
        this.source = src;
        this.destination = dest;
        this.cost = cost;
    }
    
    public int compareTo(Edge anotherEdge){
        return this.cost - anotherEdge.cost;
    }
    
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	return super.equals(obj);
    }
    
    
}
public class ConnectedCitiesSolution {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int getMinimumCostToRepair(int numTotalAvailableCities, 
                               int numTotalAvailableRoads, 
                               List<List<Integer>> roadsAvailable, 
                               int numRoadsToBeRepaired, 
                               List<List<Integer>> costRoadsToBeRepaired)
	{
        // WRITE YOUR CODE HERE
    	List<Edge> cities = new ArrayList();
    	for(int i=1;i<=numTotalAvailableCities;i++) {
    		
    	}
    	return 0;
    }
     
    // METHOD SIGNATURE ENDS
}
