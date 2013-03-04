public class Queens {

    private int[] q;
    private int N;

    public Queens(int _n){
        N = _n;
        q = new int[N];
        nqueens(0);
    }

    public boolean promising(int n) {
        for (int i = 0; i < n; i++) {

            if (q[i] == q[n]){
                return false;
            }

            if ((q[i]-q[n]) == (n-i)){
                return false;
            }

            if ((q[n]-q[i]) == (n-i)){
                return false;
            }
        }
        return true;

    }


    public void nqueens(int n) {
        int N = q.length;

        if (n == N){
            display();
        }

        else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (promising(n)){
                    nqueens(n+1);
                }
            }
        }

    }  

    public void display() {
        int N = q.length;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                if (q[i] == j){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("* ");
                }
            }

            System.out.println("");

        }  

        System.out.println("");

    }


    public static void main(String[] args) {
        new Queens(Integer.parseInt(args[0]));
    }

}
