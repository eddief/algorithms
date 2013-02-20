import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//0.152 ms to read-in file and add to list

class ExchangeSort{

	private ArrayList<Integer> nums;

	public ExchangeSort(String _filename){
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

	public void sort(){
		double count1 = 0;
		double count2 = 0;
		for(int i = 0; i < nums.size() - 1; i++){
			count1++;
			for(int j = i+1; j < nums.size(); j++){
				count2++;
				if(nums.get(i) > nums.get(j)){
					swap(i,j);		
				}
			}
		}
		System.out.println("OuterForLoopCount: " + count1);
		System.out.println("InnerForLoopCount: " + count2);
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

	public static void main(String[] args) {
		ExchangeSort e = new ExchangeSort(args[0]);
		long startTime = System.nanoTime();
		e.sort();
		System.out.println("Time taken to sort: " + (System.nanoTime() - startTime));
		e.write();

	}

}