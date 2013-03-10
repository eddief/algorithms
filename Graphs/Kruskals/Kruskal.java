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

public class Kruskal{

	private List<Edge> s, min;
	private Queue<Edge> u;

	private int n;


	public Kruskal(String filename){

		s = new ArrayList<Edge>();
		min = new ArrayList<Edge>();
		u = new LinkedList<Edge>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String curr;
			String[] line = new String[3];

			while ((curr = br.readLine()) != null) {
				line = curr.trim().split(", ");

				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				int c = Integer.parseInt(line[2]);			

				s.add(new Edge(a, b, c));		
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

		n = s.size();

		Edge[] temp = s.toArray(new Edge[s.size()]);

		QuickSort q = new QuickSort(temp);
		Edge[] sorted = q.sort(0, temp.length - 1);

		for(Edge e: sorted){
			u.add(e);
		}

		long startTime = System.nanoTime();
		minspan();
		long timetaken = System.nanoTime() - startTime;

		writeData(timetaken, "kruskal_time.txt");


		//System.out.println(min);

	}

	public void minspan(){

		DisjointSet d = new DisjointSet(n);

		d.initial();

		while(!u.isEmpty()){
			Edge e = u.poll();

			int i = e.getleft();
			int j = e.getright();

			int p = d.find(i);
			int q = d.find(j);

			if(! d.equal(p, q)){
				d.merge(p, q);
				min.add(e);
			}

			u.remove(e);
		}
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
		new Kruskal(args[0]);
	}

}