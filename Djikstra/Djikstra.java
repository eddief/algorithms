import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Djikstra{

	private int[][] graph;

	//number of vertices
	private int n;

	private List<Edge> lin;
	
	public Djikstra(int[][] _graph){
		this.graph = _graph;
		n = graph.length;
		findpath();
	}

	public void findpath(){
		int i, j, min;
		int e;
		int[] touch = new int[n];
		int[] length = new int[n];
		int vnear = 0;

		lin = new LinkedList<Edge>();
		for(i = 0; i < n; i++){
			touch[i] = 0;
			length[i] = graph[0][i];
		}

		for(j = 0; j < n-1; j++){

			min = Integer.MAX_VALUE;

			for(i = 0; i < n; i++){

				if(0 <= length[i] && length[i] < min){
					min = length[i];
					vnear = i;
				}

			}

			lin.add(new Edge(touch[vnear], vnear, graph[touch[vnear]][vnear]));

			for(i = 0; i <n; i++){
				if(length[vnear] + graph[vnear][i] < length[i]){
					length[i] = length[vnear] + graph[vnear][i];
					touch[i] = vnear;
					length[vnear] = -1;
				}
			}

		}

		System.out.println(lin);
	}

	public void doadd(int from, int too){
		return;
	}

	public void display(int[] l){
		//System.out.println(Arrays.ToString(l));
		for(int k = 0; k < l.length; k++){
			System.out.println(l[k]);
		}
	}

	public static void main(String[] args) {
		int[][] g = 


		s = new ArrayList<Edge>();
		min = new ArrayList<Edge>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String curr;
			int j;
			int[][] graph;

			while ((curr = br.readLine()) != null) {

				line = curr.trim().split(", "));

				for(int i = 0; i < line.length; i++){


					
				}

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





		


		Djikstra d = new Djikstra(g);
	}

}