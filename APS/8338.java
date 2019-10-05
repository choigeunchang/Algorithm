import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static char[] cal = {'+', '*'};
	static int n;
	static int[] arr;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			n = Integer.parseInt(bf.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int temp = arr[0];
			max = 0;
			calculation(temp, 1);
			
			bw.write("#" + t + " " + max + "\n");
			bw.flush();
		}
		bw.close();
	}

	static void calculation(int temp, int idx) {
		
		if(idx == arr.length) {
			
			if(max < temp)
				max = temp;
			return;
		}
		
		calculation(temp*arr[idx], idx+1);
		calculation(temp+arr[idx], idx+1);
	}
}