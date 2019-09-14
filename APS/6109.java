import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static boolean flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			arr = new int[n][n];
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				
				str = bf.readLine();
				st = new StringTokenizer(str);
				int j=0;
				while(st.hasMoreTokens()) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
			
			flag = true;
			if(s.equals("up"))
				up();
			else if(s.equals("down"))
				down();
			else if(s.equals("left"))
				left();
			else if(s.equals("right"))
				right();
			
			System.out.println("#" + t);
			print(arr);
		}
	}
	
	static boolean range(int t) {
		return t>=0 && t<n;
	}
	
	static void print(int[][] arr) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	
	static void up() {
		
		for(int j=0; j<n; j++) {
			for(int i=0; i<n-1; i++) {
				
				if(arr[i][j] == 0 && arr[i+1][j] != 0) {
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = 0;
					
					boolean temp = visited[i][j];
					visited[i][j] = visited[i+1][j];
					visited[i+1][j] = temp;
					flag = false;
				}
				else if(!visited[i][j] && !visited[i+1][j] && arr[i][j] == arr[i+1][j]) {
					arr[i][j] *= 2;
					arr[i+1][j] =0;
					visited[i][j] = true;
					visited[i+1][j] = true;
					flag = false;
				}
			}
		}
		
		if(flag)
			return;
		else {
			flag = true;
			up();
		}
	}
	
	static void down() {
		
		for(int j=0; j<n; j++) {
			for(int i=n-1; i>0; i--) {
				
				if(arr[i][j] == 0 && arr[i-1][j] != 0) {
					arr[i][j] = arr[i-1][j];
					arr[i-1][j] = 0;
					
					boolean temp = visited[i][j];
					visited[i][j] = visited[i-1][j];
					visited[i-1][j] = temp;
					flag = false;
				}
				else if(!visited[i][j] && !visited[i-1][j] && arr[i][j] == arr[i-1][j]) {
					arr[i][j] *= 2;
					arr[i-1][j] =0;
					visited[i][j] = true;
					visited[i-1][j] = true;
					flag = false;
				}
			}
		}
		
		if(flag)
			return;
		else {
			flag = true;
			down();
		}
	}
	
	static void left() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				
				if(arr[i][j] == 0 && arr[i][j+1] != 0) {
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = 0;
					
					boolean temp = visited[i][j];
					visited[i][j] = visited[i][j+1];
					visited[i][j+1] = temp;
					flag = false;
				}
				else if(!visited[i][j] && !visited[i][j+1] && arr[i][j] == arr[i][j+1]) {
					arr[i][j] *= 2;
					arr[i][j+1] =0;
					visited[i][j] = true;
					visited[i][j+1] = true;
					flag = false;
				}
			}
		}
		
		if(flag)
			return;
		else {
			flag = true;
			left();
		}
	}
	
	static void right() {
		
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>0; j--) {
				
				if(arr[i][j] == 0 && arr[i][j-1] != 0) {
					arr[i][j] = arr[i][j-1];
					arr[i][j-1] = 0;
					
					boolean temp = visited[i][j];
					visited[i][j] = visited[i][j-1];
					visited[i][j-1] = temp;
					flag = false;
				}
				else if(!visited[i][j] && !visited[i][j-1] && arr[i][j] == arr[i][j-1]) {
					arr[i][j] *= 2;
					arr[i][j-1] =0;
					visited[i][j] = true;
					visited[i][j-1] = true;
					flag = false;
				}
			}
		}
		
		if(flag)
			return;
		else {
			flag = true;
			right();
		}
	}
}