package javalang.utils.datastructure.graph;

import java.util.HashMap;
import java.util.Map;


public class UndirectedGraph {
	private int nodesCount = 0;
    private Map<String,Edge> graphEdges;
    
    public UndirectedGraph(int nodesCount){
        this.nodesCount = nodesCount;
        graphEdges= new HashMap();
    }
    
    /**
     * Adds new Edge or update its weight if it already exists
     * @param src
     * @param destination
     * @param weight
     */
    public void addEdge(int src, int destination, int weight){
        //
        String id = src+"_"+destination;
        Edge e =  graphEdges.get(id);
        if(e==null) {
        	e = new Edge(src,destination,weight);
        	graphEdges.put(id,e);
        }else {
        	e.setWeight(weight);
        }
    }

	public int getNodesCount() {
		return nodesCount;
	}

	public void setNodesCount(int nodesCount) {
		this.nodesCount = nodesCount;
	}

	public Map<String, Edge> getGraphEdges() {
		return graphEdges;
	}

	public void setGraphEdges(Map<String, Edge> graphEdges) {
		this.graphEdges = graphEdges;
	}
    
    
    
}
