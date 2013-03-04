class QuickSort{

	private int[] nums;
	private int[] helper;
	private int n;

	public QuickSort(int[] unsorted){
		nums = unsorted;
		n = nums.length;
	}

	public int[] sort(int low, int high){
		int i = low;
		int j = high;
		int pivot = nums[(high+low)/2];

		while(i <= j){

			while(nums[i] < pivot){
				i++;
			}
			while(nums[j] > pivot){
				j--;
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

		return nums;
	}

	public void swap(int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

	public void display(){
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + ",");
		}
		System.out.println("");		
	}

}