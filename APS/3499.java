import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

    	Scanner s = new Scanner(System.in);
    	int test_case = s.nextInt();
    	
    	for(int t=1; t<=test_case; t++) {
    		
    		int n = s.nextInt();
    		int mid = Math.round((float)n/2);
    		String[] arr = new String[n];
    		
    		String[] left = new String[mid];
    		String[] right = new String[n-mid];

    		for(int i=0; i<n; i++) {
    			arr[i] = s.next();
    			if(i < mid)
    				left[i] = arr[i];
    			else
    				right[i-mid] = arr[i];
    		}

    		int l = 0, r = 0;
    		System.out.print("#" + t + " ");
    		for(int i=0; i<n; i++) {
    			
    			if(i % 2 == 0) {
    				System.out.print(left[l] + " ");
    				l++;
    			}
    			else if(i % 2 == 1) {
    				System.out.print(right[r] + " ");
    				r++;
    			}
    		}
    		System.out.println();
    	}
    }
}