import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr;
	static int n;
	static int k;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n];
			
			str = bf.readLine();
			st = new StringTokenizer(str);
			int idx = 0;
			while(st.hasMoreTokens()) {
				arr[idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
			
			cnt = 0;
			partsum(0, 0);
			System.out.println("#" + t + " " + cnt);
			
		}
	}
	
	static void partsum(int pos, int sum) {
		
		if(sum > k)
			return;
		
		if(sum == k) {
			cnt++;
			return;
		}
		
		if(pos > n-1)
			return;
		
		partsum(pos + 1, sum);
		partsum(pos + 1, sum + arr[pos]);
	}
}