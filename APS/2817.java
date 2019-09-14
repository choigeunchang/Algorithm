import java.util.*;
 
public class Solution {
 
	static int K;
	static int count = 0;
    public static void main(String[] args) {
         
        Scanner s = new Scanner(System.in);
        int test_case = s.nextInt();
        int N = 0;
         
        for(int k=0; k<test_case; k++) {
            
        	count = 0;
            N = s.nextInt();
            K = s.nextInt();
            int[] arr = new int[N];

            for(int i=0; i<N; i++)
                arr[i] = s.nextInt();
             
            subsum(arr, 0, 0);
            System.out.println("#" + (k+1) + " " + count);
        }
    }
    
    static void subsum(int[] arr, int idx, int sum) {
    	
    	if(idx == arr.length) {
    		if(sum == K)
        		count++;
    		return;
    	}
		subsum(arr, idx+1, sum);
		subsum(arr, idx+1, sum+arr[idx]);
    }
}