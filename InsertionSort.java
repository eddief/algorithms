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


	public void sort()
{		long count1 = 0;
		long count2 = 0;

	    for(int i = 1; i < nums.size(); i++){
	        int j = i;
	        while ((j > 0) && (nums.get(j) < nums.get(j-1))){				       
	            swap(j, j-1);        
	            j--;
	            count2++;
	        }
	        count1++;
	    } 
		System.out.println("For loop: " + count1);
		System.out.println("While loop: " + count2);	

	}

	public void swap(int x, int y){
		nums.set(x, nums.get(x)^nums.get(y));
		nums.set(y, nums.get(x)^nums.get(y));
		nums.set(x, nums.get(x)^nums.get(y));
	}


	public void write(){
		try{
			File file = new File("sorted.txt");
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

	public void display(){
		for(int i = 0; i < nums.size(); i++){
			System.out.print(nums.get(i) + ",");
		}
		System.out.println("");		
	}

	public static void main(String[] args) {
		InsertionSort e = new InsertionSort(args[0]);
		long startTime = System.nanoTime();
		e.sort();
		System.out.println("Time taken to sort: " + (System.nanoTime() - startTime));
		e.write();	
	}

}