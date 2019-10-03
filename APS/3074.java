import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr;
	static int count;
	static int white, blue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String nm = bf.readLine();
			StringTokenizer st = new StringTokenizer(nm);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			long max = 0;
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(bf.readLine());
				if(max < arr[i])
					max = arr[i];
			}
			
			long t1 = 0;
			long t2 = max * m;
			long mid = 0;
			long result = max * m;
			
			while(t1 <= t2) {
				
				mid = (t1 + t2) / 2;
				long temp = 0;
				for(int i=0; i<n; i++)
					temp += (mid/arr[i]);
				
				if(temp < m)
					t1 = mid + 1;
				else {
					t2 = mid - 1;
					if(mid < result)
						result = mid;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}