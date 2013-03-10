import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Djikstra{

	private int[][] graph;

	//number of vertices
	private int n;

	private List<Edge> lin;
	
	public Djikstra(int[][] _graph){
		this.graph = _graph;
		n = graph.length;
		findpath();
		System.out.println(lin);
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
	}

	public static void main(String[] args) {

		String[] line;
		String curr;

		String filename = args[0];
		int size = Integer.parseInt(args[1]);

		int[][] g = new int[size][size];
		int j = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){

			while ((curr = br.readLine()) != null) {

				line = curr.trim().split(", ");

				for(int i = 0; i < line.length; i++){

					int num = Integer.parseInt(line[i]);

					if(num == -1){
						g[j][i] = Integer.MAX_VALUE;
					}else{
						g[j][i] = num;
					}

				}

				j++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		Djikstra d = new Djikstra(g);
	}

}