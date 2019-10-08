import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr;
	static int[][] copy;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		copy = new int[n][m];				// 각 노드별 녹일 숫자
		visited = new boolean[n][m];
		// 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
//		print(arr);
		
		int year = 0;
		boolean flag = false;
		
		// 분리될때까지 반복
		while(true) {
			
			// 빙산갯수 세기
			int count = 0;
			// 어차피 가장자리가 0이어야 녹을 수가 있기 때문에 가장자리는 반복문을 돌 필요가 없다.
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					if (!visited[i][j] && arr[i][j] != 0) {
						seperation(i, j);
						count++;
					}
				}//			System.out.println("------------------" + year + " " + count);

			}
			
			if(count >= 2)
				break;
			if(count == 0) {
				year = 0;
				break;
			}
			
			// 1년간 빙하 녹이기
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<m-1; j++) {
					arr[i][j] = Math.max(arr[i][j] - copy[i][j], 0);
					copy[i][j] = 0;
					visited[i][j] = false;
				}
			}
//			print(arr);
			year++;
		}
		
		bw.write(year + "\n");
		bw.flush();
		bw.close();
	}

	// 빙산 분리 판별
	static void seperation(int r, int c) {

		visited[r][c] = true;
		for(int i=0; i<4; i++) {
			
			int x = r + dr[i];
			int y = c + dc[i];
			if(range(x, y)) {

				// 해당 지점주위 0의 갯수 세기 -> 녹일 양 결정
				if(arr[x][y] == 0)
					copy[r][c]++;
				if(!visited[x][y] && arr[x][y] > 0)
					seperation(x, y);
			}
				
		}
	}

	static void print(int[][] arr) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	static boolean range(int x, int y) {
		return x>=0 && y>=0 && x<n && y<m;
	}
}