import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class InsertionSort{

	private ArrayList<Integer> nums;

	public InsertionSort(String _filename){
		String filename = _filename;
		nums = new ArrayList<Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String curr;
			while ((curr = br.readLine()) != null) {
				nums.add(Integer.parseInt(curr));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public long sort(){
		long count = 0;

	    for(int i = 1; i < nums.size(); i++){
	        int j = i;
	        while ((j > 0) && (nums.get(j) < nums.get(j-1))){				       
	            swap(j, j-1);        
	            j--;
	            count++;
	        }
	    } 
	    return count;
	}

	public void swap(int x, int y){
		nums.set(x, nums.get(x)^nums.get(y));
		nums.set(y, nums.get(x)^nums.get(y));
		nums.set(x, nums.get(x)^nums.get(y));
	}


	public void writeSorted(){
		try{
			File file = new File("insertion_sorted.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(int k = 0; k < nums.size(); k++){
				String content = "" + nums.get(k) + "\n";
				bw.write(content);
			} 
			bw.close();
		} catch (IOException e){
				e.printStackTrace();
		}
		System.out.println("");
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


	public void display(){
		for(int i = 0; i < nums.size(); i++){
			System.out.print(nums.get(i) + ",");
		}
		System.out.println("");		
	}

	public static void main(String[] args) {
		InsertionSort e = new InsertionSort(args[0]);

		long startTime = System.nanoTime();
		long comparisons = e.sort();
		long timetaken = System.nanoTime() - startTime;

		System.out.println("Number of Comparisons:" + comparisons);
		System.out.println("Time taken to sort: " + timetaken);

		//e.writeSorted();
		e.writeData(comparisons, "counts.txt");
		e.writeData(timetaken, "times.txt");

	}

}