import java.util.Scanner;
 
public class Solution {
     
    static int N = 0, L = 0;
    static int[] ti, ki;
    static int max = 0;
     
    public static void main(String[] args) {
           
        Scanner s = new Scanner(System.in);
        int test_case = 0;
         
        test_case = s.nextInt();
        int[] max_score = new int[test_case];
         
        for(int t=0; t<test_case; t++) {

        	N = s.nextInt();
        	L = s.nextInt();
            ti = new int[N];
            ki = new int[N];
            max = 0;
             
            for(int i=0; i<N; i++) {
                 
                ti[i] = s.nextInt();
                ki[i] = s.nextInt();
            }
            pride(0, 0, 0);
            max_score[t] = max;
        }
        s.close();
        for(int i=0; i<test_case; i++)
            System.out.println("#" + (i+1) + " " + max_score[i]);
    }
     
    static void pride(int score, int cal, int idx) {
         
        if(idx > N-1) {
            if(cal <= L && score > max)
                max = score;
            return;
        }
        pride(score, cal, (idx+1));
        pride(score+ti[idx], cal+ki[idx], (idx+1));
    }
}