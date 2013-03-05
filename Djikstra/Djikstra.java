import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Djikstra{

	private List<Edge> s, min;
	private List<Integer> count;

	//number of edges
	private int n;

	//number of vertices
	private int m;	
	
	public Djikstra(String filename){
		s = new ArrayList<Edge>();
		min = new ArrayList<Edge>();

		//used to count number of vertices
		count = new ArrayList<Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String curr;
			String[] line = new String[3];

			while ((curr = br.readLine()) != null) {
				line = curr.trim().split(", ");

				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				int c = Integer.parseInt(line[2]);			

				s.add(new Edge(a, b, c));	

				//count vertices
				if(!count.contains(a)){
					count.add(a);
				}
				if(!count.contains(b)){
					count.add(b);
				}	
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

		n = s.size();
		m = count.size();

		findpath();
		//System.out.println(s);
	}

	public void findpath(){

		List<Edge> t = new LinkedList<Edge>();

		int rootvert = 1;
		int currvert = rootvert + 1;
		int index = 0;

		while(index < m){

			//find all iterations of currvert'th value (e.g. for 1->2, find all edges leading to 2)
			for(int i = 0; i < n; i++){

				if (s.get(i).getto() == currvert) {
					t.add(s.get(i));
				}
			
			}
			
			Edge e;
			int sum = 0;
			int pathweight = Integer.MAX_VALUE;

			for(int i = 0; i < t.size(); i++){

				if(t.get(i).getfrom() == 1){
					sum = sum + t.get(i).getWeight();

					if (sum <= pathweight) {
						pathweight = sum;
						e = t.get(i);
					}
				} 
				else{
					sum = sum + helper(i, t.get(i));
				}

			}

			currvert++;
			index++;
			t.clear();

		}

	public void helper(int index, Edge e){

					sum = sum + e.getWeight();


	}




	}



	public static void main(String[] args) {
		new Djikstra(args[0]);
	}

}




public void spin(){
	int i, vnear;
	Edge e;
	int[] touch = new 
}