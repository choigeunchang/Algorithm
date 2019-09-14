import java.io.*;
import java.util.*;

public class Solution {

	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
      
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
      
		for(int t=1; t<=test_case; t++) {
         
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			for(int i=1; i<=q; i++) {
				
				String input = bf.readLine();
				StringTokenizer lr = new StringTokenizer(input);
				int l = Integer.parseInt(lr.nextToken());
				int r = Integer.parseInt(lr.nextToken());
				
				for(int j=l-1; j<r; j++)
					arr[j] = i;
			}
         
			System.out.print("#" + t + " ");
			for(int i=0; i<arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}