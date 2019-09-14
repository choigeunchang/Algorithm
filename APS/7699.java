import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int r, c;
	static int max;
	static boolean[][] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= test_case; t++) {

			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[r][c];
			check = new boolean[r][c];
			
			for(int i=0; i<r; i++) {
				
				str = bf.readLine();
				for(int j=0; j<c; j++)
					arr[i][j] = str.charAt(j);
			}
			
			max = 1;
			boolean[] visited = new boolean[26];
			check[0][0] = true;
			visited[arr[0][0] - 'A'] = true;
			dfs(arr, visited, 0, 0, 1);
			
			System.out.println("#" + t + " " + max);
		}
	}

	static void dfs(int[][] arr, boolean[] visited, int r, int c, int count) {

		if(max < count)
			max = count;
		
		for(int i=0; i<4; i++) {
			
			int x = r + dr[i];
			int y = c + dc[i];
			if(range(x, y) && !visited[arr[x][y] - 'A'] && !check[x][y]) { 
				check[x][y] = true;
				visited[arr[x][y] - 'A'] = true;
				dfs(arr, visited, x, y, count+1);
				check[x][y] = false;
				visited[arr[x][y] - 'A'] = false;
			}
		}
	}
	
	static boolean range(int x, int y) {
		return x>=0 && y>=0 && x<r && y<c;
	}
}