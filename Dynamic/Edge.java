class Edge{

	private int weight, vertleft, vertright;

	public Edge(int vertleft, int vertright, int weight){
		this.vertleft = vertleft;
		this.vertright = vertright;
		this.weight = weight;
	}	

	public int getWeight(){
		return weight;
	}

	public int getleft(){
		return vertleft;
	}

	public int getright(){
		return vertright;
	}

	public String toString(){
		return "(" + vertleft + ", " + vertright + ") = " + weight;
	}

	public String getprint(){
		return "" + vertleft + " -> " + vertright;
	}

}









