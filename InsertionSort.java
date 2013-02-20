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

	public void sort(){
		for(int i = 0; i < nums.size() - 1; i++){
			for(int j = i+1; j < nums.size(); j++){
				if(nums.get(i) > nums.get(j)){
					swap(i,j);		
				}
			}
		}
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
		System.out.println("Done");

	}

	public static void main(String[] args) {
		InsertionSort e = new InsertionSort(args[0]);
		e.sort();
		e.write();
	}

}