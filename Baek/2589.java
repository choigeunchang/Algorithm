import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {

	static class Point{
	
		int x, y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int n, m;
	static char[][] arr;
	static int min;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        
        for(int i=0; i<n; i++)
    		arr[i] = bf.readLine().toCharArray() ;

        for(int i=0; i<n; i++) {

        	for(int j=0; j<m; j++) {
        		
        		if(arr[i][j] == 'L') {
        			
        			Queue<Point> queue = new LinkedList<>();
        			queue.add(new Point(i, j, 0));
            		boolean[][] visited = new boolean[n][m];
            		visited[i][j] = true;
            		
        			while(!queue.isEmpty()) {
        				
        				Point p = queue.poll();
        				min = Math.max(min, p.cnt);
        				
        				for(int k=0; k<4; k++) {
        					
        					int x = p.x + dr[k];
        					int y = p.y + dc[k];
        					if(range(x, y) && !visited[x][y] && arr[x][y] == 'L') {
        						
        						visited[x][y] = true;
        						queue.add(new Point(x, y, p.cnt+1));
        					}
        				}
        			}
        		}
        	}
        }
        
        bw.write(min + "\n");
        bw.flush();
        bw.close();
	}
	
	static void print(char[][] arr) {
		
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
