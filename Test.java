public class Test{

	private int[] s;

	public Test(int[] m){
		s = m;
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[2];
		a[0] = 1;
		a[1] = 2;

		new Test(a);
		
	}

}