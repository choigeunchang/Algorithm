import java.util.*;
 
public class Solution {
	
	public static void main(String[] args) {
		
        Scanner s = new Scanner(System.in);
        int test_case = s.nextInt();
         
        for(int t=1; t<=test_case; t++) {
        	
        	int n = s.nextInt();
        	int k = s.nextInt();
        	int[] arr = new int[n];
        	for(int i=0; i<n; i++)
        		arr[i] = s.nextInt();
        	
        	Arrays.sort(arr);
        	
        	int sum = 0;
        	for(int i=n-1; i>n-1-k; i--)
        		sum += arr[i];
        	
        	System.out.println("#" + t + " " + sum);
        }	
    }
}