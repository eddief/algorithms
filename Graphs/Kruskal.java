import java.util.ArrayList;

public class Kruskal{

	private Integer[][] w;
	Integer[] nearest;
	Integer[] distance;
	int vnear;
	int n;
	ArrayList<String> minspan;

	
	public Prim(Integer[][] inlist){
		w = inlist;
		n = inlist.length;

		nearest = new Integer[n];
		distance = new Integer[n];
		minspan = new ArrayList<String>();

		for(int i = 0; i < n; i++){
			nearest[i] = 1;
			distance[i] = w[1][i];
		}


	}

	public void sort(){

		for(int k = 1; k < n; k++){
			int mini = Integer.MAX_VALUE;

			for(int i = 0; i < n; i++){
				if(0 < distance[i] && distance[i] < mini){
					mini = distance[i];
					vnear = i;
				}
			}

			int edge = w[vnear][nearest[vnear]];
			minspan.add(edge);

			distance[vnear] = -1;

			for(int i = 0; i < n; i++){
				if(w[i][vnear] < distance[i]){
					distance[i] = w[i][vnear];
					nearest[i] = vnear;
				}
			}

		}

		display();

	}



	public void display(){
		for(int k = 0; k < minspan.size(); k++){
			System.out.println(minspan.get(k));
		}

		System.out.println("\n");


		for(int i = 0; i < nearest.length; i++){
			System.out.println(nearest[i]);
		}

		System.out.println("\n");

	}


	public static void main(String[] args) {
		Integer[][] t = {
			{Integer.MAX_VALUE,1,10,10,10}, {1,Integer.MAX_VALUE,1,10,10}, {10,1,Integer.MAX_VALUE,10,1}, {10,10,10,Integer.MAX_VALUE,1}, {10,10,1,1,Integer.MAX_VALUE}
		};

		new Prim(t).sort();
		
	}

}