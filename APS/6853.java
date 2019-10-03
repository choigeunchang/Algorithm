import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Point{
		
		int x;
		int y;
		
		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			// x1 < x2		y1 < y2
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(bf.readLine());
			Point[] p = new Point[n];
			
			int inner = 0;
			int edge = 0;
			int outer = 0;
			
			for(int i=0; i<n; i++) {
				
				str = bf.readLine();
				st = new StringTokenizer(str);
				p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
				if((p[i].x > x1 && p[i].x < x2) && (p[i].y > y1 && p[i].y < y2))
					inner++;
				else if((p[i].x == x1 || p[i].x == x2) && (p[i].y >= y1 && p[i].y <= y2))
					edge++;
				else if((p[i].y == y1 || p[i].y == y2) && (p[i].x >= x1 && p[i].x <= x2))
					edge++;
				else
					outer++;
			}
			
			System.out.println("#" + t + " " + inner + " " + edge + " " + outer);
		}
	}
}