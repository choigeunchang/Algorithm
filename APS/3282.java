import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] v = new int[n];
			int[] c = new int[n];
			
			for(int i=0; i<n; i++) {
				str = bf.readLine();
				st = new StringTokenizer(str);
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}

			int[][] arr = new int[n+1][k+1];
			
			for(int i=0; i<=n; i++) {
				
				for(int w=0; w<=k; w++) {
					
					if(i==0 || w==0) {
						arr[i][w] = 0;
						continue;
					}
					
					if(v[i-1] > w)
						arr[i][w] = arr[i-1][w];
					else
						arr[i][w] = Math.max(arr[i-1][w-v[i-1]]+c[i-1], arr[i-1][w]);
				}
			}

			System.out.println("#" + t + " " + arr[n][k]);
		}
	}
}