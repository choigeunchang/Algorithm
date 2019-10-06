import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n+1][n+1];
			
			for(int i=1; i<=m; i++) {
				
				st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				arr[start][end] = 1;
				arr[end][start] = 1;
			}
			
			int count = 0;
			for(int i=1; i<=n; i++) {
				
				for(int j=i+1; j<=n; j++) {
					
					if(arr[i][j] == 0)
						continue;
					
					for(int k=j+1; k<=n; k++) {
						
						if(arr[k][i] == 0)
							continue;
						if(arr[k][j] == 0)
							continue;
						
						count++;
					}
				}
			}
			
			bw.write("#" + t + " " + count + "\n");
			bw.flush();
		}
		bw.close();
	}
}