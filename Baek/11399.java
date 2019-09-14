import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}
		
		Arrays.sort(arr);
		int sum = 0;
		for(int i=0; i<n; i++) {
			
			sum += arr[i];
			for(int j=0; j<i; j++)
				sum += arr[j]; 
		}
		
		System.out.println(sum);
	}
}