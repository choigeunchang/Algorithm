import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			StringBuilder sb = new StringBuilder(bf.readLine());
			
			int n = Integer.parseInt(bf.readLine());
			String input = bf.readLine();
			int[] arr = new int[n];
	
			StringTokenizer st = new StringTokenizer(input);
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			for(int i=n-1; i>=0; i--)
				sb.insert(arr[i], "-");
			
			System.out.println("#" + t + " " + sb.toString());
		}
	}
}