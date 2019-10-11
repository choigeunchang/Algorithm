import java.io.*;
import java.util.*;

public class Solution {
	
	static class Point {
		
		int x, y;
		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	static int n, m;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(bf.readLine());
        
        for(int t=1; t<=test_case; t++) {
        	
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            char[][] arr = new char[n][m];
            boolean[][] visited = new boolean[n][m];
            Queue<Point> queue = new LinkedList<>();
            
            StringBuilder sb = new StringBuilder();
            
            // 입력 및 시작 위치와 값 저장
            for(int i=0; i<n; i++)
        		arr[i] = bf.readLine().toCharArray();
            
            // 0,0에서 시작
            queue.add(new Point(0, 0));
            visited[0][0] = true;
            sb.append(arr[0][0]);
            
            // 어차피 움직이는 횟수는 정해져 있다. (n+m-2)
            for(int k=0; k<n+m-2; k++) {
            	
            	Queue<Point> save = new LinkedList<>();
            	char min = 123;		// z보다 큰 수 아무거나
            	
	            while(!queue.isEmpty()) {
	            	
	            	Point p = queue.poll();
	            	visited[p.x][p.y] = true;
	            	
	            	// 오른쪽과 아래 체크
	            	for(int i=0; i<2; i++) {
	            		
	            		int x = p.x + dr[i];
	            		int y = p.y + dc[i];
	            		
	            		// 첫 방문이면서 범위 안이라면
	            		if(range(x, y) && !visited[x][y]) {
	            			
	            			// 만약 그 곳의 값이 최솟값보다 작으면 그 곳이 새로운 움직일 장소가 된다
	            			if(min > arr[x][y]) {
	            				
	            				// 그렇기때문에 큐 다 비우고
	            				save.clear();
	            				// 해당 부분만 다시 저장
	            				save.add(new Point(x, y));
	            				// 최솟값 갱신
	            				min = arr[x][y];
	            			}
	            			// 같은 경우는 그냥 큐에 값만 넣어주기
	            			else if(min == arr[x][y])
	            				save.add(new Point(x, y));
	
	            			// 방문한 곳 체크
	            			visited[x][y] = true;            			
	            		}
	            	}
	            }
	            // 한번 움직이면 움직인 곳에 데이터 저장
	            sb.append(min);
	            queue = save;
            }
            bw.write("#" + t + " " + sb.toString() + "\n");
            bw.flush();
        }
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
    	return x<n && y<m;
    }
}