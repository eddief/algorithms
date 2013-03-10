import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class MergeSort{

	private Integer[] nums;
	private Integer[] helper;
	private long comps;

	public MergeSort(String _filename){
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
		helper = new Integer[n];

		long startTime = System.nanoTime();
		sort(0, n - 1);
		long timetaken = System.nanoTime() - startTime;

		System.out.println("Number of Comparisons:" + comps);
		System.out.println("Time taken to sort: " + timetaken);

		//writeSorted();
		writeData(comps, "m_counts.txt");
		writeData(timetaken, "m_times.txt");
	}


	public void sort(int low, int high){
		if (low < high){
			int mid = low + (high - low) / 2;
			sort(low, mid);
			sort(mid+1, high);
			merge(low, mid, high);
		}
		
	}


	public void merge(int low, int mid, int high){
		
		for(int i = low; i <= high; i++){
			helper[i] = nums[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		while(i <= mid && j <= high){
			if(helper[i] < helper[j]){
				nums[k] = helper[i];
				i++;
			} else{
				nums[k] = helper[j];
				j++;
			}
			k++;
			comps++;
		}

		while (i <= mid){
			nums[k] = helper[i];
			k++;
			i++;
			comps++;
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


	public void writeSorted(){
		try{
			File file = new File("merge_sorted.txt");
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

	public static void main(String[] args) {
		MergeSort m = new MergeSort(args[0]);
	
	}

}