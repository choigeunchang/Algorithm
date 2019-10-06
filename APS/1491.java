import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static long min;
	static long temp;
	static long n, a, b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			min = Long.MAX_VALUE;
			temp = 0;
			FindMin();
			
			bw.write("#" + t + " " + min + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void FindMin() {
		
		for(long c=1; c<=n/2; c++) {
			
			for(long r=c; r*c<=n; r++) {
				
				temp = a*Math.abs(r-c) + b*(n -r*c);
				if(min > temp)
					min = temp;
			}
		}
	}
}