import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
       
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++)
				arr[i] = bf.readLine().charAt(0) - 'A';
			
			Arrays.sort(arr);
			
			int num = 0, count = 0;
			for(int i=0; i<arr.length; i++) {
				
				if(arr[i] == num) {
					num++;
					count++;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
}