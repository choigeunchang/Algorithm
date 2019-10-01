import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static int[] arr;
	static int n;
	static int d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			
			int current = str.charAt(0) - '0';
			int result = 0;
			
			for(int i=1; i<str.length(); i++) {
				
				if(current >= i)
					current += str.charAt(i) - '0';
				else {
					result += (i - str.charAt(i) - '0');
					current += i-current + str.charAt(i) - '0';
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}