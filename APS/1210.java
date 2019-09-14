import java.util.*;
 
public class Solution {
	// 좌우 먼저 확인
	static int[] dr = {0, 0, -1};
	static int[] dc = {-1, 1, 0};
	
	public static void main(String[] args) {
 	
		Scanner s = new Scanner(System.in);
		int num = 0;
		int r = 0, c = 0, res = 0;
		
		for(int t=0; t<10; t++) {
		
			int[][] arr = new int[100][100];
			boolean[][] temp = new boolean[100][100];		// 왜 여기다 선언해야 되는거지
			num = s.nextInt();
			for(int i=0; i<arr.length; i++) {
				
				for(int j=0; j<arr[i].length; j++) {
					arr[i][j] = s.nextInt();
					if(arr[i][j] == 2) {
						r = i;
						c = j;
					}	
				}
			}
			while(true) {
				boolean flag = false;
				temp[r][c] = true;
				
				for(int i=0; i<3; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr == 0) {
						res = c;
						flag = true;
						break;
					}
					
					if(nr<0 || nc<0 || nc>99 || arr[nr][nc]==0 || temp[nr][nc])
						continue;
					
					r = nr;
					c = nc;
					break;
				}
				
				if(flag)
					break;
			}
			System.out.println("#" + (t+1) + " " + res);
		}	
	}
}