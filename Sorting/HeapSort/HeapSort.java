import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HeapSort{

	private Integer[] seq;
	private int n;
	private long comparisons;

	public HeapSort(Integer[] seq, int n){
		this.seq = seq;
		this.n = n;

		long startTime = System.nanoTime();
		heapify(seq.length - 1);
		long timetaken = System.nanoTime() - startTime;

		writeData(timetaken, "heap_time.txt");
		writeData(comparisons, "heap_comp.txt");
	}

	public void display(){
		for(int u: seq){
			System.out.print(u + ", ");
		}
		System.out.println();
	}

	public void heapify(int tail){
		for (int i = tail / 2; i >= 1; i--){
			fixheap(i, tail, seq[i]);
		}
	  
		for (int i = tail; i > 1; i--){
			swap(1, i);
			fixheap(1, i-1, seq[1]);
		}
	}
	 
	private void fixheap(int head, int tail, int key){

		comparisons++;

		int child = 2 * head;

		if (child < tail && seq[child] < seq[child + 1]){
			child++; 
		}

		if(child <= tail && key < seq[child]){
			seq[head] = seq[child];
			fixheap(child, tail, key);
		} 
		else{
			seq[head] = key;
		}
	}

	public void swap(int x, int y){
		seq[x] = seq[x]^seq[y];
		seq[y] = seq[x]^seq[y];
		seq[x] = seq[x]^seq[y];
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
		List<Integer> nums = new ArrayList<Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			nums.add(0);
			String curr;
			while ((curr = br.readLine()) != null) {
				nums.add(Integer.parseInt(curr));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Integer[] g = nums.toArray(new Integer[nums.size()]);
		new HeapSort(g, g.length);
	}

}