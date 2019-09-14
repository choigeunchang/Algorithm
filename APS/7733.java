import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			int n = Integer.parseInt(bf.readLine());
			int[][] arr = new int[n+2][n+2];
			for(int i=1; i<=n; i++) {
				
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				int j= 1;
				while(st.hasMoreTokens()) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
			
			int max = 0;
			for(int day=0; day<=100; day++) {
				
				boolean[][] visited = new boolean[n+2][n+2];
				int count = 0;
				for(int i=1; i<=n; i++) {
					for(int j=1; j<=n; j++) {
						
						if(!visited[i][j] && arr[i][j] > day) {
							count++;
							dfs(arr, visited, i, j, day);
						}
					}
				}
				max = Math.max(count, max);
			}
			System.out.println("#" + t + " " + max);
		}
	}
	
	static void dfs(int[][] arr, boolean[][] visited, int r, int c, int day) {
		
		if(day > 100)
			return;
		
		visited[r][c] = true;
		for(int i=0; i<4; i++) {
			int x = r + dr[i];
			int y = c + dc[i];
			if(!visited[x][y] && arr[x][y] > day) {
				dfs(arr, visited, x, y, day);
			}
		}
	}
}