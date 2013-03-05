class QuickSort{

	private Edge[] nums;
	private int n;

	public QuickSort(Edge[] unsorted){
		nums = unsorted;
		n = nums.length;
	}

	public Edge[] sort(int low, int high){
		int i = low;
		int j = high;

		int mid = (high+low) / 2 ;

		Edge pivot = nums[mid];

		while(i <= j){

			while(nums[i].getWeight() < pivot.getWeight()){
				i++;
			}
			while(nums[j].getWeight() > pivot.getWeight()){
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
		Edge temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}


}