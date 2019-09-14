import java.util.*;

public class Solution {

    public static void main(String[] args) {

    	Scanner s = new Scanner(System.in);
    	int test_case = s.nextInt();
    	
    	for(int t=1; t<=test_case; t++) {
    		
    		int N = s.nextInt();
    		int M = s.nextInt();
    		
    		int uni = 2*M - N;
    		int twin = N - M;
    
    		System.out.println("#" + t + " " + uni + " " + twin);	
    	}
    }
}