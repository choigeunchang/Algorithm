import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int result = 0;
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				result += arr[i];
			}
			Arrays.sort(arr);
			result = result + arr[n-1] + n;
			
			bw.write("#" + t + " " + result + "\n");
			bw.flush();
		}
		bw.close();
	}
}