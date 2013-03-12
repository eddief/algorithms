import java.util.Set;
import java.util.HashSet;

class CollectedEdge{

	private int weight, vertleft, vertright;
	private String print;
	private Set<Integer> collection;

	public CollectedEdge(Edge e){
		this.vertleft = e.getleft();
		this.vertright = e.getright();
		this.weight = e.getWeight();
		this.print = e.getprint();

		collection = new HashSet<Integer>();
		collection.add(vertleft);
		collection.add(vertright);
	}

	public CollectedEdge(CollectedEdge e){
		this.vertleft = e.getleft();
		this.vertright = e.getright();
		this.weight = weight + e.getWeight();
		this.print = e.getprint();

		collection = new HashSet<Integer>();
		collection.addAll(e.getList());

	}

	public boolean contains(int o){
		return collection.contains(o);
	}

	public Set<Integer> getList(){
		return collection;
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

		collection.add(e.getleft());
		collection.add(e.getright());
	}

	public String getprint(){
		return print;
	}

	@Override public String toString(){
		return print;
	}

}