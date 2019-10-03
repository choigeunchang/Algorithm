package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws IOException {
          
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());
        for(int t=1; t<=test_case; t++) {
        	
        	int n = Integer.parseInt(bf.readLine());
        	String str = bf.readLine();
//        	String[] arr = str.split("^\\!|\\.|\\?");
        	String[] arr = str.split(" ");
        	String[] sentence = new String[n];
        	
        	String temp = "";
        	int idx = 0;
        	for(int i=0; i<arr.length; i++) {
        		
        		temp += " "+arr[i];
        		char ctemp = temp.charAt(temp.length()-1);
        		if(ctemp == '.' || ctemp == '?' || ctemp == '!') {
        			sentence[idx] = temp.trim();
        			idx++;
        			temp = "";
        		}
        	}
       
        	StringBuilder sb = new StringBuilder();
        	for(int i=0; i<sentence.length; i++) {
        		
        		int count = 0;
        		String input = sentence[i];
        		String[] srr = input.split(" ");
        		for(int j=0; j<srr.length; j++) {
        			
        			char end = srr[j].charAt(srr[j].length()-1);
//        			System.out.println("현재: " + srr[j]);
        			
        			if(Character.isUpperCase(srr[j].charAt(0))) {
        				
        				if(!isNotLower(srr[j]))
            				count++;
            			else if(srr[j].length() == 1)
            				count++;
//        				System.out.println(i+"번째: " + count);
        			}
        		}
        		
        		sb.append(" "+count);
        	}
        	sb.append("\n");
        	System.out.print("#" + t + sb.toString());
        }
    }
	
	static boolean isNumber(String str) {
		
		for(int i=1; i<str.length(); i++) {
			
			char c = str.charAt(i);
			System.out.print(c + " ");
			if(c >= '0' && c <= '9') {
				return true;
			}
		}
		return false;
	}
	
	static boolean isNotLower(String str) {
		
		for(int i=1; i<str.length(); i++) {
			
			char c = str.charAt(i);
			if(c == '!' || c == '.' || c == '?')
				continue;
			if(c > 'z' || c < 'a') {
				return true;
			}
		}
		return false;
	}
}