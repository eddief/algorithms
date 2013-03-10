import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
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

	//number of vertices
	private int m;

	public DynTSP(String filename){
		graph = new LinkedList<Edge>();

		//count number of vertices
		List<Integer> count = new ArrayList<Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String curr;
			String[] line = new String[3];

			while ((curr = br.readLine()) != null) {
				line = curr.trim().split(", ");

				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				int c = Integer.parseInt(line[2]);			

				graph.add(new Edge(a, b, c));	

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

		m = count.size();

		travel();
	}

	public void travel(){
		Queue<CollectedEdge> coll = new LinkedList<CollectedEdge>();		

		Iterator<Edge> iter = graph.iterator();
		while (iter.hasNext()) {
			Edge u = iter.next();
			if(u.getright() == 1){
				coll.offer(new CollectedEdge(u));
				iter.remove();
			}
		}

		int count = 2;

		while(count <= m){

			int size = coll.size();

			for(int i = 0; i < size; i++){
				CollectedEdge f = coll.poll();
				int vertex = f.getleft();

				for(int k = 0; k < graph.size(); k++){
					Edge e = graph.get(k);

					if(m == count){
						if(e.getleft() == 1 && vertex == e.getright()){
							CollectedEdge temp = new CollectedEdge(f);
							temp.addEdge(e);
							coll.offer(temp);					
						}
					}

					else if(e.getright() == vertex && !f.contains(e.getleft())){
						CollectedEdge temp = new CollectedEdge(f);
						temp.addEdge(e);
						coll.offer(temp);
						graph.remove(e);
					}

				}
			}

			count++;
		}

		CollectedEdge min = coll.peek();
		for(CollectedEdge p: coll){
			if(p.getWeight() < min.getWeight()){
				min = p;
			}
		}

		System.out.println(min);

	}



	public static void main(String[] args) {
		DynTSP d = new DynTSP(args[0]);
	}

}