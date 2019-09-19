import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] par;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			par = new int[n+1];
			for(int i=0; i<par.length; i++)
				par[i] = i;
			
			for(int i=0; i<m; i++) {
				
				str = bf.readLine();
				st = new StringTokenizer(str);
				Union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//				Print();
			}
			
			int count = 0;
			for(int i=1; i<par.length; i++) {
				
				if(i == par[i])
					count++;
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
//	
//	static void Print() {
//		for(int i=0; i<par.length; i++)
//			System.out.print(par[i] + " ");
//		System.out.println();
//	}
//	
	static void Union(int x, int y) {
		
		x = Find(x);
		y = Find(y);
		par[y] = x;
	}
	
	static int Find(int a) {
		
		if(a == par[a])
			return a;
		
		par[a] = Find(par[a]);
		return par[a];
	}
}
