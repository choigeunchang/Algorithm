import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
	
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			int n = Integer.parseInt(bf.readLine());
			arr = new int[n];
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			int result = 0;
			if(arr.length % 2 == 0)
				result = arr[0] * arr[arr.length-1];
			else
				result = arr[arr.length/2] * arr[arr.length/2];
				
			bw.write("#" + t + " " + result +"\n");
			bw.flush();
		}
		bw.close();
	}
}