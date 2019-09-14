import java.io.*;
import java.util.*;

public class Solution {
	
	static String[] diff = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String trash = bf.readLine();
			StringTokenizer stt = new StringTokenizer(trash);
			String trh = stt.nextToken();
			int size = Integer.parseInt(stt.nextToken());
			String[] arr = new String[size];
			
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int[] temp = new int[diff.length];
			for(int i=0; i<size; i++) {
				
				arr[i] = st.nextToken();
				for(int j=0; j<diff.length; j++) {
					if(arr[i].contentEquals(diff[j]))
						temp[j]++;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<diff.length; i++) {
				
				for(int j=0; j<temp[i]; j++)
					sb.append(diff[i]).append(" ");
			}
			
			System.out.println("#" + t);
			System.out.println(sb.toString());
		}
	}	
}