package utils.datastructure.graph;


public class Edge {
	private int source,destination;
	private int weight;
    
    public Edge(int src,int dest, int weight){
        this.source = src;
        this.destination = dest;
        this.setWeight(weight);
    }
    
    public int compareTo(Edge anotherEdge){
        return this.getWeight() - anotherEdge.getWeight();
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (!(obj instanceof Edge)) {
    		return false;
    	}
    	Edge target = (Edge)obj;
    	return this.source == target.source && this.destination == target.destination;
    }

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}
	
	
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "{source:" +source+ ",destination:" +destination+ ", weight:" + weight+"}";
    }
    
}

