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

	public DynTSP(List<Edge> graph, int count){
		this.graph = graph;
		this.m = count;

		//long startTime = System.nanoTime();		
		travel();
		//long timetaken = System.nanoTime() - startTime;

		//writeData(timetaken, "dyntsp_time.txt");
	}

	public void travel(){

		Queue<CollectedEdge> coll = new LinkedList<CollectedEdge>();		

		for(int i = 0; i < graph.size(); i++){
			Edge e = graph.get(i);
			if(e.getright() == 1){
				coll.offer(new CollectedEdge(e));
				graph.remove(e);
			}
		}

		int count = 2;
		int c = 0;

		while(count <= m){

			int size = coll.size();

			for(int i = 0; i < size; i++){

				CollectedEdge f = coll.poll();
				int vertex = f.getleft();

				for(int k = 0; k < graph.size(); k++){

					Edge e = graph.get(k);

					if(count == m){
						if(e.getleft() == 1 && vertex == e.getright()){
							f.addEdge(e);
							coll.offer(f);
						}

					}

					if(e.getright() == vertex && !f.contains(e.getleft())){
						c++;
						System.out.println(c);
						CollectedEdge temp = new CollectedEdge(f);
						temp.addEdge(e);
						coll.offer(temp);						
					}
				}

			}
			

			count++;
		}

		//System.out.println(coll);
	}


    public void writeData(long datum, String filename){

        try{
            File file = new File(filename);

            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getName(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            String content = "" + datum + "\n";
            bw.write(content);
            bw.close();
            
        } catch (IOException e){
                e.printStackTrace();
        }

    }

	public static void main(String[] args) {

		String filename = args[0];
		int vertexcount = Integer.parseInt(args[1]);

		List<Edge> graph = new LinkedList<Edge>();

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

		DynTSP d = new DynTSP(graph, vertexcount);

	}

}