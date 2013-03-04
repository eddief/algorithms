class DisjointSet{

	private int[] u;
	private final int n;

	public DisjointSet(int size){
		n = size;
		u = new int[n];
	}
	
	public void makeset(int i){
		u[i] = i;
	}

	public int find(int i){
		int j = i;

		while(u[j] != j){
			j = u[j];
		}

		return j;
	}

	public void merge(int p, int q){
		if(p < q){
			u[q] = p;
		}
		else{
			u[p] = q;
		}

	}

	public boolean equal(int p, int q){
		return (p == q);
	}

	public void initial (int n){

		for(int i = 0; i < n; i++){
			makeset(i);
		}

	}


}