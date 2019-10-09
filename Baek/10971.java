import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	static int[][] cost;
	static int n;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(bf.readLine());
		cost = new int[n][n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++)
			dfs(i, i, 0, 0);
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
	}
	
	static void dfs(int start, int end, int idx, int sum) {
		
		if(start == end && idx == n) {
			if(min > sum)
				min = sum;
			return;
		}
		
		for(int i=0; i<n; i++) {
			
			if(!visited[i] && cost[end][i] != 0) {
				
				visited[i] = true;
				if(sum < min)
					dfs(start, i, idx+1, sum+cost[end][i]);
				visited[i] = false;
			}
		}
	}
}