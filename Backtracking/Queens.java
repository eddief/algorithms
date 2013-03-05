import java.lang.Math;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Queens {

    private int[] q;
    private int N;
    private long count;

    public Queens(int N){
        this.N = N;
        q = new int[N+1];

        //calc monte carlo
        long sum = 0;
        for(int i = 0; i < 100; i++){
            sum = sum + montecarlo();
        }

        //reset after monte carlo
        count = 1;
        q = new int[N+1];

        nqueens(0);

        System.out.println("MonteCarlo Estimation: " + (sum / 100));
        System.out.println("Nodes visited: " + count);
        System.out.println("Total nodes: " + Math.pow(N,N) + "\n");
        
    }

    public boolean promising(int n) {
        count++;

        for (int i = 0; i < n; i++) {

            if (q[i] == q[n]){
                return false;
            }

            if(Math.abs(q[n]-q[i]) == (n - i)){
                return false;
            }
        }

        return true;
    }

    public int montecarlo(){
        Random r = new Random();
        int i, j;
        List<Integer> prom_child = new ArrayList<Integer>();

        i = 0;
        int numnodes = 1;
        int m = 1;
        int mprod = 1;

        while(m != 0 && i != N){

            mprod = mprod * m;
            numnodes = numnodes + mprod * N;
            i++;
            m = 0;
            prom_child.clear();

            for(j = 0; j < N; j++){
                q[i] = j;
                if(promising(i)){
                    m++;
                    prom_child.add(j);
                }
            }

            if(m != 0){
                j = r.nextInt(prom_child.size());
                q[i] = j;
            }

        }
        return numnodes;
    }


    public void nqueens(int n) {

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i] == j){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("- ");
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
