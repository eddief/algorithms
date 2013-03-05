class Edge{

	private int weight, fromvert, tovert;

	public Edge(int fromvert, int tovert, int weight){
		this.fromvert = fromvert;
		this.tovert = tovert;
		this.weight = weight;
	}	

	public int getWeight(){
		return weight;
	}

	public int getfrom(){
		return fromvert;
	}

	public int getto(){
		return tovert;
	}

	public String toString(){
		return "(" + fromvert + ", " + tovert + ") = " + weight;
	}

}









