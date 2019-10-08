import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point{
		
		int x, y;
		int day;
		
		public Point() {}
		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}
	
	static int r, c;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Point[] swan_pos;
	static int[][] copy;
	static int day;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char[][] arr = new char[r][c];
		copy = new int[r][c];
		swan_pos = new Point[2];		//  백조 2마리
		Queue<Point> ice = new LinkedList<>();
		
		int idx = 0;
		for(int i=0; i<r; i++) {
			
			arr[i] = bf.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				
				if(arr[i][j] == '.')
					ice.add(new Point(i, j, 0));
				else if(arr[i][j] == 'L') {					
					ice.add(new Point(i, j, 0));
					swan_pos[idx] = new Point(i, j, 0);
					idx++;
				}
			}
		}
		
		// 빙판마다 녹기 위한 소요일수 저장
		int cnt = 0;
		day = 0;
		while(!ice.isEmpty()) {
			
			// 먼저 하루경과에 따른 빙판 녹이기
			Point p = ice.poll();
			
			if(p.day == cnt)
				cnt++;
			day = p.day;
			
			for(int i=0; i<4; i++) {
				
				int x = p.x + dr[i];
				int y = p.y + dc[i];
				if(range(x, y) && arr[x][y] == 'X') {
					arr[x][y] = '.';
					copy[x][y] = cnt;
					ice.add(new Point(x, y, cnt));
				}
			}
		}

		// 이분 탐색 : 현재 날짜가 해당 날짜보다 작으면 얼음이 녹지 않기 때문에 패스
		int start = 1;
		int end = day;

		while(start <= end) {
			
			int mid = (start + end) / 2;
			if(bfs(mid)) {
				end = mid - 1;
			}
			else
				start = mid + 1;
		}

		bw.write(start + "\n");
		bw.flush();
		bw.close();
	}
	
	static boolean bfs(int maxday) {
		
		Queue<Point> move = new LinkedList<>();
		move.add(new Point(swan_pos[0].x, swan_pos[0].y, 0));		// 시작 백조 위치 입력
		boolean[][] visited = new boolean[r][c];
		
		while(!move.isEmpty()) {
			
			Point p = move.poll();
			visited[p.x][p.y] = true;
			
			if(p.x == swan_pos[1].x && p.y == swan_pos[1].y)
				return true;
			
			for(int i=0; i<4; i++) {
				
				int x = p.x + dr[i];
				int y = p.y + dc[i];
				if(range(x, y) && !visited[x][y] && copy[x][y] <= maxday) {
					visited[x][y] = true;
					move.add(new Point(x, y, 0));
				}
			}
		}
		
		return false;
	}
	
	static boolean range(int x, int y) {
		return x>=0 && y>=0 && x<r && y<c;
	}
}