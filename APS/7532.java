import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int ad = e;
			int ts = e, tm = e;
			while(true) {
				
				if(ts == s && tm == m)
					break;
				
				ts += 24;
				tm += 24;
				ad +=24;
				
				if(ts > 365)
					ts -= 365;
				if(tm > 29)
					tm -= 29;				
			}
			System.out.println("#" + t + " " + ad);
		}
	}	
}