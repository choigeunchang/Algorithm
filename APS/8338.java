import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
		
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int idx = 0;
			while(st.hasMoreTokens()) {
				arr[idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
			int max = arr[0];
			for(int i=1; i<n; i++) {
				
				if(arr[i] < 2 || max < 2)
					max += arr[i];
				else
					max *= arr[i];
			}
			System.out.println("#" + t + " " + max);
		}
	}
}