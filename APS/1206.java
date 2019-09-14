import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			
			int n = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int idx = 2;
			int count = 0;
			while(idx < n-2) {
				
				int temp = 0;
				for(int i=1; i<=2; i++) {
				
					if(arr[idx] > arr[idx-i] && arr[idx] > arr[idx+i])
						temp++;
					
					if(temp == 2) {
	
						int max = 0;
						for(int j=1; j<=2; j++) {
							
							if(max < arr[idx-j])
								max = arr[idx-j];
							if(max < arr[idx+j])
								max = arr[idx+j];
						}
						count += arr[idx] - max;
					}
				}
				idx++;
			}
			System.out.println("#" + t + " " + count);
		}
	}	
}