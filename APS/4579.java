import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=test_case; t++) {
			
			String str = bf.readLine();
			char[] arr = new char[str.length()];
			for(int i=0; i<str.length(); i++)
				arr[i] = str.charAt(i);
			
			String result = "Exist";
			for(int i=0; i<arr.length/2; i++) {
				
				if(arr[i] == '*' || arr[arr.length-1-i] == '*') {
					result = "Exist";
					break;
				}
				if(arr[i] != arr[arr.length-1-i]) {
					result = "Not exist";
					break;
				}
			}
			
			bw.write("#" + t + " " + result + "\n");
			bw.flush();
		}
		bw.close();
	}
}