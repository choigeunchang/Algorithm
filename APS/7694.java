import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr;
	static int n;
	static int d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			arr = new int[n];
			
			str = bf.readLine();
			st = new StringTokenizer(str);
			int idx = 0;
			int count = 0;
			int result = 0;
			
			while(st.hasMoreTokens()) {
				arr[idx] = Integer.parseInt(st.nextToken());
				if(arr[idx] == 0)
					count++;
				else {
					result += (count/d);
					count = 0;
				}
				idx++;
				
				if(count == n)
					result = count;
			}
			
			System.out.println("#" + t + " " + result);
			
		}
	}
}