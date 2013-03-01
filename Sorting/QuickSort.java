import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class QuickSort{

	private Integer[] nums;
	private Integer[] helper;
	private long comps;

	public QuickSort(String _filename){
		String filename = _filename;
		ArrayList<Integer> temp = new ArrayList<Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String curr;
			while ((curr = br.readLine()) != null) {
				temp.add(Integer.parseInt(curr));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		nums = temp.toArray(new Integer[temp.size()]);

		int n = nums.length;

		long startTime = System.nanoTime();
		sort(0	, n-1);
		long timetaken = System.nanoTime() - startTime;


		System.out.println("Number of Comparisons:" + comps);
		System.out.println("Time taken to sort: " + timetaken);

		//writeSorted();
		writeData(comps, "m_counts.txt");
		writeData(timetaken, "m_times.txt");
	}

	public void sort(int low, int high){
		int i = low;
		int j = high;
		int pivot = nums[(high+low)/2];

		while(i <= j){

			while(nums[i] < pivot){
				i++;
				comps++;
			}
			while(nums[j] > pivot){
				j--;
				comps++;
			}
			if(i <= j){
				swap(i,j);
				i++;
				j--;
			}

		}
		
		if(low < j){
			sort(low, j);
		}
		if (i < high) {
			sort(i, high);
		}
	}

	public void swap(int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}


	public void writeSorted(){
		try{
			File file = new File("qu_sorted.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(int k = 0; k < nums.length; k++){
				String content = "" + nums[k] + "\n";
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
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + ",");
		}
		System.out.println("");		
	}

	public static void main(String[] args) {
		QuickSort e = new QuickSort(args[0]);
	}

}