import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr;
	static int n;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		// 격자판 생성
		arr = new int[n][n];

		for(int i=0; i<n; i++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int j=0;
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		count = 0;
		dfs(0, 1, 0);		// 오른쪽 기준(현재 가로)
		
		System.out.println(count);
	}
	
	// dir--> 0: 가로, 1: 대각선, 2:  세로
	static void dfs(int x, int y, int dir) {
		
		if (x == n-1 && y == n-1) {
			count++;
			return;
		}
		
		// 가로로 이동
		// 가로로 이동할 수 있는 경우는 현재 모양이 가로거나 대각선 --> 세로만 아니면 이동 가능
		// 끝부분 기준 가로 비어있어야 함
		if(range(x, y+1) && arr[x][y+1] == 0 && dir != 2)
			dfs(x, y+1, 0);
		
		// 대각선으로 이동
		// 대각선은 다 가능
		// 끝부분 기준 가로 세로 대각선 비어있어야 함
		if(range(x+1, y+1) && arr[x][y+1] == 0 && arr[x+1][y+1] == 0 && arr[x+1][y] == 0)
			dfs(x+1, y+1, 1);
		
		// 세로로 이동
		// 세로로 이동할 수 있는 경우는 현재 모양이 세로거나 대각선 --> 가로만 아니면 됨
		// 끝부분 기준 세로 비어있어야 함
		if(range(x+1, y) && arr[x+1][y] == 0 && dir != 0)
			dfs(x+1, y, 2);
	}
	
	static boolean range(int x, int y) {
		if( x>=0 && y>=0 && x<n && y<n)
			return true;
		
		return false;
	}
}
