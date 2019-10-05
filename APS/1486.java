import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] arr;
	static int temp;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr = new int[n];
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			temp = 0;
			min = Integer.MAX_VALUE;
			recur(0, n, b, 0);
			bw.write("#" + t + " " + min + "\n");
			bw.flush();
		}
		bw.close();
	}
	
	static void recur(int sum, int n, int b, int idx) {
		
		if(idx == arr.length) {
			
			if(sum >= b) {
				temp = sum - b;
				if(min > temp)
					min = temp;				
			}
			
			return;
		}
		
		recur(sum + arr[idx], n, b, idx+1);
		recur(sum, n, b, idx+1);
	}
}