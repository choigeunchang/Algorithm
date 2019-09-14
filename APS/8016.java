import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			long left = 1, right = 1;
			long n = Integer.parseInt(br.readLine());
			
			n--;
			left += 2*n*n;
			right += 2*n*n + 4*n;
			
			System.out.println("#" + t + " " + left + " " + right);
		}
	}
}