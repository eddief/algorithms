import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinMax{

	private Integer[] l;
	private int comps;

	public MinMax(Integer[] m){
		this.l = m;

		long startTime = System.nanoTime();
		sort();		
		long timetaken = System.nanoTime() - startTime;

		//System.out.println("Number of Comparisons:" + comps);
		//System.out.println("Time taken to sort: " + timetaken);

		writeData(comps, "mimx_comp.txt");
		writeData(timetaken, "mimx_time.txt");		
	}

	public void sort(){
		int begin = 0;
		int end = l.length-1;

		while (begin < end){
			int it;
		    int min = begin;
		    int max = end;

		    for(it = begin; it <= end; it++){

		    	comps++;

		        if(l[it] < l[min]){
		            min = it;
		        }
		        else if(l[it] > l[max]){
		            max = it;
		        }
		    }

            if(max == begin && min == end){
                swap(max, min);
            }

            else if(max == begin){
                swap(max, end);
                swap(min, begin);
            }

            else{
                swap(min, begin);
                swap(max, end);
            }
		   
		    begin++;
		    end--;

		}

		//display();
	}

	public void display(){
		String s = "";
		for(int o: l){
			s = s + o + ", ";
		}
		System.out.println(s);
	}

	public void swap(int x, int y){
		int temp = l[x];
		l[x] = l[y];
		l[y] = temp;
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
		ArrayList<Integer> temp = new ArrayList<Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String curr;
			while ((curr = br.readLine()) != null) {
				temp.add(Integer.parseInt(curr));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Integer[] m = temp.toArray(new Integer[temp.size()]);
		new MinMax(m);
	}

}