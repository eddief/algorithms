import java.util.ArrayList;

public class Kruskal{

	private Integer[][] w;
	
	
	public Kruskal(Integer[][] inlist){
		w = inlist;
		int n = w.length;
		int m = count(w);

		minspan(n, m, )
	}


	public minspan(int n, int m, ArrayList<Integer> e){

		ArrayList<Integer> f = new ArrayList<Integer>();


		initial(n);
		while(F.length < n-1){

			e = edge with least weight no considered
			i,j = indices of vertices connected by e;
			p = find(i);
			q = find(j);
			if(! equal(p, q)){
				merge(p, q);
				F.add(e);
			}

		}
		return F;
	}


	public int count(int[][] a){
		int count = 0;

		for(int i = 0; i < a.length; i++){

			for(int k = 0; k < a.length; k++){
				
				if(a[i][k] != Integer.MAX_VALUE){
					count++;
				}

			}
		}

		return count;
	}


	public static void main(String[] args) {
		Integer[][] t = {
			{Integer.MAX_VALUE,1,10,10,10}, {1,Integer.MAX_VALUE,1,10,10}, {10,1,Integer.MAX_VALUE,10,1}, {10,10,10,Integer.MAX_VALUE,1}, {10,10,1,1,Integer.MAX_VALUE}
		};

		new Kruskal();
		
	}

}