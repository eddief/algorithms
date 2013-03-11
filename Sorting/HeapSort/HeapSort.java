public class HeapSort{

	private int[] sequence;
	private int n;

	public HeapSort(int[] _sequence){
		this.sequence = _sequence;
		this.n = sequence.length;
		display();
		heapify();
		display();
	}

	public void heapify(){
		for(int i = 1; i < sequence.length + 1; i++){
			dwsift(i);
		}
	}

	public void dwsift(int i){

		int child1 = 2 * i;
		int child2 = 2 * i + 1;

		if(child1 <= n){
			swap(i-1, child1-1);
			sift(child1);
		}

	}

	public void upsift(int i){

		int child1 = 2 * i;
		int child2 = 2 * i + 1;

		if(child1 <= n){
			swap(i-1, child1-1);
			sift(child1);
		}

	}

	public void swap(int x, int y){
		sequence[x] = sequence[x]^sequence[y];
		sequence[y] = sequence[x]^sequence[y];
		sequence[x] = sequence[x]^sequence[y];
	}

	public void display(){
		for(int s: sequence){
			System.out.print(s + ",");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		int[] g = {2, 8, 7, 6, 5, 3, 9, 1};
		new HeapSort(g);
	}

}