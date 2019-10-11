import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 영역구하기 {

	static class Point{
		
		int x, y;

		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] arr;
	static int m, n;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        Queue<Point> queue = new LinkedList<>();
        
        for(int i=0; i<k; i++) {
        	
        	st = new StringTokenizer(bf.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	for(int x=x1; x<x2; x++) {
        		for(int y=y1; y<y2; y++)
        			arr[x][y] = 1;
        	}
        }
        
//        print(arr);
        int cnt = 0;
        visited = new boolean[n][m];
        int temp = 0;
        List<Integer> list = new ArrayList<>();
        
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				temp = 0;
				if(!visited[i][j] && arr[i][j] == 0) {
					
					queue.add(new Point(i, j));
					
					while(!queue.isEmpty()) {
						
						Point p = queue.poll();
						visited[p.x][p.y] = true;
						temp++;
						
						for(int t=0; t<4; t++) {
							
							int x = p.x + dr[t];
							int y = p.y + dc[t];
							if(range(x, y) && !visited[x][y] && arr[x][y] == 0) {
								visited[x][y] = true;
								queue.add(new Point(x, y));
							}
						}
					}
					cnt++;
					list.add(temp);
				}
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		bw.write(cnt+"\n");
		for(int var : list) {
			sb.append(var);
			sb.append(" ");
		}
		bw.write(sb.toString().trim()+ "\n");
        bw.flush();
        bw.close();
	}
	
	static void print(int[][] arr) {
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=0; j<arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	static boolean range(int x, int y) {
		return x>=0 && y>=0 && x<n && y<m;
	}
}