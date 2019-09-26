import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			int n = Integer.parseInt(bf.readLine());
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int[] arr = new int[n+1];
			int[] temp = new int[n+1];
			
			int idx = 1;
			while(st.hasMoreTokens()) {
				arr[idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
			
			temp[0] = 0;
			int index = 0;
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				
				if(arr[i] >= temp[index]) {
					index++;
					temp[index] = arr[i];
				}
				else {
					for(int j=1; j<i; j++) {
						if(temp[j] > arr[i] && temp[j-1] < arr[i]) {
							temp[j] = arr[i];
							break;
						}
					}
				}
			}
			
			for(int i=0; i<=n; i++) {

				if(temp[i] != 0)
					cnt++;
			}

			System.out.println("#" + t + " " + cnt);
		}
	}
}