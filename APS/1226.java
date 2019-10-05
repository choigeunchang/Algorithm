import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
	
	static class Node{
		
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int t=1; t<=10; t++) {
			
			Queue<Node> queue = new LinkedList<>();
			
			int test_case = Integer.parseInt(bf.readLine());
			char[][] arr = new char[16][16];

			for(int i=0; i<16; i++) {
				
				String str = bf.readLine();
				for(int j=0; j<16; j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j] == '2')
						queue.add(new Node(i, j));
				}
			}
			
			boolean result = false;
			
			while(!queue.isEmpty()) {
				
				Node node = queue.poll();
				if(arr[node.x][node.y] == '2') {
					
					for(int i=0; i<4; i++) {
						
						int x = node.x + dr[i];
						int y = node.y + dc[i];
						if(range(x, y)) {
							
							if(arr[x][y] == '0') {
								arr[x][y] = '2';
								queue.add(new Node(x, y));
							}
							else if(arr[x][y] == '3') {
								result = true;
								break;
							}
						}
					}
				}
			}
			
			if(result)
				bw.write("#" + t + " " + 1 + "\n");
			else
				bw.write("#" + t + " " + 0 + "\n");
			bw.flush();
		}
		bw.close();
	}
	
	static boolean range(int x, int y) {
		return x>=0 && y>=0 && x<100 && y<100;
	}
}