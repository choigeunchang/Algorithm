package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static class Station{
		
		private int start;
		private int end;
		
		public Station() {}
		public Station(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws IOException {
          
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());
        for(int t=1; t<=test_case; t++) {
        	
        	int n = Integer.parseInt(bf.readLine());
        	Station[] station = new Station[n];
        	
        	for(int i=0; i<n; i++) {
        		String ab = bf.readLine();
        		StringTokenizer st = new StringTokenizer(ab);
        		station[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	}
        	
        	int p = Integer.parseInt(bf.readLine());
        	System.out.print("#" + t);
        	
        	for(int i=0; i<p; i++) {
        		
        		int res = 0;
        		int c = Integer.parseInt(bf.readLine());
        		for(int j=0; j<n; j++) {
        			if(c >= station[j].start && c <= station[j].end)
        				res++;
        		}        		
        		System.out.print(" " + res);
        	}
        	System.out.println();
        }
    }
}