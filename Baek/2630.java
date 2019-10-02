package edu.ssafy.c1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr;
	static int count;
	static int white, blue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int j = 0;
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		count = 0;
		white = 0;
		blue = 0;
		isMaking(n, 0, 0);
		
		System.out.println(white + "\n" + blue);
	}
	
	static void isMaking(int n, int start, int end) {
		
		int temp = arr[start][end];
		for(int i=start; i<start+n; i++) {
			
			for(int j=end; j<end+n; j++) {
				
				if(arr[i][j] != temp) {
					
					isMaking(n/2, start, end);
					isMaking(n/2, start + n/2, end);
					isMaking(n/2, start, end + n/2);
					isMaking(n/2, start + n/2, end + n/2);
					return;
				}
			}
		}
		
		if(temp == 1)
			blue++;
		else
			white++;
	}
}
