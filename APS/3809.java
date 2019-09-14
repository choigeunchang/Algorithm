import java.util.*;

public class Solution {
 
	static int max;
    public static void main(String[] args) {
       
    	Scanner s = new Scanner(System.in);
    	int test_case = s.nextInt();
    	for(int t=1; t<=test_case; t++) {
    		
    		int n = s.nextInt();
    		boolean[] flag = new boolean[1000];
    		
    		int[] arr = new int[n];
    		String str = "";
    		for(int i=0; i<n; i++) {
    			arr[i] = s.nextInt();
    			str += arr[i];
    		}
    		
    		for(int i=0; i<3; i++) {
    			
    			for(int j=0; j<str.length()-i; j++)
    				flag[Integer.parseInt(str.substring(j, j+i+1))] = true;
    		}
    		
    		System.out.print("#" + t + " ");
    		for(int i=0; i<flag.length; i++) {
    			
    			if(!flag[i]) {
    				System.out.println(i);
    				break;
    			}
    		}
    	}
	}
}