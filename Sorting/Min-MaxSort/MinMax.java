public class MinMax{

	private int[] l;

	public MinMax(int[] m){
		this.l = m;	

		int begin = 0;
		int end = l.length-1;

		while (begin < end){
			int it;
		    int min = begin;
		    int max = end;

		    for(it = begin; it <= end; it++){

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

		display();

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


	public static void main(String[] args) {
		int[] m = {7, 8, 4, 5, 0, 1, 11, 3};
		new MinMax(m);
	}

}