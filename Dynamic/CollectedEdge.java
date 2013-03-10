class CollectedEdge{

	private int weight, vertleft, vertright;
	private String print;

	public CollectedEdge(Edge e){
		this.vertleft = e.getleft();
		this.vertright = e.getright();
		this.weight = e.getWeight();
		this.print = e.getprint();
	}

	public CollectedEdge(CollectedEdge e){
		this.vertleft = e.getleft();
		this.vertright = e.getright();
		this.weight = e.getWeight();
		this.print = e.getprint();
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

	public void addEdge(Edge e){
		print = e.getleft() + " -> " + print;
		vertleft = e.getleft();
		weight = weight + e.getWeight();
	}

	public String getprint(){
		return print;
	}

	@Override public String toString(){
		return print;
	}

}