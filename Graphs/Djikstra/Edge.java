class Edge{

	private int weight, from, too;

	public Edge(int from, int too, int weight){
		this.from = from + 1;
		this.too = too + 1;
		this.weight = weight;
	}	

	public int getWeight(){
		return weight;
	}

	public int getfrom(){
		return from;
	}

	public int gettoo(){
		return too;
	}

	public String toString(){
		return "(" + from + ", " + too + ") = " + weight;
	}

}









