import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str =  bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int d = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			if(m - 11 < 0) {
				h--;
				sum += 60 + m - 11;
			}
			else
				sum += m-11;
			if(h - 11 < 0) {
				d--;
				sum += 60 * (24 + h - 11);
			}
			else
				sum += 60 * (h - 11);
			sum += 24 * 60 * (d - 11);
			
			if(sum < 0)
				System.out.println("#" + t + " " + -1);
			else
				System.out.println("#" + t + " " + sum);
		}
	}
}