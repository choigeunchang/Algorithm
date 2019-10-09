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
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(bf.readLine());
		Point[] p = new Point[n];
		arr = new char[n][n];
		visited = new boolean[n][n];
		// 입력
		for(int i=0; i<n; i++)
			arr[i] = bf.readLine().toCharArray();
		
		int normal = bfs();
		// 먼저 정상인 구역 구하기
		// 색약 환자가 보는 구역 정하기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 'G')
					arr[i][j] = 'R';
			}
		}
		
		visited = new boolean[n][n];
		int strange = bfs();
		
		bw.write(normal + " " + strange + "\n");
		bw.flush();
		bw.close();
	}
	
	static int bfs() {
		
		Queue<Point> queue = new LinkedList<>();
		int sector = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				if(!visited[i][j]) {
					
					visited[i][j] = true;
					queue.add(new Point(i, j));
					while(!queue.isEmpty()) {
						
						Point p = queue.poll();
						for(int k=0; k<4; k++) {
							
							int x = p.x + dr[k];
							int y = p.y + dc[k];
							if(range(x, y) && !visited[x][y] && arr[i][j] == arr[x][y]) {
								
								visited[x][y] = true;
								queue.add(new Point(x, y));
							}
						}
					}
					sector++;
				}
			}
		}
		return sector;
	}
	
	static boolean range(int x, int y) {
		return x>=0 && y>=0 && x<n && y<n;
	}
	
	static void print() {
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}