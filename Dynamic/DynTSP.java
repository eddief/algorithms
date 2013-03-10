import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DynTSP{

	private List<Edge> graph;
	private int n;

	public DynTSP(String filename){
		graph = new LinkedList<Edge>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String curr;
			String[] line = new String[3];

			while ((curr = br.readLine()) != null) {
				line = curr.trim().split(", ");

				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				int c = Integer.parseInt(line[2]);			

				graph.add(new Edge(a, b, c));		
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

		travel();
	}

	public void travel(){
		Queue<CollectedEdge> coll = new LinkedList<CollectedEdge>();		
		Queue<CollectedEdge> en = new LinkedList<CollectedEdge>();

		for(Edge e: graph){
			if(e.getright() == 1){
				coll.offer(new CollectedEdge(e));
			}
		}

		int size = coll.size();

		for(int i = 0; i < size; i++){
			CollectedEdge f = coll.poll();
			int vertex = f.getleft();

			for(int k = 0; k < graph.size(); k++){
				Edge e = graph.get(k);
				if(e.getright() == vertex && e.getleft() != f.getright()){
					CollectedEdge temp = new CollectedEdge(f);
					temp.addEdge(e);
					en.offer(temp);
				}

			}

		}

		System.out.println(en);

	}



	public static void main(String[] args) {
		DynTSP d = new DynTSP(args[0]);
	}

}