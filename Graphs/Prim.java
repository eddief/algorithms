import java.util.ArrayList;
import java.util.Arrays;  
import java.util.List;
import java.util.LinkedList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Prim{

	private List<Edge> s, min;
	private List<Integer> count;

	//number of edges
	private int n;

	//number of vertices
	private int m;


	public Prim(String filename){

		s = new LinkedList<Edge>();
		min = new ArrayList<Edge>();

		//count number of vertices
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

		Edge[] temp = s.toArray(new Edge[s.size()]);

		QuickSort q = new QuickSort(temp);
		s =  Arrays.asList(q.sort(0, temp.length - 1));


		long startTime = System.nanoTime();
		minspan();
		long timetaken = System.nanoTime() - startTime;

		e.writeData(timetaken, "prim_time.txt");

		System.out.println(min);
	}


	public void minspan(){

		List<Edge> t = new LinkedList<Edge>();

		for(int i = 1; i < m; i++){
			for(int k = 0; k < n; k++){
				if(s.get(k).getleft() == i || s.get(k).getright() == i){
					if(!min.contains(s.get(k))){
						t.add(s.get(k));
					}
				}
			}

			min.add(t.get(0));
			t.clear();
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
		new Prim(args[0]);
	}

}