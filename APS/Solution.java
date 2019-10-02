package edu.ssafy.c1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int p, q;
	static String[] good, bad;
	static int[] res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			String pq = bf.readLine();
			StringTokenizer st = new StringTokenizer(pq);
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			good = new String[p];
			bad = new String[q];
			res = new int[q];
			
			for(int i=0; i<p; i++)
				good[i] = bf.readLine();
			for(int i=0; i<q; i++)
				bad[i] = bf.readLine();
			for(int i=0; i<q; i++)
				res[i] = -2;
			
			for(int i=1; i<=20; i++) {
				
				for(int j=1; j<=20; j++) {
					
					for(int k=1; k<=20; k++) {
						
						if(isGood(i, j, k))
							isBad(i, j, k);
					}
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<res.length; i++)
				System.out.print(res[i] + " ");
			System.out.println();
		}
	}
	
	static boolean isGood(int r, int c, int s) {
		
		int tr = 0;
		int tc = 0;
		int ts = 0;
		
		for(int i=0; i<p; i++) {
			
			int cnt = 0;			
			int k = 0;
			
			for(int j=0; j<good[i].length(); j++) {
				
				if(good[i].charAt(j) == '.')
					cnt++;
				else {
					k = j;
					break;
				}
			}

			if(tr*r + tc*c + ts*s != cnt)
				return false;
			
			for(int j=k; j<good[i].length(); j++) {
				
				if(good[i].charAt(j) == '(')
					tr++;
				else if(good[i].charAt(j) == ')')
					tr--;
				else if(good[i].charAt(j) == '{')
					tc++;
				else if(good[i].charAt(j) == '}')
					tc--;
				else if(good[i].charAt(j) == '[')
					ts++;
				else if(good[i].charAt(j) == ']')
					ts--;
			}
			
		}
		
		return true;
	}
	
	static void isBad(int r, int c, int s) {
		
		int tr = 0;
		int tc = 0;
		int ts = 0;
		int cnt = 0;
		
		for(int i=0; i<q; i++) {
			
			if(res[i] == -2)
				res[i] = cnt;
			else if(res[i] != cnt)
				res[i] = -1;

			for(int j=0; j<bad[i].length(); j++) {
				
				if(bad[i].charAt(j) == '(')
					tr++;
				else if(bad[i].charAt(j) == ')')
					tr--;
				if(bad[i].charAt(j) == '{')
					tc++;
				else if(bad[i].charAt(j) == '}')
					tc--;
				if(bad[i].charAt(j) == '[')
					ts++;
				else if(bad[i].charAt(j) == ']')
					ts--;
			}
			cnt = r*tr + c*tc + s*ts;
		}
	}
}
