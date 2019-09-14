import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine().trim());
		
		for(int t=1; t<=test_case; t++) {
			
			int n = Integer.parseInt(bf.readLine().trim());
			int[] arr = new int[200];		// 어차피 방 둘로 쪼개면 200개
			for(int i=0; i<n; i++) {
				
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int ta = start / 2;
				int tb = end / 2;

				if(start > end) {
					int temp = tb;
					tb = ta;
					ta = temp;
				}
				
				for(int c=ta; c<=tb; c++)
					arr[c]++;
			}
			
			int max = 0;
			for(int i=0; i<arr.length; i++) {
				
				if(max < arr[i])
					max = arr[i];
			}
			System.out.println("#" + t + " " + max);
		}
	}
}