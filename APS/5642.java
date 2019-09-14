import java.io.*;
import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1; t<=test_case; t++) {
			
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int max = Integer.MIN_VALUE, sum = 0;
			
			for(int i=0; i<n; i++) {
				
				sum += arr[i];
				if( sum > max )
					max = sum;
				if( sum < 0 )
					sum = 0;
			}
			System.out.println("#" + t + " " + max);
		}
	}
}